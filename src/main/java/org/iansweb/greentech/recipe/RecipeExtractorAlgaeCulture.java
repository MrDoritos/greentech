package org.iansweb.greentech.recipe;

import org.iansweb.greentech.init.ModRecipes;

import ic2.api.recipe.Recipes;

public class RecipeExtractorAlgaeCulture implements IHasRecipe {
	public RecipeExtractorAlgaeCulture() {
		ModRecipes.HASRECIPE.add(this);
	}
		
	@Override
	public void registerRecipes() {
		Recipes.extractor.addRecipe(ModRecipes.RECIPE_ALGAE_CULTURE, null, ModRecipes.RECIPE_ALGAE_CULTURE.getOutput());
		
	}

}
