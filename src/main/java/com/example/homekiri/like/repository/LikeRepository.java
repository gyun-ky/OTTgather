package com.example.homekiri.like.repository;

import com.example.homekiri.exercise.model.Difficulty;
import com.example.homekiri.exercise.model.WorkoutActivity;
import com.example.homekiri.food.model.Country;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.model.FoodImage;
import com.example.homekiri.like.dto.LikeFoodDto;
import com.example.homekiri.like.dto.LikeMediaDto;
import com.example.homekiri.like.dto.LikeWorkoutDto;
import com.example.homekiri.like.model.LikeFood;
import com.example.homekiri.like.model.LikeMedia;
import com.example.homekiri.media.model.Genre;
import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.user.dto.MypageLikeExercise;
import com.example.homekiri.user.dto.MypageLikeMedia;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LikeRepository {
    @PersistenceContext
    private EntityManager em;

    public Long saveLikeFood(LikeFood likeFood){
        em.persist(likeFood);
        em.flush();
        return likeFood.getIdx();
    }

    /**
     마이페이지 - 좋아한 Food List
     @param Long userIdx
     @return List<LikeFoodDto>
     */
    public List<LikeFoodDto> findLikeFoodByUserIdx(Long userIdx){
        List<Object[]> queryResult = em.createQuery("SELECT DISTINCT l.food, l.food.country, l.user, MAX(fImg.imgUrl) FROM LikeFood l JOIN FETCH l.food.foodImages fImg WHERE l.user.idx = :userIdx group by fImg.food.idx order by l.createdAt DESC")
                .setParameter("userIdx", userIdx).getResultList();

        System.out.println("[REPO] findLikeFoodByUserIdx queryResult complete");

        List<LikeFoodDto> result = new ArrayList<>();
        for(Object[] row : queryResult){
            result.add(new LikeFoodDto((FoodActivity)row[0], (Country)row[1], (String)row[3]));
        }

        System.out.println("[REPO] findLikeFoodByUserIdx LikeFoodDto convert complete");
        if(result.size() != 0){
            return result;
        }
        else {
            return null;
        }

    }

    /**
     마이페이지 - 좋아한 Media List
     @param Long userIdx
     @return List<LikeFoodDto>
     */
    public List<LikeMediaDto> findLikeMediaByUserIdx(Long userIdx){
        List<Object[]> queryResult = em.createQuery("SELECT l.media, l.media.genre, MAX(mImg.imgUrl), l.user FROM LikeMedia l JOIN FETCH l.media.mediaImages mImg WHERE l.user.idx = :userIdx GROUP BY mImg.media.idx ORDER BY l.createdAt DESC ")
                .setParameter("userIdx", userIdx).getResultList();

        System.out.println("[REPO] findLikeMediaByUserIdx queryResult complete");

        List<LikeMediaDto> result = new ArrayList<>();
        for(Object[] row : queryResult){
            result.add(new LikeMediaDto((MediaActivity) row[0], (Genre) row[1], (String)row[2]));
        }
        System.out.println("[REPO] findLikeMediaByUserIdx LikeMediaDto convert complete");
        System.out.println("[CHECK] --> "+result.size());
        if(result.size()!= 0){
            return result;
        }
        else{
            return null;
        }
    }

    /**
     마이페이지 - 좋아한 Exercise List
     @param Long userIdx
     @return List<LikeFoodDto>
     */
    public Optional<List<LikeWorkoutDto>> findLikeExerciseByUserIdx(Long userIdx){
        List<Object[]> queryResult = em.createQuery("SELECT l.workout, l.workout.difficulty, MAX(wImg.imgUrl), l.user FROM LikeExercise l JOIN FETCH l.workout.workoutImgList wImg WHERE l.user.idx = :userIdx group by wImg.workoutActivity.idx ORDER BY l.createdAt DESC")
                .setParameter("userIdx", userIdx).getResultList();

        System.out.println("[REPO] findLikeExerciseByUserIdx queryresult complete");

        List<LikeWorkoutDto> result = new ArrayList<>();
        for(Object[] row : queryResult){
            result.add(new LikeWorkoutDto((WorkoutActivity)row[0], (Difficulty) row[1], (String)row[2]));
        }
        System.out.println("[REPO] findLikeExerciseByUserIdx MypageLikeExercise convert complete");

        if(result.size() != 0){
            return Optional.ofNullable(result);
        }
        else{
            return Optional.empty();
        }

    }
}
