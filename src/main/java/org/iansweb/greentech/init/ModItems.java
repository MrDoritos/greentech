package org.iansweb.greentech.init;

import java.util.ArrayList;
import java.util.List;

import org.iansweb.greentech.items.ItemAlgaeCulture;
import org.iansweb.greentech.items.ItemAmorphousCarbon;
import org.iansweb.greentech.items.ItemAmorphousCarbonPile;
import org.iansweb.greentech.items.ItemBase;
import org.iansweb.greentech.items.ItemBucketBase;
import org.iansweb.greentech.items.ItemPowderedAlgae;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item AMORPHOUS_CARBON = new ItemAmorphousCarbon();// = new ItemBase("amorphous_carbon");
	public static final Item AMORPHOUS_CARBON_PILE = new ItemAmorphousCarbonPile();
	public static final Item ALGAE_CULTURE = new ItemAlgaeCulture();
	public static final Item POWDERED_ALGAE = new ItemPowderedAlgae();
	public static final Item CARBON_SLURRY_BUCKET = new ItemBucketBase("carbon_slurry_bucket", ModBlocks.CARBON_SLURRY);
	public static final Item ALGAE_INFESTED_WATER_BUCKET = new ItemBucketBase("algae_infested_water_bucket", ModBlocks.ALGAE_INFESTED_WATER);
	public static final Item WILD_ALGAE_BUCKET = new ItemBase("wild_algae_bucket");
	public static final Item ALGAE_CULTURE_BUCKET = new ItemBucketBase("algae_culture_bucket", Blocks.air);
	public static Item IC2_STEAM_BUCKET;
	public static Item IC2_DISTILLED_WATER_BUCKET;
}
