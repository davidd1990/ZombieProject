/**
 * Created by JUAN DAVID on 19/04/2017.
 */
import java.util.ArrayList;


public class OrganizadorString {


    public static boolean validar (String texto1, String texto2){

        boolean bandera = false;

        for (int i = 0; i < texto1.length(); i++) {

            if (!(texto1.charAt(i) == texto2.charAt(i))){
                if (bandera){return false;}
                else{bandera = true;}
            }

        }
        return true;

    }

    public static Nodo busquedaNodo(Nodo valor, ArrayList<Nodo>lista, ArrayList<Nodo>listaResultado){
        int puntero = 0;
        Nodo resultado = new Nodo(), anterior = new Nodo();

        for(int i = 0; i < lista.size(); i++){
            if (lista.get(i).getValue().equals(valor)){
                puntero = i;
            }
        }

        for(int i = puntero+1; i < lista.size(); i++){
            if (!lista.get(i).isMarca() && validar(lista.get(i).getValue(), listaResultado.get(listaResultado.size()-1).getValue())){
                resultado = lista.get(i);
            }
        }

        if(resultado.equals("")){
            if (puntero == lista.size() && resultado == null){return resultado;}
            for(int i = 0; i < lista.size(); i++){
                if (lista.get(i).getValue().equals(listaResultado.get(listaResultado.size()-1).getValue())){
                    lista.get(i).desmmarcar();
                }
            }
            anterior = listaResultado.get(listaResultado.size()-1);
            listaResultado.remove(listaResultado.size()-1);
            return busquedaNodo(anterior, lista, listaResultado);
        }

        return resultado;
    }

    public static boolean busqueda (Nodo origen, ArrayList<Nodo> lista, ArrayList<Nodo> listaResultado){
        boolean bandera = false;


        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).isMarca()){
                if (validar(origen.getValue(), lista.get(i).getValue())){
                    lista.get(i).marcar();
                    listaResultado.set((listaResultado.size()+1), lista.get(i));
                    bandera = true;
                    return busqueda(lista.get(i), lista, listaResultado);
                }
            }
        }


        if (!bandera){
            origen.desmmarcar();
            listaResultado.remove(listaResultado.size()-1);
            if (busquedaNodo(origen, lista, listaResultado) == null){
                return false;
            }else{
                return busqueda(busquedaNodo(origen, lista, listaResultado), lista, listaResultado);
            }

        }

        if (lista.size() == listaResultado.size())
            return true;
        else
            return false;

    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Nodo> lista            = new ArrayList<Nodo>();
        ArrayList<Nodo> listaResultado   = new ArrayList<Nodo>();


        validar("ababababa", "ababccaba");
    }


}