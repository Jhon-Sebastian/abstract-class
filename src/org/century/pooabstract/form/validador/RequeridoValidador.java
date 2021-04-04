package org.century.pooabstract.form.validador;

public class RequeridoValidador extends Validador{

    protected String mensaje = "El campo %s es requerido";

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
        return (valor != null && valor.length() > 0);
    }
}
