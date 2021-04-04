package org.century.pooabstract.form.validador;

public class NumeroValidador extends Validador{

    protected String mensaje = "El campo %s debe ser un numero";

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
        try{
            Integer.parseInt(valor);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
