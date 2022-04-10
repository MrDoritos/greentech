package org.iansweb.greentech.init;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.recipe.IHasRecipe;
import org.iansweb.greentech.recipe.RecipeAlgaeCulture;
import org.iansweb.greentech.recipe.RecipeAmorphousCarbon;
import org.iansweb.greentech.recipe.RecipeAmorphousCarbonPile;
import org.iansweb.greentech.recipe.RecipeBlastFurnaceOil;
import org.iansweb.greentech.recipe.RecipeCarbonSlurry;
import org.iansweb.greentech.recipe.RecipeCompressorCoal;
import org.iansweb.greentech.recipe.RecipeExtractorAlgaeCulture;

import ic2.api.recipe.IRecipeInput;

public class ModRecipes {
	public static final List<IRecipeInput> RECIPES = new ArrayList<IRecipeInput>();
	public static final List<IHasRecipe> HASRECIPE = new ArrayList<IHasRecipe>();
	
	public static final RecipeAmorphousCarbonPile RECIPE_AMORPHOUS_CARBON_PILE = new RecipeAmorphousCarbonPile();
	public static final RecipeCompressorCoal RECIPE_COMPRESSOR_COAL = new RecipeCompressorCoal();
	public static final RecipeAmorphousCarbon RECIPE_AMORPHOUS_CARBON = new RecipeAmorphousCarbon();
	public static final RecipeBlastFurnaceOil RECIPE_BLASTFURNACE_OIL = new RecipeBlastFurnaceOil();
	public static final RecipeCarbonSlurry RECIPE_CARBON_SLURRY = new RecipeCarbonSlurry();
	public static final RecipeExtractorAlgaeCulture RECIPE_EXTRACTOR_ALGAE_CULTURE = new RecipeExtractorAlgaeCulture();
	public static final RecipeAlgaeCulture RECIPE_ALGAE_CULTURE = new RecipeAlgaeCulture();
}
