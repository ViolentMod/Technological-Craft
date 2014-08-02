package violentninjad.technologicalcraft.world;
//Copyright ViolentNInjaD 2014

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class TCWorld {

    public static void init()
    {
        registerWorldGen(new WorldGenChrome(), 1);
    }

    public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProberblity)
    {
        GameRegistry.registerWorldGenerator(worldGenClass, weightedProberblity);
    }
}
