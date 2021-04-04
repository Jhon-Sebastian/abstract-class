package org.century.pooabstract.form.elementos;

import org.century.pooabstract.form.validador.LargoValidador;
import org.century.pooabstract.form.validador.Validador;
import org.century.pooabstract.form.validador.mensaje.MensajeFormateado;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementosForm {

    protected String valor;
    protected String nombre;
    private List<Validador> validadors;
    private List<String> errores;

    public ElementosForm() {
        validadors = new ArrayList<>();
        errores = new ArrayList<>();
    }

    public ElementosForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    //Agregar Validadores
    public ElementosForm addValidador(Validador validador){
        this.validadors.add(validador);
        return this;
    }

    //Ver los mensajes de errores
    public List<String> getErrores() {
        return errores;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido(){
        for (Validador v: this.validadors) {
            if(!v.isValid(this.valor)) {
                if (v instanceof MensajeFormateado) {
                    this.errores.add( ((MensajeFormateado) v).getMensajeFormateado(nombre));
                } else {
                    this.errores.add(String.format(v.getMensaje(), this.nombre));
                }
            }

        }
        return (this.errores.isEmpty()); // this.errores.size() == 0
    }

    //Metodos abstractos van de ultimas
    abstract public String dibujarHtml();

}
