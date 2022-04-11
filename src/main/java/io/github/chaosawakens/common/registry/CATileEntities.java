package io.github.chaosawakens.common.registry;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.blocks.tileentities.CherryCampfireTileEntity;
import io.github.chaosawakens.common.blocks.tileentities.CrystalFurnaceTileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.CampfireTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CATileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ChaosAwakens.MODID);

    public static final RegistryObject<TileEntityType<CrystalFurnaceTileEntity>> CRYSTAL_FURNACE = TILE_ENTITIES.register("crystal_furnace",
            () -> TileEntityType.Builder.of(CrystalFurnaceTileEntity::new, CABlocks.CRYSTAL_FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<CherryCampfireTileEntity>> CHERRY_CAMPFIRE = TILE_ENTITIES.register("campfire",
            () -> TileEntityType.Builder.of(CherryCampfireTileEntity::new, CABlocks.CHERRY_CAMPFIRE.get()).build(null));

}
