package org.iansweb.greentech.items;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.util.IHasModel;
import org.iansweb.greentech.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
		
	public ItemBase(String name) {
		//setTranslationKey(name);
		setUnlocalizedName(name);
		
		this.setTextureName(Reference.MODID + ":" + name);
		//setRegistryName(name);
		setCreativeTab(GreentechMod.CREATIVE_TAB);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		GreentechMod.clientProxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
