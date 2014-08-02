package violentninjad.technologicalcraft;
//Copyright ViolentNInjaD 2014


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import violentninjad.technologicalcraft.init.*;
import violentninjad.technologicalcraft.proxy.IProxy;
import violentninjad.technologicalcraft.reference.Proxies;
import violentninjad.technologicalcraft.util.LogHelper;
import violentninjad.technologicalcraft.world.TCWorld;

@Mod(modid = TechnologicalCraft.MOD_ID, name = TechnologicalCraft.MOD_NAME, version = TechnologicalCraft.MOD_VERSION)
public class TechnologicalCraft {

    //Mod Information
    public static final String MOD_ID = "techcraft";
    public static final String MOD_NAME = "Technological Craft";
    public static final String MOD_VERSION = "1.7.10";

    @Mod.Instance
    public static TechnologicalCraft instance;

    @SidedProxy(clientSide = Proxies.CLIENT, serverSide = Proxies.SERVER)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        TCOreDict.registerEntries();

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

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
