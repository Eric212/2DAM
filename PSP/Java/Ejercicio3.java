package Java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb=new ProcessBuilder("CMD","/c","java --version");
        File error=new File("Z:\\PSP\\Java\\error.txt");
        pb.redirectError(error);
        pb.start();
        int i;
        FileReader fr=new FileReader(error);
        while((i=fr.read())!=-1){
            System.out.print((char)i);
        }
    }
}
