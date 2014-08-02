package violentninjad.technologicalcraft.handler;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import violentninjad.technologicalcraft.client.gui.GuiChromeProcessor;
import violentninjad.technologicalcraft.client.inventory.ContainerChromeProcessor;
import violentninjad.technologicalcraft.tileentity.TileEntityChromeProcessor;

public class GuiHandler implements IGuiHandler
{
    public GuiHandler()
    {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
    {
        if(ID == 0){
            TileEntityChromeProcessor tileEntityFurnace = (TileEntityChromeProcessor) world.getTileEntity(x, y, z);
            return new ContainerChromeProcessor(player.inventory, tileEntityFurnace);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
    {
        if(ID == 0){
            TileEntityChromeProcessor tileEntityTestContainer = (TileEntityChromeProcessor) world.getTileEntity(x, y, z);
            return new GuiChromeProcessor(player.inventory, tileEntityTestContainer);
        }
        return null;
    }



}
