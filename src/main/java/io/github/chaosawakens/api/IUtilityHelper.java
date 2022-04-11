package io.github.chaosawakens.api;

import net.minecraft.entity.Entity;
import java.util.UUID;

public interface IUtilityHelper {
	///////////////////////////////
	//          Booleans         //
	///////////////////////////////

	/**
	 * Checks the uuid of an entity or player
	 * @param entityToCheck entity to check uuid of
	 * @param uuidToCheck uuid of entity to check
	 * @return true if entity's uuid is equal to uuidToCheck, else returns false
	 */
	static boolean isUserOrEntityUUIDEqualTo(Entity entityToCheck, UUID uuidToCheck) {
		return entityToCheck.getUUID().equals(uuidToCheck);
	}
}
