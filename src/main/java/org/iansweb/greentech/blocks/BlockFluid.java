package org.iansweb.greentech.blocks;

import javax.annotation.Nullable;

import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModBlocks;
import org.iansweb.greentech.util.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic {

    String texture;
    public IIcon stillIcon;
    public IIcon flowIcon;
public BlockFluid(String id, Fluid fluid, Material material, double red, double green, double blue)
{
    this(id, fluid, material);
}

public BlockFluid(String id, Fluid fluid, Material material)
{
    super(fluid, material);
    setBlockName(id);
    setCreativeTab(GreentechMod.CREATIVE_TAB);
    texture = id;
    ModBlocks.BLOCKS.add(this);
}

@Override
public int getRenderBlockPass() {
	return 0;
}

@Override
public void registerBlockIcons (IIconRegister iconRegister)
{
	GreentechMod.logger.info("Registering liquid: " + texture);
    stillIcon = iconRegister.registerIcon(Reference.MODID + ":" + texture + "_still");
     flowIcon = iconRegister.registerIcon(Reference.MODID + ":" + texture + "_flow");
    GreentechMod.logger.info("stillIcon: " + stillIcon.getIconName());
    GreentechMod.logger.info("flowIcon: " + flowIcon.getIconName());
}

@Override
@SideOnly(Side.CLIENT)
public IIcon getIcon (int side, int meta)
{
	//return stillIcon;
	
    if (side == 0 || side == 1)
        return stillIcon;
    return flowIcon;
    
}

}
