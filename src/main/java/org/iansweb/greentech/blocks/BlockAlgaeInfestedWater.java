package org.iansweb.greentech.blocks;

import java.util.Random;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.init.ModFluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockAlgaeInfestedWater extends BlockFluid {
	public BlockAlgaeInfestedWater() {
		super("algae_infested_water", ModFluids.ALGAE_INFESTED_WATER, Material.water);
		this.setTickRandomly(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int meta) {
	    if (side == 0 || side == 1 || meta == 0)
	    	return stillIcon;
	    return flowIcon;
	}
	
	public static final Random RAND = new Random();
	
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		//if (world.getBlock(x, y, z) == Blocks.water) {
		//	return world.getBlockMetadata(x, y, z) > 3;
		//}
		return false;
	}
	
	/*
	public boolean displaceIfPossibleExt(World world, int x, int y, int z, int x1, int y1, int z1) {
        if (world.getBlock(x, y, z).isAir(world, x, y, z))
        {
            return true;
        }

        Block block = world.getBlock(x, y, z);
        if (block == this)
        {
            return false;
        }

		if (block == Blocks.water) {
			Block b = world.getBlock(x, y, z);
			if (!(b instanceof IFluidBlock))
				return false;
			
			//if (world.getBlockMetadata(x, y, z) < 4)
			//if ((BlockFluidBase))
			//	return false;
			//return true;			
		}
		
		return false;
	}
	*/
	
	/*
	@Override
	public int getRenderType() {
		return 3;
	}
	*/
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public int getRenderBlockPass() {
       return 1;
    }
	
	@Override 
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.isRemote)
			return;
		//GreentechMod.logger.info("Random tick for {0},{1},{2}", x, y, z);
		//super.updateTick(world, x, y, z, RAND);
		//updateFluidFlow(world,x,y,z);
		int lightLevel = world.getBlockLightValue(x, y, z);
		if (lightLevel > 9) {
			final int[] neighbors = {-1,0,0,1,0,0,0,-1,0,0,1,0,0,0,-1,0,0,1};
			//See if any neighbor is water (for any loops i add later on to change mechanics)
			boolean check = false;
			for (int i = 0; i < 6; i++) {
				int ix = x + neighbors[i * 3 + 0], iy = y + neighbors[i * 3 + 1], iz = z + neighbors[i * 3 + 2];
				if (world.getBlock(ix, iy, iz) == Blocks.water && world.getBlockMetadata(ix, iy, iz) == 0)
					check = true;
			}
			if (!check)
				return;
		
			//for (int i = lightLevel; i > 9; i--) {
				int index = rand.nextInt(6);
				int ix = x + neighbors[index * 3 + 0], iy = y + neighbors[index * 3 + 1], iz = z + neighbors[index * 3 + 2];
				if (world.getBlock(ix,iy,iz) == Blocks.water && world.getBlockMetadata(ix, iy, iz) == 0)
					world.setBlock(ix,iy,iz,ModBlocks.ALGAE_INFESTED_WATER);
			//}
		}
	}
	
	//Modified block tick - new fluid flow algorithm
    public void updateFluidFlow(World world, int x, int y, int z)
    {
        int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
        int expQuanta = -101;

        // check adjacent block levels if non-source
        if (quantaRemaining < quantaPerBlock)
        {
            int y2 = y - densityDir;

            if (world.getBlock(x,     y2, z    ) == this ||
                world.getBlock(x - 1, y2, z    ) == this ||
                world.getBlock(x + 1, y2, z    ) == this ||
                world.getBlock(x,     y2, z - 1) == this ||
                world.getBlock(x,     y2, z + 1) == this)
            {
                expQuanta = quantaPerBlock - 1;
            }
            else
            {
                int maxQuanta = -100;
                maxQuanta = getLargerQuanta(world, x - 1, y, z,     maxQuanta);
                maxQuanta = getLargerQuanta(world, x + 1, y, z,     maxQuanta);
                maxQuanta = getLargerQuanta(world, x,     y, z - 1, maxQuanta);
                maxQuanta = getLargerQuanta(world, x,     y, z + 1, maxQuanta);

                expQuanta = maxQuanta - 1;
            }

            // decay calculation
            if (expQuanta != quantaRemaining)
            {
                quantaRemaining = expQuanta;

                if (expQuanta <= 0)
                {
                    world.setBlock(x, y, z, Blocks.air);
                }
                else
                {
                	//	world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
                    //	world.scheduleBlockUpdate(x, y, z, this, tickRate);
                    //	world.notifyBlocksOfNeighborChange(x, y, z, this);
                	
                }
            }
        }
        // This is a "source" block, set meta to zero, and send a server only update
        else if (quantaRemaining >= quantaPerBlock)
        {
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        }

        // Flow vertically if possible
        if (canDisplace(world, x, y + densityDir, z))
        {
            flowIntoBlockExt(world, x, y + densityDir, z, 1,x,y,z);
            return;
        }

        // Flow outward if possible
        int flowMeta = quantaPerBlock - quantaRemaining + 1;
        if (flowMeta >= quantaPerBlock)
        {
            return;
        }

        if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z))
        {
            if (world.getBlock(x, y - densityDir, z) == this)
            {
                flowMeta = 1;
            }
            boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

            if (flowTo[0]) flowIntoBlockExt(world, x - 1, y, z,     flowMeta,x,y,z);
            if (flowTo[1]) flowIntoBlockExt(world, x + 1, y, z,     flowMeta,x,y,z);
            if (flowTo[2]) flowIntoBlockExt(world, x,     y, z - 1, flowMeta,x,y,z);
            if (flowTo[3]) flowIntoBlockExt(world, x,     y, z + 1, flowMeta,x,y,z);
        }
    }
	
	public boolean updateSelfBySurroundingFluids(World worldIn, int x, int y, int z, Block block) {
		final int[] neighbors = {-1,0,0,1,0,0,0,0,-1,0,0,1};
		Block self = worldIn.getBlock(x, y, z);
		int selfLevel = worldIn.getBlockMetadata(x, y, z);
		double selfFillPercentage = super.getFilledPercentage(worldIn, x, y, z);
		boolean toChangeSelf = false;
		for (int i = 0; i < 4; i++) {
			int index = i * 3;
			int ix = neighbors[index] + x, iy = neighbors[index + 1] + y, iz = neighbors[index + 2] + z;
			Block candidate = worldIn.getBlock(ix, iy, iz);
			if (candidate == null)
				return false;
			if (worldIn.getBlock(x + ix, y + iy, z + iz) instanceof IFluidBlock) {
				IFluidBlock candidateAsFluid = (IFluidBlock)candidate;
				if (candidateAsFluid.getFluid().getUnlocalizedName() == this.getFluid().getUnlocalizedName())
					continue;
				if (candidateAsFluid.getFilledPercentage(worldIn, ix, iy, iz) > selfFillPercentage) {
					worldIn.setBlockToAir(x, y, z);
					candidate.updateTick(worldIn, ix, iy, iz, RAND);
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
		//updateFluidFlow(world,x,y,z);
		
		//if (updateSelfBySurroundingFluids(world,x,y,z,block))
		//	return;
		//super.updateTick(world, x, y, z, RAND);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	//updateFluidFlow(world,x,y,z);
		//super.updateTick(world, x, y, z, RAND);
    }

	protected void flowIntoBlockExt(World world, int x, int y, int z, int meta, int x1, int y1, int z1)
	{
		if (meta < 0) 
			return;
		
		IFluidBlock self,candidate;
		Block bSelf,bCandidate;
		bCandidate = world.getBlock(x, y, z);
		bSelf = world.getBlock(x1, y1, z1);
		if (bSelf == null || bCandidate == null)
			return;
		if (!(bSelf instanceof IFluidBlock) || !(bCandidate instanceof IFluidBlock))
			return;
		self = (IFluidBlock)bSelf;
		candidate = (IFluidBlock)bCandidate;
		
		if (candidate.getFilledPercentage(world, x, y, z) > self.getFilledPercentage(world, x1, y1, z1))
			return;

		//world.setBlockMetadataWithNotify(p_72921_1_, p_72921_2_, p_72921_3_, p_72921_4_, p_72921_5_)
		world.setBlock(x, y, z, this, meta, 0);
		//world.setBlockState(x,y,z, this.getDefaultState().withProperty(LEVEL, meta), 3);
	}
}
