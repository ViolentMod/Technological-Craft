package violentninjad.technologicalcraft;
//Copyright ViolentNInjaD 2014


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import violentninjad.technologicalcraft.configuration.TCConfigHandler;
import violentninjad.technologicalcraft.init.*;
import violentninjad.technologicalcraft.proxy.IProxy;
import violentninjad.technologicalcraft.reference.GUI;
import violentninjad.technologicalcraft.reference.Proxies;
import violentninjad.technologicalcraft.util.LogHelper;
import violentninjad.technologicalcraft.world.TCWorld;

@Mod(modid = TechnologicalCraft.MOD_ID, name = TechnologicalCraft.MOD_NAME, version = TechnologicalCraft.MOD_VERSION, guiFactory = GUI.GUI_FACTORY_REF)
public class TechnologicalCraft {

    //Mod Information
    public static final String MOD_ID = "technologicalcraft";
    public static final String MOD_NAME = "Technological Craft";
    public static final String MOD_VERSION = "1.7.10";

    @Mod.Instance
    public static TechnologicalCraft instance;

    @SidedProxy(clientSide = Proxies.CLIENT, serverSide = Proxies.SERVER)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        TCConfigHandler.initialise(event.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(new TCConfigHandler());

        TCWorld.init();

        ModItems.init();

        ModTools.registerTools();

        ModBlocks.initialiseBlocks();

        LogHelper.info("This is Technological Craft! An awesome Tech Mod.");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        Recipes.initialiseFurnaceRecipes();

        Recipes.initialiseCraftingRecipes();

        TCOreDict.registerEntries();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
