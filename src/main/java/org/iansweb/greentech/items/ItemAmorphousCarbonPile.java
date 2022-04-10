package org.iansweb.greentech.items;

import java.util.List;

import org.iansweb.greentech.util.IFuel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmorphousCarbonPile extends ItemBase implements IFuel {
	public ItemAmorphousCarbonPile() {
		super("amorphous_carbon_pile");
	}
	//public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean flagIn) {
		((List<String>)info).add("Pile of amorphous carbon.");
	}
	
	@Override
	public int getBurnTime(ItemStack stack) {
		return 800;
	}
}
