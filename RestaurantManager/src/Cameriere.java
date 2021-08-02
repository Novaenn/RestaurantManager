import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cameriere {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cameriere window = new Cameriere();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cameriere() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnCameriere = new JTextPane();
		txtpnCameriere.setEditable(false);
		txtpnCameriere.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtpnCameriere.setText("                                         CAMERIERE");
		txtpnCameriere.setBounds(0, 0, 694, 45);
		frame.getContentPane().add(txtpnCameriere);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.main(new String[0]);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(285, 511, 135, 65);
		frame.getContentPane().add(btnNewButton);
	}

}
