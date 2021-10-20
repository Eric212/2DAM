package Java;
import java.io.IOException;


public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		new ProcessBuilder().command("cmd.exe","/c","whoami /all").start();
	}
}