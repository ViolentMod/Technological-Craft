package violentninjad.technologicalcraft.client.gui;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import violentninjad.technologicalcraft.TechnologicalCraft;
import violentninjad.technologicalcraft.configuration.TCConfigHandler;

public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(TCConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                TechnologicalCraft.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(TCConfigHandler.configuration.toString()));
    }
}
