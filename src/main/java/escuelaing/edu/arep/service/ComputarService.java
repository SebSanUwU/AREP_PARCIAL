package escuelaing.edu.arep.service;

public class ComputarService {
    /**
     * Metodo para el calculo de dos numeros segun la operacion matematica basica.
     * @param operation Cadena que describe que operacion se quiere ejecutar
     * @param num1 Primer numero para operacion.
     * @param num2 Segundo numero para operacion.
     * @return Objeto nulo o valor de la operacion. En caso de ser una operacion o divison de 0 se retorna nulo.
     */
    public Object operation(String operation, float num1, float num2){
        float value;
        switch (operation) {
            case "/" -> {
                if(num2 == 0){
                    return null;
                }
                value = num1 / num2;
            }
            case "*" -> value = num1 * num2;
            case "+" -> value = num1 + num2;
            case "-" -> value = num1 - num2;
            default -> {
                return null;
            }
        }
        return value;
    }

    /**
     * Implementacion del algoritmo de bubble sort
     * @param list lista con los numero a ordenar
     * @return Lista ordenada
     */
    public String[] bubblesort(String[] list){
        return null;
    }
}
