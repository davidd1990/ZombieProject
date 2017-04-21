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
        return bandera;

    } 

    public static Nodo busquedaNodo(Nodo valor, ArrayList<Nodo>lista, ArrayList<Nodo>listaResultado){
        int puntero = valor.getId()+1;
        Nodo resultado = new Nodo(), anterior = new Nodo();

        for (int i = puntero; i <= lista.size(); i++) {
            if (i < lista.size()) {
                if (listaResultado.size() > 0) {
                    if (!lista.get(i).isMarca() && validar(lista.get(i).getValue(), listaResultado.get(listaResultado.size() - 1).getValue())) {
                        lista.get(i).marcar();
                        resultado = lista.get(i);
                        listaResultado.add(lista.get(i));
                        break;
                    }
                } else {
                    lista.get(i).marcar();
                    resultado = lista.get(i);
                    listaResultado.add(lista.get(i));
                    break;
                }
            }else{
                if (listaResultado.size() != 0){
                    lista.get(listaResultado.get(listaResultado.size()-1).getId()).desmmarcar();
                    anterior = listaResultado.get(listaResultado.size()-1);
                    listaResultado.remove(listaResultado.size()-1);
                    return busquedaNodo(anterior, lista, listaResultado);
                }else{
                    return new Nodo();
                }

            }
        }

        return resultado;
    }

    public static boolean busqueda (Nodo origen, ArrayList<Nodo> lista, ArrayList<Nodo> listaResultado){

        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).isMarca()){
                if (validar(origen.getValue(), lista.get(i).getValue())){
                    lista.get(i).marcar();
                    listaResultado.add(lista.get(i));
                    return busqueda(lista.get(i), lista, listaResultado);
                }
            }
        }

            if (lista.size() == listaResultado.size()){
                return true;
            }
            else{
                origen.desmmarcar();
                if(listaResultado.size() > 0) {
                    listaResultado.remove(listaResultado.size()-1);
                }

                Nodo nuevoOrigen = busquedaNodo(origen, lista, listaResultado);

                if(nuevoOrigen.getValue().equals("")){
                    return false;
                } else {
                    return busqueda(nuevoOrigen, lista, listaResultado);
                }


            }

    }


  /* public static void main(String[] args) {
        ArrayList<Nodo> lista            = new ArrayList<Nodo>();
        ArrayList<Nodo> listaResultado   = new ArrayList<Nodo>();

        Nodo n1 = new Nodo();

        n1.setValue("aba");


        n1.setId(0);
        n1.marcar();
        listaResultado.add(n1);
        lista.add(n1);

        Nodo n2 = new Nodo();

        n2.setValue("acc");

        n2.setId(1);
        lista.add(n2);

        Nodo n3 = new Nodo();

        n3.setValue("abb");
        n3.setId(2);
        lista.add(n3);

       Nodo n4 = new Nodo();
       n4.setValue("abc");
       n4.setId(3);
       lista.add(n4);

		System.out.println("NodoEnvia: "+ n1.getValue());
        System.out.println(busqueda(n1, lista, listaResultado));
        for (int i = 0 ; i < listaResultado.size(); i++)
            System.out.println(listaResultado.get(i).getValue());


        //validar("ababababa", "ababccaba");
    }*/

}