package violentninjad.technologicalcraft.block;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import violentninjad.technologicalcraft.reference.Textures;

public class BlockTC extends Block {

    public BlockTC()
    {
        this(Material.rock);
    }

    public BlockTC(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    //Code from Pahimar's EE3! Thanks :)
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
