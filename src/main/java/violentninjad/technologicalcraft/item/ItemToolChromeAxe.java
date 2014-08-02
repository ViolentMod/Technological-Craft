package violentninjad.technologicalcraft.item;
//Copyright ViolentNInjaD 2014

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import violentninjad.technologicalcraft.reference.Material;

import java.util.Set;

public class ItemToolChromeAxe extends ItemToolTC
{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

    public ItemToolChromeAxe()
    {
        super(0.5F, Material.Tools.CHROME, blocksEffectiveAgainst);
        this.setUnlocalizedName("chromeAxe");
    }
}
