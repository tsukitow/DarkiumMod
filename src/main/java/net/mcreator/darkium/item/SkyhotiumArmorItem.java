
package net.mcreator.darkium.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.darkium.itemgroup.SkyhotiumItemGroup;
import net.mcreator.darkium.DarkiumModElements;

@DarkiumModElements.ModElement.Tag
public class SkyhotiumArmorItem extends DarkiumModElements.ModElement {
	@ObjectHolder("darkium:skyhotiumarmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("darkium:skyhotiumarmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("darkium:skyhotiumarmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("darkium:skyhotiumarmor_boots")
	public static final Item boots = null;
	public SkyhotiumArmorItem(DarkiumModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 29;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{16, 24, 34, 18}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 20;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SkyhotiumIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "skyhotiumarmor";
			}

			public float getToughness() {
				return 4f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SkyhotiumItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedHead = new Modelcustom_model().helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "darkium:textures/kyhotelmet.png";
			}
		}.setRegistryName("skyhotiumarmor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(SkyhotiumItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedBody = new ModelSkyhotChestplate().body;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "darkium:textures/kyhothestplate.png";
			}
		}.setRegistryName("skyhotiumarmor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(SkyhotiumItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedLeftLeg = new ModelSkyhotLeggings().leftLeg;
				armorModel.bipedRightLeg = new ModelSkyhotLeggings().rightLeg;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "darkium:textures/kyhoteggings.png";
			}
		}.setRegistryName("skyhotiumarmor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(SkyhotiumItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedLeftLeg = new ModelSkyhotBoots().leftLeg2;
				armorModel.bipedRightLeg = new ModelSkyhotBoots().rightLeg2;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "darkium:textures/kyhotoots.png";
			}
		}.setRegistryName("skyhotiumarmor_boots"));
	}
	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelSkyhotChestplate extends EntityModel<Entity> {
		private final RendererModel leftArm;
		private final RendererModel rightArm;
		private final RendererModel body;
		public ModelSkyhotChestplate() {
			textureWidth = 128;
			textureHeight = 128;
			leftArm = new RendererModel(this);
			leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			leftArm.cubeList.add(new ModelBox(leftArm, 22, 0, 0.0F, -5.0F, -3.0F, 3, 3, 6, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 24, 16, 3.0F, -3.0F, -2.0F, 2, 3, 4, 0.0F, false));
			rightArm = new RendererModel(this);
			rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			rightArm.cubeList.add(new ModelBox(rightArm, 44, 0, -3.0F, -5.0F, -3.0F, 3, 3, 6, 0.0F, false));
			rightArm.cubeList.add(new ModelBox(rightArm, 46, 14, -5.0F, -3.0F, -2.0F, 2, 3, 4, 0.0F, false));
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, 0.0F, -3.0F, 8, 12, 1, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 26, 30, 4.0F, 0.0F, -2.0F, 1, 12, 4, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 46, 28, -5.0F, 0.0F, -2.0F, 1, 12, 4, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 18, -4.0F, 0.0F, 2.0F, 8, 12, 1, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 35, -3.0F, 3.0F, 3.0F, 6, 8, 1, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 47, -4.0F, 4.0F, -4.0F, 8, 8, 1, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 60, -3.0F, 8.0F, -5.0F, 6, 9, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			leftArm.render(f5);
			rightArm.render(f5);
			body.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelSkyhotBoots extends EntityModel<Entity> {
		private final RendererModel rightLeg2;
		private final RendererModel leftLeg2;
		public ModelSkyhotBoots() {
			textureWidth = 128;
			textureHeight = 128;
			rightLeg2 = new RendererModel(this);
			rightLeg2.setRotationPoint(-1.9F, 12.0F, 0.0F);
			rightLeg2.cubeList.add(new ModelBox(rightLeg2, 120, 50, -2.1F, 7.0F, -3.0F, 4, 5, 1, 0.0F, false));
			rightLeg2.cubeList.add(new ModelBox(rightLeg2, 117, 60, -2.1F, 7.0F, 2.0F, 3, 5, 1, 0.0F, false));
			rightLeg2.cubeList.add(new ModelBox(rightLeg2, 90, 1, -3.1F, 7.0F, -3.0F, 1, 5, 6, 0.0F, false));
			leftLeg2 = new RendererModel(this);
			leftLeg2.setRotationPoint(1.9F, 12.0F, 0.0F);
			leftLeg2.cubeList.add(new ModelBox(leftLeg2, 90, 39, -1.9F, 7.0F, -3.0F, 4, 5, 1, 0.0F, false));
			leftLeg2.cubeList.add(new ModelBox(leftLeg2, 90, 24, 2.1F, 7.0F, -3.0F, 1, 5, 6, 0.0F, false));
			leftLeg2.cubeList.add(new ModelBox(leftLeg2, 90, 19, -2.9F, 7.0F, 2.0F, 5, 5, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			rightLeg2.render(f5);
			leftLeg2.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final RendererModel helmet;
		public Modelcustom_model() {
			textureWidth = 128;
			textureHeight = 128;
			helmet = new RendererModel(this);
			helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
			helmet.cubeList.add(new ModelBox(helmet, 80, 91, -5.0F, -9.0F, -5.0F, 10, 1, 10, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 72, 114, -4.0F, -10.0F, -4.0F, 8, 1, 7, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 77, 106, -3.0F, -11.0F, -5.0F, 6, 1, 5, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 116, 106, -3.0F, -13.0F, -5.0F, 2, 2, 2, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 105, 106, 1.0F, -13.0F, -5.0F, 2, 2, 2, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 118, 114, 2.0F, -14.0F, -6.0F, 1, 2, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 107, 114, -3.0F, -14.0F, -6.0F, 1, 2, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 117, 120, -4.0F, -15.0F, -7.0F, 1, 2, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 107, 120, 3.0F, -15.0F, -7.0F, 1, 2, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 52, 90, -4.0F, -8.0F, -5.0F, 1, 5, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 72, 90, 3.0F, -8.0F, -5.0F, 1, 5, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 82, 73, 4.0F, -8.0F, -4.0F, 1, 8, 8, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 104, 73, -5.0F, -8.0F, -4.0F, 1, 8, 8, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 56, 101, -4.0F, -3.0F, -5.0F, 8, 3, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 49, 109, -4.0F, -8.0F, 4.0F, 8, 8, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 50, 122, -3.0F, -6.0F, 5.0F, 6, 5, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 56, 85, -3.0F, -8.0F, -5.0F, 6, 1, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			helmet.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelSkyhotLeggings extends EntityModel<Entity> {
		private final RendererModel rightLeg;
		private final RendererModel leftLeg;
		public ModelSkyhotLeggings() {
			textureWidth = 128;
			textureHeight = 128;
			rightLeg = new RendererModel(this);
			rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			rightLeg.cubeList.add(new ModelBox(rightLeg, 119, 0, -2.1F, 0.0F, -3.0F, 3, 7, 1, 0.0F, false));
			rightLeg.cubeList.add(new ModelBox(rightLeg, 118, 13, -2.1F, 0.0F, 2.0F, 3, 7, 1, 0.0F, false));
			rightLeg.cubeList.add(new ModelBox(rightLeg, 116, 22, -3.1F, 0.0F, -2.0F, 2, 7, 4, 0.0F, false));
			rightLeg.cubeList.add(new ModelBox(rightLeg, 118, 37, -4.1F, 1.0F, -1.0F, 1, 5, 2, 0.0F, false));
			leftLeg = new RendererModel(this);
			leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			leftLeg.cubeList.add(new ModelBox(leftLeg, 105, 0, -1.9F, 0.0F, -3.0F, 3, 7, 1, 0.0F, false));
			leftLeg.cubeList.add(new ModelBox(leftLeg, 104, 11, -1.9F, 0.0F, 2.0F, 3, 7, 1, 0.0F, false));
			leftLeg.cubeList.add(new ModelBox(leftLeg, 104, 22, 0.1F, 0.0F, -2.0F, 2, 7, 4, 0.0F, false));
			leftLeg.cubeList.add(new ModelBox(leftLeg, 105, 36, 2.1F, 1.0F, -1.0F, 1, 5, 2, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			rightLeg.render(f5);
			leftLeg.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
