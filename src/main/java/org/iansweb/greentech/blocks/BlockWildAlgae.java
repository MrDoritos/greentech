package org.iansweb.greentech.blocks;

import java.util.List;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWildAlgae extends BlockBush {
	public static final String _name = "wild_algae_block";
	public BlockWildAlgae() {
	      float var1 = 0.5F;
	      float var2 = 0.015625F;
	      this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
	      	this.setBlockName(_name);
			super.setBlockTextureName(Reference.MODID + ":" + _name);
			ModBlocks.BLOCKS.add(this);
			setCreativeTab(GreentechMod.CREATIVE_TAB);
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int X, float Y, float Z, float f){
			if (world.isRemote) {
				return true;
			}
		
			ItemStack itemstack = entityplayer.inventory.getCurrentItem();

			if(itemstack.isItemEqual(new ItemStack(Items.bucket, 1)) && itemstack.stackSize == 1) {
				//EntityItem entityitem = new EntityItem(world, x, y, z, new ItemStack(Items.blaze_powder, 4));
				//entityitem.delayBeforeCanPickup = 10;
				//world.spawnEntityInWorld(entityitem);
				entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, new ItemStack(ModItems.WILD_ALGAE_BUCKET, 1));
				world.setBlockToAir(x, y, z);
                entityplayer.inventoryContainer.detectAndSendChanges();
                //world.markBlockForUpdate(x,y,z);
                
                
                return true;
			}
			
			return false;
	}
	
	   //@Override
	   public int getRenderType() {
		      return 23;
		   }

	  // @Override
	   public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
	      if(p_149743_7_ == null || !(p_149743_7_ instanceof EntityBoat)) {
	         super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
	      }
	   }

	   //@Override
	   public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		   return AxisAlignedBB.getBoundingBox(0, 0,0,0,0,0);
	      //return AxisAlignedBB.getBoundingBox((double)p_149668_2_ + this.field_149759_B, (double)p_149668_3_ + this.field_149760_C, (double)p_149668_4_ + this.field_149754_D, (double)p_149668_2_ + this.field_149755_E, (double)p_149668_3_ + this.field_149756_F, (double)p_149668_4_ + this.field_149757_G);
	   }

	   //@Override
	   public int getBlockColor() {
	      return 2129968;
	   }

	   //Override
	   public int getRenderColor(int p_149741_1_) {
	      return 2129968;
	   }

	   //@Override
	   public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
	      return 2129968;
	   }

	   protected boolean func_149854_a(Block p_149854_1_) {
	      return p_149854_1_ == Blocks.water;
	   }

	   @Override
	   public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
	      return p_149718_3_ >= 0 && p_149718_3_ < 256?p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_).getMaterial() == Material.water && p_149718_1_.getBlockMetadata(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == 0:false;
	   }
	   @Override
	   public boolean canPlaceBlockAt(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
		      return p_149718_3_ >= 0 && p_149718_3_ < 256?p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_).getMaterial() == Material.water && p_149718_1_.getBlockMetadata(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == 0:false;
		   }
}
