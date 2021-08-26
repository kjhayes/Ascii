public class Mat4f {
	Vec4f i,j,k,t;
	Mat4f(){
		MakeIdentity();
	}
	Mat4f(Vec4f i, Vec4f j, Vec4f k, Vec4f t){
		this.i = new Vec4f(i);
		this.j = new Vec4f(j);
		this.k = new Vec4f(k);
		this.t = new Vec4f(t);
	}
	public void MakeIdentity(){
		i = new Vec4f(1.0f, 0.0f, 0.0f, 0.0f);
		j = new Vec4f(0.0f, 1.0f, 0.0f, 0.0f);
		k = new Vec4f(0.0f, 0.0f, 1.0f, 0.0f);
		t = new Vec4f(0.0f, 0.0f, 0.0f, 1.0f);
	}

	public Vec4f VecMult(Vec4f v){
		Vec4f ret = i.Prod(v.x);
		ret.Add(j.Prod(v.y));
		ret.Add(k.Prod(v.z));
		ret.Add(t.Prod(v.w));
		return ret;
	}
	public Mat4f MatMult(Mat4f m){
		Mat4f ret = new Mat4f();
		Vec4f xrow = new Vec4f(i.x, j.x, k.x, t.x);
		Vec4f yrow = new Vec4f(i.y, j.y, k.y, t.y);
		Vec4f zrow = new Vec4f(i.z, j.z, k.z, t.z);
		Vec4f wrow = new Vec4f(i.w, j.w, k.w, t.w);
		ret.i.x = xrow.Dot(m.i);
		ret.j.x = xrow.Dot(m.j);
		ret.k.x = xrow.Dot(m.k);
		ret.t.x = xrow.Dot(m.t);
		ret.i.y = yrow.Dot(m.i);
		ret.j.y = yrow.Dot(m.j);
		ret.k.y = yrow.Dot(m.k);
		ret.t.y = yrow.Dot(m.t);
		ret.i.z = zrow.Dot(m.i);
		ret.j.z = zrow.Dot(m.j);
		ret.k.z = zrow.Dot(m.k);
		ret.t.z = zrow.Dot(m.t);
		ret.i.w = wrow.Dot(m.i);
		ret.j.w = wrow.Dot(m.j);
		ret.k.w = wrow.Dot(m.k);
		ret.t.w = wrow.Dot(m.t);
		return ret;
	}

	public static Mat4f CreateTranslation(Vec3f translation){
		Mat4f m = new Mat4f();
		m.t.x = translation.x;
		m.t.y = translation.y;
		m.t.z = translation.z;
		return m;
	}
	public static Mat4f CreateScale(Vec3f scale){
		Mat4f m = new Mat4f();
		m.i.x = scale.x;
		m.j.y = scale.y;
		m.k.z = scale.z;
		return m;
	}

	public static Mat4f CreateXRotation(float theta){
		Mat4f ret = new Mat4f();
		float cos = (float)Math.cos(theta);
		float sin = (float)Math.sin(theta);
		ret.j.y = cos;
		ret.j.z = sin;
		ret.k.y = -sin;
		ret.k.z = cos;
		return ret;
	}
	public static Mat4f CreateYRotation(float theta){
		Mat4f ret = new Mat4f();
		float cos = (float)Math.cos(theta);
		float sin = (float)Math.sin(theta);
		ret.i.x = cos;
		ret.i.z = -sin;
		ret.k.x = sin;
		ret.k.z = cos;
		return ret;
	}
	public static Mat4f CreateZRotation(float theta){
		Mat4f ret = new Mat4f();
		float cos = (float)Math.cos(theta);
		float sin = (float)Math.sin(theta);
		ret.i.x = cos;
		ret.i.y = sin;
		ret.j.x = -sin;
		ret.j.y = sin;
		return ret;
	}

	public static Mat4f CreatePerspectiveProjection(float fov, float aspect_ratio, float near, float far){
		Mat4f ret = new Mat4f();
		float reciprocal_tanhalffov = 1.0f/ (float)Math.tan(fov*0.5f);
		float reciprocal_near_far_dif = 1.0f/(near-far);

		ret.i.x = reciprocal_tanhalffov / aspect_ratio;
		ret.j.y = reciprocal_tanhalffov;
		ret.k.z = (-near-far)*reciprocal_near_far_dif;
		ret.k.w = 1.0f;
		ret.t.z = (2*near*far)*reciprocal_near_far_dif;
		ret.t.w = 0.0f;

		return ret;
	}
}