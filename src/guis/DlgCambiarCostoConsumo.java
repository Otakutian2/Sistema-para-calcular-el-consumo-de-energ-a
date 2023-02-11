package guis;

import java.awt.BorderLayout;


import clases.Paises;
import Arreglos.ArregloPaises;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class DlgCambiarCostoConsumo extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtCostoConsumo;
	private JButton btnCambiar;
	
	ArregloPaises ap = new ArregloPaises();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCambiarCostoConsumo dialog = new DlgCambiarCostoConsumo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCambiarCostoConsumo() {
		setTitle("Editar Costo de Consumo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCambiarCostoConsumo.class.getResource("/img/costos.png")));
		setResizable(false);
		setBounds(100, 100, 584, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Cambiar costo de consumo:");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 168, 28);
		contentPanel.add(lblNewLabel);
		
		txtCostoConsumo = new JTextField();
		txtCostoConsumo.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		txtCostoConsumo.setBackground(new Color(224, 255, 255));
		txtCostoConsumo.addKeyListener(this);
		txtCostoConsumo.setBounds(188, 32, 147, 20);
		contentPanel.add(txtCostoConsumo);
		txtCostoConsumo.setColumns(10);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnCambiar.setBackground(new Color(189, 183, 107));
		btnCambiar.addActionListener(this);
		btnCambiar.setBounds(367, 28, 175, 28);
		contentPanel.add(btnCambiar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCambiar) {
			actionPerformedBtnCambiar(e);
		}
	}
	protected void actionPerformedBtnCambiar(ActionEvent e) {
		
		/*mensaje1("Ingresar numeros mayores a 0", "Intentelo de nuevo");
		return;*/
		
		double costo;
		
		try {
			costo = getCostoConsumo();
			if (costo <= 0) {
				mensaje1("Ingresar numeros mayores a 0", "Intentelo de nuevo");
				return;	
			}
		} catch (NumberFormatException e2) {
			txtCostoConsumo.setText("");
			mensaje1("Ingrese los datos", "Intentelo de nuevo");
			txtCostoConsumo.requestFocus();
			return;
		}
		
		switch (FrmLogin.Pais) {
		case 0:
			if (FrmLogin.Tipo == 0){
				Paises x = ap.buscar("Perú");
				x.setKloWattsNegocio(costo);
				ap.actualizarArchivo();
				mensaje("Kilo Watts para Empresa ha sido modificado en Perú ", "Cambio aplicado", x.getKloWattsNegocio());
				
			}else {
				Paises x = ap.buscar("Perú");
				x.setKloWattsHogar(costo);
				ap.actualizarArchivo();

				mensaje("Kilo Watts para Hogar ha sido modificado en Perú ", "Cambio aplicado", x.getKloWattsHogar());
			}
			break;
		case 1:
			if (FrmLogin.Tipo == 0){
				Paises x = ap.buscar("Argentina");
				x.setKloWattsNegocio(costo);
				ap.actualizarArchivo();

				mensaje("Kilo Watts para Empresa ha sido modificado en Argentina ", "Cambio aplicado", x.getKloWattsNegocio());
			}else {
				Paises x = ap.buscar("Argentina");
				x.setKloWattsHogar(costo);
				ap.actualizarArchivo();

				mensaje("Kilo Watts para Hogar ha sido modificado en Argentina ", "Cambio aplicado", x.getKloWattsHogar());
			}
			break;
		default:
			if (FrmLogin.Tipo == 0){
				Paises x = ap.buscar("Colombia");
				x.setKloWattsNegocio(costo);
				ap.actualizarArchivo();

				mensaje("Kilo Watts para Empresa ha sido modificado en Colombia ", "Cambio aplicado", x.getKloWattsNegocio());
			}else {
				Paises x = ap.buscar("Colombia");
				x.setKloWattsHogar(costo);
				ap.actualizarArchivo();

				mensaje("Kilo Watts para Hogar ha sido modificado en Colombia ", "Cambio aplicado", x.getKloWattsHogar());
			}
		}
	}
	
	void mensaje(String mensaje, String titulo, double valor){
        JOptionPane.showMessageDialog(this, mensaje + ""  + valor, titulo,JOptionPane.INFORMATION_MESSAGE);
    }
	
	void mensaje1(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje + "" , titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	private double getCostoConsumo() {
		return Double.parseDouble(txtCostoConsumo.getText());
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCostoConsumo) {
			keyTypedTxtCostoConsumo(e);
		}
	}
	protected void keyTypedTxtCostoConsumo(KeyEvent e) {
		
	    bloquearLetras(e);
	}
	
	void bloquearLetras(KeyEvent xarg0) {
        char letra = xarg0.getKeyChar();
        if(Character.isLetter(letra)) {
            getToolkit().beep();
            xarg0.consume();
            JOptionPane.showMessageDialog(this, "Ingrese solo numeros");
            }
    }
	
}
