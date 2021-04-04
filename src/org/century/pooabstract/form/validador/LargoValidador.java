package org.century.pooabstract.form.validador;

import org.century.pooabstract.form.validador.mensaje.MensajeFormateado;

public class LargoValidador extends Validador implements MensajeFormateado {

    protected String mensaje = "El campo %s debe tener entre %d caracteres y maximo %d caracteres";
    private int min;
    private int max = Integer.MAX_VALUE;

    public LargoValidador(){

    }
    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return this.mensaje;
    }

    @Override
    public boolean isValid(String valor) {
        //String.formart('String a utilizar',Valor que reemplazara '%d');
        //this.mensaje = String.format(this.mensaje,this.min,this.max);
        //Ya que lo que valida es el largo, no si es nulo
        if(valor == null){
            return true;
        }
        int largo = valor.length();
        return (largo >= this.min && largo <= this.max);
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String getMensajeFormateado(String campo){
        return String.format(this.mensaje,campo,this.min,this.max);
    }
}
