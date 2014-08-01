package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.item.ItemToolChromePickaxe;
import violentninjad.technologicalcraft.item.ItemToolTC;

public class ModTools
{

    public static final ItemToolTC chromePickaxe = new ItemToolChromePickaxe();

    public static void registerTools()
    {
        GameRegistry.registerItem(chromePickaxe, "chromePickaxe");
    }

}
