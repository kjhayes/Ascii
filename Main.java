import java.util.ArrayList;
import java.util.Scanner;

import java.lang.Thread;

public class Main {
	public static void main(String[] args){
		RenderTarget rt = new RenderTarget(44,22);
		Shader sh = new Shader(new AtFragShader());

		Model model = new Model();
		model.ReadFromOBJ("../Models/Stego.obj");

		while(true){
			model.Render(rt, sh);
		//	rt.FragmentPhase();
			rt.Clear();
			TrivialVertexShader.theta+=0.1f;
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.err.println(e);
			}
		}
	}
}