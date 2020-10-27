// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelSkyhotChestplate extends ModelBase {
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer body;

	public ModelSkyhotChestplate() {
		textureWidth = 128;
		textureHeight = 128;

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 22, 0, 0.0F, -5.0F, -3.0F, 3, 3, 6, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 24, 16, 3.0F, -3.0F, -2.0F, 2, 3, 4, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 0, -3.0F, -5.0F, -3.0F, 3, 3, 6, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 46, 14, -5.0F, -3.0F, -2.0F, 2, 3, 4, 0.0F, false));

		body = new ModelRenderer(this);
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
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}