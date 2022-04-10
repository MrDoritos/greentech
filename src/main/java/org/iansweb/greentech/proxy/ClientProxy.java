package org.iansweb.greentech.proxy;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.iansweb.greentech.GreentechMod;
import org.iansweb.greentech.init.ModItems;
import org.iansweb.greentech.util.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		//registerItemRenderer(item, meta, id);
	}
}
