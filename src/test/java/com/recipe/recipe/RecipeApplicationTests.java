package com.recipe.recipe;

import com.recipe.recipe.controllers.RecipeController;
import com.recipe.recipe.models.*;
import com.recipe.recipe.repos.RecipeRepo;
import com.recipe.recipe.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(RecipeController.class)
//@ContextConfiguration(classes = RecipeApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(classes = RecipeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeApplicationTests  {
	@Autowired
	RecipeService recipeService;

	@Autowired
	RecipeRepo recipeRepo;

	@Autowired
	MockMvc mockMvc;

//	@Test
//	void contextLoads() {
//	}
	@Test
	public void testGetRecipeByIdSuccessBehavior() throws Exception {

		final long recipeId = 1;

		// set up GET request
		mockMvc.perform(get("/recipes/" + recipeId))

				// print response
				.andDo(print())
				// expect status 200 OK
				.andExpect(status().isOk())
				// expect return Content-Type header as application/json
				.andExpect(content().contentType(
						MediaType.APPLICATION_JSON))

				// confirm returned JSON values
				.andExpect(jsonPath("id").value(recipeId))
				.andExpect(jsonPath("minutesToMake").value(2))
				.andExpect(jsonPath("reviews", hasSize(1)))
				.andExpect(jsonPath("ingredients", hasSize(1)))
				.andExpect(jsonPath("steps", hasSize(2)));

	}




}
