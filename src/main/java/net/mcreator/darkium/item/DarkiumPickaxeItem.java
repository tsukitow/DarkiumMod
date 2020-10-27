
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.darkium.itemgroup.DarkiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

@DarkiumModElements.ModElement.Tag
public class DarkiumPickaxeItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:darkiumpickaxe")
	public static final Item block = null;
	public DarkiumPickaxeItem(DarkiumModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 17f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkiumIngotItem.block, (int) (1)));
			}
		}, 1, -2.7f, new Item.Properties().group(DarkiumItemGroup.tab)) {
		}.setRegistryName("darkiumpickaxe"));
	}
}
