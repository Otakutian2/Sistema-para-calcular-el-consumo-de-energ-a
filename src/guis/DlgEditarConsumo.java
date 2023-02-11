package guis;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import Arreglos.arregloElectrodomestico;
import clases.Electrodomesticos;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class DlgEditarConsumo extends JDialog implements ActionListener {
	private JTextField txtConsumo;
	private JTextField txtnomElectro;
	private JButton btnAceptar;
	private JComboBox cboTipo;
	
	arregloElectrodomestico a = new arregloElectrodomestico();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgEditarConsumo dialog = new DlgEditarConsumo ();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgEditarConsumo() {
		setTitle("Editar Consumo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgEditarConsumo.class.getResource("/img/consumo-de-energia.png")));
		getContentPane().setBackground(new Color(224, 255, 255));
		setBounds(100, 100, 602, 202);
		getContentPane().setLayout(null);
		
		JLabel lblConsumidor = new JLabel("Electrodomesticos :");
		lblConsumidor.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblConsumidor.setBounds(10, 36, 121, 17);
		getContentPane().add(lblConsumidor);
		
		txtConsumo = new JTextField();
		txtConsumo.setBounds(335, 36, 102, 20);
		getContentPane().add(txtConsumo);
		txtConsumo.setColumns(10);
		
		cboTipo = new JComboBox();
		cboTipo.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		cboTipo.setBackground(new Color(189, 183, 107));
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"kWh", "Watts"}));
		cboTipo.setSelectedIndex(0);
		cboTipo.setBounds(462, 32, 97, 30);
		getContentPane().add(cboTipo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(134, 122, 115, 30);
		getContentPane().add(btnAceptar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtConsumo.setText("");
				txtnomElectro.setText("");
				cboTipo.setSelectedIndex(0);
				
			}
		});
		btnBorrar.setBounds(10, 122, 114, 30);
		getContentPane().add(btnBorrar);
		
		txtnomElectro = new JTextField();
		txtnomElectro.setColumns(10);
		txtnomElectro.setBounds(126, 36, 121, 20);
		getContentPane().add(txtnomElectro);
		
		JLabel lblConsumo = new JLabel("Consumo :");
		lblConsumo.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblConsumo.setBounds(272, 36, 64, 17);
		getContentPane().add(lblConsumo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		String NomElectrodomestico = "";
		double valor = 0, consumo = 0;
		int tipo = 0;
		
		
		NomElectrodomestico = getNombreElec();
		if(NomElectrodomestico.length() > 0){
			try {
				consumo = getConsumo();
				
				if(consumo <= 0){
					error("Ingresar un consumo mayor a 0", "Error");
					txtConsumo.setText("");
					txtConsumo.requestFocus();
					return;	
				}
				tipo = getTipo();
				consumo(tipo, consumo, NomElectrodomestico, valor);
			} catch (Exception e2) {
				error("Ingresar el consumo", "Error");
				txtConsumo.setText("");
				txtConsumo.requestFocus();
				return;
			}
			
			
			
		}else {
			error("Ingrese el nombre de electrodoméstico", "Error");
			return;
		}
		
		
		
		
		
	}
	
	private String getNombreElec() {
		return txtnomElectro.getText().trim();
	}
	
	private void error(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}

	
	private double getConsumo() {
		return Double.parseDouble(txtConsumo.getText());
	}
	
	private int getTipo() {
		return cboTipo.getSelectedIndex();
	}
	
	public void consumo(int tipo, double consumo, String NomElectrodomestico, double valor) {
		
		Electrodomesticos x = a.buscar(NomElectrodomestico);
		if(x == null){
			error("El electrodoméstico ingresado no existe", "Error");
			return;
		}else {
			if(tipo == 0){
				x.setKwhElectrodomestico(consumo);
				a.actualizarArchivo();
				JOptionPane.showMessageDialog(this, "Electrodomestico "+ NomElectrodomestico +"\n" + "Consumo " + x.getKwhElectrodomestico(),"Cambio aplicado",JOptionPane.INFORMATION_MESSAGE);
			}else {
				x.setKwhElectrodomestico((consumo * 1)/1000);
				a.actualizarArchivo();
				JOptionPane.showMessageDialog(this, "Electrodomestico "+ NomElectrodomestico +"\n" + "Consumo " + x.getKwhElectrodomestico(),"Cambio aplicado",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}