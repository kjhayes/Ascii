import java.util.ArrayList;
//static
public class Bresenham {
	public static ArrayList<Vec2i> DrawOctant0Line(Vec2i origin, Vec2i delta, Vec2i constraints){
		int d = (2*delta.y)-delta.x;
		int y = origin.y;
		int max_x = origin.x+delta.x;

		ArrayList<Vec2i> pos = new ArrayList<Vec2i>();

		for(int i = origin.x; i <= max_x; i++){
			pos.add(new Vec2i(i, y));
			if(d > 0){
				y++;
				d -= 2*delta.x;
			}
			d += 2*delta.y;
		}
		return pos;
	}
	public static ArrayList<Vec2i> DrawOctant1Line(Vec2i origin, Vec2i delta, Vec2i constraints){
		int d = (2*delta.x)-delta.y;
		int x = origin.x;
		int max_y = origin.y+delta.y;
		
		ArrayList<Vec2i> pos = new ArrayList<Vec2i>();
		
		for(int i = origin.y; i <= max_y; i++){
			pos.add(new Vec2i(x, i));
			if(d > 0){
				x++;
				d -= 2*delta.y;
			}
			d += 2*delta.x;
		}
		return pos;
	}

	public static ArrayList<Vec2i> DrawOctant3Line(Vec2i origin, Vec2i delta, Vec2i constraints){
		int d = (2*delta.y)+delta.x;
		int y = origin.y;
		int min_x = origin.x+delta.x;
		
		ArrayList<Vec2i> pos = new ArrayList<Vec2i>();
		
		for(int i = origin.x; i >= min_x; i--){
			pos.add(new Vec2i(i, y));
			if(d > 0){
				y++;
				d += 2*delta.x;
			}
			d += 2*delta.y;
		}
		return pos;
	}
	public static ArrayList<Vec2i> DrawOctant2Line(Vec2i origin, Vec2i delta, Vec2i constraints){
		int d = (-2*delta.x)-delta.y;
		int x = origin.x;
		int max_y = origin.y+delta.y;

		ArrayList<Vec2i> pos = new ArrayList<Vec2i>();
		
		for(int i = origin.y; i <= max_y; i++){
			pos.add(new Vec2i(x, i));
			if(d > 0){
				x--;
				d -= 2*delta.y;
			}
			d -= 2*delta.x;
		}
		return pos;
	}

	public static ArrayList<Vec2i> DrawLine(Vec2i a, Vec2i b, Vec2i constraints){
		Vec2i origin;
		Vec2i delta;
		
		if(a.y <= b.y){
			origin = new Vec2i(a);
			delta = new Vec2i(b.x-a.x, b.y-a.y);
		}
		else{
			origin = new Vec2i(b);
			delta = new Vec2i(a.x-b.x, a.y-b.y);
		}
		if((delta.x*delta.x)+(delta.y*delta.y) < 0.7){
			return new ArrayList<Vec2i>();
		}
		if(delta.x >= 0){
			if(delta.y <= delta.x){
				return DrawOctant0Line(origin, delta, constraints);
			}
			else{
				return DrawOctant1Line(origin, delta, constraints);
			}
		}
		else{
			if(delta.y <= -delta.x){
				return DrawOctant3Line(origin, delta, constraints);
			}
			else{
				return DrawOctant2Line(origin, delta, constraints);
			}
		}
	}
}