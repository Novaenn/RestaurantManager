import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;



import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ChefGUI {

	private JFrame frmChef;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Chef tizio) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefGUI window = new ChefGUI(tizio);
					window.frmChef.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChefGUI(Chef tizio) {
		initialize(tizio);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Chef tizio) {
		frmChef = new JFrame();
		frmChef.setResizable(false);
		frmChef.setBounds(100, 100, 700, 700);
		frmChef.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmChef.getContentPane().setLayout(null);
		
		JTextPane txtpnChef = new JTextPane();
		txtpnChef.setEditable(false);
		txtpnChef.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtpnChef.setText("                                             CHEF");
		txtpnChef.setBounds(0, 0, 694, 45);
		frmChef.getContentPane().add(txtpnChef);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuGUI.main(new String[0]);
				frmChef.dispose();
			}
		});
		btnNewButton.setBounds(285, 511, 135, 65);
		frmChef.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aggiungi piatto");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiPiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_1.setBounds(96, 132, 135, 65);
		frmChef.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rimuovi piatto");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RimuoviPiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_2.setBounds(425, 132, 135, 65);
		frmChef.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifica nome");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificaNomePiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_3.setBounds(96, 330, 135, 65);
		frmChef.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Modifica prezzo");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificaPrezzoPiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_4.setBounds(425, 330, 135, 65);
		frmChef.getContentPane().add(btnNewButton_4);
	}
}
