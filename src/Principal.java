import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Generador generador = new Generador();
		OrganizadorString organizador = new OrganizadorString(); 
		
		ArrayList<ArrayList> ejercicio = generador.generadorArrayList();
		ArrayList<ArrayList> arrSalida = new ArrayList<ArrayList>();
		ArrayList<Boolean> arrResultado = new ArrayList<Boolean>();
		Nodo primerNodo = new Nodo();
		
		//Se ejecuta tantas veces como ejercicios allá en el archivo
		for(int i=0; i< ejercicio.size(); i++)
		{
			ArrayList<String> ejercicioActual = ejercicio.get(i);
			ArrayList<Nodo> lista = new ArrayList<Nodo>();
			ArrayList<Nodo> listaResultado = new ArrayList<Nodo>();
			
			//Se llena la lista con nodos
			for(int j=0; j<ejercicioActual.size(); j++)
			{
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
			boolean resultado = OrganizadorString.busqueda(primerNodo, lista, listaResultado);
			if(listaResultado.size() == 0){
				resultado = false;
				arrSalida.add(lista);
				arrResultado.add(resultado);
			}else{
				arrSalida.add(lista);
				arrResultado.add(resultado);
			}
			
		}
		generador.generarArchivoSalida(arrSalida, arrResultado);
	}

}
