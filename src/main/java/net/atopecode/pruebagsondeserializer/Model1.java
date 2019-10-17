package net.atopecode.pruebagsondeserializer;

public class Model1 extends ModelBase {

    private String campo1;

    public Model1(){

    }

    public Model1(String nombre, String apellidos, String campo1) {
        super(nombre, apellidos);
        this.campo1 = campo1;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }
}
