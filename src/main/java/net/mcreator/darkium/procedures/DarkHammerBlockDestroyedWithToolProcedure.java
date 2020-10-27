package net.mcreator.darkium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.darkium.DarkiumModVariables;
import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;

@DarkiumModElements.ModElement.Tag
public class DarkHammerBlockDestroyedWithToolProcedure extends DarkiumModElements.ModElement {
	public DarkHammerBlockDestroyedWithToolProcedure(DarkiumModElements instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DarkHammerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DarkHammerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DarkHammerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DarkHammerBlockDestroyedWithTool!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		DarkiumModVariables.MapVariables.get(world).DarkHammerX = (double) (x - 1);
		DarkiumModVariables.MapVariables.get(world).syncData(world);
		DarkiumModVariables.MapVariables.get(world).DarkHammerY = (double) (y - 1);
		DarkiumModVariables.MapVariables.get(world).syncData(world);
		DarkiumModVariables.MapVariables.get(world).DarkHammerZ = (double) (z - 1);
		DarkiumModVariables.MapVariables.get(world).syncData(world);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			for (int index1 = 0; index1 < (int) (3); index1++) {
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if ((!(((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
							(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY), (int) (DarkiumModVariables.MapVariables.get(
									world).DarkHammerZ)))).getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())
							|| (((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
									(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY), (int) (DarkiumModVariables.MapVariables.get(
											world).DarkHammerZ)))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())
									|| (((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
											(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY), (int) (DarkiumModVariables.MapVariables
													.get(world).DarkHammerZ)))).getBlock() == Blocks.GRASS_PATH.getDefaultState().getBlock())
											|| (((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
													(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
													(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ)))).getBlock() == Blocks.MYCELIUM
															.getDefaultState().getBlock())
													|| (((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(
															world).DarkHammerX), (int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
															(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ))))
																	.getBlock() == Blocks.DIRT.getDefaultState().getBlock())
															|| (((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(
																	world).DarkHammerX),
																	(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
																	(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ))))
																			.getBlock() == Blocks.OAK_SAPLING.getDefaultState().getBlock())
																	|| (((world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables
																			.get(world).DarkHammerX),
																			(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
																			(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ))))
																					.getBlock() == Blocks.GRASS.getDefaultState().getBlock())
																			|| (((world.getBlockState(new BlockPos(
																					(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
																					(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
																					(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ))))
																							.getBlock() == Blocks.OAK_LOG.getDefaultState()
																									.getBlock())
																					|| (((world.getBlockState(new BlockPos(
																							(int) (DarkiumModVariables.MapVariables.get(
																									world).DarkHammerX),
																							(int) (DarkiumModVariables.MapVariables.get(
																									world).DarkHammerY),
																							(int) (DarkiumModVariables.MapVariables.get(
																									world).DarkHammerZ))))
																											.getBlock() == Blocks.ACACIA_LOG
																													.getDefaultState().getBlock())
																							|| (((world.getBlockState(new BlockPos(
																									(int) (DarkiumModVariables.MapVariables.get(
																											world).DarkHammerX),
																									(int) (DarkiumModVariables.MapVariables.get(
																											world).DarkHammerY),
																									(int) (DarkiumModVariables.MapVariables.get(
																											world).DarkHammerZ))))
																													.getBlock() == Blocks.OAK_LEAVES
																															.getDefaultState()
																															.getBlock())
																									|| (((world.getBlockState(new BlockPos(
																											(int) (DarkiumModVariables.MapVariables
																													.get(world).DarkHammerX),
																											(int) (DarkiumModVariables.MapVariables
																													.get(world).DarkHammerY),
																											(int) (DarkiumModVariables.MapVariables
																													.get(world).DarkHammerZ))))
																															.getBlock() == Blocks.ACACIA_LEAVES
																																	.getDefaultState()
																																	.getBlock())
																											|| (((world.getBlockState(new BlockPos(
																													(int) (DarkiumModVariables.MapVariables
																															.get(world).DarkHammerX),
																													(int) (DarkiumModVariables.MapVariables
																															.get(world).DarkHammerY),
																													(int) (DarkiumModVariables.MapVariables
																															.get(world).DarkHammerZ))))
																																	.getBlock() == Blocks.SAND
																																			.getDefaultState()
																																			.getBlock())
																													|| (((world.getBlockState(
																															new BlockPos(
																																	(int) (DarkiumModVariables.MapVariables
																																			.get(world).DarkHammerX),
																																	(int) (DarkiumModVariables.MapVariables
																																			.get(world).DarkHammerY),
																																	(int) (DarkiumModVariables.MapVariables
																																			.get(world).DarkHammerZ))))
																																					.getBlock() == Blocks.SUGAR_CANE
																																							.getDefaultState()
																																							.getBlock())
																															|| (((world.getBlockState(
																																	new BlockPos(
																																			(int) (DarkiumModVariables.MapVariables
																																					.get(world).DarkHammerX),
																																			(int) (DarkiumModVariables.MapVariables
																																					.get(world).DarkHammerY),
																																			(int) (DarkiumModVariables.MapVariables
																																					.get(world).DarkHammerZ))))
																																							.getBlock() == Blocks.POPPY
																																									.getDefaultState()
																																									.getBlock())
																																	|| (((world
																																			.getBlockState(
																																					new BlockPos(
																																							(int) (DarkiumModVariables.MapVariables
																																									.get(world).DarkHammerX),
																																							(int) (DarkiumModVariables.MapVariables
																																									.get(world).DarkHammerY),
																																							(int) (DarkiumModVariables.MapVariables
																																									.get(world).DarkHammerZ))))
																																											.getBlock() == Blocks.DANDELION
																																													.getDefaultState()
																																													.getBlock())
																																			|| (((world
																																					.getBlockState(
																																							new BlockPos(
																																									(int) (DarkiumModVariables.MapVariables
																																											.get(world).DarkHammerX),
																																									(int) (DarkiumModVariables.MapVariables
																																											.get(world).DarkHammerY),
																																									(int) (DarkiumModVariables.MapVariables
																																											.get(world).DarkHammerZ))))
																																													.getBlock() == Blocks.SUNFLOWER
																																															.getDefaultState()
																																															.getBlock())
																																					|| (((world
																																							.getBlockState(
																																									new BlockPos(
																																											(int) (DarkiumModVariables.MapVariables
																																													.get(world).DarkHammerX),
																																											(int) (DarkiumModVariables.MapVariables
																																													.get(world).DarkHammerY),
																																											(int) (DarkiumModVariables.MapVariables
																																													.get(world).DarkHammerZ))))
																																															.getBlock() == Blocks.RED_MUSHROOM
																																																	.getDefaultState()
																																																	.getBlock())
																																							|| (((world
																																									.getBlockState(
																																											new BlockPos(
																																													(int) (DarkiumModVariables.MapVariables
																																															.get(world).DarkHammerX),
																																													(int) (DarkiumModVariables.MapVariables
																																															.get(world).DarkHammerY),
																																													(int) (DarkiumModVariables.MapVariables
																																															.get(world).DarkHammerZ))))
																																																	.getBlock() == Blocks.OAK_PLANKS
																																																			.getDefaultState()
																																																			.getBlock())
																																									|| (((world
																																											.getBlockState(
																																													new BlockPos(
																																															(int) (DarkiumModVariables.MapVariables
																																																	.get(world).DarkHammerX),
																																															(int) (DarkiumModVariables.MapVariables
																																																	.get(world).DarkHammerY),
																																															(int) (DarkiumModVariables.MapVariables
																																																	.get(world).DarkHammerZ))))
																																																			.getBlock() == Blocks.LAVA
																																																					.getDefaultState()
																																																					.getBlock())
																																											|| (((world
																																													.getBlockState(
																																															new BlockPos(
																																																	(int) (DarkiumModVariables.MapVariables
																																																			.get(world).DarkHammerX),
																																																	(int) (DarkiumModVariables.MapVariables
																																																			.get(world).DarkHammerY),
																																																	(int) (DarkiumModVariables.MapVariables
																																																			.get(world).DarkHammerZ))))
																																																					.getBlock() == Blocks.WATER
																																																							.getDefaultState()
																																																							.getBlock())
																																													|| (((world
																																															.getBlockState(
																																																	new BlockPos(
																																																			(int) (DarkiumModVariables.MapVariables
																																																					.get(world).DarkHammerX),
																																																			(int) (DarkiumModVariables.MapVariables
																																																					.get(world).DarkHammerY),
																																																			(int) (DarkiumModVariables.MapVariables
																																																					.get(world).DarkHammerZ))))
																																																							.getBlock() == Blocks.BROWN_MUSHROOM
																																																									.getDefaultState()
																																																									.getBlock())
																																															|| (((world
																																																	.getBlockState(
																																																			new BlockPos(
																																																					(int) (DarkiumModVariables.MapVariables
																																																							.get(world).DarkHammerX),
																																																					(int) (DarkiumModVariables.MapVariables
																																																							.get(world).DarkHammerY),
																																																					(int) (DarkiumModVariables.MapVariables
																																																							.get(world).DarkHammerZ))))
																																																									.getBlock() == Blocks.RED_MUSHROOM
																																																											.getDefaultState()
																																																											.getBlock())
																																																	|| (((world
																																																			.getBlockState(
																																																					new BlockPos(
																																																							(int) (DarkiumModVariables.MapVariables
																																																									.get(world).DarkHammerX),
																																																							(int) (DarkiumModVariables.MapVariables
																																																									.get(world).DarkHammerY),
																																																							(int) (DarkiumModVariables.MapVariables
																																																									.get(world).DarkHammerZ))))
																																																											.getBlock() == Blocks.OAK_SLAB
																																																													.getDefaultState()
																																																													.getBlock())
																																																			|| (((world
																																																					.getBlockState(
																																																							new BlockPos(
																																																									(int) (DarkiumModVariables.MapVariables
																																																											.get(world).DarkHammerX),
																																																									(int) (DarkiumModVariables.MapVariables
																																																											.get(world).DarkHammerY),
																																																									(int) (DarkiumModVariables.MapVariables
																																																											.get(world).DarkHammerZ))))
																																																													.getBlock() == Blocks.PUMPKIN
																																																															.getDefaultState()
																																																															.getBlock())
																																																					|| (((world
																																																							.getBlockState(
																																																									new BlockPos(
																																																											(int) (DarkiumModVariables.MapVariables
																																																													.get(world).DarkHammerX),
																																																											(int) (DarkiumModVariables.MapVariables
																																																													.get(world).DarkHammerY),
																																																											(int) (DarkiumModVariables.MapVariables
																																																													.get(world).DarkHammerZ))))
																																																															.getBlock() == Blocks.VINE
																																																																	.getDefaultState()
																																																																	.getBlock())
																																																							|| (((world
																																																									.getBlockState(
																																																											new BlockPos(
																																																													(int) (DarkiumModVariables.MapVariables
																																																															.get(world).DarkHammerX),
																																																													(int) (DarkiumModVariables.MapVariables
																																																															.get(world).DarkHammerY),
																																																													(int) (DarkiumModVariables.MapVariables
																																																															.get(world).DarkHammerZ))))
																																																																	.getBlock() == Blocks.BEETROOTS
																																																																			.getDefaultState()
																																																																			.getBlock())
																																																									|| (((world
																																																											.getBlockState(
																																																													new BlockPos(
																																																															(int) (DarkiumModVariables.MapVariables
																																																																	.get(world).DarkHammerX),
																																																															(int) (DarkiumModVariables.MapVariables
																																																																	.get(world).DarkHammerY),
																																																															(int) (DarkiumModVariables.MapVariables
																																																																	.get(world).DarkHammerZ))))
																																																																			.getBlock() == Blocks.CARROTS
																																																																					.getDefaultState()
																																																																					.getBlock())
																																																											|| (((world
																																																													.getBlockState(
																																																															new BlockPos(
																																																																	(int) (DarkiumModVariables.MapVariables
																																																																			.get(world).DarkHammerX),
																																																																	(int) (DarkiumModVariables.MapVariables
																																																																			.get(world).DarkHammerY),
																																																																	(int) (DarkiumModVariables.MapVariables
																																																																			.get(world).DarkHammerZ))))
																																																																					.getBlock() == Blocks.POTATOES
																																																																							.getDefaultState()
																																																																							.getBlock())
																																																													|| (((world
																																																															.getBlockState(
																																																																	new BlockPos(
																																																																			(int) (DarkiumModVariables.MapVariables
																																																																					.get(world).DarkHammerX),
																																																																			(int) (DarkiumModVariables.MapVariables
																																																																					.get(world).DarkHammerY),
																																																																			(int) (DarkiumModVariables.MapVariables
																																																																					.get(world).DarkHammerZ))))
																																																																							.getBlock() == Blocks.MELON
																																																																									.getDefaultState()
																																																																									.getBlock())
																																																															|| (((world
																																																																	.getBlockState(
																																																																			new BlockPos(
																																																																					(int) (DarkiumModVariables.MapVariables
																																																																							.get(world).DarkHammerX),
																																																																					(int) (DarkiumModVariables.MapVariables
																																																																							.get(world).DarkHammerY),
																																																																					(int) (DarkiumModVariables.MapVariables
																																																																							.get(world).DarkHammerZ))))
																																																																									.getBlock() == Blocks.NETHER_WART
																																																																											.getDefaultState()
																																																																											.getBlock())
																																																																	|| ((world
																																																																			.getBlockState(
																																																																					new BlockPos(
																																																																							(int) (DarkiumModVariables.MapVariables
																																																																									.get(world).DarkHammerX),
																																																																							(int) (DarkiumModVariables.MapVariables
																																																																									.get(world).DarkHammerY),
																																																																							(int) (DarkiumModVariables.MapVariables
																																																																									.get(world).DarkHammerZ))))
																																																																											.getBlock() == Blocks.COCOA
																																																																													.getDefaultState()
																																																																													.getBlock()))))))))))))))))))))))))))))))))) {
						Block.spawnDrops(
								world.getBlockState(new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
										(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
										(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ))),
								world.getWorld(),
								new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
										(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
										(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ)));
						world.destroyBlock(new BlockPos((int) (DarkiumModVariables.MapVariables.get(world).DarkHammerX),
								(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerY),
								(int) (DarkiumModVariables.MapVariables.get(world).DarkHammerZ)), false);
					}
					DarkiumModVariables.MapVariables
							.get(world).DarkHammerY = (double) ((DarkiumModVariables.MapVariables.get(world).DarkHammerY) + 1);
					DarkiumModVariables.MapVariables.get(world).syncData(world);
				}
				DarkiumModVariables.MapVariables.get(world).DarkHammerX = (double) ((DarkiumModVariables.MapVariables.get(world).DarkHammerX) + 1);
				DarkiumModVariables.MapVariables.get(world).syncData(world);
				DarkiumModVariables.MapVariables.get(world).DarkHammerY = (double) ((DarkiumModVariables.MapVariables.get(world).DarkHammerY) - 3);
				DarkiumModVariables.MapVariables.get(world).syncData(world);
			}
			DarkiumModVariables.MapVariables.get(world).DarkHammerZ = (double) ((DarkiumModVariables.MapVariables.get(world).DarkHammerZ) + 1);
			DarkiumModVariables.MapVariables.get(world).syncData(world);
			DarkiumModVariables.MapVariables.get(world).DarkHammerX = (double) ((DarkiumModVariables.MapVariables.get(world).DarkHammerX) - 3);
			DarkiumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
