package dni;

import java.io.Serializable;

public class DNI implements Serializable{
    private String dni;//8 digitos + letra
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    public DNI(String dni) throws DNIException {
        //suponemos que un dni ES CORRECTO SI tiene  8 digitos + una letra. Sin guiones. 
        //comprobamos si llega String null
        if (dni == null) {
            throw new DNIException("Dni con valor nulo");
        }
        //comprobamos si la longitud del string no es exactamente 9
        if (dni.length() != 9) {
            throw new DNIException("La longintud de "+ dni +" no es de 9 carateres");
        }

        //comprobamos que último caracter es letra 
        //y la pasamos a mayuscula si no estuviera para simplificar ifs
        char letraDni = dni.charAt(dni.length() - 1);
        letraDni=Character.toUpperCase(letraDni);


        if (!Character.isLetter(letraDni)) {
            throw new DNIException("El ultimo caracter de "+ dni +" no es letra ");
        }

        //comprobamos que los 8 primeros caracteres son números
        String parteNumero = dni.substring(0, dni.length() - 1);
        if (!esNumero(parteNumero)) {
            throw new DNIException("Los 8 primeros caracteres de "+ dni +" no son todos numeros");
        }

        //compruebo el algortimo de la letra que detecta si hay error tanto en letra como en número
        char letraCorrecta = calcularLetra(parteNumero);
        if (letraDni != letraCorrecta) {
            throw new DNIException("El dni  "+ dni +" no cumple algortimo de validacion modulo 23");
        }
        this.dni = dni;
    }

    //algún posible método que podría interesar
    public String getDNI() {
        return this.dni;
    }

    public String getDNISoloNumero() {
        return this.dni.substring(0, this.dni.length() - 1);
    }

    public char getDNISoloLetra() {
        return this.dni.charAt(dni.length() - 1);
    }
    //aunque ahora todos los métodos son públicos las code conventions no obligan a que estén juntos
    //se pueden intercalar con los públicos sin problemas

    private boolean esNumero(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    //con excepciones es menos eficiente
    private boolean esNumero2(String s){
        int numero = 0;
        try {
            numero = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private char calcularLetra(String parteNumero) {
        int numero = Integer.parseInt(parteNumero);
        return LETRAS_DNI.charAt(numero % 23);
    }

}