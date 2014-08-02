package violentninjad.technologicalcraft.configuration;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import violentninjad.technologicalcraft.TechnologicalCraft;

import java.io.File;

public class TCConfigHandler
{

    public static Configuration configuration;

    public static boolean configGenChromeOre = false;

    public static void initialise(File configFile)
    {

        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }


    }

    private static void loadConfiguration()
    {
        configGenChromeOre = configuration.get(Configuration.CATEGORY_GENERAL, "chromeOreGen", true, "Do you want Chrome Ore to spawn?").getBoolean(true);
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(TechnologicalCraft.MOD_ID))
        {
            loadConfiguration();
        }
    }

}
