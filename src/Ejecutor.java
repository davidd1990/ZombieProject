import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Ejecutor {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Generador generador = new Generador();
		OrganizadorString organizador = new OrganizadorString(); 
		
		ArrayList<ArrayList> ejercicio = generador.generadorArrayList();
		Nodo primerNodo = new Nodo();
		
		
		for(int i=0; i< ejercicio.size(); i++){
			ArrayList<String> ejercicioActual = ejercicio.get(i);
			System.out.println("EJERCICIO ACTUAL: "+ ejercicioActual);
			ArrayList<Nodo> lista = new ArrayList<Nodo>();
			ArrayList<Nodo> listaResultado = new ArrayList<Nodo>();
			
			//Se llena la lista con nodos
			for(int j=0; j<ejercicioActual.size(); j++){
				Nodo nodo = new Nodo();
				if(j==0){
					String texto = ejercicioActual.get(j);
					nodo.setValue(texto);
					nodo.marcar();
					nodo.setId(j);
					primerNodo = nodo;
					listaResultado.add(nodo);
					lista.add(nodo);
				}else{
					String texto = ejercicioActual.get(j);
					nodo.setValue(texto);
					nodo.setId(j);
					lista.add(nodo);
				}
			}
			System.out.println("PrimerNodo: "+ primerNodo.getValue());
			System.out.println(OrganizadorString.busqueda(primerNodo, lista, listaResultado));
			for(int x=0; x<listaResultado.size(); x++){
				System.out.println("POS "+x+" "+listaResultado.get(x).getValue());
			}
	        
			
		}
	}

}
