package analizador;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta = new String("C:/Users/carlo/Documents/Teoria_Compiladores/compiladores_sintactico/src/analizador/Lexer.flex");
		generarLexer(ruta);
	}
	
	public static void generarLexer(String ruta) {
		File archivo = new File(ruta);
		JFlex.Main.generate(archivo);
	}
}
