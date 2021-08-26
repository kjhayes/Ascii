public class Vert {
	public Vec3f position;
	public float[] fields;
	public Vert(Vec3f pos){
		position = new Vec3f(pos);
	}
	public Vert(Vec3f pos, float[] f){
		position = new Vec3f(pos);
		fields = f;
	}
}