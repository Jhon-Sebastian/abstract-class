package org.century.pooabstract.form.validador;

public class EmailValidador extends Validador{

    //Caracteres ancla en expresiones regular
    // ^ -> Significa que empieza a validar desde la primera linea
    // $ -> Significa que empieza a validar desde el final
    // () -> Un grupo
    // . -> Indica cualquiera caracter
    // + -> Este caracter se puede repetir n veces
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";

    protected String mensaje = "El campo %s tiene un formato de Email invalido";

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
        //Matches -> se pueda pasar por arg la expresion regular como un String
        return (valor.matches(EMAIL_REGEX));
    }
}
