package com.dfsek.testgenerator;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;

public class EndChunkGenerator extends ChunkGenerator {
	@Override
	public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
		ChunkData chunk = createChunkData(world);
		for(int X = 0; X<16; X++) {
			for(int Z = 0; Z<16; Z++) {
				if(biome.getBiome(X, 0, Z) == Biome.SMALL_END_ISLANDS) chunk.setBlock(X, 0, Z, Material.STONE);
				for(int Y = world.getMaxHeight()-1; Y>0; Y--) biome.setBiome(X, Y, Z, Biome.END_HIGHLANDS);
			}
		}
		return chunk;
	}
	@Override
	public boolean shouldGenerateStructures() {
		return true;
	}
	@Override
	public boolean shouldGenerateDecorations() {
		return true;
	}
}
