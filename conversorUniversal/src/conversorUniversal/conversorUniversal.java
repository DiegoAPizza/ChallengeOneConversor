package conversorUniversal;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Iterator;
	

public class conversorUniversal  {

	public static void main(String[] args) throws Exception{
		
		Object[] opciones={"Convertidor de Divisas","Convertidor de Temperatura","Convertidor de Tiempo(min,hs,disas)","Convertidor de Bytes","Convertidor de Longitudes","Salir"};
		String opcionSeleccionada = (String) JOptionPane.showInputDialog(
	            null,
	            "¿Qué operación desea realizar?",
	            "Conversor Universal",
	            JOptionPane.PLAIN_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	        );
			int posicion=0;
				for (int i = 0; i < opciones.length; i++) {
						if (opciones[i].equals(opcionSeleccionada)) {
							posicion = i;
							break;
						}
					}
	        do {
	        	 
	        	
	            // Procesar la elección del usuario
	            switch (posicion) {
	                case 0:
	                    // Lógica para Convertidor de Divisas
	                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Divisas.");
	                    boolean continuar=true;
	                    DecimalFormat formatDiv=new DecimalFormat("#.##");
	                    convertidor_de_monedas(continuar,formatDiv);
	                    break;
	                case 1:
	                    // Lógica para Convertidor de Temperatura
	                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Temperatura.");
	                    break;
	                case 2:
	                    // Lógica para Convertidor de Tiempo
	                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Tiempo (min, hs, días).");
	                    break;
	                case 3:
	                    // Lógica para Convertidor de Bytes
	                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Bytes.");
	                    break;
	                case 4:
	                    // Lógica para Convertidor de Longitudes
	                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Longitudes.");
	                    break;
	                case 5:
	                    // Salir del menú
	                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
	                    break;
	                default:
	                    // Opción inválida
	                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, elige una opción válida.");
	                    break;
	            }
	        } while (posicion != 5); // Continuar el menú hasta que el usuario seleccione "Salir" (opción 5)
	    }

	public static void convertidor_de_monedas(boolean continuar, DecimalFormat formatDiv) {
		while(continuar) {
			String[] divisasDisponibles= {"ARG a USD","ARG a EUR","ARG a JPY","ARG a GBP","ARG a KRW","ARG a BTC"};
			String divisa_a_Cambiar=(String) JOptionPane.showInputDialog(null,"Seleccione  una Opcion","Conversor de Divisas",JOptionPane.QUESTION_MESSAGE,null,divisasDisponibles,divisasDisponibles[0]);
			String cantidad_De_Monedas=JOptionPane.showInputDialog(null,"Ingrese Cantidad que desee cambiar de Pesos Arg");
			double moneda=0.00;
			try {
				moneda=Double.parseDouble(cantidad_De_Monedas);
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(null,"Valor No valido para esta Operacion");
			}
			if(divisa_a_Cambiar.equals("ARG a USD")) {
				double dolar=moneda/550;
				JOptionPane.showMessageDialog(null, moneda+"ARG a USD son: "+formatDiv.format(dolar)+" Dolares");
			}
			
			else if(divisa_a_Cambiar.equals("ARG a EUR")) {
				double euro=moneda/299.74;
				JOptionPane.showMessageDialog(null, moneda+"ARG a EUR son: "+formatDiv.format(euro)+" Euros");
			}
			
			else if(divisa_a_Cambiar.equals("ARG a JPY")) {
				double yen=moneda/1.92;
				JOptionPane.showMessageDialog(null, moneda+"ARG a JPY son: "+formatDiv.format(yen)+" Yen");
			}
			
			else if(divisa_a_Cambiar.equals("ARG a GBP")) {
				double libra=moneda/349.69;
				JOptionPane.showMessageDialog(null, moneda+"ARG a GBP son: "+formatDiv.format(libra)+" Libra Estarlina");
			}
			
			else if(divisa_a_Cambiar.equals("ARG a KRW")) {
				double won=moneda/0.21;
				JOptionPane.showMessageDialog(null, moneda+"ARG a KRW son: "+formatDiv.format(won)+" Won");
			}
			
			
		}
		
	}
	
	
	}
	
	
	
