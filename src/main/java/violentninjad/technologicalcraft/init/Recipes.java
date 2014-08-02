package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import violentninjad.technologicalcraft.reference.Itemstacks;

public class Recipes
{

    public static void initialiseFurnaceRecipes()
    {
        GameRegistry.addSmelting(ModBlocks.chromeOreBlock, Itemstacks.ModItemStacks.chromeIngotStack, 0.5F);
    }

}
