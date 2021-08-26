public class Vec2i {
	public int x,y;
	public Vec2i(){}
	public Vec2i(int x, int y){
		this.x = x; this.y = y;
	}
	public Vec2i(Vec2i c){
		this.x = c.x;
		this.y = c.y;
	}

	public static Vec2i NearestV2i(Vec3f v3){
		return new Vec2i(Math.round(v3.x), Math.round(v3.y));		
	}
}