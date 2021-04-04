package org.century.pooabstract.form.validador;

public class NoNuloValidador extends Validador{

    protected String mensaje = "El campo %s no puede ser Nulo";
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
        return (valor != null);
    }
}
