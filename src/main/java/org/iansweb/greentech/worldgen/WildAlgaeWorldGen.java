package org.iansweb.greentech.worldgen;
import java.util.Random;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class WildAlgaeWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		//GreentechMod.logger.info("generating for chunk " + chunkX + ":" + chunkZ);
        final int x = chunkX * 16 + 8;
        final int z = chunkZ * 16 + 8;

        final BiomeGenBase biome = world.getBiomeGenForCoords(x,z);
        
        if (biome.biomeName != "Swampland") {
        	return;
        }
        
        if (random.nextFloat() <= 0.5f) {
        	//GreentechMod.logger.info("good");
        //if (true) {
        	for (int i = 0; i < 4;i++) {
        		final int posX = x - (world.rand.nextInt(16)-8);
        		final int posZ = z - (world.rand.nextInt(16)-8);
        	
        	if (ModBlocks.WILD_ALGAE_BLOCK.canPlaceBlockAt(world, posX, 63, posZ)) {
        		world.setBlock(posX, 63, posZ, ModBlocks.WILD_ALGAE_BLOCK);
    		//world.setBlock(posX+1, 64, posZ, ModBlocks.WILD_ALGAE_BLOCK);
        	}        		
        	}
        }
	}

}
