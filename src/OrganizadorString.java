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
            if (lista.get(i).getValue().equals(valor.getValue())){
                puntero = i;
            }
        }


        for(int i = puntero+1; i < lista.size(); i++){
            if(listaResultado.size() > 0){
                if (!lista.get(i).isMarca() && validar(lista.get(i).getValue(), listaResultado.get(listaResultado.size()-1).getValue())){
                    lista.get(i).marcar();
                    resultado = lista.get(i);
                    listaResultado.add(lista.get(i));
                }
            }
            else {
                    lista.get(i).marcar();
                    resultado = lista.get(i);
                    listaResultado.add(lista.get(i));
                }
        }

        if(resultado.getValue().equals("")){
            if ((puntero+1) == lista.size()){
                return new Nodo();
            }


                for (int i = 0; i < lista.size(); i++) {
                    if(listaResultado.size() > 0)
                        if (lista.get(i).getValue().equals(listaResultado.get(i).getValue())) {
                            lista.get(i).desmmarcar();
                            listaResultado.remove(listaResultado.size()-1);
                            return busquedaNodo(lista.get(i), lista, listaResultado);
                    }else{
                        return new Nodo();
                    }
                }

        }

        return resultado;
    }

    public static boolean busqueda (Nodo origen, ArrayList<Nodo> lista, ArrayList<Nodo> listaResultado){
        boolean bandera = false;


        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).isMarca()){
                if (validar(origen.getValue(), lista.get(i).getValue())){
                    lista.get(i).marcar();
                    listaResultado.add(lista.get(i));
                    bandera = true;
                    return busqueda(lista.get(i), lista, listaResultado);
                }
            }
        }


        if (!bandera){
            if (lista.size() == listaResultado.size()){
                return true;
            }
            else{
                origen.desmmarcar();
                if(listaResultado.size() > 0) listaResultado.remove(listaResultado.size()-1);
                if (busquedaNodo(origen, lista, listaResultado).getValue().equals("")){
                    return false;
                }else{
                    return busqueda(busquedaNodo(origen, lista, listaResultado), lista, listaResultado);
                }
            }


        }


            return false;

    }


    public static void main(String[] args) {
        ArrayList<Nodo> lista            = new ArrayList<Nodo>();
        ArrayList<Nodo> listaResultado   = new ArrayList<Nodo>();


        Nodo n1 = new Nodo();
        n1.setValue("bbbc");
        n1.marcar();
        listaResultado.add(n1);
        lista.add(n1);

        Nodo n2 = new Nodo();
        n2.setValue("bbbx");
        lista.add(n2);

        Nodo n3 = new Nodo();
        n3.setValue("abbx");
        lista.add(n3);

       /* Nodo n4 = new Nodo();
        n4.setValue("abbd");
        lista.add(n4);

        Nodo n5 = new Nodo();
        n5.setValue("abbb");
        lista.add(n5);*/


        System.out.println(busqueda(n1, lista, listaResultado));
        System.out.println(listaResultado);
        validar("ababababa", "ababccaba");
    }


}