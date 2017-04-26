import java.util.ArrayList;

public class Nodo {

    private String value = "";
    private boolean marca = false;
    private ArrayList<Nodo> arcos = new ArrayList<Nodo>();
    private int id = 0;
    private boolean zonaSegura = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public boolean isMarca() {
        return marca;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }

    public void marcar (){
        this.marca = true;
    }

    public void desmmarcar (){
        this.marca = false;
    }

    public ArrayList<Nodo> getArcos() {

        return arcos;
    }

    public void setArcos(Nodo nodo) {

        this.arcos.add(nodo);
    }

    public void setArcos(ArrayList<Nodo> arcos) {
        this.arcos = arcos;
    }

    public boolean isZonaSegura() {
        return zonaSegura;
    }

    public void marcarZonaSegura() {
        this.zonaSegura = true;
    }
}