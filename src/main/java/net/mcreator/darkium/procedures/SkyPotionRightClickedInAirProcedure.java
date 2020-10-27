package net.mcreator.darkium.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.darkium.potion.SkyEffectPotion;
import net.mcreator.darkium.item.SkyPotionItem;
import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;

@DarkiumModElements.ModElement.Tag
public class SkyPotionRightClickedInAirProcedure extends DarkiumModElements.ModElement {
	public SkyPotionRightClickedInAirProcedure(DarkiumModElements instance) {
		super(instance, 103);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SkyPotionRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(SkyPotionItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 1);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SkyEffectPotion.potion, (int) 60, (int) 1));
	}
}
