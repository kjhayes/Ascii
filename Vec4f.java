public class Vec4f {
	float x,y,z,w;
	public Vec4f(){}
	public Vec4f(float x, float y, float z){
		this.x = x; this.y = y; this.z = z;
		this.w = 1.0f;
	}
	public Vec4f(float x, float y, float z, float w){
		this.x = x; this.y = y; this.z = z; this.w = w;
	}
	public Vec4f(Vec4f c){
		this.x = c.x; this.y = c.y; this.z = c.z; this.w = c.w;
	}
	public Vec4f(Vec3f v){
		this.x = v.x; this.y = v.y; this.z = v.z; this.w = 1.0f;
	}
	public Vec4f(Vec3f v, float w){
		this.x = v.x; this.y = v.y; this.z = v.z; this.w = w;
	}

	public Vec4f Sum(Vec4f o){
		return new Vec4f(
			this.x + o.x,
			this.y + o.y,
			this.z + o.z,
			this.w + o.w
		);
	}
	public void Add(Vec4f o){
		this.x += o.x;
		this.y += o.y;
		this.z += o.z;
		this.w += o.w;
	}
	public Vec4f Prod(float s){
		return new Vec4f(
			this.x * s,
			this.y * s,
			this.z * s,
			this.w * s
		);
	}
	public void Mul(float s){
		this.x *= s; 
		this.y *= s; 
		this.z *= s; 
		this.w *= s;
	}

	public float Dot(Vec4f o){
		return (x*o.x)+(y*o.y)+(z*o.z)+(w*o.w);
	}

	public static Vec3f HomogenousToCartesian(Vec4f v4){
		return new Vec3f(
			v4.x / v4.w,
			v4.y / v4.w,
			v4.z / v4.w
		);
	}

	@Override
	public String toString(){
		return "("+x+", "+y+", "+z+", "+w+")";
	}
}