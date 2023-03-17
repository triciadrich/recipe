package com.recipe.recipe.repos;

import com.recipe.recipe.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByUsername(String username);
}
