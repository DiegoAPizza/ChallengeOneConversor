package conversorUniversal;
import javax.swing.*;
import java.text.DecimalFormat;
	

public class conversorUniversal  {

	public static void main(String[] args) throws Exception{
		
		Object[] opciones={"Convertidor de Divisas","Convertidor de Temperatura","Convertidor de Tiempo(min,hs,disas)","Convertidor de Bytes","Convertidor de Longitudes","Salir"};
		
		 int eleccion;
	        do {
	            eleccion = JOptionPane.showOptionDialog(
	                null,
	                "¿Qué operación desea realizar?",
	                "Conversor Universal",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE,
	                null,
	                opciones,
	                opciones[0]
	            );

	            // Procesar la elección del usuario
	            switch (eleccion) {
	                case 0:
	                    // Lógica para Convertidor de Divisas
	                    JOptionPane.showMessageDialog(null, "Has seleccionado Convertidor de Divisas.");
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
	        } while (eleccion != 5); // Continuar el menú hasta que el usuario seleccione "Salir" (opción 5)
	    }
	
	
	}
	
	
	
