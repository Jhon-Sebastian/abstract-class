package org.century.pooabstract.form.elementos;

public class InputForm extends ElementosForm{

    /*
         Las clases abstracta siempre se tiene que heredar ya que ese es el objetivo de
         las clases abstractas(SER PADRE), aquellas que la hereden tiene dos opciones
         tambien ser abstractas para evitar error, o sobreescribir los metodos abstractas
         que tenga el padre, ya que el objetivo de una clase abstracta es ser heredada
         y si tiene metodos tambien tiene que ser heredados obligatioriamente

         Ademas de cada clase que (implementa=interfaz-abstract/sobreescrite=extends)
         un metodo abstracto es diferente al de implementacion de otra clase

         ** LAS CLASES ABSTRACTAS SE USANDO CUANDO:
            Necesimas una clase padre general la cual tenga una implementacion distinta
            para que hija -> EJ: Los Mamiferos, es una clase padre y puede tener metodos
            como ruido(gritar), movimiento etc -> estos no son absolutos para todos
            algunos mamiferos no hacen ruidao como gritar , si no gruñen , otros no
            les gusta ir despascio en su movimiento o ir rapido
         **
     */

    private String tipo = "text";

    public InputForm(String nombre) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String dibujarHtml() {
        return "<input type=\"" + this.tipo
                +"\" name=\"" + this.nombre
                +"\" value=\"" + this.valor   +"\">";
    }

}
