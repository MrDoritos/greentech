package org.iansweb.greentech.blocks;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.util.IHasModel;
import org.iansweb.greentech.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	public BlockBase(String name, Material material) {
		super (material);
		//setUnlocalizedName(name);
		//setRegistryName(name);
		setBlockName(name);
		super.setBlockTextureName(Reference.MODID + ":" + name);
		ModBlocks.BLOCKS.add(this);
		setCreativeTab(GreentechMod.CREATIVE_TAB);
		//ModItems.ITEMS.add(new ItemBlock(this).setUnlocalizedName(this.getUnlocalizedName()));
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		GreentechMod.clientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
