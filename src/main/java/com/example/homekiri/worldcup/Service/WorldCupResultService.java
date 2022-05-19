package com.example.homekiri.worldcup.Service;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.survey.Repository.FoodSurveyRepository;
import com.example.homekiri.survey.Repository.MediaSurveyRepository;
import com.example.homekiri.survey.model.FoodSurvey;
import com.example.homekiri.survey.model.MediaSurvey;
import com.example.homekiri.worldcup.Dto.ResultItem;
import com.example.homekiri.worldcup.Dto.WorldCupResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WorldCupResultService {

    public final MediaSurveyRepository mediaSurveyRepository;
    public final FoodSurveyRepository foodSurveyRepository;

    public Long updateResult(WorldCupResultDto worldCupResultDto ,Long userIdx, String category) throws BaseException {
        if (category.equals("food")){
            FoodSurvey foodSurvey = foodSurveyRepository.findByUserIdx(userIdx)
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.INVALID_USER_IDX));

            List<ResultItem> resultItem = worldCupResultDto.getList();
            for (ResultItem data : resultItem) {
                String name = data.getCategory();

                if (name.equals("beef")){
                    foodSurvey.setBeef(foodSurvey.getBeef() + data.getPoint());
                }
                if (name.equals("chicken")){
                    foodSurvey.setChicken(foodSurvey.getChicken() + data.getPoint());
                }
                if (name.equals("china")){
                    foodSurvey.setChina(foodSurvey.getChina() + data.getPoint());
                }
                if (name.equals("japan")){
                    foodSurvey.setJapan(foodSurvey.getJapan() + data.getPoint());
                }
                if (name.equals("korea")){
                    foodSurvey.setKorea(foodSurvey.getKorea() + data.getPoint());
                }
                if (name.equals("noodle")){
                    foodSurvey.setNoodle(foodSurvey.getNoodle() + data.getPoint());
                }
                if (name.equals("pork")){
                    foodSurvey.setPork(foodSurvey.getPork() + data.getPoint());
                }
                if (name.equals("raw")){
                    foodSurvey.setRaw(foodSurvey.getRaw() + data.getPoint());
                }
                if (name.equals("rice")){
                    foodSurvey.setRice(foodSurvey.getRice() + data.getPoint());
                }
                if (name.equals("roasted")){
                    foodSurvey.setRoasted(foodSurvey.getRoasted() + data.getPoint());
                }
                if (name.equals("seaFood")){
                    foodSurvey.setSeaFood(foodSurvey.getSeaFood() + data.getPoint());
                }
                if (name.equals("soup")){
                    foodSurvey.setSoup(foodSurvey.getSoup() + data.getPoint());
                }
                if (name.equals("temperature")){
                    foodSurvey.setTemperature(foodSurvey.getTemperature() + data.getPoint());
                }
                if (name.equals("western")){
                    foodSurvey.setWestern(foodSurvey.getWestern() + data.getPoint());
                }
                foodSurveyRepository.save(foodSurvey);
            }

            System.out.println(foodSurvey.getBeef());
        }
        if (category.equals("media")){
            MediaSurvey mediaSurvey = mediaSurveyRepository.findByUserIdx(userIdx)
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.INVALID_USER_IDX));
            List<ResultItem> resultItem = worldCupResultDto.getList();
            for (ResultItem data : resultItem) {
                String name = data.getCategory();
                if (name.equals("action")){
                    mediaSurvey.setAction(mediaSurvey.getAction() + data.getPoint());
                }
                if (name.equals("animation")){
                    mediaSurvey.setAnimation(mediaSurvey.getAnimation() + data.getPoint());
                }
                if (name.equals("classic")){
                    mediaSurvey.setClassic(mediaSurvey.getClassic() + data.getPoint());
                }
                if (name.equals("comedy")){
                    mediaSurvey.setComedy(mediaSurvey.getComedy() + data.getPoint());
                }
                if (name.equals("crime")){
                    mediaSurvey.setCrime(mediaSurvey.getCrime() + data.getPoint());
                }
                if (name.equals("drama")){
                    mediaSurvey.setDrama(mediaSurvey.getDrama() + data.getPoint());
                }
                if (name.equals("fantasy")){
                    mediaSurvey.setFantasy(mediaSurvey.getFantasy() + data.getPoint());
                }
                if (name.equals("horror")){
                    mediaSurvey.setHorror(mediaSurvey.getHorror() + data.getPoint());
                }
                if (name.equals("jtbc")){
                    mediaSurvey.setJtbc(mediaSurvey.getJtbc() + data.getPoint());
                }
                if (name.equals("kbs")){
                    mediaSurvey.setKbs(mediaSurvey.getKbs() + data.getPoint());
                }
                if (name.equals("mbc")){
                    mediaSurvey.setMbc(mediaSurvey.getMbc() + data.getPoint());
                }
                if (name.equals("netflix")){
                    mediaSurvey.setNetflix(mediaSurvey.getNetflix() + data.getPoint());
                }
                if (name.equals("romance")){
                    mediaSurvey.setRomance(mediaSurvey.getRomance() + data.getPoint());
                }
                if (name.equals("sbs")){
                    mediaSurvey.setSbs(mediaSurvey.getSbs() + data.getPoint());
                }
                if (name.equals("scienceFiction")){
                    mediaSurvey.setScienceFiction(mediaSurvey.getScienceFiction() + data.getPoint());
                }
                if (name.equals("twShow")){
                    mediaSurvey.setTvShow(mediaSurvey.getTvShow() + data.getPoint());
                }
                if (name.equals("twShow")){
                    mediaSurvey.setTvShow(mediaSurvey.getTvShow() + data.getPoint());
                }
                if (name.equals("tving")){
                    mediaSurvey.setTving(mediaSurvey.getTving() + data.getPoint());
                }
                if (name.equals("tvn")){
                    mediaSurvey.setTvn(mediaSurvey.getTvn() + data.getPoint());
                }
                if (name.equals("watch")){
                    mediaSurvey.setWatcha(mediaSurvey.getWatcha() + data.getPoint());
                }
                if (name.equals("wave")){
                    mediaSurvey.setWave(mediaSurvey.getWave() + data.getPoint());
                }
            }
        }
        return userIdx;
    }
}
