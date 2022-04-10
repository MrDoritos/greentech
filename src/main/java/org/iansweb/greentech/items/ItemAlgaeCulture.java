package org.iansweb.greentech.items;

import org.iansweb.greentech.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemAlgaeCulture extends ItemBase {

	public ItemAlgaeCulture() {
		super("algae_culture");
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
		if (mop == null) {
			return stack;
		} else {
			if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				int x = mop.blockX, y = mop.blockY, z = mop.blockZ;
				if (!world.canMineBlock(player, x, y, z)) {
					return stack;
				}
				
				Material mat = world.getBlock(x, y, z).getMaterial();
				int num = world.getBlockMetadata(x, y, z);
				if (mat == Material.water && num == 0) {
					world.setBlock(x, y, z, ModBlocks.ALGAE_INFESTED_WATER);
					if (stack.stackSize < 2)
						return null;
					ItemStack ret = stack.copy();					
					ret.stackSize--;
					return ret;					
				}
			}
		}		
		return stack;
	}

}
