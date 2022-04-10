package org.iansweb.greentech.fluids;

import javax.annotation.Nullable;

import org.iansweb.greentech.init.ModFluids;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidBase extends Fluid {
	
	
	public FluidBase(String fluidName) {
		super(fluidName);
		
		//super.setIcons(fluidName+"still", fluidName+"flowing")
		ModFluids.FLUIDS.add(this);
	}
}
