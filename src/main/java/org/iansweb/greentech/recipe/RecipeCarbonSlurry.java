package org.iansweb.greentech.recipe;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.init.ModRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.recipe.IRecipeInput;
import ic2.core.item.ItemFluidCell;
import ic2.core.item.ItemIC2FluidContainer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipeCarbonSlurry implements IRecipeInput {
	public RecipeCarbonSlurry() {
		//INPUTS = new ArrayList<ItemStack>();
		//INPUTS.add(new ItemStack(GameRegistry.findItem(modId, name));
		//OUTPUT = new ItemStack(GameRegistry.find);
		ModRecipes.RECIPES.add(this);
	}

	private List<ItemStack> INPUTS;
	public ItemStack OUTPUT;
	
	@Override
	public boolean matches(ItemStack subject) {
		//GreentechMod.logger.info("Testing match");
		//GreentechMod.logger.info(subject.getItem().getUnlocalizedName());
		//GreentechMod.logger.info(getInput().getItem().getUnlocalizedName());
		
		//GreentechMod.logger.info(subject..getFluidID());
		//GreentechMod.logger.info(getInputFluidStack().getFluidID());
		//GreentechMod.logger.info(getInputFluidStack().isFluidEqual(subject));
		//if (subject.getItem() instanceof ItemFluidCell)
			//GreentechMod.logger.info((ItemFluidCell)(subject.getItem()).);
		//	GreentechMod.logger.info(((ItemFluidCell)subject.getItem()).getFluid(subject).getFluidID());
		return getInputFluidStack().isFluidEqual(subject);
		//return subject.getItem().getUnlocalizedName()
		//return false;
		//return subject.isItemEqual(getOutput());
		// TODO Auto-generated method stub
		//return false;
	}

	public ItemStack getOutput() {
		return ItemFluidCell.getUniversalFluidCell(new FluidStack(FluidRegistry.getFluid("oil"), 1000));
		
	}
	
	public FluidStack getInputFluidStack() {
		return new FluidStack(FluidRegistry.getFluid("carbon_slurry"), 1000);
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
		return ItemFluidCell.getUniversalFluidCell(new FluidStack(FluidRegistry.getFluid("carbon_slurry"), 1000));
	}

}
