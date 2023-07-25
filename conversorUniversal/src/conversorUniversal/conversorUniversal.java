package conversorUniversal;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Iterator;

public class conversorUniversal {

    public static void main(String[] args) throws Exception {

        Object[] opciones = { "Convertidor de Divisas", "Convertidor de Temperatura",
                "Convertidor de Tiempo(min,hs,disas)", "Convertidor de Bytes", "Convertidor de Longitudes", "Salir" };
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "¿Qué operación desea realizar?",
                "Conversor Universal",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);
        int posicion = 0;
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].equals(opcionSeleccionada)) {
                posicion = i;
                break;
            }
        }
        boolean continuar = true;
        DecimalFormat formatDiv = new DecimalFormat("#.##");
        do {

            // Procesar la elección del usuario
            switch (posicion) {
                case 0:
                    // Lógica para Convertidor de Divisas
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Divisas.");
     
                    continuar=convertidor_de_monedas( formatDiv);
   
                    break;
                case 1:
                    // Lógica para Convertidor de Temperatura
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Temperatura.");
                    
                    continuar = false;
                    break;
                case 2:
                    // Lógica para Convertidor de Tiempo
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Tiempo (min, hs, días).");
                    continuar = false;
                    break;
                case 3:
                    // Lógica para Convertidor de Bytes
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Bytes.");
                    continuar = false;
                    break;
                case 4:
                    // Lógica para Convertidor de Longitudes
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Longitudes.");
                    continuar = false;
                    break;
                case 5:
                    // Salir del menú
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    continuar=false;
                    break;
                default:
                    // Opción inválida
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, elige una opción válida.");
                    break;
            }
        } while (continuar&&posicion != 5); // Continuar el menú hasta que el usuario seleccione "Salir" (opción 5)
    }

    public static boolean convertidor_de_monedas( DecimalFormat formatDiv) {
       
            String[] divisasDisponibles = { "ARG a USD", "ARG a EUR", "ARG a JPY", "ARG a GBP", "ARG a KRW",
                    "USD a ARG","EUR a ARG","JPY a ARG","GBP a ARG","KRW a ARG","Salir" };
            String divisa_a_Cambiar = (String) JOptionPane.showInputDialog(null, "Seleccione  una Opcion",
                    "Conversor de Divisas", JOptionPane.QUESTION_MESSAGE, null, divisasDisponibles,
                    divisasDisponibles[0]);
            if(divisa_a_Cambiar==null) {
            	return false;
            }
            if(divisa_a_Cambiar.equals("Salir")) {
            	return false;
            }
            else {
            	String cantidad_De_Monedas = JOptionPane.showInputDialog(null,
                        "Ingrese Cantidad que desee cambiar "+ divisa_a_Cambiar);
                double moneda = 0.00;
                if (cantidad_De_Monedas == null) {
                    // Si el usuario hace clic en "Cancelar" o cierra el cuadro de diálogo, muestra un mensaje y repite el bucle.
                    JOptionPane.showMessageDialog(null, "Operación cancelada. Por favor, ingrese una cantidad válida.");
                    return true;
                }
                
                try {
                    moneda = Double.parseDouble(cantidad_De_Monedas);
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Valor No valido para esta Operacion");
                }
                if (divisa_a_Cambiar.equals("ARG a USD")) {
                    double dolar = moneda / 550;
                    JOptionPane.showMessageDialog(null, moneda + "ARG a USD son: " + formatDiv.format(dolar) + " $Dolares"); 
                }

                else if (divisa_a_Cambiar.equals("ARG a EUR")) {
                    double euro = moneda / 600;
                    JOptionPane.showMessageDialog(null, moneda + "ARG a EUR son: " + formatDiv.format(euro) + " €Euros");
                }

                else if (divisa_a_Cambiar.equals("ARG a JPY")) {
                    double yen = moneda / 1.92;
                    JOptionPane.showMessageDialog(null, moneda + "ARG a JPY son: " + formatDiv.format(yen) + " ¥Yenes");
                }

                else if (divisa_a_Cambiar.equals("ARG a GBP")) {
                    double libra = moneda / 349.69;
                    JOptionPane.showMessageDialog(null,
                            moneda + "ARG a GBP son: " + formatDiv.format(libra) + " £Libra Estarlina");
                }

                else if (divisa_a_Cambiar.equals("ARG a KRW")) {
                    double won = moneda / 0.21;
                    JOptionPane.showMessageDialog(null, moneda + "ARG a KRW son: " + formatDiv.format(won) + " ₩Wones");
                }
                else if (divisa_a_Cambiar.equals("KRW a ARG")) {
                    double won = moneda * 0.21;
                    JOptionPane.showMessageDialog(null, moneda + "KRW a ARG son: " + formatDiv.format(won) + " $ARG");
                }
                else if (divisa_a_Cambiar.equals("GBP a ARG")) {
                    double libra = moneda * 349.69;
                    JOptionPane.showMessageDialog(null, moneda + "GBP a ARG son: " + formatDiv.format(libra) + " $ARG");
                }
                else if (divisa_a_Cambiar.equals("JPY a ARG")) {
                    double yen = moneda * 1.92;
                    JOptionPane.showMessageDialog(null, moneda + "JPY a ARG son: " + formatDiv.format(yen) + " $ARG");
                }
                else if (divisa_a_Cambiar.equals("EUR a ARG")) {
                    double euro = moneda * 600;
                    JOptionPane.showMessageDialog(null, moneda + "EUR a ARG son: " + formatDiv.format(euro) + " $ARG");
                }
                else if (divisa_a_Cambiar.equals("ARG a USD")) {
                    double dolar = moneda * 550;
                    JOptionPane.showMessageDialog(null, moneda + "USD a ARG son: " + formatDiv.format(dolar) + " $ARG"); 
                }
                
                return true;
            }
            
    	}


    

}
