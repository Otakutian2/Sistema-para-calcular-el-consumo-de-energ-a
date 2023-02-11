package guis;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import Arreglos.arregloElectrodomestico;
import clases.Electrodomesticos;
import clases.Paises;
import guis.FrmLogin;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import Arreglos.ArregloPaises;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class DlgAsignarValores extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;
	private JTextField txtDias;
	private JTextField txtHora;
	private JTextField txtMinutos;
	private JComboBox comboBox;
	private JButton btnAñadir;
	private JLabel lblImagen;
	DecimalFormat df = new DecimalFormat("0.00");
	// Variables
	private double producto, totalProducto;
	private String mensaje = "";
	private double impuesto, pagoImpAgregado;

	// Variables útiles
	ArregloPaises ae = new ArregloPaises();
	arregloElectrodomestico aa = new arregloElectrodomestico();
	private JButton btnGuardar;
	private double total;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgAsignarValores dialog = new DlgAsignarValores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAsignarValores() {
		setTitle("Asignar Valores");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgAsignarValores.class.getResource("/img/lista-de-verificacion.png")));
		setResizable(false);
		setBounds(100, 100, 791, 546);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblImagen = new JLabel("");
			lblImagen.setBounds(57, 333, 145, 130);
			contentPanel.add(lblImagen);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBackground(new Color(189, 183, 107));
			comboBox.setFont(new Font("Sitka Text", Font.BOLD, 16));
			comboBox.addActionListener(this);
			comboBox.setBounds(23, 39, 197, 29);
			contentPanel.add(comboBox);
		}

		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		txtCantidad.setBackground(new Color(224, 255, 255));
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(306, 40, 86, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtDias = new JTextField();
		txtDias.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		txtDias.setBackground(new Color(224, 255, 255));
		txtDias.addKeyListener(this);
		txtDias.setBounds(481, 40, 86, 20);
		contentPanel.add(txtDias);
		txtDias.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblCantidad.setBounds(230, 42, 66, 17);
		contentPanel.add(lblCantidad);

		JLabel lblDias = new JLabel("D\u00EDas :");
		lblDias.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblDias.setBounds(425, 42, 46, 17);
		contentPanel.add(lblDias);

		JLabel lblHoras = new JLabel("Horas :");
		lblHoras.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblHoras.setBounds(601, 43, 46, 14);
		contentPanel.add(lblHoras);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		txtHora.setBackground(new Color(224, 255, 255));
		txtHora.addKeyListener(this);
		txtHora.setBounds(657, 40, 32, 20);
		contentPanel.add(txtHora);
		txtHora.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblNewLabel_1.setBounds(699, 43, 16, 14);
		contentPanel.add(lblNewLabel_1);

		txtMinutos = new JTextField();
		txtMinutos.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		txtMinutos.setBackground(new Color(224, 255, 255));
		txtMinutos.addKeyListener(this);
		txtMinutos.setBounds(709, 40, 32, 20);
		contentPanel.add(txtMinutos);
		txtMinutos.setColumns(10);

		btnAñadir = new JButton("A\u00F1adir Valores");
		btnAñadir.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnAñadir.setBackground(new Color(189, 183, 107));
		btnAñadir.addActionListener(this);
		btnAñadir.setBounds(425, 453, 155, 29);
		contentPanel.add(btnAñadir);

		btnGuardar = new JButton("Calcular");
		btnGuardar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnGuardar.setBackground(new Color(189, 183, 107));
		btnGuardar.addActionListener(new ActionListener() {

			// BOTON GUARDAR
			public void actionPerformed(ActionEvent arg0) {
				/**/
				txtS.setText("");
				imprimir ("======================================================================="+"\n");
				switch(FrmLogin.Pais) {
				case 0:
					imprimir(" 		             <<-----Perú----->>"  + "\n");
					imprimir(mensaje);
					imprimir ("======================================================================="+"\n");
					imprimir("	Consumo acumulado		: 	S/. " + df.format(totalProducto) + "\n" +
							"	Impuesto generado		: 	S/. " + df.format(impuesto) + "\n" + "	Pago total			: 	S/. " + df.format(pagoImpAgregado));
				break;
				case 1:
					imprimir(" 		           <<-----Argentina----->>"+ "\n");
					imprimir(mensaje);
					imprimir ("======================================================================="+"\n");
					imprimir("	Consumo acumulado		: 	ARS$ " + df.format(totalProducto) + "\n" +
							"	Impuesto generado		: 	ARS$ " + df.format(impuesto) + "\n" + "	Pago total			: 	ARS$ " + df.format(pagoImpAgregado));
				break;
				default:
					imprimir(" 		            <<-----Colombia----->>" + "\n");
					imprimir(mensaje);
					imprimir ("======================================================================="+"\n");
					imprimir("	Consumo acumulado		: 	COL$ " + df.format(totalProducto) + "\n" +
							"	Impuesto generado		: 	COL$ " + df.format(impuesto) + "\n" + "	Pago total			: 	COL$ " + df.format(pagoImpAgregado));
				}
						
				/**/
			}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(586, 452, 155, 30);
		contentPanel.add(btnGuardar);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(230, 94, 511, 2);
		contentPanel.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 127, 511, 302);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("NSimSun", Font.PLAIN, 14));
		txtS.setBackground(new Color(240, 255, 240));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			actionPerformedBtnAñadir(e);
		}
		if (e.getSource() == comboBox) {
			actionPerformedComboBox(e);
		}
	}

	// COMBO BOX EVENTO
	protected void actionPerformedComboBox(ActionEvent e) {
		if (comboBox.getSelectedItem() == "Computadora") {
			imagen("/img2/ordenador-de-sobremesa (1).png");
		} else if (comboBox.getSelectedItem() == "Aire Acondicionado") {
			imagen("/img2/aire-acondicionado.png");
		} else if (comboBox.getSelectedItem() == "Aspiradora") {
			imagen("/img2/aspiradora.png");
		} else if (comboBox.getSelectedItem() == "Foco incandecente") {
			imagen("/img2/bombilla-de-idea.png");
		}

		else if (comboBox.getSelectedItem() == "Foco led") {
			imagen("/img2/bombilla.png");
		}

		else if (comboBox.getSelectedItem() == "Foco ahorrador") {
			imagen("/img2/bulbo.png");
		}

		else if (comboBox.getSelectedItem() == "Ducha Electrica") {
			imagen("/img2/water-heater.png");
		} else if (comboBox.getSelectedItem() == "Calentador") {
			imagen("/img2/calentador.png");
		} else if (comboBox.getSelectedItem() == "Hervidor") {
			imagen("/img2/hervidor-electrico.png");
		} else if (comboBox.getSelectedItem() == "Cocina") {
			imagen("/img2/cocina.png");
		} else if (comboBox.getSelectedItem() == "Microondas") {
			imagen("/img2/microonda.png");
		} else if (comboBox.getSelectedItem() == "TV") {
			imagen("/img2/monitor-de-tv.png");
		} else if (comboBox.getSelectedItem() == "Terma") {
			imagen("/img2/calentador-de-agua.png");
		} else if (comboBox.getSelectedItem() == "Plancha") {
			imagen("/img2/planchar.png");
		} else if (comboBox.getSelectedItem() == "Licuadora") {
			imagen("/img2/licuadora.png");
		} else if (comboBox.getSelectedItem() == "Celular") {
			imagen("/img2/telefono-celular.png");
		} else if (comboBox.getSelectedItem() == "Ventilador") {
			imagen("/img2/ventilador.png");
		} else if (comboBox.getSelectedItem() == "Olla arrocera") {
			imagen("/img2/olla-arrocera.png");
		} else if (comboBox.getSelectedItem() == "Secador de cabello") {
			imagen("/img2/secador-de-pelo.png");
		} else if (comboBox.getSelectedItem() == "Equipo de video") {
			imagen("/img2/reproductor-de-dvd.png");
		} else if (comboBox.getSelectedItem() == "Equipo de sonido") {
			imagen("/img2/equipo-de-sonido.png");
		} else if (comboBox.getSelectedItem() == "Refrigeradora") {
			imagen("/img2/refrigerador.png");
		} else if (comboBox.getSelectedItem() == "Lavadora") {
			imagen("/img2/lavadora.png");
		} else {
			imagen("");
		}
	}

	protected void actionPerformedBtnAñadir(ActionEvent e) {
		Electrodomesticos x;
		Paises p;
		// Valores a obtener
		int cantidad, dias, horas, minutos, objetos;
		// Obtener y validar

		try {
			cantidad = getCantidad();

			if (cantidad <= 0) {
				error("Ingrese valores mayores a 0", "Error");
				return;
			}
			try {
				dias = getDias();
				if (dias <= 0) {
					error("Ingrese un día mayor a 0", "Error");
					return;
				} else if (dias > 31) {
					error("Solo puedes ingresar hasta 30 días", "Error");
					return;
				}
				try {
					horas = getHoras();
					if (horas <= 0) {
						error("Ingrese una hora mayor a 0", "Error");
						return;
					} else if (horas > 23) {
						error("Solo puedes ingresar hasta 23 horas", "Error");
						return;
					}

					try {
						minutos = getMinutos();

						if (minutos < 0) {
							error("Ingrese un minuto mayor a 0", "Error");
							return;
						} else if (minutos > 59) {
							error("Solo puedes ingresar 59 minutos", "Error");
							return;
						}

						// Tiempo
						int tiempo = calcTiempoConsumo(dias, cantidad, horas, minutos);
						// Imprimir después separando horas con minutos
						double Tiempoenhoras = TiempolecturaHoras(tiempo);
						double Tiempoenminutos = TiempolecturaMinutos(tiempo);
						TiempoTotal(Tiempoenhoras, Tiempoenminutos);
						String nombre = getItemNameCbo();

						x = aa.buscar(nombre);
						x.setCantidad(cantidad);
						x.sethUso(tiempo);
						comboBox.removeItem(nombre);
						

						// Mensaje para mostrar cambios
						mensaje(x.getNombre() + "\n" + "Cantidad: " + x.getCantidad() + "\n" + "Tiempo en minutos "
								+ x.gethUso(), x.getNombre() + " ha sido modificado");

						// Modificar

						switch (FrmLogin.Pais) {
						case 0:
								
							if (FrmLogin.Tipo == 0) {
								p = ae.buscar("Perú");
								Paises pa = ae.obtener(FrmLogin.Pais);
								producto = x.getKwhElectrodomestico() * (x.gethUso() / 60) * p.getKloWattsNegocio();
								totalProducto += producto;
								impuesto = (totalProducto * pa.getT_IGV());
								pagoImpAgregado = totalProducto + impuesto;  
								
								mensaje += "	Producto 			: 	" + x.getNombre() + "\n" + 
								"	Cantidad			: 	" + x.getCantidad() + "\n" + "	Minutos de uso total		: 	" + x.gethUso()+" min."
								+ "\n" + "	Consumo de electrodomestico 	: 	" + x.getKwhElectrodomestico() +" kwh" 
								+ "\n" + "	Costo por consumo Negocio	: 	" + p.getKloWattsNegocio() +" kwh" + "\n" + "	Costo por consumo		: 	S/. " +  df.format(producto) + "\n"+ "\n";
								
								
								
							} else {
								p = ae.buscar("Perú");
								Paises pa = ae.obtener(FrmLogin.Pais);
								producto = x.getKwhElectrodomestico() * (x.gethUso() / 60) * p.getKloWattsHogar();
								totalProducto += producto;
								impuesto = (totalProducto * pa.getT_IGV());
								pagoImpAgregado = totalProducto + impuesto;  
								
								mensaje += "	Producto			: " + x.getNombre() + "\n" + "	Cantidad			: " + x.getCantidad() + "\n" + "	Minutos de uso total		: " + x.gethUso()+" min."
								+ "\n" + "	Consumo de electrodomestico : " + x.getKwhElectrodomestico() +" kwh"
								+ "\n" + "	Costo por consumo Hogar		: " + p.getKloWattsHogar()+" kwh" + "\n" + "	Costo por consumo		: S/. " + df.format(producto) + "\n" + "\n";
								
								
							}
							break;
						case 1: 
							if (FrmLogin.Tipo == 0) {
								p = ae.buscar("Argentina");
								Paises pa = ae.obtener(FrmLogin.Pais);
								producto = x.getKwhElectrodomestico() * (x.gethUso() / 60) * p.getKloWattsNegocio();
								totalProducto += producto;
								impuesto = (totalProducto * pa.getT_IGV());
								pagoImpAgregado = totalProducto + impuesto;  
								
								mensaje += "	Producto 			: 	" + x.getNombre() + "\n" + "	Cantidad			: 	" + x.getCantidad() + "\n" + "	Minutos de uso total		: 	" + x.gethUso()+" min."
										+ "\n" + "	Consumo de electrodomestico 	: 	" + x.getKwhElectrodomestico() +" kwh" 
										+ "\n" + "	Costo por consumo Negocio	: 	" + p.getKloWattsNegocio() +" kwh" + "\n" + "	Costo por consumo		: 	ARS$ " +  df.format(producto) + "\n"+ "\n";
								
								
							} else {
								p = ae.buscar("Argentina");
								Paises pa = ae.obtener(FrmLogin.Pais);
								producto = x.getKwhElectrodomestico() * (x.gethUso() / 60) * p.getKloWattsHogar();
								totalProducto += producto;
								impuesto = (totalProducto * pa.getT_IGV());
								pagoImpAgregado = totalProducto + impuesto;  
								
								mensaje += "	Producto			: " + x.getNombre() + "\n" + "	Cantidad			: " + x.getCantidad() + "\n" + "	Minutos de uso total		: " + x.gethUso()+" min."
										+ "\n" + "	Consumo de electrodomestico 	: " + x.getKwhElectrodomestico() +" kwh"
										+ "\n" + "	Costo por consumo Hogar		: " + p.getKloWattsHogar()+" kwh" + "\n" + "	Costo por consumo		: ARS$ " + df.format(producto) + "\n" + "\n";
								
							}
							break;
						default: 
							if (FrmLogin.Tipo == 0) {
								p = ae.buscar("Colombia");
								Paises pa = ae.obtener(FrmLogin.Pais);
								producto = x.getKwhElectrodomestico() * (x.gethUso() / 60) * p.getKloWattsNegocio();
								totalProducto += producto;
								impuesto = (totalProducto * pa.getT_IGV());
								pagoImpAgregado = totalProducto + impuesto;  
								
								mensaje += "	Producto 			: 	" + x.getNombre() + "\n" + "	Cantidad			: 	" + x.getCantidad() + "\n" + "	Minutos de uso total		: 	" + x.gethUso()+" min."
										+ "\n" + "	Consumo de electrodomestico 	:	" + x.getKwhElectrodomestico() +" kwh" 
										+ "\n" + "	Costo por consumo Negocio	: 	" + p.getKloWattsNegocio() +" kwh" + "\n" + "	Costo por consumo		: 	COL$ " +  df.format(producto) + "\n"+ "\n";
								
								
							} else {
								p = ae.buscar("Colombia");
								Paises pa = ae.obtener(FrmLogin.Pais);
								producto = x.getKwhElectrodomestico() * (x.gethUso() / 60) * p.getKloWattsHogar();
								totalProducto += producto;
								impuesto = (totalProducto * pa.getT_IGV());
								pagoImpAgregado = totalProducto + impuesto;  
								
								mensaje += "	Producto			: " + x.getNombre() + "\n" + "	Cantidad			: " + x.getCantidad() + "\n" + "	Minutos de uso total		: " + x.gethUso()+" min."
										+ "\n" + "	Consumo de electrodomestico 	: " + x.getKwhElectrodomestico() +" kwh"
										+ "\n" + "	Costo por consumo Hogar		: " + p.getKloWattsHogar()+" kwh" + "\n" + "	Costo por consumo		: COL$ " + df.format(producto) + "\n" + "\n";
								
							}
						}

						// Para activar el botón se active
						FrmPrincipal.cantidad--;
						if (FrmPrincipal.cantidad == 0) {
							btnGuardar.setEnabled(true);

						}
					} catch (Exception e2) {
						error("Ingrese la cantidad de minutos", "Error");
						txtMinutos.setText("");
						txtMinutos.requestFocus();
						return;
					}
				} catch (Exception e2) {
					error("Ingrese la cantidad de horas", "Error");
					txtHora.setText("");
					txtHora.requestFocus();
					return;
				}
			} catch (Exception e2) {
				error("Ingrese la cantidad de días", "Error");
				txtDias.setText("");
				txtDias.requestFocus();
				return;
			}
		} catch (Exception e2) {
			error("Ingrese la cantidad de electrodomésticos", "Error");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
			return;
		}

	}

	// Mostrar mensajes
	private void error(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}

	// Obtener valores
	private String getItemNameCbo() {
		return (String) comboBox.getSelectedItem();
	}

	private int getMinutos() {

		return Integer.parseInt(txtMinutos.getText());
	}

	private int getHoras() {

		return Integer.parseInt(txtHora.getText());
	}

	private int getDias() {

		return Integer.parseInt(txtDias.getText());
	}

	private int getCantidad() {

		return Integer.parseInt(txtCantidad.getText());
	}

	private int ComboBox() {
		return comboBox.getSelectedIndex();
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	// Para cambiar las imágenes
	public void imagen(String ubicacion) {
		ImageIcon imagen = new ImageIcon(getClass().getResource(ubicacion));
		ImageIcon icono = new ImageIcon(
				imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		lblImagen.setIcon(icono);

	}

	// MENSAJE
	void mensaje(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	// Métodos para calcular hora
	public int calcTiempoConsumo(int dias, int cantidad, int horas, int minutos) {
		int Totalminutos, HorasaMinutos;

		HorasaMinutos = horas * 60;
		// 1 * 60 = 60

		Totalminutos = HorasaMinutos + minutos;
		// 60 + 30 = 90

		return dias * cantidad * Totalminutos;
		// 1 * 1 * 90 = 90

	}

	public double TiempolecturaHoras(int tiempo) {
		double tiempodividido, numero, parteDecimal;
		double parteEntera;

		tiempodividido = tiempo / 60;
		// 90 / 60
		numero = tiempodividido;
		// 1.5

		parteDecimal = numero % 1; // Lo que sobra de dividir al número entre 1
		// = 0.5
		parteEntera = numero - parteDecimal; // Le quitamos la parte decimal
												// usando una resta
		// 1.5 - 0.5 = 1

		return parteEntera;

	}

	public double TiempolecturaMinutos(int tiempo) {
		double tiempodividido, numero, parteDecimal;
		double minutosaHoras;

		tiempodividido = tiempo / 60;
		numero = tiempodividido;
		// 1.5

		parteDecimal = numero % 1; // Lo que sobra de dividir al número entre 1
		// = 0.5

		minutosaHoras = parteDecimal * 60;
		// 0.5 * 60 = 30

		return minutosaHoras;
		// 30
	}

	public String TiempoTotal(double Tiempoenhoras, double Tiempoenminutos) {
		return Tiempoenhoras + "horas " + Tiempoenminutos + "minutos";
	}

	private double calcMinutosaHoras(int minutos) {
		return minutos / 60;
	}

	// validacion de solo numeros

	void bloquearLetras(KeyEvent xarg0) {
		char letra = xarg0.getKeyChar();
		if (Character.isLetter(letra)) {
			getToolkit().beep();
			xarg0.consume();
			JOptionPane.showMessageDialog(this, "Ingrese solo numeros");
		}
	}

	// Para evitar que entren textos
	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtMinutos) {
			keyTypedTxtMinutos(e);
		}
		if (e.getSource() == txtHora) {
			keyTypedTxtHora(e);
		}
		if (e.getSource() == txtDias) {
			keyTypedTxtDias(e);
		}
		if (e.getSource() == txtCantidad) {
			keyTypedTxtCantidad(e);
		}
	}

	protected void keyTypedTxtCantidad(KeyEvent e) {
		bloquearLetras(e);
	}

	protected void keyTypedTxtDias(KeyEvent e) {
		char c = e.getKeyChar();

		if (c >= '0' && c <= '9' && txtDias.getText().length() <= 1) {

		} else {
			e.consume();
		}
	}

	protected void keyTypedTxtHora(KeyEvent e) {
		char c = e.getKeyChar();

		if (c >= '0' && c <= '9' && txtHora.getText().length() <= 1) {

		} else {
			e.consume();
		}
	}

	protected void keyTypedTxtMinutos(KeyEvent e) {
		char c = e.getKeyChar();

		if (c >= '0' && c <= '9' && txtMinutos.getText().length() <= 1) {

		} else {
			e.consume();
		}
	}
	void imprimir(String text) {
		txtS.append(" "+ text + "\n");
	}
	
}
