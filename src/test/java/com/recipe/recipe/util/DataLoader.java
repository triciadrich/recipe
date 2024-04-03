package com.recipe.recipe.util;

import com.recipe.recipe.models.*;
import com.recipe.recipe.models.Role.Roles;
import com.recipe.recipe.repos.RecipeRepo;
import com.recipe.recipe.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
@Component
@Profile("test")
public class DataLoader implements CommandLineRunner {
    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    UserRepo userRepo;
    @Override
    public void run(String...args) throws Exception{
        System.out.println("STARTING WITH TEST DATABASE SETUP");
    if(userRepo.findAll().isEmpty() && recipeRepo.findAll().isEmpty()) {
        CustomUserDetails user1 = CustomUserDetails.builder()
                .username("user1")
                .password("123456789")
                .authorities(Set.of(Role.builder()
                        .role(Roles.ROLE_ADMIN)
                        .build()))
                .userMeta(UserMeta.builder()
                        .email("user1@email.com")
                        .name("firstname")
                        .build())
                .build();
        userRepo.save(user1);

        CustomUserDetails user2 = CustomUserDetails.builder()
                .username("user2")
                .password("223456789")
                .authorities(Set.of(Role.builder()
                        .role(Roles.ROLE_USER)
                        .build()))
                .userMeta(UserMeta.builder()
                        .email("user2@email.com")
                        .name("secondname")
                        .build())
                .build();
        userRepo.save(user2);








            Ingredient ingredient = Ingredient.builder()
                    .name("flour")
                    .state("dry")
                    .amount("2 cups")
                    .build();
            Step step1 = Step.builder()
                    .description("put flour in bowl")
                    .stepNumber(1)
                    .build();
            Step step2 = Step.builder()
                    .description("eat it?")
                    .stepNumber(2)
                    .build();

            Review review = Review.builder()
                    .description("tasted pretty bad")
                    .rating(2)
                    .user(user1)
                    .build();

            Recipe recipe1 = Recipe.builder()
                    .name("test recipe")
                    .difficultyRating(10)
                    .minutesToMake(2)
                    .ingredients(Set.of(ingredient))
                    .steps(Set.of(step1, step2))
                    .reviews(Set.of(review))
                    .user(user1)
                    .build();

            recipeRepo.save(recipe1);

            ingredient.setId(null);
            Recipe recipe2 = Recipe.builder()
                    .steps(Set.of(Step.builder()
                            .description("test")
                            .build()))
                    .ingredients(Set.of(Ingredient.builder()
                            .name("test ing")
                            .amount("1")
                            .state("dry")
                            .build()))
                    .name("another test recipe")
                    .difficultyRating(10)
                    .minutesToMake(2)
                    .user(user2)
                    .build();
            recipeRepo.save(recipe2);

            Recipe recipe3 = Recipe.builder()
                    .steps(Set.of(Step.builder()
                            .description("test 2")
                            .build()))
                    .ingredients(Set.of(Ingredient.builder()
                            .name("test ing 2")
                            .amount("2")
                            .state("wet")
                            .build()))
                    .name("another another test recipe")
                    .difficultyRating(5)
                    .minutesToMake(2)
                    .user(user2)
                    .build();

            recipeRepo.save(recipe3);

            Recipe recipe4 = Recipe.builder()
                    .name("chocolate and potato chips")
                    .difficultyRating(10)
                    .minutesToMake(1)
                    .ingredients(Set.of(
                            Ingredient.builder()
                                    .name("potato chips")
                                    .amount("1 bag")
                                    .build(),
                            Ingredient.builder()
                                    .name("chocolate")
                                    .amount("1 bar")
                                    .build()))
                    .steps(Set.of(Step.builder()
                            .stepNumber(1)
                            .description("eat both items together")
                            .build()))
                    .reviews(Set.of(Review.builder()
                            .user(user1)
                            .rating(10)
                            .description("this stuff is so good")
                            .build()))
                    .user(user1)
                    .build();

            recipeRepo.save(recipe4);
            System.out.println("FINISHED TEST DATABASE SETUP");
        }
    }
}
