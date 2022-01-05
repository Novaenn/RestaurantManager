import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
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
		ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frmChef.setIconImage(img.getImage());
    	frmChef.getContentPane().setBackground(new Color(10,28,48));
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setBackground(new Color(223,182,127));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmChef.dispose();
			}
		});
		btnNewButton.setBounds(281, 511, 135, 65);
		frmChef.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aggiungi piatto");
		btnNewButton_1.setBackground(new Color(223,182,127));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiPiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_1.setBounds(97, 130, 135, 65);
		frmChef.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rimuovi piatto");
		btnNewButton_2.setBackground(new Color(223,182,127));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RimuoviPiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_2.setBounds(457, 130, 135, 65);
		frmChef.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifica nome");
		btnNewButton_3.setBackground(new Color(223,182,127));
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
		btnNewButton_4.setBackground(new Color(223,182,127));
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificaPrezzoPiattoGUI.main(new String[0], tizio);
			}
		});
		btnNewButton_4.setBounds(457, 330, 135, 65);
		frmChef.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
        ImageIcon imgCam = new ImageIcon("icons/Chef22.png");
        lblNewLabel.setIcon(imgCam);
        lblNewLabel.setBounds(198, 0, 357, 75);
        frmChef.getContentPane().add(lblNewLabel);
	}
}
