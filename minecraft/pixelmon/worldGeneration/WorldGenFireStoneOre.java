package pixelmon.worldGeneration;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import pixelmon.config.PixelmonBlocks;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenFireStoneOre extends WorldGenerator implements IWorldGenerator {

	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (world.getBlockId(x, y + 1, z) == Block.lavaStill.blockID) {
			if (world.getBlockId(x, y, z) != Block.lavaStill.blockID) {
				world.setBlock(x, y, z, PixelmonBlocks.fireStoneOre.blockID, 0, 0);
				return true;
			}
		}
		return false;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int i = 0; i < 50; i++) {
			int xPos = random.nextInt(16) + chunkX * 16;
			int zPos = random.nextInt(16) + chunkZ * 16;
			int yPos = random.nextInt(30);
			generate(world, random, xPos, yPos, zPos);
		}
	}

}
