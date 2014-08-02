package violentninjad.technologicalcraft.item;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import violentninjad.technologicalcraft.reference.Material;
import violentninjad.technologicalcraft.reference.Textures;

public class ItemToolChromeSword extends ItemSword
{

    public ItemToolChromeSword()
    {
        super(Material.Tools.CHROME);
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setNoRepair();
        this.maxStackSize = 1;
        this.setUnlocalizedName("chromeSword");
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }


}
