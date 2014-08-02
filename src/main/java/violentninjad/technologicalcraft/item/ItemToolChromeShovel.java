package violentninjad.technologicalcraft.item;
//Copyright ViolentNInjaD 2014

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import violentninjad.technologicalcraft.reference.Material;

import java.util.Set;

public class ItemToolChromeShovel extends ItemToolTC
{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public ItemToolChromeShovel()
    {
        super(0.5F, Material.Tools.CHROME, blocksEffectiveAgainst);
        this.setUnlocalizedName("chromeShovel");
    }



}
