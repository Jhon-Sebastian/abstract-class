package org.century.pooabstract.form.validador;

public abstract class Validador{

    protected String mensaje;

    public abstract  void setMensaje(String mensaje);

    public abstract String getMensaje();

    public abstract boolean isValid(String valor);



}
