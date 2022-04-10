package org.iansweb.greentech.init;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.blocks.BlockAlgaeInfestedWater;
import org.iansweb.greentech.blocks.BlockBase;
import org.iansweb.greentech.blocks.BlockFluid;
import org.iansweb.greentech.blocks.BlockWildAlgae;
import org.iansweb.greentech.machines.MachineCarbonSequestrator;
//import org.iansweb.greentech.machines.MachineCarbonSequestrator;
import org.iansweb.greentech.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
//import net.minecraftforge.client.event.ModelRegistryEvent;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final MachineCarbonSequestrator CARBON_SEQUESTRATOR = new MachineCarbonSequestrator();	
	public static final Block CARBON_SLURRY = new BlockFluid("carbon_slurry", ModFluids.CARBON_SLURRY, Material.water);
	public static final Block ALGAE_INFESTED_WATER = new BlockAlgaeInfestedWater();
	public static final Block AMORPHOUS_CARBON_BLOCK = new BlockBase("amorphous_carbon_block", Material.sand);
	public static final Block WILD_ALGAE_BLOCK = new BlockWildAlgae();
}
