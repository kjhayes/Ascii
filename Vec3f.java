public class Vec3f {
	float x,y,z;

	public Vec3f(){}
	public Vec3f(float x, float y, float z){
		this.x = x; this.y = y; this.z = z;
	}
	public Vec3f(Vec3f c){
		this.x = c.x; this.y = c.y; this.z = c.z;
	}
	public Vec3f(Vec4f v){
		this.x = v.x; this.y = v.y; this.z = v.z;
	}

	public Vec3f Sum(Vec3f o){
		return new Vec3f(
			this.x + o.x,
			this.y + o.y,
			this.z + o.z
		);
	}
	public void Add(Vec3f o){
		this.x += o.x;
		this.y += o.y;
		this.z += o.z;
	}
	public Vec3f Prod(float s){
		return new Vec3f(
			this.x * s,
			this.y * s,
			this.z * s
		);
	}
	public void Mul(float s){
		this.x *= s; 
		this.y *= s; 
		this.z *= s; 
	}

	public Vec4f CreateHomogenous(){
		return new Vec4f(this.x, this.y, this.z, 1.0f);
	}

	@Override
	public String toString(){
		return "("+x+", "+y+", "+z+")";
	}
}