package org.iansweb.greentech.proxy;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModRecipes;
import org.iansweb.greentech.recipe.IHasRecipe;

//import org.iansweb.greentech.init.ModBlocks;
//import org.iansweb.greentech.init.ModRecipes;
//import org.iansweb.greentech.init.ModTileEntities;
//import org.iansweb.greentech.recipe.IHasRecipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
//import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {
		
	}
	
	public void registerRenderInformation(Item item) {
		
	}
		
	public void registerRecipes() {
		GreentechMod.logger.info("recipes");
		for (IHasRecipe recipe : ModRecipes.HASRECIPE) {
			GreentechMod.logger.info("doing smth");
			((IHasRecipe)recipe).registerRecipes();
		}
	}

	public void registerRenderers() {
		// TODO Auto-generated method stub
		
	}
}
