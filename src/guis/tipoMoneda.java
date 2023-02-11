package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class tipoMoneda extends JDialog implements ActionListener {
	private JTextField txtMoneda;
	private JButton btnConvertir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			tipoMoneda dialog = new tipoMoneda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public tipoMoneda() {
		setTitle("Tipo de Moneda");
		getContentPane().setBackground(new Color(224, 255, 255));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(tipoMoneda.class.getResource("/img/tipo-de-cambio.png")));
		setBounds(100, 100, 545, 172);
		getContentPane().setLayout(null);
		
		JLabel lblMoneda = new JLabel("Moneda :");
		lblMoneda.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblMoneda.setBounds(23, 36, 62, 17);
		getContentPane().add(lblMoneda);
		
		txtMoneda = new JTextField();
		txtMoneda.setBackground(new Color(224, 255, 255));
		txtMoneda.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		txtMoneda.setBounds(95, 34, 86, 20);
		getContentPane().add(txtMoneda);
		txtMoneda.setColumns(10);
		
		JComboBox cboMoneda = new JComboBox();
		cboMoneda.setBackground(new Color(189, 183, 107));
		cboMoneda.setFont(new Font("Sitka Text", Font.BOLD, 16));
		cboMoneda.setModel(new DefaultComboBoxModel(new String[] {"Sol", "Dolar"}));
		cboMoneda.setBounds(205, 23, 92, 46);
		getContentPane().add(cboMoneda);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBackground(new Color(189, 183, 107));
		btnConvertir.addActionListener(this);
		btnConvertir.setBounds(388, 11, 127, 29);
		getContentPane().add(btnConvertir);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(189, 183, 107));
		btnBorrar.setBounds(388, 51, 127, 29);
		getContentPane().add(btnBorrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConvertir) {
			actionPerformedBtnConvertir(e);
		}
	}
	protected void actionPerformedBtnConvertir(ActionEvent e) {
	}
}
