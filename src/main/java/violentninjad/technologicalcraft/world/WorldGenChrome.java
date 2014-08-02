package violentninjad.technologicalcraft.world;
//Thanks to http://www.youtube.com/user/TheGrovesyProject101/'s video for showing me how to do this!

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import violentninjad.technologicalcraft.init.ModBlocks;

import java.util.Random;

public class WorldGenChrome implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                generateNether(random, chunkX * 16, chunkZ * 16, world);
                break;
            case 0:
                generateSurface(random, chunkX * 16, chunkZ * 16, world);
                break;
            case 1:
                generateEnd(random, chunkX * 16, chunkZ * 16, world);
                break;
            default:
                ;
        }
    }

    private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int spawnChance)
    {
        for (int i = 0; i < spawnChance; i++)
        {
            int defaultChunkSize = 16;

            int xPos = posX + random.nextInt(defaultChunkSize);
            int yPos = minY + random.nextInt(maxY - minY);
            int zPos = posZ + random.nextInt(defaultChunkSize);

            new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockSpawn).generate(world, random, xPos, yPos, zPos);
        }
    }

    private void generateEnd(Random random, int chunkX, int chunkZ, World world)
    {

    }

    private void generateSurface(Random random, int chunkX, int chunkZ, World world)
    {

        addOre(ModBlocks.chromeOreBlock, Blocks.stone, random, world, chunkX, chunkZ, 5, 25, 1, 12, 3);

    }

    private void generateNether(Random random, int i, int i1, World world)
    {

    }

}
