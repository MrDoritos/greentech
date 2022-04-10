package org.iansweb.greentech.tileentity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Level;
import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModItems;

import ic2.api.energy.prefab.BasicSink;
import ic2.api.tile.IWrenchable;
import ic2.core.block.machine.tileentity.TileEntityElectricMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

public class TileEntityCarbonSequestrator extends TileEntityElectricMachine implements IInventory, IWrenchable {
	//private EnergyStorage energyStorage = new EnergyStorage();
	//private BasicSink energyBuffer;
	private short facing;
	private List<ItemStack> carbonSequestratorItemStacks = new ArrayList<ItemStack>();
	private int ticksPassed;
	private static final int SLOT_OUTPUT = 0;	
	
	
	public TileEntityCarbonSequestrator() {
		super(3200, 1, 1);
		//this.energyBuffer = new BasicSink(this, 32000, 1);
		carbonSequestratorItemStacks.add(new ItemStack(ModItems.AMORPHOUS_CARBON, 0));
		this.facing = (short)EnumFacing.NORTH.ordinal();
		this.ticksPassed = 0;
	}
		
	@Override
	public short getFacing() {
		return facing;
	}

	@Override
	public void setFacing(short newDirection) {
		facing = newDirection;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ItemStack getWrenchDrop(EntityPlayer player) {
		return new ItemStack(ModBlocks.CARBON_SEQUESTRATOR, 1, 0);
	}
		
	@Override
	public int getSizeInventory() {
		return 1;
	}

	public boolean isEmpty() {
        for (ItemStack itemstack : this.carbonSequestratorItemStacks)
        {
            if (itemstack.stackSize > 0)
            {
                return false;
            }
        }

        //return true;
        return false;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return new ItemStack(ModItems.AMORPHOUS_CARBON, 1);
		/*
		if (index >= getSizeInventory())
			return null;
        return this.carbonSequestratorItemStacks.get(index);
        */
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) {	
		return new ItemStack(ModItems.AMORPHOUS_CARBON, 1);
		/*
		GreentechMod.logger.info("cur: {2} decrStackSize {0} {1}", index, count, getStackInSlot(0).stackSize);
		if (index >= getSizeInventory())
			return null;	
        //return ItemStackHelper.getAndSplit(this.carbonSequestratorItemStacks, index, count);
		if (getStackInSlot(index).stackSize <= count) {
			getStackInSlot(index).stackSize = 0;
			return getStackInSlot(index);
		}
		ItemStack ret = getStackInSlot(index).splitStack(count);
		//ret.stackSize = ret.stackSize < count ? ret.stackSize : count;
		//getStackInSlot(index).stackSize -= ret.stackSize;		
		return ret;
		*/
	}

	public ItemStack removeStackFromSlot(int index) {
		GreentechMod.logger.info("cur: {1} removeStackFromSlot {0}", index, getStackInSlot(0).stackSize);
		if (index >= getSizeInventory())
			return null;
        //return ItemStackHelper.getAndRemove(this.carbonSequestratorItemStacks, index);
		ItemStack ret = getStackInSlot(index).copy();
		getStackInSlot(index).stackSize = 0;
		return ret;
		
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index >= getSizeInventory())
			return;
        carbonSequestratorItemStacks.set(index, stack);
        if (stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 0)
			return false;
		return false;
	}

	public int getField(int id) {
		return 0;
	}

	public void setField(int id, int value) {
		
	}

	public int getFieldCount() {
		return 0;
	}

	public void clear() {
		this.carbonSequestratorItemStacks.get(SLOT_OUTPUT).stackSize = 0;
	}
	
	public void printDebugInfo() {
		//GreentechMod.logger.log(Level.INFO, "Energy: " + energyBuffer.getEnergyStored() + " Carbon: " + this.getStackInSlot(SLOT_OUTPUT).getCount() + " Ticks: " + ticksPassed);
		if (Minecraft.getMinecraft().theWorld.playerEntities.isEmpty())
			return;
		//Minecraft.getMinecraft().theWorld.playerEntities.get(0).sendMessage(new TextComponentString("Energy: " + energyBuffer.getEnergyStored() + " Carbon: " + this.getStackInSlot(SLOT_OUTPUT).getCount() + " Ticks: " + ticksPassed));
	}
	

   public double getEnergy() {
      return this.energy;
   }

   public boolean useEnergy(double amount) {
      if (this.energy >= amount) {
         this.energy -= amount;
         return true;
      } else {
         return false;
      }
   }
	
   @Override
	public void updateEntityServer() {
		//this.energyBuffer.update();
		
		ItemStack output = this.getStackInSlot(SLOT_OUTPUT);
		
		if (output.stackSize > 63)
			return;
		
		if (getEnergy() > 799 && ++ticksPassed > 49 && useEnergy(800)) {
			if (output.stackSize > 0) {
				output.stackSize = (output.stackSize + 1);
			} else {
				output = new ItemStack(ModItems.AMORPHOUS_CARBON, 1);
			}
			ticksPassed = 0;
			this.carbonSequestratorItemStacks.set(SLOT_OUTPUT, output);			
			//this.markDirty();
		}
	}
	
	
	/*
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY)
			return (T) energyBuffer;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (facing != EnumFacing.UP && capability == CapabilityEnergy.ENERGY)
			return true;
		return false;
	}
	*/

	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getWrenchDropRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
}
