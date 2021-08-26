public class RenderTarget {
	public final int x_size, y_size;

	public char empty_char = '.';

	public Frag[][] frags;
	public RenderTarget(int x, int y){
		x_size = x;
		y_size = y;
		frags = new Frag[x][y];
	}

	public void Clear(){
		frags = new Frag[x_size][y_size];
	}

	public void SetFrag(Frag f, Vec2i pos){
		if(pos.x >= 0 && pos.x < x_size && pos.y >= 0 && pos.y < y_size){
			frags[pos.x][pos.y] = f;
		}
	}

	public Vec2i PosToPixel(Vec3f v){
		return new Vec2i(Math.round((v.x+1.0f)*0.5f*(float)(x_size-1)), Math.round((v.y+1.0f)*0.5f*(float)(y_size-1)));
	}

	public void FragmentPhase(){
		for(int y = y_size-1; y >= 0; y--){
			for(int x = 0; x < x_size; x++){
				if(frags[x][y] == null){System.out.print(empty_char); continue;}
				System.out.print(frags[x][y].CalcValue());
			}
			System.out.print("\n");
		}
	}

	public void AddFragWithDepthTest(Frag f, Vec2i pos){
		if(pos.x >= 0 && pos.x < x_size && pos.y >= 0 && pos.y < y_size){
			if(frags[pos.x][pos.y] != null){
				if(f.depth < frags[pos.x][pos.y].depth){
					frags[pos.x][pos.y] = f;
				}
			}else{
				frags[pos.x][pos.y] = f;
			}
		}
	}
}