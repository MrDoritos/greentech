package org.iansweb.greentech.recipe;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.init.ModRecipes;

import ic2.api.recipe.IRecipeInput;
import ic2.core.item.ItemFluidCell;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipeAlgaeCulture implements IRecipeInput {
	public RecipeAlgaeCulture() {
		//INPUTS = new ArrayList<ItemStack>();
		//INPUTS.add(new ItemStack(GameRegistry.findItem(modId, name));
		//OUTPUT = new ItemStack(GameRegistry.find);
		ModRecipes.RECIPES.add(this);
	}

	private List<ItemStack> INPUTS;
	public ItemStack OUTPUT;
	
	@Override
	public boolean matches(ItemStack subject) {
		//return getInputFluidStack().isFluidEqual(subject);
		//return subject.getUnlocalizedName() == getInput().getUnlocalizedName();
		//return subject.isItemEqual(subject);
		return subject.isItemEqual(getInput());
	}

	public ItemStack getOutput() {
		return new ItemStack(ModItems.POWDERED_ALGAE, 1);
		
	}
	
	public FluidStack getInputFluidStack() {
		return new FluidStack(FluidRegistry.getFluid("algae_infested_water"), 1000);
	}
	
	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public List<ItemStack> getInputs() {
		// TODO Auto-generated method stub
		List<ItemStack> inputs = new ArrayList<ItemStack>();
		inputs.add(getInput());
		return inputs;
	}
	
	public ItemStack getInput() {
		//return ItemFluidCell.getUniversalFluidCell(getInputFluidStack());
		return new ItemStack(ModItems.ALGAE_INFESTED_WATER_BUCKET, 1);
	}
}
