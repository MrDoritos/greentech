package org.iansweb.greentech.recipe;

import org.iansweb.greentech.init.ModRecipes;

import ic2.api.recipe.Recipes;

public class RecipeBlastFurnaceOil implements IHasRecipe {
	public RecipeBlastFurnaceOil() {
		ModRecipes.HASRECIPE.add(this);
	}
	@Override
	public void registerRecipes() {
		// TODO Auto-generated method stub
		Recipes.blastfurance.addRecipe(ModRecipes.RECIPE_CARBON_SLURRY, null, ModRecipes.RECIPE_CARBON_SLURRY.getOutput());
	}

}
