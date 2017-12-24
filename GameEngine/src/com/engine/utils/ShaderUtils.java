package com.engine.utils;

import static org.lwjgl.opengl.GL11.GL_FALSE;

import org.lwjgl.opengl.GL20;

public class ShaderUtils {

	private ShaderUtils(){}
	
	public static int load(String vertPath, String fragPath) {
		String vert = FileUtils.loadAsString(vertPath);
		String frag = FileUtils.loadAsString(fragPath);
		return create(vert, frag);
	}
	
	public static int create(String vert, String frag) {
		int program = GL20.glCreateProgram();
		int vertID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		int fragID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		GL20.glShaderSource(vertID, vert);
		GL20.glShaderSource(fragID, frag);
		GL20.glCompileShader(vertID);
		if (GL20.glGetShaderi(vertID, GL20.GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile vertex shader!");
			System.err.println(GL20.glGetShaderInfoLog(vertID, 2048));
		}
		GL20.glCompileShader(fragID);
		if (GL20.glGetShaderi(fragID, GL20.GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile fragment shader!");
			System.err.println(GL20.glGetShaderInfoLog(fragID, 2048));
		}
		GL20.glAttachShader(program, vertID);
		GL20.glAttachShader(program, fragID);
		GL20.glLinkProgram(program);
		GL20.glValidateProgram(program);
		return program;
	}
	
}