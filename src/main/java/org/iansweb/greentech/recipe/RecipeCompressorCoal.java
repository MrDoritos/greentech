package org.iansweb.greentech.recipe;

import java.util.Map;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.init.ModRecipes;

import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
//import ic2.api.recipe.RecipeInputItemStack;
//import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class RecipeCompressorCoal implements IHasRecipe {
	public RecipeCompressorCoal() {
		//Recipes.compressor.addRecipe(ModRecipes.RECIPE_AMORPHOUS_CARBON_PILE.getRecipe(), null, false, ModRecipes.RECIPE_AMORPHOUS_CARBON_PILE.getOutput());
		ModRecipes.HASRECIPE.add(this);
	}

	@Override
	public void registerRecipes() {
		GreentechMod.logger.info("registering recipes");
		// TODO Auto-generated method stub
		//Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(ModItems.AMORPHOUS_CARBON_PILE)), null, new ItemStack(Items.COAL));
		//Recipes.compressor.addRecipe(Blocks.leaves, null, new ItemStack(Blocks.dirt));
		Recipes.compressor.addRecipe(ModRecipes.RECIPE_AMORPHOUS_CARBON_PILE.getRecipe(), null, ModRecipes.RECIPE_AMORPHOUS_CARBON_PILE.getOutput());
		Recipes.compressor.addRecipe(ModRecipes.RECIPE_AMORPHOUS_CARBON.getRecipe(), null, new ItemStack(Items.coal));
	}
	
	
}
