package violentninjad.technologicalcraft.proxy;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.TechnologicalCraft;
import violentninjad.technologicalcraft.handler.GuiHandler;
import violentninjad.technologicalcraft.tileentity.TileEntityChromeProcessor;

public abstract class CommonProxy implements IProxy
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityChromeProcessor.class, "TileEntityChromeProcessor");

    }

    public void registerGuiHandler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(TechnologicalCraft.instance, new GuiHandler());

    }
}
