package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.TechnologicalCraft;
import violentninjad.technologicalcraft.item.ItemChromeIngot;
import violentninjad.technologicalcraft.item.ItemTC;

@GameRegistry.ObjectHolder(TechnologicalCraft.MOD_ID)
public class ModItems
{

    public static final ItemTC chromeIngot = new ItemChromeIngot();

    public static void init()
    {
        GameRegistry.registerItem(chromeIngot, "chromeIngot");
    }
}
