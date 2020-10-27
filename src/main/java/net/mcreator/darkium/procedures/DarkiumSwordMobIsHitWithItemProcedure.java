package net.mcreator.darkium.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;

@DarkiumModElements.ModElement.Tag
public class DarkiumSwordMobIsHitWithItemProcedure extends DarkiumModElements.ModElement {
	public DarkiumSwordMobIsHitWithItemProcedure(DarkiumModElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DarkiumSwordMobIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 1));
	}
}
