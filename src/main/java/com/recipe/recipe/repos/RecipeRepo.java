package com.recipe.recipe.repos;

import com.recipe.recipe.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    List<Recipe> findByNameContainingIgnoreCase(String name);

    List<Recipe> findByAvgGreaterThanEqual(Double avg);

    Recipe findRecipeByReviews_Id(Long id);

    Recipe findRecipeByNameAndDifficultyRating(String name, Integer difficultyRating);

    List<Recipe> findByUser_id(Long id);

}
