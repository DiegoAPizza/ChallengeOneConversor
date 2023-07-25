package conversorUniversal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton conversor = new JButton("Conversor");
		conversor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		conversor.setBounds(20, 9, 100, 23);
		contentPane.add(conversor);
		
		JButton temperatura = new JButton("Temperatura");
		temperatura.setBounds(348, 9, 100, 23);
		contentPane.add(temperatura);
		
		JPanel contenido = new JPanel();
		contenido.setBackground(Color.LIGHT_GRAY);
		contenido.setBounds(20, 43, 428, 273);
		contentPane.add(contenido);
		contenido.revalidate();
		contenido.repaint();
	}
}
