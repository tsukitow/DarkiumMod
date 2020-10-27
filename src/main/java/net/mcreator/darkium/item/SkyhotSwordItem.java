
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.darkium.itemgroup.SkyhotiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

@DarkiumModElements.ModElement.Tag
public class SkyhotSwordItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:skyhotsword")
	public static final Item block = null;
	public SkyhotSwordItem(DarkiumModElements instance) {
		super(instance, 81);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 14.5f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(SkyhotiumItemGroup.tab)) {
		}.setRegistryName("skyhotsword"));
	}
}
