package com.atom596.galacticraft.items;

import com.atom596.galacticraft.gui.SpaceMenuGui;
import com.atom596.galacticraft.gui.SpaceMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Passport extends Item {
    public Passport(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient.getInstance().setScreen(new SpaceMenuScreen(new SpaceMenuGui(user, world)));

        return super.use(world, user, hand);
    }
}
