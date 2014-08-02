package violentninjad.technologicalcraft.init;
//Copyright ViolentNInjaD 2014

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChromeProcessorRecipes
{

    private static final ChromeProcessorRecipes SMELTING_BASE = new ChromeProcessorRecipes();

    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    public static ChromeProcessorRecipes smelting() {
        return SMELTING_BASE;
    }

    private ChromeProcessorRecipes(){
        this.addRecipe(ModItems.chromeIngot, new ItemStack(ModItems.chromeIngot, 2), 0.8F);
    }

    public void addRecipe(Item item, ItemStack itemstack, float experience){
        this.addLists(item, itemstack, experience);
    }

    public void addLists(Item item, ItemStack itemstack, float experience){
        this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
    }

    public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience){
        this.smeltingList.put(itemstack, itemstack2);
        this.experienceList.put(itemstack2, Float.valueOf(experience));
    }

    public ItemStack getSmeltingResult(ItemStack itemstack) {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Map.Entry entry;

        do {
            if (!iterator.hasNext()) {
                return null;
            }
            entry = (Map.Entry) iterator.next();
        } while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));
        return (ItemStack) entry.getValue();
    }

    private boolean canBeSmelted(ItemStack itemstack, ItemStack itemstack2) {
        return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
    }

    public float giveExperience(ItemStack itemstack){
        Iterator iterator = this.experienceList.entrySet().iterator();
        Map.Entry entry;

        do{
            if(!iterator.hasNext()){
                return 0.0f;
            }

            entry = (Map.Entry) iterator.next();
        }
        while(!this.canBeSmelted(itemstack, (ItemStack) entry.getKey()));

        if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
            return itemstack.getItem().getSmeltingExperience(itemstack);
        }

        return ((Float) entry.getValue()).floatValue();
    }


}
