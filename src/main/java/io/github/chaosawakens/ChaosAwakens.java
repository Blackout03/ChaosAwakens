package io.github.chaosawakens;

import io.github.chaosawakens.api.CAReflectionHelper;
import io.github.chaosawakens.client.ClientSetupEvent;
import io.github.chaosawakens.client.ToolTipEventSubscriber;
import io.github.chaosawakens.common.UpdateHandler;
import io.github.chaosawakens.common.config.CAConfig;
import io.github.chaosawakens.common.events.*;
import io.github.chaosawakens.common.integration.CAJER;
import io.github.chaosawakens.common.integration.TheOneProbePlugin;
import io.github.chaosawakens.common.registry.*;
import io.github.chaosawakens.common.worldgen.BiomeLoadEventSubscriber;
import io.github.chaosawakens.data.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.forgespi.language.IModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

import java.util.Locale;
import java.util.Optional;

@Mod(ChaosAwakens.MODID)
public class ChaosAwakens {
	public static final String MODID = "chaosawakens";
	public static final String MODNAME = "Chaos Awakens";
	public static ArtifactVersion VERSION = null;
	public static final Logger LOGGER = LogManager.getLogger();
	public static boolean APRIL_FOOLS = true;

	public ChaosAwakens() {
		GeckoLibMod.DISABLE_IN_DEV = true;
		GeckoLib.initialize();

		Optional<? extends ModContainer> opt = ModList.get().getModContainerById(MODID);
		if (opt.isPresent()) {
			IModInfo modInfo = opt.get().getModInfo();
			VERSION = modInfo.getVersion();
		} else {
			LOGGER.warn("Cannot get version from mod info");
		}

		LOGGER.debug(MODNAME + " Version is: " + VERSION);
		LOGGER.debug("Mod ID for " + MODNAME + " is: " + MODID);

		CAReflectionHelper.classLoad("io.github.chaosawakens.common.registry.CATags");

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		//Register to the mod event bus
		eventBus.addListener(CommonSetupEvent::onFMLCommonSetupEvent);
		eventBus.addListener(this::gatherData);
		eventBus.addListener(this::onInterModEnqueueEvent);

		if (FMLEnvironment.dist == Dist.CLIENT) {
			eventBus.addListener(ClientSetupEvent::onFMLClientSetupEvent);
			MinecraftForge.EVENT_BUS.addListener(ToolTipEventSubscriber::onToolTipEvent);
		}
		
		//Register the deferred registers
		CABiomes.BIOMES.register(eventBus);
		CABlocks.ITEM_BLOCKS.register(eventBus);
		CABlocks.BLOCKS.register(eventBus);
		CAEntityTypes.ENTITY_TYPES.register(eventBus);
		CAItems.ITEMS.register(eventBus);
		CATileEntities.TILE_ENTITIES.register(eventBus);
		CAStructures.STRUCTURES.register(eventBus);
		CAFeatures.FEATURES.register(eventBus);
		CASoundEvents.SOUND_EVENTS.register(eventBus);
		CAVillagers.POI_TYPES.register(eventBus);
		CAVillagers.PROFESSIONS.register(eventBus);
		eventBus.addListener(EntitySetAttributeEventSubscriber::onEntityAttributeCreationEvent);
		
		ModList modList = ModList.get();
		if (modList.isLoaded("jeresources")) CAJER.init();
		
		//Register to the forge event bus
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(EventPriority.HIGH, BiomeLoadEventSubscriber::onBiomeLoadingEvent);
		forgeBus.addListener(EventPriority.NORMAL, CommonSetupEvent::addDimensionalSpacing);
		forgeBus.addListener(LoginEventHandler::onPlayerLogin);
		forgeBus.addListener(MiscEventHandler::onRegisterCommandEvent);
		forgeBus.addListener(MiscEventHandler::onServerChatEvent);
		forgeBus.addListener(MiscEventHandler::livingDeathEvent);
		forgeBus.addListener(MiscEventHandler::onPlayerLoggedIn);
		forgeBus.addListener(MiscEventHandler::onEntityJoin);
		forgeBus.addListener(GiantEventHandler::onEntityJoin);
		forgeBus.addListener(CraftingEventSubscriber::onItemCraftedEvent);
		forgeBus.addListener(EventPriority.NORMAL, CAVanillaCompat::registerFurnaceFuel);
		forgeBus.addListener(EventPriority.LOWEST, MiscEventHandler::onMobDrops);
		forgeBus.register(this);
		
		//Check for updates
		if (CAConfig.COMMON.showUpdateMessage.get())
			UpdateHandler.init();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CAConfig.COMMON_SPEC);
	}

	public static ResourceLocation prefix(String name) {
		return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
	}

	private void gatherData(final GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		final ExistingFileHelper existing = event.getExistingFileHelper();

		if (event.includeServer()) {
			dataGenerator.addProvider(new CAAdvancementProvider(dataGenerator));
			dataGenerator.addProvider(new CACustomConversionProvider(dataGenerator));
			dataGenerator.addProvider(new CALootTableProvider(dataGenerator));
			dataGenerator.addProvider(new CABlockModelProvider(dataGenerator, MODID, existing));
			dataGenerator.addProvider(new CAItemModelGenerator(dataGenerator, existing));
			dataGenerator.addProvider(new CABlockStateProvider(dataGenerator, MODID, existing));
			dataGenerator.addProvider(new CATagProvider.CABlockTagProvider(dataGenerator, existing));
			dataGenerator.addProvider(new CATagProvider.CAItemTagProvider(dataGenerator, existing));
			dataGenerator.addProvider(new CARecipeProvider(dataGenerator));
		}
	}

	private void onInterModEnqueueEvent(final InterModEnqueueEvent event) {
		if (ModList.get().isLoaded("theoneprobe")) TheOneProbePlugin.register();
	}
} 
