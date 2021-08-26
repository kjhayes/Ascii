public class Frag {
	public float depth;
	public float[] fields;
	public FragmentShader shader;

	public Frag(FragmentShader fs, float[] fds, float d){
		shader = fs;
		fields = fds;
		depth = d;
	}

	public char CalcValue(){
		return shader.ProcessFrag(this);
	}
}