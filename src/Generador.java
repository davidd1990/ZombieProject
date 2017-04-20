

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Generador {
	
	public static ArrayList<ArrayList> generadorArrayList() throws FileNotFoundException, IOException {
		
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(file);
		File archivo = file.getSelectedFile();
		
		
		ArrayList<ArrayList> listas = new ArrayList<ArrayList>();
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        while((cadena = b.readLine())!=null) {
        	ArrayList<String> vector = new ArrayList<String>();
        	String[] actual = cadena.split(" ");
        	for(int i=0; i<actual.length; i++){
        		String val = actual[i].trim();
        		vector.add(val);
        	}
        	listas.add(vector);
        }
        b.close(); 
        
        /*for(int j=0; j<listas.size(); j++){
        	System.out.println(listas.get(j));
        }*/
       return listas;	
	}
	
	public static void generadorDeArchivoSalida(ArrayList resultado) throws FileNotFoundException{
		resultado= new ArrayList();
		File file = new File("salida.out");
		PrintWriter pw = new PrintWriter(file);
		for(int i=0; i>resultado.size() ;i++)
		{
			if(i == resultado.size()){
				pw.print(resultado.get(i));
			}else{
				pw.print(resultado.get(i)+" ");
			}
		    
		}
		pw.close(); 
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		generadorArrayList();
	}

}
