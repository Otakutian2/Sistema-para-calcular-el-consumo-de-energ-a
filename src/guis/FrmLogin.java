package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloPaises;
import Arreglos.arregloElectrodomestico;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class FrmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPaises;
	private JLabel lblEntidad;
	
	public static int Pais;
	public static int Tipo;
	
	private JButton btnIniciar;
	private JComboBox cboEntidad;
	private JComboBox cboPaises;
	
	arregloElectrodomestico ae= new arregloElectrodomestico();
	ArregloPaises ap = new ArregloPaises();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/img3/icons8_customer_32px_1.png")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPaises = new JLabel("PAISES :");
		lblPaises.setFont(new Font("DialogInput", Font.BOLD, 16));
		lblPaises.setForeground(Color.RED);
		lblPaises.setBounds(70, 170, 80, 22);
		contentPane.add(lblPaises);
		
		lblEntidad = new JLabel("ENTIDAD :");
		lblEntidad.setForeground(Color.RED);
		lblEntidad.setFont(new Font("DialogInput", Font.BOLD, 16));
		lblEntidad.setBackground(Color.WHITE);
		lblEntidad.setBounds(70, 339, 90, 22);
		contentPane.add(lblEntidad);
		
		cboPaises = new JComboBox();
		cboPaises.setBackground(new Color(245, 255, 250));
		cboPaises.setFont(new Font("DialogInput", Font.BOLD, 20));
		cboPaises.setForeground(new Color(204, 0, 0));
		cboPaises.setModel(new DefaultComboBoxModel(new String[] {"Per\u00FA", "Argentina", "Colombia"}));
		cboPaises.setBounds(115, 203, 193, 38);
		contentPane.add(cboPaises);
		
		cboEntidad = new JComboBox();
		cboEntidad.setBackground(new Color(245, 255, 250));
		cboEntidad.setForeground(new Color(204, 0, 0));
		cboEntidad.setFont(new Font("DialogInput", Font.BOLD, 20));
		cboEntidad.setModel(new DefaultComboBoxModel(new String[] {"Empresa", "Casa"}));
		cboEntidad.setBounds(115, 372, 193, 38);
		contentPane.add(cboEntidad);
		
		btnIniciar = new JButton("");
		btnIniciar.setIcon(new ImageIcon(FrmLogin.class.getResource("/img3/Enter_OFF.png")));
		btnIniciar.addActionListener(this);
		btnIniciar.setBounds(128, 489, 119, 41);
		contentPane.add(btnIniciar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/img3/icons8_Key_32px.png")));
		lblNewLabel.setBounds(70, 378, 32, 32);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(66, 421, 242, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/img3/icons8_customer_32px_1.png")));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(70, 209, 32, 32);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(66, 252, 242, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img3/icons8_User_96px_2.png")));
		lblNewLabel_2.setBounds(139, 47, 96, 96);
		contentPane.add(lblNewLabel_2);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciar) {
			actionPerformedBtnIniciar(e);
		}
	}
	protected void actionPerformedBtnIniciar(ActionEvent e) {
		
		int pais, entidad;
		pais = getPais();
		entidad = getEntidad();
		
		Pais = pais;
		Tipo = entidad;
		
		
		dispose();
		FrmPrincipal Principal = new FrmPrincipal();
		Principal.setLocationRelativeTo(this);
        Principal.setVisible(true);
	}

	private int getEntidad() {
		return cboEntidad.getSelectedIndex();
	}

	private int getPais() {
		return cboPaises.getSelectedIndex();
	}
}
