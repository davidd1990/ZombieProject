public class Nodo {

    private String value = "";
    private boolean marca = false;
    private int id = 0;

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

}