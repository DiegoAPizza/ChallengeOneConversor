package conversorUniversal;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Iterator;

public class conversorUniversal {

    public static void main(String[] args) throws Exception {

        Object[] opciones = { "Convertidor de Divisas", "Convertidor de Temperatura",
                "Convertidor de Tiempo(Seg, Min, Hs, Dias)", "Convertidor de Longitudes", "Salir" };
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
                    
                    continuar = convertidor_de_Temperaturas(formatDiv);
                    break;
                case 2:
                    // Lógica para Convertidor de Tiempo
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Tiempo (min, hs, días).");
                    continuar = convertidor_de_Tiempo(formatDiv);
                    break;
    
                case 3:
                    // Lógica para Convertidor de Longitudes
                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Longitudes.");
                    continuar = convertidor_de_medidas(formatDiv);
                    break;
                case 4:
                    // Salir del menú
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    continuar=false;
                    break;
                default:
                    // Opción inválida
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, elige una opción válida.");
                    break;
            }
        } while (continuar&&posicion != 4); // Continuar el menú hasta que el usuario seleccione "Salir" (opción 5)
    }

    public static boolean convertidor_de_Tiempo(DecimalFormat formatDiv) {
		
    	String[] tiempoDisponible= {"Hora a Minutos","Hora a Segundos","Hora a Dias","Segundos a Hora","Dias a Horas","Minutos a Horas","Salir"};
    	Object tiempo_a_Cambiar=(String) JOptionPane.showInputDialog(null, "Seleccione  una Opcion",
                "Conversor de Tiempo(Seg, Mins, Hs, Dias)", JOptionPane.QUESTION_MESSAGE, null, tiempoDisponible,
                tiempoDisponible[0]);;
		if(tiempo_a_Cambiar==null) {
        	return false;
        }
		if(tiempo_a_Cambiar.equals("Salir")) {
        	return false;
        }
		else {
			String tiempoAelegir = JOptionPane.showInputDialog(null,
                    "Ingrese Cantidad que desee cambiar "+ tiempo_a_Cambiar);
            double hora = 0.00;
            if (tiempoAelegir == null) {
                // Si el usuario hace clic en "Cancelar" o cierra el cuadro de diálogo, muestra un mensaje y repite el bucle.
                JOptionPane.showMessageDialog(null, "Operación cancelada. Por favor, ingrese una cantidad válida.");
                return true;
            }
            try {
            	hora = Double.parseDouble(tiempoAelegir);
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Valor No valido para esta Operacion");
            }
            if(tiempo_a_Cambiar.equals("Hora a Minutos")) {
            	double minutos=hora*60;
            	JOptionPane.showMessageDialog(null, hora + "Hora a Minutos son: " + formatDiv.format(minutos) + " mins"); 
            }
            else if(tiempo_a_Cambiar.equals("Hora a Segundos")) {
            	double seg=hora*3600;
            	JOptionPane.showMessageDialog(null, hora + "Hora a Segundos son: " + formatDiv.format(seg) + " seg"); 
            }
            else if(tiempo_a_Cambiar.equals("Hora a Dias")) {
            	double dias=hora*24;
            	JOptionPane.showMessageDialog(null, hora + "Horas a Dias son: " + formatDiv.format(dias) + " dia"); 
            }
            else if(tiempo_a_Cambiar.equals("Segundos a Horas")) {
            	double seg=hora/3600;
            	JOptionPane.showMessageDialog(null, hora + "Seg a Hora son: " + formatDiv.format(seg) + " hs"); 
            }
            
            else if(tiempo_a_Cambiar.equals("Minutos a Horas")) {
            	double min=hora/60;
            	JOptionPane.showMessageDialog(null, hora + "Minutos a Hora son: " + formatDiv.format(min) + " hs"); 
            }
            
            else if(tiempo_a_Cambiar.equals("Dias a Horas")) {
            	double dias=hora/24;
            	JOptionPane.showMessageDialog(null, hora + "Dias a Horas son: " + formatDiv.format(dias) + " hs"); 
            }
            
            
		return true;
		}
	}

	public static boolean convertidor_de_Temperaturas(DecimalFormat formatDiv) {
    	String[] temperaturasDisponibles= {"Celcius(c°) a Fahrenheit (°F)","Celcius(c°) a Kelvin(K)","Kelvin(K) a Celcius(c°)","Fahrenheit (°F) a Celcius(c°)","Salir"};
    	Object temperatura_a_Cambiar=(String) JOptionPane.showInputDialog(null, "Seleccione  una Opcion",
                "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE, null, temperaturasDisponibles,
                temperaturasDisponibles[0]);;
		if(temperatura_a_Cambiar==null) {
        	return false;
        }
		if(temperatura_a_Cambiar.equals("Salir")) {
        	return false;
        }
		else {
			String temperatura = JOptionPane.showInputDialog(null,
                    "Ingrese Cantidad que desee cambiar "+ temperatura_a_Cambiar);
            double celsius = 0.00;
            if (temperatura == null) {
                // Si el usuario hace clic en "Cancelar" o cierra el cuadro de diálogo, muestra un mensaje y repite el bucle.
                JOptionPane.showMessageDialog(null, "Operación cancelada. Por favor, ingrese una cantidad válida.");
                return true;
            }
            try {
            	celsius = Double.parseDouble(temperatura);
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Valor No valido para esta Operacion");
            }
            if (temperatura.equals("Celcius(c°) a Fahrenheit (°F)")) {
                double fahrenheit = (celsius * 9/5) + 32;
                JOptionPane.showMessageDialog(null, celsius + "Celcius(c°) a Fahrenheit (°F) son: " + formatDiv.format(fahrenheit) + " °F"); 
            }
            else if(temperatura.equals("Celcius(c°) a Kelvin(K)")) {
            	double kelvin=celsius+273.15;
            	JOptionPane.showMessageDialog(null, celsius + "Celcius(c°) a a Kelvin(K) son: " + formatDiv.format(kelvin) + " K");
            }
            
            else if(temperatura.equals("Fahrenheit (°F) a Celcius(c°)")) {
            	double fahrenheit = (celsius / (9/5)) - 32;
            	JOptionPane.showMessageDialog(null, celsius + "Fahrenheit(°F) a Celcius(c°) son: " + formatDiv.format(fahrenheit) + " °c");
            }
            
            else if(temperatura.equals("Kelvin(K) a Celcius(c°)")) {
            	double kelvin=celsius-273.15;
            	JOptionPane.showMessageDialog(null, celsius + "Kelvin(K) a Celcius(c°) son: " + formatDiv.format(kelvin) + " °c");
            }
            
			return true;
		}
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
    
    public static boolean convertidor_de_medidas(DecimalFormat formatDiv) {
    	formatDiv=new DecimalFormat("#.###");
    	String[] medidasDisponibles= {"Metros a Kilometros(Km)","Metros a Centimetros(Cm)","Metros a MiliMetros(mm)","Metros a Millas(mile)","Metros a Pulgadas (inch)","Kilometros(Km) a Metros","Centimetros(Cm) a Metros","MiliMetros(mm) a Metros","Millas a Metros","Pulgadas (inch) a Metros","Salir"};
		String medida_a_Cambiar = (String) JOptionPane.showInputDialog(null, "Seleccione  una Opcion",
                 "Conversor de Longitudes/Medidas", JOptionPane.QUESTION_MESSAGE, null, medidasDisponibles,
                 medidasDisponibles[0]);
         if(medida_a_Cambiar==null) {
         	return false;
         }
         if(medida_a_Cambiar.equals("Salir")) {
         	return false;
         }
         else {
        	 String cantidad_De_Medida = JOptionPane.showInputDialog(null,
                     "Ingrese Cantidad que desee cambiar "+ medida_a_Cambiar);
             double medida = 0.00;
             if (cantidad_De_Medida == null) {
                 // Si el usuario hace clic en "Cancelar" o cierra el cuadro de diálogo, muestra un mensaje y repite el bucle.
                 JOptionPane.showMessageDialog(null, "Operación cancelada. Por favor, ingrese una cantidad válida.");
                 return true;
             }
             
             try {
            	 medida = Double.parseDouble(cantidad_De_Medida);
             } catch (NumberFormatException error) {
                 JOptionPane.showMessageDialog(null, "Valor No valido para esta Operacion");
             }
             
             if (medida_a_Cambiar.equals("Metros a Pulgadas (inch)")) {
                 double pulgadas = medida / 39.37;
                 JOptionPane.showMessageDialog(null, medida + "Metros a Pulgadas son: " + formatDiv.format(pulgadas) + " inch"); 
             }
             else if(medida_a_Cambiar.equals("Metros a Millas(mile)")){
            	 double mile=medida/0.000621371;
            	 JOptionPane.showMessageDialog(null, medida + "Metros a Millas son: " + formatDiv.format(mile) + " mile"); 
             }
             
             else if(medida_a_Cambiar.equals("Metros a MiliMetros(mm)")){
            	 double mm=medida/0.001;
            	 JOptionPane.showMessageDialog(null, medida + "Metros a Millas son: " + formatDiv.format(mm) + " mm"); 
             }
             
             else if(medida_a_Cambiar.equals("Metros a Centimetros(Cm)")){
            	 double cm=medida/0.01;
            	 JOptionPane.showMessageDialog(null, medida + "Metros a Centimetros son: " + formatDiv.format(cm) + " Cm"); 
             }
             else if(medida_a_Cambiar.equals("Metros a Kilometros(Km)")){
            	 double km=medida/1000;
            	 JOptionPane.showMessageDialog(null, medida + "Metros a Centimetros son: " + formatDiv.format(km) + " Km"); 
             }
             else if(medida_a_Cambiar.equals("Kilometros(Km) a Metros")){
            	 double km=medida/1000;
            	 JOptionPane.showMessageDialog(null, medida + "Kilometros a Metros son: " + formatDiv.format(km) + " M"); 
             }
             else if(medida_a_Cambiar.equals("Centimetros(Cm) a Metros")){
            	 double cm=medida*0.01;
            	 JOptionPane.showMessageDialog(null, medida + "Centimetros(Cm) a Metros: " + formatDiv.format(cm) + " M"); 
             }
             else if(medida_a_Cambiar.equals("MiliMetros a Metros")){
            	 double mm=medida*0.001;
            	 JOptionPane.showMessageDialog(null, medida + "MiliMetros a Metros son: " + formatDiv.format(mm) + " M"); 
             }
             else if(medida_a_Cambiar.equals("Millas a Metros")){
            	 double mile=medida*0.000621371;
            	 JOptionPane.showMessageDialog(null, medida + "Millas a Metros son: " + formatDiv.format(mile) + " M"); 
             }
             else if(medida_a_Cambiar.equals("Pulgadas  a Metros")){
            	 double pulgadas = medida * 39.37;
            	 JOptionPane.showMessageDialog(null, medida + "Pulgadas  a Metros son: " + formatDiv.format(pulgadas) + " M"); 
             }
        	 return true;
         }
    }
    
    

    

}
