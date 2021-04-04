package org.century.pooabstract.form;

import org.century.pooabstract.form.elementos.*;
import org.century.pooabstract.form.elementos.select.Opcion;
import org.century.pooabstract.form.validador.*;

import java.util.*;

public class EjemploForm {
    public static void main(String[] args) {

        //Instanciacion de los input con los atributos de [name, type]
        InputForm username = new InputForm("username"); //Tipoe=text -> por defecto
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("claveSecreta", "password");
        password.addValidador(new RequeridoValidador()).addValidador(new LargoValidador(6,12));


        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador()).addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        //Instanciacion del textarea con los atributos de [name,rows,columns]
        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        //Instanciacion del select con el atributo de [name] con sus items(Opcion)
        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        //Instanciacion de los itesm(Opcion) del SELECTFORM con atributos de[value,name,selected]
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpciones(java)
                .addOpciones(new Opcion("2", "Python"))
                .addOpciones(new Opcion("3", "JavaScript"))
                .addOpciones(new Opcion("4", "TypeScript").setSelected())
                .addOpciones(new Opcion("5", "PHP"));

        //Agregando el atributo [value] de cada input
        username.setValor("");
        password.setValor("1234");
        email.setValor("");
        edad.setValor("34");

        experiencia.setValor("... mas de 10 años de expereriencia ...");
        //Agregando al atributo [selected] del items(Opcion)
        //java.setSelected(true);

        //Ejemplo de clase anonima , solo se puede usar una ves
        ElementosForm saludar = new ElementosForm() {
            @Override
            public String dibujarHtml() {
                return "<input disable name='"+this.nombre+"'" +
                        " value=\""+this.valor+"\">";
            }
        };
        saludar.setValor("Hola que tal este campo esta desabilidado");

        // *** MOSTRAR LOS VALORES ***
        List<ElementosForm> elementosFormList =
                Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        /*
            for (ElementosForm e : elementosFormList) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
         */

        elementosFormList.forEach(e ->{
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        //IMPLEMENTACION DE LA CLASE ASBTRACTA VALIDADOR
        elementosFormList.forEach(e ->{
            if(!e.esValido()){
                /*
                    Cuando se tiene parametro en el lambda  ( err -> System.out.println(err))
                    y ese valor se pasa por argumento en algun metodo o funcion se puede hacer un atajo
                    en donde se indique la accion ademas de (::) y JAVA ya sabe que ese parametro
                    va como argumento dentro del metodo que se ve o se especifica

                    SE LE CONOCE COMO = 'Metodo de Referencia o Referenciado'

                    e.getErrores().forEach(System.out::println);

                 */
                e.getErrores().forEach(System.out::println);
            }
        });


    }
}
