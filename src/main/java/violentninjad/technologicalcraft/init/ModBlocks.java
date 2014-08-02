package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import violentninjad.technologicalcraft.TechnologicalCraft;
import violentninjad.technologicalcraft.block.BlockChrome;
import violentninjad.technologicalcraft.block.BlockChromeOre;
import violentninjad.technologicalcraft.block.BlockChromeProcessor;
import violentninjad.technologicalcraft.block.BlockTC;

@GameRegistry.ObjectHolder(TechnologicalCraft.MOD_ID)
public class ModBlocks {

    public static final BlockTC chromeBlock = new BlockChrome();
    public static final BlockTC chromeOreBlock = new BlockChromeOre();

    //Chrome Processor
    public static Block chromeProcessor;
    public static Block chromeProccessorActive;

    public static void initialiseBlocks()
    {
        GameRegistry.registerBlock(chromeBlock, "chromeBlock");
        GameRegistry.registerBlock(chromeOreBlock, "chromeOreBlock");
        initialiseChromeProcessor();
        GameRegistry.registerBlock(chromeProcessor, "chromeProcessor");
        GameRegistry.registerBlock(chromeProccessorActive, "chromeProcessorActive");
    }

    public static void initialiseChromeProcessor()
    {
        chromeProcessor = new BlockChromeProcessor(false).setBlockName("chromeProcessor").setCreativeTab(CreativeTabs.tabBlock);
        chromeProccessorActive = new BlockChromeProcessor(true).setBlockName("chromeProcessorActive");
    }
}
