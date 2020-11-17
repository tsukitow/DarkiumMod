package net.mcreator.darkium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;

@DarkiumModElements.ModElement.Tag
public class DarkiumPickaxeBlockDestroyedWithToolProcedure extends DarkiumModElements.ModElement {
	public DarkiumPickaxeBlockDestroyedWithToolProcedure(DarkiumModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DarkiumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DarkiumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DarkiumPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DarkiumPickaxeBlockDestroyedWithTool!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorld().getRecipeManager()
				.getRecipe(IRecipeType.SMELTING,
						new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))), world.getWorld())
				.isPresent())
				&& (!(((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIAMOND_ORE.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COAL_ORE.getDefaultState()
								.getBlock()))
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.LAPIS_ORE.getDefaultState()
								.getBlock()))
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.REDSTONE_ORE.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.REDSTONE_ORE
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EMERALD_ORE
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.STONE
														.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																.getBlock() == Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock()))))))))) {
			if (world instanceof World && !world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, (world.getWorld().getRecipeManager()
						.getRecipe(IRecipeType.SMELTING,
								new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
								world.getWorld())
						.isPresent()
								? world.getWorld().getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory(
														(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
												world.getWorld())
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
	}
}
