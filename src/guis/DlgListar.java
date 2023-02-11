package guis;

import java.awt.BorderLayout;
import Arreglos.arregloElectrodomestico;
import clases.Electrodomesticos;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class DlgListar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JComboBox cboModelo;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	arregloElectrodomestico ae = new arregloElectrodomestico();
	Electrodomesticos x;
	private JLabel iblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListar dialog = new DlgListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListar() {
		setTitle("Listado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgListar.class.getResource("/img/lista-de-verificacion.png")));
		setResizable(false);
		setBounds(100, 100, 698, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Electrodom\u00E9sticos:");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 29, 179, 17);
		contentPanel.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.setBackground(new Color(189, 183, 107));
		cboModelo.setFont(new Font("Sitka Text", Font.BOLD, 16));
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Computadora", "Foco ahorrador", "Cocina", "TV", "Terma", "Equipo de video", "Equipo de sonido", "Foco incandecente", "Foco led", "Hervidor", "Licuadora", "Aspiradora", "Microondas", "Olla arrocera", "Plancha", "Celular", "Refrigeradora", "Secador de cabello", "Ventilador", "Calentador", "Ducha Electrica", "Aire Acondicionado", "Lavadora"}));
		cboModelo.setBounds(20, 70, 179, 34);
		contentPanel.add(cboModelo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 26, 429, 90);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setBackground(new Color(240, 255, 240));
		scrollPane.setViewportView(txtS);
		txtS.setText("");
		
		iblImagen = new JLabel("");
		iblImagen.setBounds(381, 149, 160, 132);
		contentPanel.add(iblImagen);
		String nombre = getItemNameCbo();
		
		//Listado
		txtS.setText("");
		x = ae.buscar(nombre);
		txtS.append("");
		txtS.append("------------------------------------------------------------------------------------------------------" + "\n");
		txtS.append("	Consumo		: " + x.getKwhElectrodomestico() + "\n");
		txtS.append("	Tiempo de uso		: " + x.gethUso() + " minutos" + "\n");
		txtS.append("	Cantidad		: " + x.getCantidad() + "\n");
		txtS.append("------------------------------------------------------------------------------------------------------");
		imagen(x.getImg());

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			actionPerformedComboBox(arg0);
		}
	}
	protected void actionPerformedComboBox(ActionEvent arg0) {
		String nombre = getItemNameCbo();
		
		//Listado
		txtS.setText("");
		x = ae.buscar(nombre);
		txtS.append("");
		txtS.append("------------------------------------------------------------------------------------------------------" + "\n");
		txtS.append("	Consumo		: " + x.getKwhElectrodomestico() + "\n");
		txtS.append("	Tiempo de uso		: " + x.gethUso() + " minutos" + "\n");
		txtS.append("	Cantidad		: " + x.getCantidad() + "\n");
		txtS.append("------------------------------------------------------------------------------------------------------");
		imagen(x.getImg());
		
	}
	// Llamar nombre
		private String getItemNameCbo() {
			return (String) cboModelo.getSelectedItem();
		}
		public void imagen(String ubicacion) {
			ImageIcon imagen = new ImageIcon(getClass().getResource(ubicacion));
			ImageIcon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(iblImagen.getWidth(), iblImagen.getHeight(), Image.SCALE_DEFAULT));
			iblImagen.setIcon(icono);

		}
}
