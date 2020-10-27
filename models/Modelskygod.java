// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelskygod extends EntityModel {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer head2;
	private final ModelRenderer head3;

	public Modelskygod() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -7.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 40, -11.0F, -2.0F, -6.0F, 23, 12, 12, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 0, 70, -6.0F, 10.0F, -3.0F, 12, 5, 6, 0.5F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.0F, -2.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 24, 0, -1.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 24, 0, -10.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 24, 0, 8.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(0.0F, -7.0F, 0.0F);
		rightarm.cubeList.add(new ModelBox(rightarm, 60, 21, 12.0F, -2.5F, -3.0F, 5, 30, 6, 0.0F, true));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(0.0F, -7.0F, 0.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 60, 58, -16.0F, -2.5F, -3.0F, 5, 30, 6, 0.0F, true));

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(4.0F, 11.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 37, 0, -2.5F, -3.0F, -3.0F, 7, 16, 5, 0.0F, true));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-5.0F, 11.0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 60, 0, -4.0F, -3.0F, -3.0F, 7, 16, 5, 0.0F, false));

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, 24.0F, 0.0F);
		head2.cubeList.add(new ModelBox(head2, 0, 0, 5.0F, -43.0F, -7.5F, 8, 10, 8, 0.0F, true));

		head3 = new ModelRenderer(this);
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
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
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