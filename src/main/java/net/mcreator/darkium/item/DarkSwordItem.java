
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.darkium.procedures.DarkiumSwordMobIsHitWithItemProcedure;
import net.mcreator.darkium.itemgroup.DarkiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;
import java.util.HashMap;

@DarkiumModElements.ModElement.Tag
public class DarkSwordItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:darksword")
	public static final Item block = null;
	public DarkSwordItem(DarkiumModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2700;
			}

			public float getEfficiency() {
				return 7.5f;
			}

			public float getAttackDamage() {
				return 6.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkiumIngotItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(DarkiumItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DarkiumSwordMobIsHitWithItemProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("darksword"));
	}
}
