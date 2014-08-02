package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.item.*;

public class ModTools
{

    public static final ItemToolTC chromePickaxe = new ItemToolChromePickaxe();
    public static final ItemToolTC chromeShovel = new ItemToolChromeShovel();
    public static final ItemToolTC chromeAxe = new ItemToolChromeAxe();
    public static final ItemToolChromeSword chromeSword = new ItemToolChromeSword();

    public static void registerTools()
    {
        GameRegistry.registerItem(chromePickaxe, "chromePickaxe");
        GameRegistry.registerItem(chromeShovel, "chromeShovel");
        GameRegistry.registerItem(chromeAxe, "chromeAxe");
        GameRegistry.registerItem(chromeSword, "chromeSword");
    }

}
