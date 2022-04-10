package org.iansweb.greentech.util.handlers;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModItems;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class RightClickHandler {
	public static RightClickHandler INSTANCE = new RightClickHandler();
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onBlockActivated(PlayerInteractEvent event) {
		/*
		GreentechMod.logger.info("a");
		if (event.entityPlayer == null)
			return;
		GreentechMod.logger.info("b");
		ItemStack stack = event.entityPlayer.inventory.getCurrentItem();
		if (stack == null)
			return;
		GreentechMod.logger.info("c");
		if (stack.isItemEqual(new ItemStack(ModItems.ALGAE_CULTURE, 1))) {
			if (event.world.isRemote)
				return;
			GreentechMod.logger.info("d");
			if (stack.stackSize > 0 && Block.isEqualTo(event.world.getBlock(event.x, event.y, event.z), Blocks.water)) {
				stack.stackSize--;
				event.world.setBlock(event.x, event.y, event.z, ModBlocks.ALGAE_INFESTED_WATER);
				event.entityPlayer.inventoryContainer.detectAndSendChanges();
				GreentechMod.logger.info("e");
				return;
			}
		}
		*/
	} 
}
