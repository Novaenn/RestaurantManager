import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ErrorGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorGUI window = new ErrorGUI();
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
	public ErrorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 239);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(10,28,48));
		
		ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
		
		ImageIcon imgError = new ImageIcon("icons/Error.png");
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					frame.dispose();
				}
			}
		});
		lblNewLabel.setBounds(49, 39, 52, 70);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(imgError);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(223,182,127));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(280, 151, 116, 35);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnErrorePiattoNon = new JTextPane();
		txtpnErrorePiattoNon.setForeground(new Color(255, 255, 255));
		txtpnErrorePiattoNon.setFocusable(false);
		txtpnErrorePiattoNon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnErrorePiattoNon.setText("\r\n\r\n\r\nERRORE: Formato non valido / Piatto non trovato");
		txtpnErrorePiattoNon.setEditable(false);
		txtpnErrorePiattoNon.setBounds(106, 0, 311, 140);
		txtpnErrorePiattoNon.setBackground(new Color(10,28,48));
		frame.getContentPane().add(txtpnErrorePiattoNon);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(0, 0, 107, 141);
		textPane.setBackground(new Color(10,28,48));
		frame.getContentPane().add(textPane);
		
		
		
	}
}
