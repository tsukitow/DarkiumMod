
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;

import net.mcreator.darkium.procedures.DarkSwordToolInHandTickProcedure;
import net.mcreator.darkium.itemgroup.DarkiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;
import java.util.HashMap;

@DarkiumModElements.ModElement.Tag
public class DarkiumBigSwordItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:darkiumbigsword")
	public static final Item block = null;
	public DarkiumBigSwordItem(DarkiumModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 10.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.7f, new Item.Properties().group(DarkiumItemGroup.tab)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DarkSwordToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("darkiumbigsword"));
	}
}
