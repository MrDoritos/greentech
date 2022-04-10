package org.iansweb.greentech.util;

import net.minecraft.item.ItemStack;

public interface IFuel {
	public int getBurnTime(ItemStack stack);
}
