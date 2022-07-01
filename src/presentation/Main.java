package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.Vehicle;
import persistence.VehicleControls;

public class Main extends JFrame {

	VehicleControls vc = new VehicleControls();

	private JPanel contentPane;
	private JTextField tftBrand;
	private JTextField tftName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(57, 71, 65, 28);
		desktopPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(57, 35, 65, 28);
		desktopPane.add(lblNewLabel_1);

		tftBrand = new JTextField();
		tftBrand.setBounds(107, 71, 396, 20);
		desktopPane.add(tftBrand);
		tftBrand.setColumns(10);

		tftName = new JTextField();
		tftName.setColumns(10);
		tftName.setBounds(107, 40, 396, 20);
		desktopPane.add(tftName);

		JButton btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehicle vehicle = new Vehicle();

				vehicle.setName(tftName.getText());
				vehicle.setBrand(tftBrand.getText());

				/* Try saving */
				if (vc.save(vehicle)) {
					JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
					tftName.setText("");
					tftBrand.setText("");
					tftName.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo!");
				}
			}
		});
		btnSave.setBounds(131, 321, 89, 23);
		desktopPane.add(btnSave);

		JButton btnSeeAll = new JButton("Ver todos");
		btnSeeAll.setBounds(414, 247, 89, 23);
		desktopPane.add(btnSeeAll);

		JButton btnLogout = new JButton("Sair");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(275, 321, 89, 23);
		desktopPane.add(btnLogout);
	}
}
