package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class DlgListado extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListado dialog = new DlgListado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListado() {
		setTitle("Listado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgListado.class.getResource("/img/usuario-verificado.png")));
		setResizable(false);
		setBounds(100, 100, 511, 534);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnListar.setBackground(new Color(189, 183, 107));
		btnListar.setBounds(198, 11, 109, 36);
		contentPanel.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 475, 411);
		contentPanel.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		txtS.setBackground(new Color(240, 255, 240));
		scrollPane.setViewportView(txtS);
	}
}
