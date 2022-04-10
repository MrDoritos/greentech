package org.iansweb.greentech.items;

import java.util.List;

import org.iansweb.greentech.util.IFuel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmorphousCarbon extends ItemBase implements IFuel {
	public ItemAmorphousCarbon() {
		super("amorphous_carbon");
	}
	//public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean flagIn) {
		((List<String>)info).add("Carbon that lacks a crystal structure. Burns hot and fast.");
	}
	
	@Override
	public int getBurnTime(ItemStack stack) {
		return 200;
	}
}
