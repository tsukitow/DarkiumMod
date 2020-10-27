
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.darkium.itemgroup.DarkiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

@DarkiumModElements.ModElement.Tag
public class DarkiumAxeItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:darkiumaxe")
	public static final Item block = null;
	public DarkiumAxeItem(DarkiumModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 11;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkiumIngotItem.block, (int) (1)));
			}
		}, 1, -3.5f, new Item.Properties().group(DarkiumItemGroup.tab)) {
		}.setRegistryName("darkiumaxe"));
	}
}
