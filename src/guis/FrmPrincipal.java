package guis;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloPaises;
import Arreglos.arregloElectrodomestico;
import clases.Electrodomesticos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Color;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame implements ActionListener {
	

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnConfig;
	private JMenu mnDetalles;
	private JMenu mnAcerca;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsumo;
	private JMenuItem mntmCosto;
	private JMenuItem mntmNewMenuItem;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JCheckBox cbLavadora;
	private JCheckBox cbLavadora1;
	public static int[] objetos = new int[23];
	public static int cantidad = 0;
	private JMenuItem mntmNewMenuItem_2;
	

 	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setTitle("COCOLUZ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img2/bombilla-de-idea.png")));
		setResizable(false);
		
		
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 902);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(245, 255, 250));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setBackground(new Color(245, 255, 250));
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/carpetas.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("");
		mntmSalir.setBackground(new Color(245, 255, 250));
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/puerta-de-salida.png")));
		mntmSalir.setSelectedIcon(null);
		mntmSalir.addActionListener(this);
		
		mntmNewMenuItem_2 = new JMenuItem("");
		mntmNewMenuItem_2.addActionListener(this);
		mntmNewMenuItem_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/acceso.png")));
		mnArchivo.add(mntmNewMenuItem_2);
		mnArchivo.add(mntmSalir);
		
		mnDetalles = new JMenu("Detalles");
		mnDetalles.setBackground(new Color(245, 255, 250));
		mnDetalles.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/detalles.png")));
		menuBar.add(mnDetalles);
		
		mntmNewMenuItem = new JMenuItem("Listar");
		mntmNewMenuItem.setBackground(new Color(245, 255, 250));
		mntmNewMenuItem.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/lista-de-verificacion.png")));
		mntmNewMenuItem.addActionListener(this);
		mnDetalles.add(mntmNewMenuItem);
		
		mnConfig = new JMenu("Configuraci\u00F3n");
		mnConfig.setBackground(new Color(245, 255, 250));
		mnConfig.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/configuracion.png")));
		menuBar.add(mnConfig);
		
		mntmConsumo = new JMenuItem("Consumo");
		mntmConsumo.setBackground(new Color(245, 255, 250));
		mntmConsumo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/consumo-de-energia.png")));
		mntmConsumo.addActionListener(this);
		mnConfig.add(mntmConsumo);
		
		mntmCosto = new JMenuItem("Costo");
		mntmCosto.setBackground(new Color(245, 255, 250));
		mntmCosto.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/costos.png")));
		mntmCosto.addActionListener(this);
		mnConfig.add(mntmCosto);
		
		mnAcerca = new JMenu("Acerca de nosotros");
		mnAcerca.setBackground(new Color(240, 240, 240));
		mnAcerca.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/equipos.png")));
		menuBar.add(mnAcerca);
		
		mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setBackground(new Color(245, 255, 250));
		mntmNewMenuItem_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cola.png")));
		mntmNewMenuItem_1.addActionListener(this);
		mnAcerca.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(192, 109, 593, -5);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/ordenador-de-sobremesa (1).png")));
		lblNewLabel.setBounds(40, 53, 64, 64);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/aire-acondicionado.png")));
		lblNewLabel_2.setBounds(202, 53, 64, 64);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/bombilla.png")));
		lblNewLabel_3.setBounds(673, 53, 64, 64);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/aspiradora.png")));
		lblNewLabel_4.setBounds(360, 53, 64, 64);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/bombilla-de-idea.png")));
		lblNewLabel_5.setBounds(514, 53, 64, 64);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/bulbo.png")));
		lblNewLabel_6.setBounds(202, 630, 64, 64);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/calentador-de-agua.png")));
		lblNewLabel_7.setBounds(202, 485, 64, 64);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/calentador.png")));
		lblNewLabel_8.setBounds(40, 485, 64, 64);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/cocina.png")));
		lblNewLabel_9.setBounds(202, 201, 64, 64);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/equipo-de-sonido.png")));
		lblNewLabel_10.setBounds(514, 630, 64, 64);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/hervidor-electrico.png")));
		lblNewLabel_11.setBounds(40, 201, 64, 64);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/licuadora.png")));
		lblNewLabel_12.setBounds(360, 485, 64, 64);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/microonda.png")));
		lblNewLabel_13.setBounds(360, 201, 64, 64);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/monitor-de-tv.png")));
		lblNewLabel_14.setBounds(514, 201, 64, 64);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/olla-arrocera.png")));
		lblNewLabel_15.setBounds(360, 336, 64, 64);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/planchar.png")));
		lblNewLabel_16.setBounds(360, 630, 64, 64);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/refrigerador.png")));
		lblNewLabel_17.setBounds(514, 485, 64, 64);
		contentPane.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/reproductor-de-dvd.png")));
		lblNewLabel_18.setBounds(673, 336, 64, 64);
		contentPane.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/secador-de-pelo.png")));
		lblNewLabel_19.setBounds(514, 336, 64, 64);
		contentPane.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/telefono-celular.png")));
		lblNewLabel_20.setBounds(40, 336, 64, 64);
		contentPane.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/ventilador.png")));
		lblNewLabel_21.setBounds(202, 336, 64, 64);
		contentPane.add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/water-heater.png")));
		lblNewLabel_22.setBounds(673, 201, 64, 64);
		contentPane.add(lblNewLabel_22);
		
		JCheckBox cbPc = new JCheckBox("Computadora");
		cbPc.setBackground(new Color(245, 255, 250));
		cbPc.setBounds(20, 124, 108, 23);
		contentPane.add(cbPc);
		
		JCheckBox cbAire = new JCheckBox("Aire Acondi.");
		cbAire.setBackground(new Color(245, 255, 250));
		cbAire.setBounds(182, 124, 97, 23);
		contentPane.add(cbAire);
		
		JCheckBox cbAspiradora = new JCheckBox("Aspiradora");
		cbAspiradora.setBackground(new Color(245, 255, 250));
		cbAspiradora.setBounds(347, 124, 97, 23);
		contentPane.add(cbAspiradora);
		
		JCheckBox cbFocoA = new JCheckBox("Foco incan.");
		cbFocoA.setBackground(new Color(245, 255, 250));
		cbFocoA.setBounds(502, 124, 108, 23);
		contentPane.add(cbFocoA);
		
		JCheckBox cbFocoB = new JCheckBox("Foco LED");
		cbFocoB.setBackground(new Color(245, 255, 250));
		cbFocoB.setBounds(655, 124, 82, 23);
		contentPane.add(cbFocoB);
		
		JCheckBox cbFocoC = new JCheckBox("Foco Ahorrador");
		cbFocoC.setBackground(new Color(245, 255, 250));
		cbFocoC.setBounds(182, 701, 126, 23);
		contentPane.add(cbFocoC);
		
		JCheckBox cbDucha = new JCheckBox("Ducha Electrica");
		cbDucha.setBackground(new Color(245, 255, 250));
		cbDucha.setBounds(182, 556, 126, 23);
		contentPane.add(cbDucha);
		
		JCheckBox cbCalentador = new JCheckBox("Calentador");
		cbCalentador.setBackground(new Color(245, 255, 250));
		cbCalentador.setBounds(20, 556, 97, 23);
		contentPane.add(cbCalentador);
		
		JCheckBox cbHervidor = new JCheckBox("Hervidor");
		cbHervidor.setBackground(new Color(245, 255, 250));
		cbHervidor.setBounds(20, 272, 108, 23);
		contentPane.add(cbHervidor);
		
		JCheckBox cbCocina = new JCheckBox("Cocina");
		cbCocina.setBackground(new Color(245, 255, 250));
		cbCocina.setBounds(182, 272, 64, 23);
		contentPane.add(cbCocina);
		
		JCheckBox cbMicroondas = new JCheckBox("Microondas");
		cbMicroondas.setBackground(new Color(245, 255, 250));
		cbMicroondas.setBounds(347, 272, 97, 23);
		contentPane.add(cbMicroondas);
		
		JCheckBox cbTv = new JCheckBox("Televisor");
		cbTv.setBackground(new Color(245, 255, 250));
		cbTv.setBounds(502, 272, 108, 23);
		contentPane.add(cbTv);
		
		JCheckBox cbTerma = new JCheckBox("Terma");
		cbTerma.setBackground(new Color(245, 255, 250));
		cbTerma.setBounds(655, 272, 82, 23);
		contentPane.add(cbTerma);
		
		JCheckBox cbPLancha = new JCheckBox("Plancha");
		cbPLancha.setBackground(new Color(245, 255, 250));
		cbPLancha.setBounds(347, 701, 97, 23);
		contentPane.add(cbPLancha);
		
		JCheckBox cbLicuadora = new JCheckBox("Licuadora");
		cbLicuadora.setBackground(new Color(245, 255, 250));
		cbLicuadora.setBounds(347, 556, 97, 23);
		contentPane.add(cbLicuadora);
		
		JCheckBox cbCelular = new JCheckBox("Celular");
		cbCelular.setBackground(new Color(245, 255, 250));
		cbCelular.setBounds(20, 407, 97, 23);
		contentPane.add(cbCelular);
		
		JCheckBox cbVentilador = new JCheckBox("Ventilador");
		cbVentilador.setBackground(new Color(245, 255, 250));
		cbVentilador.setBounds(182, 407, 139, 23);
		contentPane.add(cbVentilador);
		
		JCheckBox cbOlla = new JCheckBox("Olla arrocera");
		cbOlla.setBackground(new Color(245, 255, 250));
		cbOlla.setBounds(347, 407, 109, 23);
		contentPane.add(cbOlla);
		
		JCheckBox cbSecador = new JCheckBox("Secador");
		cbSecador.setBackground(new Color(245, 255, 250));
		cbSecador.setBounds(502, 407, 87, 23);
		contentPane.add(cbSecador);
		
		JCheckBox cbDvd = new JCheckBox("DVD");
		cbDvd.setBackground(new Color(245, 255, 250));
		cbDvd.setBounds(655, 407, 87, 23);
		contentPane.add(cbDvd);
		
		JCheckBox cbEquipo = new JCheckBox("Estereo");
		cbEquipo.setBackground(new Color(245, 255, 250));
		cbEquipo.setBounds(502, 701, 87, 23);
		contentPane.add(cbEquipo);
		
		JCheckBox cbRefri = new JCheckBox("Refrigerador");
		cbRefri.setBackground(new Color(245, 255, 250));
		cbRefri.setBounds(502, 556, 108, 23);
		contentPane.add(cbRefri);
		
		JCheckBox cbLavadora1 = new JCheckBox("Lavadora");
		cbLavadora1.setBackground(new Color(245, 255, 250));
		cbLavadora1.setBounds(655, 556, 97, 23);
		contentPane.add(cbLavadora1);
		
		
		JButton btnAsignarValores = new JButton("Calcular");
		btnAsignarValores.setBackground(new Color(189, 183, 107));
		btnAsignarValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					DlgAsignarValores valores = new DlgAsignarValores();
					valores.setVisible(true);
					
					if(cbPc.isSelected()) {
						valores.getComboBox().addItem("Computadora");
						objetos[0] = 0;
						cantidad++;
						}
				        if(cbAire.isSelected()) {
				        valores.getComboBox().addItem("Aire Acondicionado");
				        objetos[22] = 22;
						cantidad++;

						}
				        if(cbAspiradora.isSelected()) {
				        valores.getComboBox().addItem("Aspiradora");
				        objetos[12] = 12;
						cantidad++;

						}
			            if(cbFocoA.isSelected()) {
			            valores.getComboBox().addItem("Foco incandecente");	
			            objetos[7] = 7;
						cantidad++;

						}
			            if(cbFocoB.isSelected()) {
			            valores.getComboBox().addItem("Foco led");
			            objetos[8] = 8;
						cantidad++;

						}
			            if(cbFocoC.isSelected()) {
			             valores.getComboBox().addItem("Foco ahorrador");
			             objetos[1] = 1;
						cantidad++;

						}
			            if(cbDucha.isSelected()) {
			            valores.getComboBox().addItem("Ducha Electrica");
			            objetos[21] = 21;
						cantidad++;

						}
			            if(cbCalentador.isSelected()) {
			            valores.getComboBox().addItem("Calentador");	
			            objetos[20] = 20;
						cantidad++;

			        	}
			            if(cbHervidor.isSelected()) {
			            valores.getComboBox().addItem("Hervidor");	
			            objetos[9] = 9;
						cantidad++;

			        	}
			            if(cbCocina.isSelected()) {
			            valores.getComboBox().addItem("Cocina");	
			            objetos[2] = 2;
						cantidad++;

			        	}
			            if(cbMicroondas.isSelected()) {
			            valores.getComboBox().addItem("Microondas");	
			            objetos[13] = 13;
						cantidad++;

			        	}
			            if(cbTv.isSelected()) {
			            valores.getComboBox().addItem("TV");	
			            objetos[3] = 3;
						cantidad++;

			        	}
			            if(cbTerma.isSelected()) {
			            valores.getComboBox().addItem("Terma");		
			            objetos[4] = 4;
						cantidad++;

			        	}
			            if(cbPLancha.isSelected()) {
			            valores.getComboBox().addItem("Plancha");	
			            objetos[15] = 15;
						cantidad++;

			        	}
			            if(cbLicuadora.isSelected()) {
			            valores.getComboBox().addItem("Licuadora");	
			            objetos[11] = 11;
						cantidad++;

			        	}
			            if(cbCelular.isSelected()) {
			            valores.getComboBox().addItem("Celular");
			            objetos[16] = 16;
						cantidad++;

			        	}
			            if(cbVentilador.isSelected()) {
			            valores.getComboBox().addItem("Ventilador");
			            objetos[19] = 19;
						cantidad++;

			        	}
			            if(cbOlla.isSelected()) {
			            valores.getComboBox().addItem("Olla arrocera");		
			            objetos[14] = 14;
						cantidad++;

			        	}
			            if(cbSecador.isSelected()) {
			            valores.getComboBox().addItem("Secador de cabello");
			            objetos[18] = 18;
						cantidad++;

			        	}
			            if(cbDvd.isSelected()) {
						valores.getComboBox().addItem("Equipo de video");
						objetos[5] = 5;
						cantidad++;

			        	}
			            if(cbEquipo.isSelected()) {
			            valores.getComboBox().addItem("Equipo de sonido");		
			            objetos[6] = 6;
						cantidad++;

			        	}
			            if(cbRefri.isSelected()) {
			            valores.getComboBox().addItem("Refrigeradora");		
			            objetos[17] = 17;
						cantidad++;

			        	}
			            if(cbLavadora1.isSelected()) {
				        valores.getComboBox().addItem("Lavadora");	
				        objetos[10] = 10;
						cantidad++;

				        }
					
					
					
				
			}
		});
		btnAsignarValores.setBounds(310, 777, 146, 35);
		contentPane.add(btnAsignarValores);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img2/lavadora.png")));
		lblNewLabel_1.setBounds(673, 485, 64, 64);
		contentPane.add(lblNewLabel_1);
		
		
	

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(arg0);
		}
		if (arg0.getSource() == mntmCosto) {
			actionPerformedMntmCosto(arg0);
		}
		if (arg0.getSource() == mntmConsumo) {
			actionPerformedMntmConsumo(arg0);
		}
	}
	
	protected void actionPerformedMntmConsumo(ActionEvent arg0) {
		DlgEditarConsumo consumo = new DlgEditarConsumo();
		consumo.setVisible(true);
		consumo.setLocationRelativeTo(this);
	}
	

	protected void actionPerformedMntmCosto(ActionEvent arg0) {
		DlgCambiarCostoConsumo costo = new DlgCambiarCostoConsumo();
		costo.setVisible(true);
		costo.setLocationRelativeTo(this);
	}
	
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
		DlgListar listar = new DlgListar();
		listar.setLocationRelativeTo(this);
		listar.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent arg0) {
		DlgGrupo grupo = new DlgGrupo();
		grupo.setLocationRelativeTo(this);
		grupo.setVisible(true);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent arg0) {
		dispose();
		FrmLogin costo = new FrmLogin();
        costo.setVisible(true);
        costo.setLocationRelativeTo(this);
		
	}
}
