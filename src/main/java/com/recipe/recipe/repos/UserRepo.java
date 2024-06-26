package com.recipe.recipe.repos;

import com.recipe.recipe.models.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<CustomUserDetails, Long> {
    CustomUserDetails findByUsername(String username);
}
