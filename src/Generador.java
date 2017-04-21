

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
       return listas;	
	}
	
	
	public void generarArchivoSalida(ArrayList<ArrayList> arrSalida, ArrayList<Boolean> arrResultado){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("salida.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < arrSalida.size(); i++) {
    			for (int j = 0; j < arrSalida.get(i).size(); j++) {
    				Nodo nodo = (Nodo) arrSalida.get(i).get(j);
    				if(j+1 == arrSalida.get(i).size()){
    					pw.println(nodo.getValue()+" = "+ arrResultado.get(i));
    				}else{
    					pw.print(nodo.getValue()+" ");
    				}
    			}
    		}
            System.out.println("Archivo generado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

}
