package org.iansweb.greentech;

import org.apache.logging.log4j.Logger;
import org.iansweb.greentech.blocks.BlockFluid;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModFluids;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.items.ItemBucketBase;
import org.iansweb.greentech.proxy.ClientProxy;
import org.iansweb.greentech.proxy.CommonProxy;
import org.iansweb.greentech.util.FuelHandler;
import org.iansweb.greentech.util.Reference;
import org.iansweb.greentech.util.handlers.BucketHandler;
import org.iansweb.greentech.util.handlers.RightClickHandler;
import org.iansweb.greentech.worldgen.WildAlgaeWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;

@Mod(modid=Reference.MODID, version=Reference.VERSION, name=Reference.NAME)
public class GreentechMod {
	@Mod.Instance(Reference.MODID)
	public static GreentechMod instance;
	
	public static CommonProxy serverProxy = new CommonProxy();
	public static ClientProxy clientProxy = new ClientProxy();
	
	public static Logger logger;
	
	public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("tabGreentech") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(ModItems.AMORPHOUS_CARBON).getItem();
		}
	};
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(RightClickHandler.INSTANCE);
		GameRegistry.registerFuelHandler(new FuelHandler());
		ModFluids.register();
		for (Item item : ModItems.ITEMS)
			GameRegistry.registerItem(item, item.getUnlocalizedName(), Reference.MODID);
		for (Block block : ModBlocks.BLOCKS) {
			GameRegistry.registerBlock(block, block.getUnlocalizedName());
			//block.registerBlockIcons(Minecraft.getMinecraft().);
		}
		
		for (Item item : ModItems.ITEMS) {
			if (item instanceof ItemBucketBase) {
				ItemBucketBase itemBucket = (ItemBucketBase)item;
				logger.info("Created bucket");
				BucketHandler.INSTANCE.buckets.put(itemBucket.getBlock(), itemBucket);
			}
		}
		
		//GameRegistry.addSmelting(ModItems.WILD_ALGAE_BUCKET, new ItemStack(ModItems.ALGAE_CULTURE, 1), 1.0f);
		GameRegistry.addSmelting(ModItems.WILD_ALGAE_BUCKET, new ItemStack(ModItems.ALGAE_CULTURE_BUCKET), 1.0f);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ALGAE_CULTURE, 1), new ItemStack(ModItems.ALGAE_CULTURE_BUCKET, 1));
		
		//GameRegistry.registerBlock(ModBlocks.AMORPHOUS_CARBON_BLOCK, ModBlocks.AMORPHOUS_CARBON_BLOCK.getUnlocalizedName());
		//GameRegistry.registerBlock(ModBlocks.ALGAE_INFESTED_WATER, ModBlocks.ALGAE_INFESTED_WATER.getUnlocalizedName());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WildAlgaeWorldGen(),1);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("postInit");
		ModItems.IC2_STEAM_BUCKET = new ItemBucketBase("ic2_steam_bucket", GameRegistry.findBlock("IC2", "fluidSteam"));
		GameRegistry.registerItem(ModItems.IC2_STEAM_BUCKET, ModItems.IC2_STEAM_BUCKET.getUnlocalizedName());
		BucketHandler.INSTANCE.buckets.put(((ItemBucketBase)ModItems.IC2_STEAM_BUCKET).getBlock(), ModItems.IC2_STEAM_BUCKET);
		
		serverProxy.registerRecipes();
	}
}
