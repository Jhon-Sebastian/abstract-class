package org.century.pooabstract.form.elementos.select;

public class Opcion {
    //Esta clase represente los valores y el estado de un SelectForm en html
    private String valor;
    private String nombre;
    private boolean selected;

    public Opcion(){

    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return selected;
    }

    public Opcion setSelected(){
        this.selected = true;
        return this;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
