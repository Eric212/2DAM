package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder();
		Process p = pb.command("cmd.exe","/c","whoami /all").start();		
		try {	
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			System.out.println("Esta es la salida del comando:");
			String linea;
			while ((linea = br.readLine()) != null)	{		 
				System.out.println(linea);
			}
			br.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		int valorSalida;
		try {
			valorSalida = p.waitFor();
			System.out.println("El valor de Salida del proceso es: " + valorSalida);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}