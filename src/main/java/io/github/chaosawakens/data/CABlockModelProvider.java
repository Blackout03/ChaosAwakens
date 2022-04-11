package io.github.chaosawakens.data;

import io.github.chaosawakens.ChaosAwakens;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * @author invalid2
 */
public class CABlockModelProvider extends BlockModelProvider {
	
	/**
	 * @param generator
	 * @param modid
	 * @param existingFileHelper
	 */
	public CABlockModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		// TODO Automate the data generators
		this.cubeAll("fossilised_acacia_ent", chaosRL("fossilised_acacia_ent"));
		this.cubeAll("fossilised_birch_ent", chaosRL("fossilised_birch_ent"));
		this.cubeAll("fossilised_dark_oak_ent", chaosRL("fossilised_dark_oak_ent"));
		this.cubeAll("fossilised_jungle_ent", chaosRL("fossilised_jungle_ent"));
		this.cubeAll("fossilised_oak_ent", chaosRL("fossilised_oak_ent"));
		this.cubeAll("fossilised_spruce_ent", chaosRL("fossilised_spruce_ent"));
		this.cubeAll("fossilised_crimson_ent", chaosRL("fossilised_crimson_ent"));
		this.cubeAll("fossilised_warped_ent", chaosRL("fossilised_warped_ent"));

		this.cubeColumn("apple_log", chaosRL("apple_log"), chaosRL("apple_log_top"));
		this.cubeColumnHorizontal("apple_log", chaosRL("apple_log"), chaosRL("apple_log_top"));
		this.cubeColumn("stripped_apple_log", chaosRL("stripped_apple_log"), chaosRL("stripped_apple_log_top"));
		this.cubeColumnHorizontal("stripped_apple_log", chaosRL("stripped_apple_log"), chaosRL("stripped_apple_log_top"));
		this.cubeColumn("cherry_log", chaosRL("cherry_log"), chaosRL("cherry_log_top"));
		this.cubeColumnHorizontal("cherry_log", chaosRL("cherry_log"), chaosRL("cherry_log_top"));
		this.cubeColumn("stripped_cherry_log", chaosRL("stripped_cherry_log"), chaosRL("stripped_cherry_log_top"));
		this.cubeColumnHorizontal("stripped_cherry_log", chaosRL("stripped_cherry_log"), chaosRL("stripped_cherry_log_top"));
		this.cubeColumn("duplication_log", chaosRL("duplication_log"), chaosRL("duplication_log_top"));
		this.cubeColumnHorizontal("duplication_log", chaosRL("duplication_log"), chaosRL("duplication_log_top"));
		this.cubeColumn("stripped_duplication_log", chaosRL("stripped_duplication_log"), chaosRL("stripped_duplication_log_top"));
		this.cubeColumnHorizontal("stripped_duplication_log", chaosRL("stripped_duplication_log"), chaosRL("stripped_duplication_log_top"));
		this.cubeColumn("dead_duplication_log", chaosRL("dead_duplication_log"), chaosRL("dead_duplication_log_top"));
		this.cubeColumnHorizontal("dead_duplication_log", chaosRL("dead_duplication_log"), chaosRL("dead_duplication_log_top"));
		this.cubeColumn("peach_log", chaosRL("peach_log"), chaosRL("peach_log_top"));
		this.cubeColumnHorizontal("peach_log", chaosRL("peach_log"), chaosRL("peach_log_top"));
		this.cubeColumn("stripped_peach_log", chaosRL("stripped_peach_log"), chaosRL("stripped_peach_log_top"));
		this.cubeColumnHorizontal("stripped_peach_log", chaosRL("stripped_peach_log"), chaosRL("stripped_peach_log_top"));
		this.cubeAll("apple_planks", chaosRL("apple_planks"));
		this.cubeAll("apple_leaves", chaosRL("apple_leaves"));
		this.cubeAll("apple_leaves_ripe", chaosRL("apple_leaves_ripe"));
		this.cross("apple_sapling", chaosRL("apple_sapling"));
		this.cubeAll("cherry_planks", chaosRL("cherry_planks"));
		this.cubeAll("cherry_leaves", chaosRL("cherry_leaves"));
		this.cubeAll("cherry_leaves_ripe", chaosRL("cherry_leaves_ripe"));
		this.cross("cherry_sapling", chaosRL("cherry_sapling"));
		this.cubeAll("peach_planks", chaosRL("peach_planks"));
		this.cubeAll("peach_leaves", chaosRL("peach_leaves"));
		this.cubeAll("peach_leaves_ripe", chaosRL("peach_leaves_ripe"));
		this.cross("peach_sapling", chaosRL("peach_sapling"));
		this.cubeAll("duplication_planks", chaosRL("duplication_planks"));
		this.cubeAll("duplication_leaves", chaosRL("duplication_leaves"));

		this.cubeAll("cherry_cobblestone", chaosRL("cherry_cobblestone"));

		this.cubeAll("mining_lamp", chaosRL("mining_lamp"));
	}
	
	private ResourceLocation chaosRL(String texture) {
		return new ResourceLocation(ChaosAwakens.MODID, BLOCK_FOLDER + "/" + texture);
	}
	
	@Override
	public BlockModelBuilder cubeAll(String name, ResourceLocation texture) {
		return singleTexture(name, mcLoc(BLOCK_FOLDER + "/cube_all"), "all", texture);
	}
	
	@Override
	public BlockModelBuilder cubeColumn(String name, ResourceLocation side, ResourceLocation end) {
		ChaosAwakens.LOGGER.debug("DATAGEN:" + side.getPath());
		return withExistingParent(name, BLOCK_FOLDER).texture("side", side).texture("end", end);
	}
	
	@Override
	public BlockModelBuilder cubeColumnHorizontal(String name, ResourceLocation side, ResourceLocation end) {
		return withExistingParent(name, BLOCK_FOLDER).texture("side", side).texture("end", end);
	}
}