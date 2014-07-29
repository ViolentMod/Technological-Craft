package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.TechnologicalCraft;
import violentninjad.technologicalcraft.block.BlockChrome;
import violentninjad.technologicalcraft.block.BlockTC;

@GameRegistry.ObjectHolder(TechnologicalCraft.MOD_ID)
public class ModBlocks {

    public static final BlockTC chromeBlock = new BlockChrome();

    public static void initialiseBlocks()
    {
        GameRegistry.registerBlock(chromeBlock, "chromeBlock");
    }
}
