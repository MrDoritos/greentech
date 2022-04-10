package org.iansweb.greentech.recipe;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.init.ModRecipes;

import ic2.api.recipe.IRecipeInput;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeAmorphousCarbonPile implements IRecipeInput {
	public RecipeAmorphousCarbonPile() {
		INPUTS = new ArrayList<ItemStack>();
		INPUTS.add(new ItemStack(ModItems.AMORPHOUS_CARBON_PILE));
		OUTPUT = new ItemStack(Items.coal);
		ModRecipes.RECIPES.add(this);
	}
	
	@Override
	public boolean matches(ItemStack subject) {
		GreentechMod.logger.info("testing match " + subject.getItem().getUnlocalizedName() + " == " + ModItems.AMORPHOUS_CARBON_PILE.getUnlocalizedName());
		return (subject.isItemEqual(new ItemStack(ModItems.AMORPHOUS_CARBON_PILE)));
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 1;
	}

	private List<ItemStack> INPUTS;
	public ItemStack OUTPUT;
	
	public ItemStack getOutput() {
		return OUTPUT;
	}
	
	public IRecipeInput getRecipe() {
		return this;
	}
	
	@Override
	public List<ItemStack> getInputs() {
		// TODO Auto-generated method stub
		return INPUTS;
	}

}
