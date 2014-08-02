package violentninjad.technologicalcraft.client.inventory;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import violentninjad.technologicalcraft.init.ChromeProcessorRecipes;
import violentninjad.technologicalcraft.tileentity.TileEntityChromeProcessor;

public class ContainerChromeProcessor extends Container
{

    private TileEntityChromeProcessor tileProcessor;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerChromeProcessor(InventoryPlayer invPlayer, TileEntityChromeProcessor tileEntityProcessor)
    {
        this.tileProcessor = tileEntityProcessor;
        this.addSlotToContainer(new Slot(tileEntityProcessor, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntityProcessor, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(invPlayer.player, tileEntityProcessor, 2, 116, 35));
        int i;

        for(i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(invPlayer, i , 8 + i * 18 , 142));
        }
    }

    public void addCraftingToCrafters(ICrafting craft){
        super.addCraftingToCrafters(craft);
        craft.sendProgressBarUpdate(this, 0, this.tileProcessor.furnaceCookTime);
        craft.sendProgressBarUpdate(this, 1, this.tileProcessor.furnaceBurnTime);
        craft.sendProgressBarUpdate(this, 2, this.tileProcessor.currentBurnTime);
    }

    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for(int i = 0; i < this.crafters.size(); ++i){
            ICrafting craft = (ICrafting) this.crafters.get(i);

            if(this.lastCookTime != this.tileProcessor.furnaceCookTime){
                craft.sendProgressBarUpdate(this, 0, this.tileProcessor.furnaceCookTime);
            }

            if(this.lastBurnTime != this.tileProcessor.furnaceBurnTime){
                craft.sendProgressBarUpdate(this, 1, this.tileProcessor.furnaceBurnTime);
            }

            if(this.lastItemBurnTime != this.tileProcessor.currentBurnTime){
                craft.sendProgressBarUpdate(this, 2, this.tileProcessor.currentBurnTime);
            }
        }

        this.lastBurnTime = this.tileProcessor.furnaceBurnTime;
        this.lastCookTime = this.tileProcessor.furnaceCookTime;
        this.lastItemBurnTime = this.tileProcessor.currentBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2){
        if(par1 == 0){
            this.tileProcessor.furnaceCookTime = par2;
        }

        if(par1 == 1){
            this.tileProcessor.furnaceBurnTime = par2;
        }

        if(par1 == 2){
            this.tileProcessor.currentBurnTime = par2;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileProcessor.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2){
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if(slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(par2 == 2){
                if(!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if(par2 != 1 && par2 != 0){
                if(ChromeProcessorRecipes.smelting().getSmeltingResult(itemstack1) != null){
                    if(!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                }else if(TileEntityChromeProcessor.isItemFuel(itemstack1)){
                    if(!this.mergeItemStack(itemstack1, 1, 2, false)){
                        return null;
                    }
                }else if(par2 >=3 && par2 < 30){
                    if(!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
                    return null;
                }
            }else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
                return null;
            }
            if(itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }else{
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }

}
