import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class CuocoGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuocoGUI window = new CuocoGUI();
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
	public CuocoGUI() {
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
		
		JTextPane txtpnCuoco = new JTextPane();
		txtpnCuoco.setEditable(false);
		txtpnCuoco.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtpnCuoco.setText("                                            CUOCO");
		txtpnCuoco.setBounds(0, 0, 694, 45);
		frame.getContentPane().add(txtpnCuoco);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuGUI.main(new String[0]);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(285, 511, 135, 65);
		frame.getContentPane().add(btnNewButton);
	}

}
