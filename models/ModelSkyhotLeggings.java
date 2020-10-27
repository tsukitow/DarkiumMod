// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelSkyhotLeggings extends ModelBase {
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public ModelSkyhotLeggings() {
		textureWidth = 128;
		textureHeight = 128;

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 119, 0, -2.1F, 0.0F, -3.0F, 3, 7, 1, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 118, 13, -2.1F, 0.0F, 2.0F, 3, 7, 1, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 116, 22, -3.1F, 0.0F, -2.0F, 2, 7, 4, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 118, 37, -4.1F, 1.0F, -1.0F, 1, 5, 2, 0.0F, false));

		leftLeg = new ModelRenderer(this);
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
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}