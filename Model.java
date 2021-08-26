import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;

public class Model {
	public ArrayList<Vec3f> vert_pos;
	public ArrayList<Tri> tris;

	public void ReadFromOBJ(String obj_file){
		int ln = 1;
		try{
			vert_pos = new ArrayList<Vec3f>();
			tris = new ArrayList<Tri>();

			BufferedReader br = new BufferedReader(new FileReader(obj_file));

			String line = br.readLine();
			while(line != null){
				if(line.charAt(0) == 'v'){
					int i = 3;
					int coords = 0;
					int last_space = 2;
					Vec3f v = new Vec3f();
					while(coords < 2){	
						if(line.charAt(i) == ' '){
							if(coords == 0){
								v.x = Float.parseFloat(line.substring(last_space+1, i));
							}
							else if(coords == 1){
								v.y = Float.parseFloat(line.substring(last_space+1, i));
								v.z = Float.parseFloat(line.substring(i+1));
							}
							coords++;
							last_space = i;
						}
						i++;
					}
					vert_pos.add(v);
				}
				else if(line.charAt(0) == 'f'){
					boolean hitSlash = false;
					int i = 1;
					int vert = 0;
					int last_space = 0;
					Tri tri = new Tri();
					while(vert < 3){
						
						if(line.charAt(i) == '/'){
							if(!hitSlash){
								if(vert == 0){
								tri.vert1 = new Vert(vert_pos.get(
									Integer.parseInt(line.substring(last_space+1, i)) - 1
								));
								}
								else if(vert == 1){
								tri.vert2 = new Vert(vert_pos.get(
									Integer.parseInt(line.substring(last_space+1, i)) - 1
								));
								}
								else if(vert == 2){
								tri.vert3 = new Vert(vert_pos.get(
									Integer.parseInt(line.substring(last_space+1, i)) - 1
								));
								}
								vert++;
							}
							hitSlash = true;
						}
						if(line.charAt(i) == ' '){
							hitSlash = false;
							last_space = i;
						}
						i++;
					}
					tris.add(tri);
				}
				line = br.readLine();
				ln++;
			}

		}catch(Exception e){
			System.err.println("Reading File: "+obj_file);
			System.err.println("Line Number: "+ln);
			e.printStackTrace();
		}
	}
	public void Render(RenderTarget rt, Shader sh){
		for(int i = 0; i < tris.size(); i++){
			tris.get(i).PushFrags(rt, sh);
		}
	}
}