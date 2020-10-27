// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelSkyhotBoots extends ModelBase {
	private final ModelRenderer rightLeg2;
	private final ModelRenderer leftLeg2;

	public ModelSkyhotBoots() {
		textureWidth = 128;
		textureHeight = 128;

		rightLeg2 = new ModelRenderer(this);
		rightLeg2.setRotationPoint(-1.9F, 12.0F, 0.0F);
		rightLeg2.cubeList.add(new ModelBox(rightLeg2, 120, 50, -2.1F, 7.0F, -3.0F, 4, 5, 1, 0.0F, false));
		rightLeg2.cubeList.add(new ModelBox(rightLeg2, 117, 60, -2.1F, 7.0F, 2.0F, 3, 5, 1, 0.0F, false));
		rightLeg2.cubeList.add(new ModelBox(rightLeg2, 90, 1, -3.1F, 7.0F, -3.0F, 1, 5, 6, 0.0F, false));

		leftLeg2 = new ModelRenderer(this);
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
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}