package org.iansweb.greentech.init;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.fluids.FluidBase;
//import org.iansweb.greentech.fluids.FluidCarbonSlurry;
import org.iansweb.greentech.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
	public static final List<Fluid> FLUIDS = new ArrayList<Fluid>();
	
	public static final Fluid CARBON_SLURRY = new FluidBase("carbon_slurry");
	public static final Fluid ALGAE_INFESTED_WATER = new FluidBase("algae_infested_water");
	//public static final Fluid WILD_ALGAE = new FluidBase("wild_algae");
	
	public static void register() {
		for (Fluid modFluid : FLUIDS) {
			//FluidRegistry.addBucketForFluid(modFluid);
			FluidRegistry.registerFluid(modFluid);
			
		}
		//FluidRegistry.addBucketForFluid(CARBON_SLURRY);
		//FluidRegistry.registerFluid(CARBON_SLURRY);
	}
}
