package com.example.homekiri.user;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.config.secret.Secret;
import com.example.homekiri.library.AES128;
import com.example.homekiri.library.JwtService;
import com.example.homekiri.like.dto.LikeFoodDto;
import com.example.homekiri.like.dto.LikeMediaDto;
import com.example.homekiri.like.dto.LikeWorkoutDto;
import com.example.homekiri.like.repository.LikeRepository;
import com.example.homekiri.user.dto.*;
import com.example.homekiri.user.model.User;
import com.example.homekiri.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final JwtService jwtService;

    @Autowired
    public UserService(UserRepository userRepository, LikeRepository likeRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
        this.jwtService = jwtService;
    }

    /**
     JWT 인증 메서드
     @param String JWT
     @return BOOLEAN
     */
    public boolean jwtAuth(Long userIdx) throws BaseException{
        try {
            Long jwtUserIdx = this.jwtService.getUserIdx();
            if(jwtUserIdx == userIdx){
                return true;
            }
            else{
                return false;
            }
        }catch (BaseException e){
            throw new BaseException(e.getStatus());
        }

    }


    /**
      Password encode
      @param String password
      @return String
    */
    public String encodePassWord(String password) throws BaseException{
        AES128 aes128 = new AES128(Secret.USER_INFO_PASSWORD_KEY);
        try {
            String result = aes128.encrypt(password);
            System.out.println("[Service] password encode complete");
            return result;
        }catch(Exception e){
            throw new BaseException(BaseResponseStatus.PASSWORD_ENCRYPTION_ERROR);
        }
    }

    /**
    validateEmail service
    @param String password
    @return boolean
     */
    public void validateEmail(String email) throws BaseException{
        if(userRepository.findByEmail(email).isEmpty()==false){
            throw new BaseException(BaseResponseStatus.DUPLICATE_USER_EMAIL);
        }
    }

    public void validateNickname(String nickName) throws BaseException{
        if(userRepository.findByNickname(nickName).isEmpty()==false){
            throw new BaseException(BaseResponseStatus.DUPLICATE_USER_NICKNAME);
        }
    }


    /**
    SignIn service
    @param String password
    @return Long
     */
    public Long signIn(User user) throws BaseException{

        try {
            //validate userEmail
            validateEmail(user.getEmail());
            //validate nickName
            validateNickname(user.getNickName());
            return userRepository.save(user);
        }catch (BaseException e){
            throw new BaseException(e.getStatus());
        }

    }

    /**
     로그인 service
     @param String email String password
     @return PostLogInRes
     */
    public PostLogInRes logIn(String email, String password) throws BaseException{
        AES128 aes128 = new AES128(Secret.USER_INFO_PASSWORD_KEY);
        User user;
        try {
            user = userRepository.findSingleUserByEmail(email);
        }catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }

        // 패스워드 decrypt
        Boolean pwMatch;
        try{
            pwMatch = aes128.decrypt(user.getPwd()).equals(password);
        }
        catch (Exception e){
            throw new BaseException(BaseResponseStatus.PASSWORD_DECRYPTION_ERROR);
        }

        // 패스워드 비교
        if (!pwMatch) {
            throw new BaseException(BaseResponseStatus.PASSWORD_NOT_MATCH);
        }

        String jwt = jwtService.createJwt(user.getIdx());
        return new PostLogInRes(user.getIdx(), jwt);

    }

    /**
     마이페이지 Service
     @param String email String password
     @return PostLogInRes
     */
    public GetMypageRes getMypageInfo(Long userIdx) throws BaseException{
        User user = null;
        //dto
        List<LikeFoodDto> likeFoodDtos = null;
        List<LikeMediaDto> likeMediaDtos = null;
        Optional<List<LikeWorkoutDto>> likeWorkoutDtos = null;
        //res
        List<MypageLikeFood> mypageLikeFoods = new ArrayList<>();
        List<MypageLikeMedia> mypageLikeMedias = new ArrayList<>();
        List<MypageLikeExercise> mypageLikeExercises = new ArrayList<>();

        try{
            user = userRepository.findUserByIdx(userIdx);
            likeFoodDtos = likeRepository.findLikeFoodByUserIdx(userIdx);
            likeMediaDtos = likeRepository.findLikeMediaByUserIdx(userIdx);
            likeWorkoutDtos = likeRepository.findLikeExerciseByUserIdx(userIdx);
        }catch (Exception e){
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }

        if(likeFoodDtos != null) {
            for (LikeFoodDto lf : likeFoodDtos) {
                mypageLikeFoods.add(new MypageLikeFood(lf));
            }
        }
        System.out.println("[SERVICE] likeFoodDtos complete");

        if(likeMediaDtos != null) {
            for (LikeMediaDto lm : likeMediaDtos) {
                mypageLikeMedias.add(new MypageLikeMedia(lm));
            }
        }
        System.out.println("[SERVICE] likeMediaDtos complete");

        if(likeWorkoutDtos.isPresent()) {
            for (LikeWorkoutDto lw : likeWorkoutDtos.get()) {
                mypageLikeExercises.add(new MypageLikeExercise(lw));
            }
        }

        System.out.println("[SERVICE] likeWorkOutDtos complete");


        return new GetMypageRes(user.getNickName(), user.getProfileImg(), mypageLikeFoods, mypageLikeMedias, mypageLikeExercises);
    }

}
