package com.atom596.galacticraft.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class SpaceMenuGui extends LightweightGuiDescription {
    public SpaceMenuGui(PlayerEntity user, World world) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        root.setInsets(Insets.ROOT_PANEL);

        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/redstone.png"));
        root.add(icon, 0, 2, 1, 1);

        ArrayList<ArrayList<String>> bodiesData = new ArrayList<>();
            ArrayList<String> overworld = new ArrayList<>();
            overworld.add("galacticraft:textures/gui/bodies/overworld.png");
            overworld.add("gui.galacticraft.overworldButton");
        bodiesData.add(overworld);
            ArrayList<String> luna = new ArrayList<>();
            luna.add("galacticraft:textures/gui/bodies/luna.png");
            luna.add("gui.galacticraft.lunaButton");
        bodiesData.add(luna);

        BiConsumer<ArrayList<String>, SpaceMenuButton> configurator = (ArrayList<String> data, SpaceMenuButton button) -> {
            button.init(data.get(0), data.get(1), user, world);
        };

        WListPanel<ArrayList<String>, SpaceMenuButton> bodiesList = new WListPanel<ArrayList<String>, SpaceMenuButton>(bodiesData, SpaceMenuButton::new, configurator);
        bodiesList.setListItemHeight(2*18);
        root.add(bodiesList, 0, 3, 10, 5);

        root.validate(this);
    }
}
