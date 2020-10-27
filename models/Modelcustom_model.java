// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer helmet;

	public Modelcustom_model() {
		textureWidth = 128;
		textureHeight = 128;

		helmet = new ModelRenderer(this);
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
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}