
package net.mcreator.darkium.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.darkium.procedures.SkyGodEntityDiesProcedure;
import net.mcreator.darkium.itemgroup.SkyhotiumItemGroup;
import net.mcreator.darkium.item.SkyhotiumIngotItem;
import net.mcreator.darkium.DarkiumModElements;

import java.util.Map;
import java.util.HashMap;

@DarkiumModElements.ModElement.Tag
public class SkyGodEntity extends DarkiumModElements.ModElement {
	public static EntityType entity = null;
	public SkyGodEntity(DarkiumModElements instance) {
		super(instance, 82);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("skygod")
						.setRegistryName("skygod");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -16724839, -1, new Item.Properties().group(SkyhotiumItemGroup.tab)).setRegistryName("skygod"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelskygod(), 0.5f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("darkium:textures/skygod.png");
				}
			};
		});
	}
	public static class CustomEntity extends IronGolemEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 600;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.8));
			this.goalSelector.addGoal(5, new PanicGoal(this, 1.2));
			this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(SkyhotiumIngotItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			Entity sourceentity = source.getTrueSource();
			double x = this.posX;
			double y = this.posY;
			double z = this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SkyGodEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(700);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelskygod extends EntityModel {
		private final RendererModel body;
		private final RendererModel head;
		private final RendererModel rightarm;
		private final RendererModel leftarm;
		private final RendererModel rightleg;
		private final RendererModel leftleg;
		private final RendererModel head2;
		private final RendererModel head3;
		public Modelskygod() {
			textureWidth = 128;
			textureHeight = 128;
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, -7.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 40, -11.0F, -2.0F, -6.0F, 23, 12, 12, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 0, 70, -6.0F, 10.0F, -3.0F, 12, 5, 6, 0.5F, true));
			head = new RendererModel(this);
			head.setRotationPoint(0.0F, -7.0F, -2.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 24, 0, -1.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 24, 0, -10.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 24, 0, 8.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));
			rightarm = new RendererModel(this);
			rightarm.setRotationPoint(0.0F, -7.0F, 0.0F);
			rightarm.cubeList.add(new ModelBox(rightarm, 60, 21, 12.0F, -2.5F, -3.0F, 5, 30, 6, 0.0F, true));
			leftarm = new RendererModel(this);
			leftarm.setRotationPoint(0.0F, -7.0F, 0.0F);
			leftarm.cubeList.add(new ModelBox(leftarm, 60, 58, -16.0F, -2.5F, -3.0F, 5, 30, 6, 0.0F, true));
			rightleg = new RendererModel(this);
			rightleg.setRotationPoint(4.0F, 11.0F, 0.0F);
			rightleg.cubeList.add(new ModelBox(rightleg, 37, 0, -2.5F, -3.0F, -3.0F, 7, 16, 5, 0.0F, true));
			leftleg = new RendererModel(this);
			leftleg.setRotationPoint(-5.0F, 11.0F, 0.0F);
			leftleg.cubeList.add(new ModelBox(leftleg, 60, 0, -4.0F, -3.0F, -3.0F, 7, 16, 5, 0.0F, false));
			head2 = new RendererModel(this);
			head2.setRotationPoint(0.0F, 24.0F, 0.0F);
			head2.cubeList.add(new ModelBox(head2, 0, 0, 5.0F, -43.0F, -7.5F, 8, 10, 8, 0.0F, true));
			head3 = new RendererModel(this);
			head3.setRotationPoint(0.0F, 24.0F, 0.0F);
			head3.cubeList.add(new ModelBox(head3, 0, 0, -13.0F, -43.0F, -7.5F, 8, 10, 8, 0.0F, true));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			head.render(f5);
			rightarm.render(f5);
			leftarm.render(f5);
			rightleg.render(f5);
			leftleg.render(f5);
			head2.render(f5);
			head3.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.head3.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head3.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
