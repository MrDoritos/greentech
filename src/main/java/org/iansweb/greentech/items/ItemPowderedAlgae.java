package org.iansweb.greentech.items;

import org.iansweb.greentech.util.IFuel;

import net.minecraft.item.ItemStack;

public class ItemPowderedAlgae extends ItemBase implements IFuel {
	public ItemPowderedAlgae() {
		super("powdered_algae");
	}

	@Override
	public int getBurnTime(ItemStack stack) {
		// TODO Auto-generated method stub
		return 100;
	}
	
	

}
