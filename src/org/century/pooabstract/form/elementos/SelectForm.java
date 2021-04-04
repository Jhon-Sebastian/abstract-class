package org.century.pooabstract.form.elementos;

import org.century.pooabstract.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementosForm{

    private List<Opcion> opciones;

    public SelectForm(String nombre) {
        super(nombre);
        opciones = new ArrayList<Opcion>();
    }

    public SelectForm(String nombre, List<Opcion> opciones){
        super(nombre);
        this.opciones = opciones;
    }

    //Para que se puedan llamar en forma encadenada EJ:
    // addOpciones(val1).addOpciones(val2)...
    /*
        Para que funcione, tiene que retornar el tipo de la clase
        y ademas return this
     */
    public SelectForm addOpciones(Opcion opcion){
        this.opciones.add(opcion);
        return this;
    }

    @Override
    public String dibujarHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<select name='")
        .append(this.nombre)
        .append("'>");

        for(Opcion opcion : this.opciones){
            sb.append("\n<option value='")
                    .append(opcion.getValor())
                    .append("'");
            if(opcion.isSelected()){
            sb.append(" selected");
            this.valor = opcion.getValor();
            }
            sb.append("> ").append(opcion.getNombre())
                    .append("</option>");
        }
        sb.append("\n</select>");
        return sb.toString();
    }
}
