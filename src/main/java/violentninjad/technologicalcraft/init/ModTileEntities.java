package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.TechnologicalCraft;
import violentninjad.technologicalcraft.tileentity.TileEntityChromeProcessor;

public class ModTileEntities
{

    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityChromeProcessor.class, TechnologicalCraft.MOD_ID);
    }

}
