public class TrivialVertexShader implements VertexShader {
	static Mat4f pp = Mat4f.CreatePerspectiveProjection(3.141592f*0.7f, 1.0f, 0.0f, 20.0f);
	static Mat4f trans = Mat4f.CreateTranslation(new Vec3f(0.0f,0.0f,2.0f));
	static Mat4f scale = Mat4f.CreateScale(new Vec3f(1.0f,1.0f,1.0f));
	static Mat4f pptrans = pp.MatMult(trans.MatMult(scale));
	static float theta = 0.0f;
	
	public Vec3f ProcessVert(Vert v){
		return Vec4f.HomogenousToCartesian(
			pptrans.VecMult(
					Mat4f.CreateYRotation(theta).VecMult(
						v.position.CreateHomogenous()
					)
				)
			);
	}
}