
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.darkium.itemgroup.SkyhotiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

@DarkiumModElements.ModElement.Tag
public class SkyAxeItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:skyaxe")
	public static final Item block = null;
	public SkyAxeItem(DarkiumModElements instance) {
		super(instance, 93);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 32f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 22;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.5f, new Item.Properties().group(SkyhotiumItemGroup.tab)) {
		}.setRegistryName("skyaxe"));
	}
}
