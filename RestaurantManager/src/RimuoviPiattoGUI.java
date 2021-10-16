import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RimuoviPiattoGUI {

	private JFrame frmRimuoviPiatto;
	private JTextField txtNomePiatto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Chef modificatore) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RimuoviPiattoGUI window = new RimuoviPiattoGUI(modificatore);
					window.frmRimuoviPiatto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RimuoviPiattoGUI(Chef nomeChef) {
		initialize(nomeChef);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Chef nomeChef) {
		frmRimuoviPiatto = new JFrame();
		frmRimuoviPiatto.setTitle("Rimuovi piatto");
		frmRimuoviPiatto.setBounds(100, 100, 460, 310);
		frmRimuoviPiatto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRimuoviPiatto.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("ShellKrustyKrab.png");
    	frmRimuoviPiatto.setIconImage(img.getImage());
		
		txtNomePiatto = new JTextField();
		txtNomePiatto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					nomeChef.eliminaPiatto(txtNomePiatto.getText());
				//System.out.println(nomeChef.stampa());
				frmRimuoviPiatto.dispose();
				}
				
			}
		});
		txtNomePiatto.setName("");
		txtNomePiatto.setForeground(Color.BLACK);
		txtNomePiatto.setToolTipText("Inserisci qui il nome del piatto da rimuovere");
		txtNomePiatto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePiatto.setBounds(110, 105, 228, 20);
		frmRimuoviPiatto.getContentPane().add(txtNomePiatto);
		txtNomePiatto.setColumns(10);
		
		JButton btnNewButton = new JButton("Rimuovi");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeChef.eliminaPiatto(txtNomePiatto.getText());
				//System.out.println(nomeChef.stampa());
				frmRimuoviPiatto.dispose();
			}
		});
		btnNewButton.setBounds(60, 203, 100, 45);
		frmRimuoviPiatto.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRimuoviPiatto.dispose();
			}
		});
		btnNewButton_1.setBounds(280, 203, 100, 45);
		frmRimuoviPiatto.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBackground(SystemColor.menu);
		txtpnNome.setEditable(false);
		txtpnNome.setRequestFocusEnabled(false);
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(110, 84, 50, 20);
		frmRimuoviPiatto.getContentPane().add(txtpnNome);
	}

}
