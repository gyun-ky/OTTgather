package com.example.homekiri.worldcup.Service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dessert.model.DessertImage;
import com.example.homekiri.dessert.repository.DessertPreferenceRepository;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.model.FoodImage;
import com.example.homekiri.food.repository.FoodActivityRepository;
import com.example.homekiri.food.repository.FoodImgRepository;
import com.example.homekiri.food.repository.FoodPreferenceRepository;
import com.example.homekiri.media.model.MediaActivity;
import com.example.homekiri.media.model.MediaImage;
import com.example.homekiri.media.repository.MediaActivityRepository;
import com.example.homekiri.media.repository.MediaPreferenceRepository;
import com.example.homekiri.preferences.FoodPreference;
import com.example.homekiri.survey.Repository.DessertSurveyRepository;
import com.example.homekiri.survey.Repository.ExerciseSurveyRepository;
import com.example.homekiri.survey.Repository.FoodSurveyRepository;
import com.example.homekiri.survey.Repository.MediaSurveyRepository;
import com.example.homekiri.survey.model.ExerciseSurvey;
import com.example.homekiri.survey.model.FoodSurvey;
import com.example.homekiri.survey.model.MediaSurvey;
import com.example.homekiri.user.model.User;
import com.example.homekiri.user.repository.UserRepository;
import com.example.homekiri.worldcup.Dto.WorldCupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import java.util.*;

@RequiredArgsConstructor
@Service
public class WorldCupService {
    // img
    public final FoodImgRepository foodImgRepository;

    // repository
    public final FoodSurveyRepository foodSurveyRepository;
    public final DessertSurveyRepository dessertSurveyRepository;
    public final MediaSurveyRepository mediaSurveyRepository;
    public final ExerciseSurveyRepository exerciseSurveyRepository;
    public final UserRepository userRepository;
    public final FoodActivityRepository foodActivityRepository;
    public final MediaActivityRepository mediaActivityRepository;


    public List<WorldCupResponseDto> worldCupResponse(Long userIdx, int round, String category) throws BaseException {
        User user = userRepository.findUserByIdx(userIdx);
        List<WorldCupResponseDto> result = new ArrayList<>();
        //****************** FOOD *************************************************//
        if (category.equals("food")) {
            FoodSurvey foodSurvey = foodSurveyRepository.findByUserIdx(userIdx).orElseThrow(() -> new BaseException(BaseResponseStatus.INVALID_USER_IDX));
            // food hash map 으로 주입 //
            Map<String, Integer> foodMap = getStringIntegerMap(foodSurvey);
            // 정렬 //
            List<Entry<String, Integer>> list = new ArrayList<>(foodMap.entrySet());
            list.sort(Entry.comparingByValue());
            Collections.reverse(list);
            // ***///
            System.out.println(list);
            for (int i = 0; i < 4; i++) {
                WorldCupResponseDto data = new WorldCupResponseDto();
                String value = list.get(i).getKey();
                List<FoodActivity> byIngredient = foodActivityRepository.findByIngredient(value);
                data.setCategory(list.get(i).getKey());
                System.out.println(list.get(i).getKey());
                if (byIngredient.size() != 0) {
                    data.setName(byIngredient.get(0).getFoodName());
                    Long idx = byIngredient.get(0).getIdx();
                    List<FoodImage> url = foodActivityRepository.findUrlByIdx(idx);
                    data.setUrl(url.get(0).getImgUrl());
                    result.add(data);
                } else if (value == "HOT" || value == "NORMAL" || value == "ICE") {
                    List<FoodActivity> Temperature = foodActivityRepository.findByTemperature(value);
                    data.setName(Temperature.get(0).getFoodName());
                    Long idx = Temperature.get(0).getIdx();
                    List<FoodImage> url = foodActivityRepository.findUrlByIdx(idx);
                    data.setUrl(url.get(0).getImgUrl());
                    result.add(data);
                } else if (value == "raw" || value == "roasted") {
                    List<FoodActivity> state = foodActivityRepository.findByCookingState(value);
                    data.setName(state.get(0).getFoodName());
                    Long idx = state.get(0).getIdx();
                    List<FoodImage> url = foodActivityRepository.findUrlByIdx(idx);
                    data.setUrl(url.get(0).getImgUrl());
                    result.add(data);
                } else {
                    Long num;
                    if (value == "korea")
                        num = 1L;
                    else if (value == "japan")
                        num = 2L;
                    else if (value == "china")
                        num = 3L;
                    else
                        num = 4L;
                    List<FoodActivity> byCountry = foodActivityRepository.findByCountry(num);
                    data.setName(byCountry.get(0).getFoodName());
                    Long idx = byCountry.get(0).getIdx();
                    List<FoodImage> url = foodActivityRepository.findUrlByIdx(idx);
                    data.setUrl(url.get(0).getImgUrl());
                    result.add(data);
                }
            }
            return result;
        }


        //****************** MEDIA *************************************************//
        if (category.equals("media"))
        {
            MediaSurvey mediaSurvey = mediaSurveyRepository.findByUserIdx(userIdx).orElseThrow(() -> new BaseException(BaseResponseStatus.INVALID_USER_IDX));
            // media hash map 으로 주입 //
            Map<String, Integer> mediaMap = new HashMap<String, Integer>();
            mediaMap.put("action",mediaSurvey.getAction());
            mediaMap.put("animation",mediaSurvey.getAnimation());
            mediaMap.put("classic",mediaSurvey.getClassic());
            mediaMap.put("comedy",mediaSurvey.getComedy());
            mediaMap.put("crime",mediaSurvey.getCrime());
            mediaMap.put("drama",mediaSurvey.getDrama());
            mediaMap.put("fantasy",mediaSurvey.getFantasy());
            mediaMap.put("horror",mediaSurvey.getHorror());
            mediaMap.put("jtbc",mediaSurvey.getJtbc());
            mediaMap.put("kbs",mediaSurvey.getKbs());
            mediaMap.put("mbc",mediaSurvey.getMbc());
            mediaMap.put("netflix",mediaSurvey.getNetflix());
            mediaMap.put("romance",mediaSurvey.getRomance());
            mediaMap.put("sbs",mediaSurvey.getSbs());
            mediaMap.put("tvShow",mediaSurvey.getTvShow());
            mediaMap.put("tving",mediaSurvey.getTving());
            mediaMap.put("tvn",mediaSurvey.getTvn());
            mediaMap.put("watcha",mediaSurvey.getWatcha());
            mediaMap.put("wave",mediaSurvey.getWave());
            // 정렬 //
            List<Entry<String, Integer>> list = new ArrayList<>(mediaMap.entrySet());
            list.sort(Entry.comparingByValue());
            Collections.reverse(list);
            System.out.println(list);
            for (int i = 0; i < 4; i++)
            {
                WorldCupResponseDto data = new WorldCupResponseDto();
                String value = list.get(i).getKey();
                data.setCategory(list.get(i).getKey());
                List<MediaActivity> findAll = mediaActivityRepository.findMedia(value); //value 넣기
                //System.out.println(findAll.get(0).getMediaName());
                if (findAll.size() != 0) {
                    data.setName(findAll.get(0).getMediaName());
                    Long idx = findAll.get(0).getIdx();
                    List<MediaImage> url = mediaActivityRepository.findUrlByIdx(idx);
                    data.setUrl(url.get(0).getImgUrl());
                }
                else{
                    List<MediaActivity> platform = mediaActivityRepository.findByPlatform(value); // value 넣기
                    data.setName(platform.get(0).getMediaName());
                    Long idx = platform.get(0).getIdx();
                    List<MediaImage> url = mediaActivityRepository.findUrlByIdx(idx);
                    data.setUrl(url.get(0).getImgUrl());
                 //   System.out.println(platform.get(0).getMediaName());
                }
                result.add(data);
            }
        }
        return result;
    }
    private Map<String, Integer> getStringIntegerMap(FoodSurvey foodSurvey) {
        Map<String, Integer> foodMap = new HashMap<String, Integer>();
        foodMap.put("beef", foodSurvey.getBeef());
        foodMap.put("rice", foodSurvey.getRice());
        foodMap.put("chicken", foodSurvey.getChicken());
        foodMap.put("china", foodSurvey.getChina());
        foodMap.put("japan", foodSurvey.getJapan());
        foodMap.put("korea", foodSurvey.getKorea());
        foodMap.put("noodle", foodSurvey.getNoodle());
        foodMap.put("pork", foodSurvey.getPork());
        foodMap.put("raw", foodSurvey.getRaw());
        foodMap.put("roasted", foodSurvey.getRoasted());
        foodMap.put("seaFood", foodSurvey.getSeaFood());
        foodMap.put("soup", foodSurvey.getSoup());
        foodMap.put("temperature", foodSurvey.getTemperature());
        foodMap.put("western", foodSurvey.getWestern());
        return foodMap;
    }

}
