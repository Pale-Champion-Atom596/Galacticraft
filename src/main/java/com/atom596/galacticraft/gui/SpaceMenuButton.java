package com.atom596.galacticraft.gui;

import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SpaceMenuButton extends WPlainPanel {
    WSprite bodySprite;
    WButton bodyTpButton;

    public SpaceMenuButton() {}

    public void init (String sprite, String name, PlayerEntity player, World world) {
        this.bodySprite = new WSprite(new Identifier(sprite));
        this.bodyTpButton = new WButton(Text.translatable(name));

        this.add(bodySprite, 0, 0, 20, 20);
        this.add(bodyTpButton, 25, 0, 80, 20);

        setTeleportDim(player, world);
    }

    public void setTeleportDim(PlayerEntity player, World world) {
        bodyTpButton.setOnClick(() -> {
            player.moveToWorld((ServerWorld) world).getServer().getWorld(World.NETHER);
        });
    }
}
