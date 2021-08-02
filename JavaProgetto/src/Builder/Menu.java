package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Menu {

	private JFrame frmKrustCrab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmKrustCrab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKrustCrab = new JFrame();
		frmKrustCrab.setBackground(Color.DARK_GRAY);
		frmKrustCrab.setForeground(Color.DARK_GRAY);
		frmKrustCrab.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		frmKrustCrab.setAlwaysOnTop(true);
		frmKrustCrab.setResizable(false);
		frmKrustCrab.setTitle("Krusty Crab");
		frmKrustCrab.setBounds(100, 100, 493, 780);
		frmKrustCrab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKrustCrab.getContentPane().setLayout(null);
		
		JTextPane txtpnMenuPlaceholder = new JTextPane();
		txtpnMenuPlaceholder.setEditable(false);
		txtpnMenuPlaceholder.setBounds(65, 53, 319, 341);
		txtpnMenuPlaceholder.setText("Menu placeholder");
		frmKrustCrab.getContentPane().add(txtpnMenuPlaceholder);
		
		JButton btnNewButton_0 = new JButton("Chef");
		btnNewButton_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton_0.setBounds(65, 405, 132, 73);
		frmKrustCrab.getContentPane().add(btnNewButton_0);
		
		JButton btnNewButton_1 = new JButton("Cameriere");
		btnNewButton_1.setBounds(262, 407, 116, 73);
		frmKrustCrab.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cuoco");
		btnNewButton_2.setBounds(65, 514, 132, 72);
		frmKrustCrab.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Resp. Cassa");
		btnNewButton_3.setBounds(262, 514, 116, 70);
		frmKrustCrab.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Esci");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(65, 617, 313, 70);
		frmKrustCrab.getContentPane().add(btnNewButton_4);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
