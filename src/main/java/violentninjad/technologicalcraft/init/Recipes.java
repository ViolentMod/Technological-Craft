package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import violentapi.api.CraftingHelper;
import violentninjad.technologicalcraft.reference.Itemstacks;

public class Recipes
{

    public static void initialiseFurnaceRecipes()
    {
        GameRegistry.addSmelting(ModBlocks.chromeOreBlock, Itemstacks.ModItemStacks.chromeIngotStack, 0.5F);
    }

    public static void initialiseCraftingRecipes()
    {
        CraftingHelper.shapeless(new ItemStack(ModItems.chromeIngot, 9), new ItemStack(ModBlocks.chromeBlock));
        CraftingHelper.standard(Itemstacks.ModItemStacks.chromeBlockStack, "sss", "sss", "sss", 's', Itemstacks.ModItemStacks.chromeIngotStack);
    }

}
