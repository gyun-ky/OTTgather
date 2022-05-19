package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dessert.model.DessertActivity;
import com.example.homekiri.dessert.model.Drink;
import com.example.homekiri.recommendation.Dto.DessertRecommendDto;
import com.example.homekiri.recommendation.Dto.FoodRecommendDto;
import com.example.homekiri.recommendation.Dto.MediaRecommendDto;
import com.example.homekiri.recommendation.Dto.WorkoutRecommendDto;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.exercise.model.WorkoutActivity;
import com.example.homekiri.preferences.DessertPreference;
import com.example.homekiri.preferences.FoodPreference;
import com.example.homekiri.preferences.MediaPreference;
import com.example.homekiri.preferences.WorkoutPreference;
import com.example.homekiri.dessert.repository.DessertRecommendListRepository;
import com.example.homekiri.food.repository.FoodRecommendListRepository;
import com.example.homekiri.media.repository.MediaRecommendListRepository;
import com.example.homekiri.exercise.repository.WorkoutRecommendListRepository;

import com.example.homekiri.dessert.repository.DessertPreferenceRepository;
import com.example.homekiri.food.repository.FoodPreferenceRepository;
import com.example.homekiri.media.repository.MediaPreferenceRepository;
import com.example.homekiri.exercise.repository.WorkoutPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service
public class RecommendListService {

    //Preference Repo
    private final DessertPreferenceRepository dessertPreferenceRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;
    private final MediaPreferenceRepository mediaPreferenceRepository;
    private final WorkoutPreferenceRepository workoutPreferenceRepository;



    //Activity Repo
    private final DessertRecommendListRepository dessertRecommendListRepository;
    private final FoodRecommendListRepository foodRecommendListRepository;
    private final MediaRecommendListRepository mediaRecommendListRepository;
    private final WorkoutRecommendListRepository workoutRecommendListRepository;

    /**
     * 추천 Service
     * @param Long UserIdx, RECOMMEND_SIZE
     * @return DessertActivityResponseDto
     */
    @Transactional
    public HashMap<String, Object> recommend(Long UserIdx, Long RECOMMEND_SIZE) throws BaseException {
        int RECOMMEND_SCORE = 70;

        //User Preference
        DessertPreference dessertPreference = dessertPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_PREFERENCE));
        FoodPreference foodPreference = foodPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_PREFERENCE));
        MediaPreference mediaPreference = mediaPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_PREFERENCE));
        WorkoutPreference workoutPreference = workoutPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_PREFERENCE));

        List<Integer> DessertColumnCandidates = new ArrayList<>();
        List<Integer> FoodColumnCandidates = new ArrayList<>();
        List<Integer> MediaColumnCandidates = new ArrayList<>();
        List<Integer> WorkoutColumnCandidates = new ArrayList<>();

        if(foodPreference.getBeef() >= RECOMMEND_SCORE)
            FoodColumnCandidates.add(0);
        if(foodPreference.getChicken()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(1);
        if(foodPreference.getPork()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(2);
        if(foodPreference.getNoodle()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(3);
        if(foodPreference.getRice()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(4);
        if(foodPreference.getTemperature()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(5);
        else FoodColumnCandidates.add(6);
        if(foodPreference.getKorea()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(7);
        if(foodPreference.getJapan()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(8);
        if(foodPreference.getChina()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(9);
        if(foodPreference.getWestern()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(10);
        if(foodPreference.getRaw()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(11);
        if(foodPreference.getRoasted()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(12);
        if(foodPreference.getSoup()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(13);
        if(foodPreference.getSeaFood()>=RECOMMEND_SCORE)
            FoodColumnCandidates.add(14);


        if(mediaPreference.getScienceFiction() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(0);
        if(mediaPreference.getHorror() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(1);
        if(mediaPreference.getDrama() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(2);
        if(mediaPreference.getRomance() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(3);
        if(mediaPreference.getAction() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(4);
        if(mediaPreference.getComedy() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(5);
        if(mediaPreference.getCrime() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(6);
        if(mediaPreference.getFantasy() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(7);
        if(mediaPreference.getAnimation() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(8);
        if(mediaPreference.getTvShow() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(9);
        if(mediaPreference.getClassic() >= RECOMMEND_SCORE)
            MediaColumnCandidates.add(10);
//        if(mediaPreference.getNetflix() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(11);
//        if(mediaPreference.getWave() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(12);
//        if(mediaPreference.getWatcha() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(13);
//        if(mediaPreference.getTving() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(14);
//        if(mediaPreference.getTvn() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(15);
//        if(mediaPreference.getJtbc() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(16);
//        if(mediaPreference.getMbc() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(17);
//        if(mediaPreference.getSbs() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(18);
//        if(mediaPreference.getKbs() >= RECOMMEND_SCORE)
//            MediaColumnCandidates.add(19);


        if(dessertPreference.getCoffee() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(0);
        if(dessertPreference.getBakery() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(1);
        if(dessertPreference.getSweet() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(2);
        if(dessertPreference.getSour() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(3);
        if(dessertPreference.getBitter() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(4);
        if(dessertPreference.getCold() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(5);
        if(dessertPreference.getHot() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(6);
        if(dessertPreference.getSmoothie() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(7);
        if(dessertPreference.getTea() >= RECOMMEND_SCORE)
            DessertColumnCandidates.add(8);
        if(dessertPreference.getFruit()>= RECOMMEND_SCORE)
            DessertColumnCandidates.add(9);


        //난이도 상
        if(workoutPreference.getDifficulty() >= RECOMMEND_SCORE)
            WorkoutColumnCandidates.add(0);
        //난이도 중
        else
            WorkoutColumnCandidates.add(1);
        //헬스 선호도
        if(workoutPreference.getHealth() >= RECOMMEND_SCORE)
            WorkoutColumnCandidates.add(2);
        //요가 선호도
        if(workoutPreference.getYoga() >= RECOMMEND_SCORE)
            WorkoutColumnCandidates.add(3);
        //기타 선호도
        if(workoutPreference.getHealth() < RECOMMEND_SCORE && workoutPreference.getYoga() < RECOMMEND_SCORE)
            WorkoutColumnCandidates.add(4);

        //높은 선호도의 칼럼 랜덤 셔플
        Collections.shuffle(DessertColumnCandidates);
        Collections.shuffle(FoodColumnCandidates);
        Collections.shuffle(MediaColumnCandidates);
        Collections.shuffle(WorkoutColumnCandidates);

        //엑티비티 인덱스 리스트
        List<Long> TempMediaList = new ArrayList<>();
        List<Long> TempFoodList = new ArrayList<>();
        List<Long> TempDessertList = new ArrayList<>();
        List<Long> TempWorkoutList = new ArrayList<>();


        for(int i = 0; i <Math.min(8, DessertColumnCandidates.size()); ++i)
            TempDessertList = MakeDessertLists(DessertColumnCandidates.get(i), TempDessertList);

        for(int i = 0; i <Math.min(8, FoodColumnCandidates.size()); ++i)
            TempFoodList = MakeFoodLists(FoodColumnCandidates.get(i), TempFoodList);

        for(int i = 0; i <Math.min(8, MediaColumnCandidates.size()); ++i)
            TempMediaList = MakeMediaLists(MediaColumnCandidates.get(i), TempMediaList);

        for(int i = 0; i <Math.min(8, WorkoutColumnCandidates.size()); ++i)
            TempWorkoutList = MakeWorkoutLists(WorkoutColumnCandidates.get(i), TempWorkoutList);



        if(TempMediaList.size() < RECOMMEND_SIZE  || TempFoodList.size() < RECOMMEND_SIZE || TempDessertList.size() < RECOMMEND_SIZE || TempWorkoutList.size() < RECOMMEND_SIZE){
            System.out.println(TempMediaList.size());
            System.out.println(TempFoodList.size());
            System.out.println(TempDessertList.size());
            System.out.println(TempWorkoutList.size());
            throw new BaseException(BaseResponseStatus.PREFERENCE_LACK_ERROR);

        }
        //엑티비티 셔플
        Collections.shuffle(TempMediaList);
        Collections.shuffle(TempFoodList);
        Collections.shuffle(TempDessertList);
        Collections.shuffle(TempWorkoutList);


        List<MediaRecommendDto> mediaActivities = new ArrayList<>();
        List<FoodRecommendDto> foodActivities = new ArrayList<>();
        List<DessertRecommendDto> dessertActivities = new ArrayList<>();
        List<WorkoutRecommendDto> workoutActivities = new ArrayList<>();


        for(int i = 0; i <RECOMMEND_SIZE; ++i){
            MediaRecommendDto res1 = new MediaRecommendDto(mediaRecommendListRepository.findById(TempMediaList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            mediaActivities.add(res1);

            FoodRecommendDto res2 = new FoodRecommendDto(foodRecommendListRepository.findById(TempFoodList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            foodActivities.add(res2);

            DessertRecommendDto res3 = new DessertRecommendDto(dessertRecommendListRepository.findById(TempDessertList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            dessertActivities.add(res3);

            WorkoutRecommendDto res4 = new WorkoutRecommendDto(workoutRecommendListRepository.findById(TempWorkoutList.get(i)).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR)));
            workoutActivities.add(res4);

        }

        HashMap<String, Object> map = new HashMap<>();

        map.put("media", mediaActivities);
        map.put("food", foodActivities);
        map.put("dessert", dessertActivities);
        map.put("workout", workoutActivities);


        return map;
    }

    List<Long> MakeFoodLists(Integer col, List<Long> TempFoodList){
        //소고기 선호도
        if(col == 0){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("beef");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //닭고기 선호도
        else if(col == 1){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("chicken");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //돼지고기 선호도
        else if(col == 2){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("pork");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //면 선호도
        else if(col == 3){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("noodle");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //밥 선호도
        else if(col == 4){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("rice");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //온도 선호도
        else if(col == 5){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByTemperature("HOT");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //찬거 선호도
        else if(col == 6){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByTemperatureOrTemperature("NORMAL", "COLD");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //한국음식 선호도
        else if(col == 7){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(1L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //일국음식 선호도
        else if(col == 8){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(2L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //중국음식 선호도
        else if(col == 9){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(3L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //양식 선호도
        else if(col == 10){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCountryIdx(4L);
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //날것 선호도
        else if(col == 11){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("raw");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //익힌거 선호도
        else if(col == 12){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("roasted");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        //국물 선호도
        else if(col == 13){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByCookingStateContains("soup");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        else if(col == 14){
            List<FoodActivity> res = foodRecommendListRepository.findFoodActivitiesByIngredient("seaFood");
            for (FoodActivity re : res) {
                Long idx = re.getIdx();
                if (!TempFoodList.contains(idx))
                    TempFoodList.add(idx);
            }
        }
        return TempFoodList;
    }
    List<Long> MakeMediaLists(Integer col, List<Long> TempMediaList){
        /*
         * Media Preference
         */
        //SF 선호도
        if(col == 0){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(1L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //호러 선호도
        else if(col == 1){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //드라마 선호도
        else if(col == 2){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //로맨스 선호도
        else if(col == 3){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(6L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //액션 선호도
        else if(col == 4){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(15L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //코미디 선호도
        else if(col == 5){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(19L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //범죄 선호도
        else if(col == 6){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdxOrGenreIdx(9L, 12L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //판타지 선호도
        else if(col == 7){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(20L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //애니 선호도
        else if(col == 8){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(14L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //예능 선호도
        else if(col == 9){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(17L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //고전 선호도
        else if(col ==10){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdxOrGenreIdx(10L,11L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //넷플릭스 선호도
        else if(col == 11){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //웨이브 선호도
        else if(col == 12){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //왓챠 선호도
        else if(col == 13){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //티빙 선호도
        else if(col == 14){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //티비앤 선호도
        else if(col == 15){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //Jtbc 선호도
        else if(col == 16){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //mbc 선호도
        else if(col == 17){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //sbs 선호도
        else if(col == 18){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }
        //kbs 선호도
        else if(col == 19){
            List<MediaActivity> res = mediaRecommendListRepository.findMediaActivitiesByGenreIdx(3L);
            for (MediaActivity re : res) {
                Long idx = re.getIdx();
                if (!TempMediaList.contains(idx))
                    TempMediaList.add(idx);
            }
        }

        return TempMediaList;
    }
    List<Long> MakeDessertLists(Integer col, List<Long> TempDessertList){
        //카페인 선호도
        if(col == 0) {
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_Caffeine("Y");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //베이커리 선호도
        else if(col == 1){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByNonDrinkIsNot(null);
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //단거 선호도
        else if(col == 2){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_Flavor("sweet");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //신거 선호도
        else if(col == 3){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_Flavor("sour");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //쓴거 선호도
        else if(col == 4){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_Flavor("bitter");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //찬거 선호도
        else if(col == 5){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_TemperatureContains("ICE");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //뜨거운거 선호도
        else if(col == 6){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_TemperatureContains("HOT");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //스무디 선호도
        else if(col == 7){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_DrinkName("smoothie");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        //티 선호도
        else if(col == 8){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_DrinkNameOrDrink_DrinkName("tea", "milk tea");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }        }
        //과일류 선호도
        else if(col == 9){
            List<DessertActivity> res = dessertRecommendListRepository.findDessertActivitiesByDrink_DrinkName("juice");
            for (DessertActivity re : res) {
                Long idx = re.getIdx();
                if (!TempDessertList.contains(idx))
                    TempDessertList.add(idx);
            }
        }
        return TempDessertList;
    }
    List<Long> MakeWorkoutLists(Integer col, List<Long> TempWorkoutList){
        /*
         * Workout Preference
         */
        //난이도별 선호도
        if(col == 0){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByDifficultyIdxOrDifficultyIdx(2L, 3L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        else if(col == 1){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByDifficultyIdx(1L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        //요가 선호도
        else if(col == 2){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(1L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        //헬스 선호도
        else if(col == 3){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(2L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }
        else if(col == 4){
            List<WorkoutActivity> res = workoutRecommendListRepository.findWorkoutActivitiesByTypeIdx(2L);
            for (WorkoutActivity re : res) {
                Long idx = re.getIdx();
                if (!TempWorkoutList.contains(idx))
                    TempWorkoutList.add(idx);
            }
        }

        return TempWorkoutList;
    }
}
