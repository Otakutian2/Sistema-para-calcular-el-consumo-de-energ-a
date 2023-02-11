package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgGrupo extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGrupo dialog = new DlgGrupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGrupo() {
		setTitle("Grupo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgGrupo.class.getResource("/img/cola.png")));
		setResizable(false);
		setBounds(100, 100, 455, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Consumo de luz");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(98, 11, 253, 46);
		contentPanel.add(lblNewLabel);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setIcon(new ImageIcon(DlgGrupo.class.getResource("/img/boton-x.png")));
		btnNewButton.addActionListener(this);
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(23, 68, 403, 2);
		contentPanel.add(separator);
		btnNewButton.setBounds(167, 369, 114, 33);
		contentPanel.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Sebastian carbajal alvarado");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(133, 105, 253, 25);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Luis Fabian Soraluz Torres");
		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(133, 170, 253, 25);
		contentPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Jhoset  Llacchua Sales");
		lblNewLabel_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(133, 307, 253, 25);
		contentPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Gary Morales Altamirano");
		lblNewLabel_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(133, 239, 253, 25);
		contentPanel.add(lblNewLabel_3_3);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DlgGrupo.class.getResource("/img3/icons8_customer_32px_1.png")));
		lblNewLabel_1.setBounds(91, 98, 32, 32);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DlgGrupo.class.getResource("/img3/icons8_customer_32px_1.png")));
		lblNewLabel_2.setBounds(91, 163, 32, 32);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(DlgGrupo.class.getResource("/img3/icons8_customer_32px_1.png")));
		lblNewLabel_4.setBounds(91, 232, 32, 32);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(DlgGrupo.class.getResource("/img3/icons8_customer_32px_1.png")));
		lblNewLabel_5.setBounds(91, 300, 32, 32);
		contentPanel.add(lblNewLabel_5);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
}
