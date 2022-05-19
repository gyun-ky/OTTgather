package com.example.homekiri.food.repository;

import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.food.model.FoodImage;
import com.example.homekiri.survey.model.ExerciseSurvey;
import com.example.homekiri.survey.model.FoodSurvey;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodActivityRepository{

    private final EntityManager em;

    public List<FoodActivity> findByIngredient(String ingredient){
        return em.createQuery("select f from FoodActivity f WHERE f.ingredient = :Ingredient", FoodActivity.class)
                .setParameter("Ingredient", ingredient)
                .getResultList();
    }

    public List<FoodImage> findUrlByIdx(Long Idx){
        return em.createQuery("select f from FoodImage f WHERE f.food.idx = :idx", FoodImage.class)
                .setParameter("idx", Idx)
                .getResultList();
    }

    public List<FoodActivity> findByCountry(Long idx){
        return em.createQuery("select f from FoodActivity f WHERE f.country.idx = :country", FoodActivity.class)
                .setParameter("country", idx)
                .getResultList();
    }

    public List<FoodActivity> findByTemperature(String Temperature){
        return em.createQuery("select f from FoodActivity f WHERE f.temperature = :temperature", FoodActivity.class)
                .setParameter("temperature", Temperature)
                .getResultList();
    }

    public List<FoodActivity> findByCookingState(String state){
        return em.createQuery("select f from FoodActivity f WHERE f.cookingState = :State", FoodActivity.class)
                .setParameter("State", state)
                .getResultList();
    }
}
