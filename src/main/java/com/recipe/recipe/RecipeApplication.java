package com.recipe.recipe;

import com.recipe.recipe.models.*;
import com.recipe.recipe.repos.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class RecipeApplication  {

	public static void main(String[] args) {

		SpringApplication.run(RecipeApplication.class, args);
	}

}
