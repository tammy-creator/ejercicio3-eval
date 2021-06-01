package ficheros;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.graalvm.compiler.hotspot.stubs.IntegerExactOverflowExceptionStub;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String archivo = System.getProperty("user.home") + "/OneDrive/Documentos/El Quijote UTF-8.txt";
		System.out.println("Tiempo sin buffer: " + leer(archivo, false));
		System.out.println("Tiempo con buffer: " + leer(archivo, true));
	}
	public static long leer(String archivo, boolean buffer) throws IOException {
		InputStream in = null;
		long totalTimeNs;
		try {
			if(buffer) {
				in = new BufferedInputStream(new FileInputStream(archivo));
				
			}else {
				in = new FileInputStream(archivo);
			}
			long t0 = System.nanoTime();
			
			while(in.read()!=-1);
			
			totalTimeNs = System.nanoTime() - t0;
			in.close();
			return totalTimeNs;
				
		}
		catch (IOException ex){
			System.err.println("Error leyendo fichero: " + ex.getMessage());
			
		}
		return 0;
	}
}
