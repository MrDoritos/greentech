package org.iansweb.greentech.machines;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Level;
import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.tileentity.TileEntityCarbonSequestrator;
import org.iansweb.greentech.util.IHasModel;
import org.iansweb.greentech.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class MachineCarbonSequestrator extends BlockContainer implements IHasModel {

	public MachineCarbonSequestrator() {
		super(Material.iron);
		
		setBlockName("carbon_sequestrator");
		this.setBlockTextureName(Reference.MODID + ":" + this.getUnlocalizedName());
		
		this.setHardness(3.0f);
		this.setCreativeTab(GreentechMod.CREATIVE_TAB);
		
		ModBlocks.BLOCKS.add(this);
		//ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public Class<TileEntityCarbonSequestrator> getTileEntityClass() {
		return TileEntityCarbonSequestrator.class;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityCarbonSequestrator();
	}
		
	@Override
    public boolean onBlockActivated(World worldIn, int posX, int posY, int posZ, EntityPlayer playerIn, int facing, float hitX, float hitY, float hitZ) {
		if (playerIn.isSneaking())
			return false;
		if (worldIn.isRemote)
			return true;
		
		//return false;

		playerIn.openGui(GreentechMod.instance, 0, worldIn, posX, posY, posZ);
	
    	return true;    	
	}
	
	@Override
	public void breakBlock(World worldIn, int posX, int posY, int posZ, Block block, int t) {
		TileEntity tileEntity = worldIn.getTileEntity(posX, posY, posZ);
		if (tileEntity instanceof IInventory) {
			//InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileEntity);
			
		}		
		super.breakBlock(worldIn, posX, posY, posZ, block, t);
	}
	
	@Override
	public void registerModels() {
		GreentechMod.clientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}
}
