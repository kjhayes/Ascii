public class Shader {
	private static VertexShader default_v_shader = new TrivialVertexShader();

	public VertexShader v_shader;
	public FragmentShader f_shader;

	public Shader(FragmentShader f){
		v_shader = default_v_shader;
		f_shader = f;
	}
	public Shader(VertexShader v, FragmentShader f){
		v_shader = v;
		f_shader = f;
	}
}