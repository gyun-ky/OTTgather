package com.example.homekiri.story.repository;

import com.example.homekiri.story.model.Story;
import com.example.homekiri.story.model.StoryLike;
import com.example.homekiri.story.model.StorySubCategory;
import com.example.homekiri.user.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StoryRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Story story){
        em.persist(story);
        System.out.println("[JPA] save complete");
    }

    public void saveLike(StoryLike like){
        em.persist(like);
        System.out.println("[JPA] saveLike complete");
    }

    public StorySubCategory findStorySubCategoryByIdx(Long idx){
        StorySubCategory storySubCategory = em.find(StorySubCategory.class, idx);
        System.out.println("[JPA] findStorySubCategoryByIdx complete");
        return storySubCategory;
    }

    public StorySubCategory getReferenceByIdx(Long idx){
        StorySubCategory storySubCategory = em.getReference(StorySubCategory.class, idx);
        System.out.println("[JPA] getReferenceByIdx complete");
        return storySubCategory;
    }
}
