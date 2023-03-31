package io.github.chaosawakens.common.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class RotateGoal extends Goal {
	private final Entity entity;

	public RotateGoal(Entity entity) {
		this.entity = entity;
		this.setFlags(EnumSet.of(Goal.Flag.LOOK));
	}

	public boolean canUse() {
		return true;
	}

	public void tick() {
		entity.setYHeadRot(entity.getYHeadRot() + 1); // Change this to change the rotation speed
	}
}
