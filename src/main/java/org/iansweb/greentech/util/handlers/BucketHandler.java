package org.iansweb.greentech.util.handlers;

import java.util.HashMap;
import java.util.Map;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketHandler {
	public static BucketHandler INSTANCE = new BucketHandler();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();
	
	@SubscribeEvent
	public void bucketFill(FillBucketEvent event) {
		GreentechMod.logger.info("onBucketFill");
		ItemStack result = fillBucket(event.world, event.target);
		if (result == null)
			return;
		event.result = result;
		event.setResult(Result.ALLOW);
	}
	
	private ItemStack fillBucket(World world, MovingObjectPosition pos) {
		GreentechMod.logger.info("fillBucket");
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
		
		Item bucket = buckets.get(block);
		//Item bucket = ModItems.CARBON_SLURRY_BUCKET;
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else {
			return null;
		}		
	}
}
