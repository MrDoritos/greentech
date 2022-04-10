package org.iansweb.greentech.items;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.util.IHasModel;
import org.iansweb.greentech.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class ItemBucketBase extends ItemBucket implements IHasModel {
	private Block _block;
	
	
	public ItemBucketBase(String name, Block block) {
		super(block);
		
		setUnlocalizedName(name);
		
		this.setTextureName(Reference.MODID + ":" + name);
		//setRegistryName(name);
		setCreativeTab(GreentechMod.CREATIVE_TAB);
		
		this._block = block;
		ModItems.ITEMS.add(this);
	}
	
	public Block getBlock() {
		return _block;
	}
	
	@Override
	public void registerModels() {
		GreentechMod.clientProxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
