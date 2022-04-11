package io.github.chaosawakens.common.registry;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.config.CAConfig;
import io.github.chaosawakens.common.entity.*;
import io.github.chaosawakens.common.entity.projectile.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.IFactory;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class CAEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ChaosAwakens.MODID);
    // Ents
    public static final RegistryObject<EntityType<EntEntity>> OAK_ENT = ENTITY_TYPES.register("oak_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.OAK), EntityClassification.MONSTER)
                    .sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "oak_ent").toString()));
    // ENTITY TYPES
    public static final RegistryObject<EntityType<EntEntity>> ACACIA_ENT = ENTITY_TYPES.register("acacia_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.ACACIA), EntityClassification.MONSTER)
                    .sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "acacia_ent").toString()));
    public static final RegistryObject<EntityType<EntEntity>> BIRCH_ENT = ENTITY_TYPES.register("birch_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.BIRCH), EntityClassification.MONSTER)
                    .sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "birch_ent").toString()));
    public static final RegistryObject<EntityType<EntEntity>> JUNGLE_ENT = ENTITY_TYPES.register("jungle_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.JUNGLE), EntityClassification.MONSTER)
                    .sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "jungle_ent").toString()));
    public static final RegistryObject<EntityType<EntEntity>> SPRUCE_ENT = ENTITY_TYPES.register("spruce_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.SPRUCE), EntityClassification.MONSTER)
                    .sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "spruce_ent").toString()));
    public static final RegistryObject<EntityType<EntEntity>> DARK_OAK_ENT = ENTITY_TYPES.register("dark_oak_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.DARK_OAK), EntityClassification.MONSTER)
                    .sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "dark_oak_ent").toString()));
    public static final RegistryObject<EntityType<EntEntity>> CRIMSON_ENT = ENTITY_TYPES.register("crimson_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.CRIMSON), EntityClassification.MONSTER)
            		.fireImmune().sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "crimson_ent").toString()));
    public static final RegistryObject<EntityType<EntEntity>> WARPED_ENT = ENTITY_TYPES.register("warped_ent",
            () -> EntityType.Builder.of((IFactory<EntEntity>) (type, world) -> new EntEntity(type, world, EntEntity.Types.WARPED), EntityClassification.MONSTER)
            		.fireImmune().sized(0.25f, 0.3125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "warped_ent").toString()));
    // Hercules Beetle
    public static final RegistryObject<EntityType<HerculesBeetleEntity>> HERCULES_BEETLE = ENTITY_TYPES.register("hercules_beetle",
            () -> EntityType.Builder.of(HerculesBeetleEntity::new, EntityClassification.MONSTER)
                    .sized(4.5f, 3.125f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "hercules_beetle").toString()));
    // Apple Cows
    public static final RegistryObject<EntityType<AppleCowEntity>> APPLE_COW = ENTITY_TYPES.register("apple_cow",
            () -> EntityType.Builder.of(AppleCowEntity::new, EntityClassification.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)// Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "apple_cow").toString()));
    public static final RegistryObject<EntityType<GoldenAppleCowEntity>> GOLDEN_APPLE_COW = ENTITY_TYPES.register("golden_apple_cow",
            () -> EntityType.Builder.of(GoldenAppleCowEntity::new, EntityClassification.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)// Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "golden_apple_cow").toString()));
    public static final RegistryObject<EntityType<EnchantedGoldenAppleCowEntity>> ENCHANTED_GOLDEN_APPLE_COW = ENTITY_TYPES.register("enchanted_golden_apple_cow",
            () -> EntityType.Builder.of(EnchantedGoldenAppleCowEntity::new, EntityClassification.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)// Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "enchanted_golden_apple_cow").toString()));
    public static final RegistryObject<EntityType<CrystalAppleCowEntity>> CRYSTAL_APPLE_COW = ENTITY_TYPES.register("crystal_apple_cow",
            () -> EntityType.Builder.of(CrystalAppleCowEntity::new, EntityClassification.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)// Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "crystal_apple_cow").toString()));
    // Ants
    public static final RegistryObject<EntityType<AntEntity>> BROWN_ANT = ENTITY_TYPES.register("brown_ant",
            () -> EntityType.Builder.of((IFactory<AntEntity>) (type, world) -> new AntEntity(type, world, CAConfig.COMMON.enableBrownAntTeleport, CADimensions.VILLAGE_MANIA), EntityClassification.CREATURE)
                    .sized(0.9f, 0.9f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "brown_ant").toString()));
    public static final RegistryObject<EntityType<AntEntity>> RAINBOW_ANT = ENTITY_TYPES.register("rainbow_ant",
            () -> EntityType.Builder.of((IFactory<AntEntity>) (type, world) -> new AntEntity(type, world, CAConfig.COMMON.enableRainbowAntTeleport, null),
                            EntityClassification.CREATURE)
                    .sized(0.9f, 0.9f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "rainbow_ant").toString()));
    public static final RegistryObject<EntityType<AggressiveAntEntity>> RED_ANT = ENTITY_TYPES.register("red_ant",
            () -> EntityType.Builder.of((IFactory<AggressiveAntEntity>) (type, world) -> new AggressiveAntEntity(type, world, CAConfig.COMMON.enableRedAntTeleport, null),
                            EntityClassification.MONSTER)
                    .sized(0.9f, 0.9f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "red_ant").toString()));
    public static final RegistryObject<EntityType<AntEntity>> UNSTABLE_ANT = ENTITY_TYPES.register("unstable_ant",
            () -> EntityType.Builder.of((IFactory<AntEntity>) (type, world) -> new AntEntity(type, world, CAConfig.COMMON.enableUnstableAntTeleport, CADimensions.CRYSTAL_WORLD), EntityClassification.CREATURE)
                    .sized(0.9f, 0.9f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "unstable_ant").toString()));
    // Termite
    public static final RegistryObject<EntityType<AggressiveAntEntity>> TERMITE = ENTITY_TYPES.register("termite",
            () -> EntityType.Builder.of((IFactory<AggressiveAntEntity>) (type, world) -> new AggressiveAntEntity(type, world, CAConfig.COMMON.enableTermiteTeleport, CADimensions.MINING_PARADISE),
                            EntityClassification.CREATURE)
                    .sized(0.9f, 0.9f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "termite").toString()));
    // Beaver
    public static final RegistryObject<EntityType<BeaverEntity>> BEAVER = ENTITY_TYPES.register("beaver",
            () -> EntityType.Builder.of(BeaverEntity::new, EntityClassification.CREATURE)
                    .sized(0.75f, 0.7f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "beaver").toString()));
    // Emerald Gator
    public static final RegistryObject<EntityType<EmeraldGatorEntity>> EMERALD_GATOR = ENTITY_TYPES.register("emerald_gator",
            () -> EntityType.Builder.of(EmeraldGatorEntity::new, EntityClassification.CREATURE)
                    .sized(1.5f, 1.0f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "emerald_gator").toString()));
    // Ruby Bug
    public static final RegistryObject<EntityType<RubyBugEntity>> RUBY_BUG = ENTITY_TYPES.register("ruby_bug",
            () -> EntityType.Builder.of(RubyBugEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f, 0.5f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "ruby_bug").toString()));
    // Stink Bug
    public static final RegistryObject<EntityType<StinkBugEntity>> STINK_BUG = ENTITY_TYPES.register("stink_bug",
            () -> EntityType.Builder.of(StinkBugEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f, 0.5f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "stink_bug").toString()));
    // Robo Sniper
    public static final RegistryObject<EntityType<RoboSniperEntity>> ROBO_SNIPER = ENTITY_TYPES.register("robo_sniper",
            () -> EntityType.Builder.of(RoboSniperEntity::new, EntityClassification.MONSTER)
                    .sized(1.0f, 1.5f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "robo_sniper").toString()));
    // Robo Warrior
    public static final RegistryObject<EntityType<RoboWarriorEntity>> ROBO_WARRIOR = ENTITY_TYPES.register("robo_warrior",
            () -> EntityType.Builder.of(RoboWarriorEntity::new, EntityClassification.MONSTER)
                    .sized(2.0f, 4.0f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "robo_warrior").toString()));
    // Wasp
    public static final RegistryObject<EntityType<WaspEntity>> WASP = ENTITY_TYPES.register("wasp",
            () -> EntityType.Builder.of(WaspEntity::new, EntityClassification.MONSTER)
                    .sized(1.5f, 2.0f) // Hitbox Size ()
                    .build(new ResourceLocation(ChaosAwakens.MODID, "wasp").toString()));
    // Projectiles
    public static final RegistryObject<EntityType<RoboLaserEntity>> ROBO_LASER = ENTITY_TYPES.register("robo_laser",
            () -> EntityType.Builder.<RoboLaserEntity>of(RoboLaserEntity::new, EntityClassification.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(ChaosAwakens.MODID, "robo_laser").toString()));
    public static final RegistryObject<EntityType<UltimateArrowEntity>> ULTIMATE_ARROW = ENTITY_TYPES.register("ultimate_arrow",
            () -> EntityType.Builder.<UltimateArrowEntity>of(UltimateArrowEntity::new, EntityClassification.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(ChaosAwakens.MODID, "ultimate_arrow").toString()));
    public static final RegistryObject<EntityType<IrukandjiArrowEntity>> IRUKANDJI_ARROW = ENTITY_TYPES.register("irukandji_arrow",
            () -> EntityType.Builder.<IrukandjiArrowEntity>of(IrukandjiArrowEntity::new, EntityClassification.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(ChaosAwakens.MODID, "irukandji_arrow").toString()));
    public static final RegistryObject<EntityType<ThunderStaffProjectileEntity>> THUNDER_BALL = ENTITY_TYPES.register("thunder_ball",
            () -> EntityType.Builder.<ThunderStaffProjectileEntity>of(ThunderStaffProjectileEntity::new, EntityClassification.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(ChaosAwakens.MODID, "thunder_ball").toString()));
    public static final RegistryObject<EntityType<RayGunProjectileEntity>> EXPLOSIVE_BALL = ENTITY_TYPES.register("explosive_ball",
            () -> EntityType.Builder.<RayGunProjectileEntity>of(RayGunProjectileEntity::new, EntityClassification.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(ChaosAwakens.MODID, "explosive_ball").toString()));
    public static final RegistryObject<EntityType<UltimateFishingBobberEntity>> ULTIMATE_FISHING_BOBBER = ENTITY_TYPES.register("ultimate_fishing_bobber",
            () -> EntityType.Builder.<UltimateFishingBobberEntity>createNothing(EntityClassification.MISC).noSave().noSummon()
                    .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(5)
                    .build(new ResourceLocation(ChaosAwakens.MODID, "ultimate_fishing_bobber").toString()));
    private static final List<EntityType<?>> ALL = new ArrayList<>();

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(ALL.toArray(new EntityType<?>[0]));
    }

    public static void registerSpawnPlacementTypes() {
        EntitySpawnPlacementRegistry.register(ACACIA_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(BIRCH_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(CRIMSON_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(DARK_OAK_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(JUNGLE_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(OAK_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(SPRUCE_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(WARPED_ENT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(HERCULES_BEETLE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(RUBY_BUG.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(EMERALD_GATOR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(APPLE_COW.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(GOLDEN_APPLE_COW.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ENCHANTED_GOLDEN_APPLE_COW.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(CRYSTAL_APPLE_COW.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CrystalAppleCowEntity::checkCrystalAppleCowSpawnRules);
        EntitySpawnPlacementRegistry.register(BEAVER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(STINK_BUG.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ROBO_SNIPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(ROBO_WARRIOR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
    }
}