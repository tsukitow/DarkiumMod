
package net.mcreator.darkium.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.darkium.itemgroup.DarkiumItemGroup;
import net.mcreator.darkium.item.DarkDustItem;
import net.mcreator.darkium.DarkiumModElements;

import java.util.List;
import java.util.Collections;

@DarkiumModElements.ModElement.Tag
public class DarkLeavesBlock extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:darkleaves")
	public static final Block block = null;
	public DarkLeavesBlock(DarkiumModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(DarkiumItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.CROP).hardnessAndResistance(0.7f, 10f).lightValue(0));
			setRegistryName("darkleaves");
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 1;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 1;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(DarkDustItem.block, (int) (1)));
		}
	}
}
