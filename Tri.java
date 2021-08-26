import java.util.ArrayList;

public class Tri {
	public Vert vert1, vert2, vert3;

	public void PushFrags(RenderTarget target, Shader shader){
		//Vertex Shader
		Vert v1 = new Vert(shader.v_shader.ProcessVert(vert1), vert1.fields);
		Vert v2 = new Vert(shader.v_shader.ProcessVert(vert2), vert2.fields);
		Vert v3 = new Vert(shader.v_shader.ProcessVert(vert3), vert3.fields);

		Vec2i target_constraints = new Vec2i(target.x_size, target.y_size);
		ArrayList<Vec2i> v1_v2 = Bresenham.DrawLine(target.PosToPixel(v1.position), target.PosToPixel(v2.position), target_constraints);
		ArrayList<Vec2i> v2_v3 = Bresenham.DrawLine(target.PosToPixel(v2.position), target.PosToPixel(v3.position), target_constraints);
		ArrayList<Vec2i> v3_v1 = Bresenham.DrawLine(target.PosToPixel(v3.position), target.PosToPixel(v1.position), target_constraints);

		for(int i = 0; i < v1_v2.size(); i++){
			target.AddFragWithDepthTest(new Frag(shader.f_shader, v1.fields, 1.0f), v1_v2.get(i));	
		}
		for(int i = 0; i < v2_v3.size(); i++){
			target.AddFragWithDepthTest(new Frag(shader.f_shader, v2.fields, 1.0f), v2_v3.get(i));	
		}
		for(int i = 0; i < v3_v1.size(); i++){
			target.AddFragWithDepthTest(new Frag(shader.f_shader, v3.fields, 1.0f), v3_v1.get(i));	
		}
	}
}