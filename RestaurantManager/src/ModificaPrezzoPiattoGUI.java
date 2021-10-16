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

public class ModificaPrezzoPiattoGUI {

	private JFrame frmModificaPrezzo;
	private JTextField txtNomePiatto;
	private JTextField txtNuovoPrezzo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Chef modificatore) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaPrezzoPiattoGUI window = new ModificaPrezzoPiattoGUI(modificatore);
					window.frmModificaPrezzo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificaPrezzoPiattoGUI(Chef nomeChef) {
		initialize(nomeChef);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Chef nomeChef) {
		frmModificaPrezzo = new JFrame();
		frmModificaPrezzo.setTitle("Modifica nome");
		frmModificaPrezzo.setBounds(100, 100, 460, 310);
		frmModificaPrezzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificaPrezzo.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("ShellKrustyKrab.png");
    	frmModificaPrezzo.setIconImage(img.getImage());
		
		txtNomePiatto = new JTextField();
		txtNomePiatto.setName("");
		txtNomePiatto.setForeground(Color.BLACK);
		txtNomePiatto.setToolTipText("Inserisci qui il nome del piatto da modificare");
		txtNomePiatto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePiatto.setBounds(110, 57, 228, 20);
		frmModificaPrezzo.getContentPane().add(txtNomePiatto);
		txtNomePiatto.setColumns(10);
		
		txtNuovoPrezzo = new JTextField();
		txtNuovoPrezzo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					nomeChef.modificaPrezzo(Float.valueOf(txtNuovoPrezzo.getText()), txtNomePiatto.getText());
				//System.out.println(nomeChef.stampa());
				frmModificaPrezzo.dispose();
				}
				
			}
		});
		txtNuovoPrezzo.setToolTipText("Inserisci qui il nuovo prezzo del piatto");
		txtNuovoPrezzo.setForeground(Color.BLACK);
		txtNuovoPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuovoPrezzo.setBounds(110, 138, 228, 20);
		frmModificaPrezzo.getContentPane().add(txtNuovoPrezzo);
		txtNuovoPrezzo.setColumns(10);
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					nomeChef.modificaPrezzo(Float.valueOf(txtNuovoPrezzo.getText()), txtNomePiatto.getText());
					//System.out.println(nomeChef.stampa());
					frmModificaPrezzo.dispose();
				}
				catch (NumberFormatException ex) {
					ErrorGUI.main(new String[0]);
					frmModificaPrezzo.dispose();
				}
			}
		});
		btnNewButton.setBounds(60, 203, 100, 45);
		frmModificaPrezzo.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmModificaPrezzo.dispose();
			}
		});
		btnNewButton_1.setBounds(280, 203, 100, 45);
		frmModificaPrezzo.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBackground(SystemColor.menu);
		txtpnNome.setEditable(false);
		txtpnNome.setRequestFocusEnabled(false);
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(110, 38, 50, 20);
		frmModificaPrezzo.getContentPane().add(txtpnNome);
		
		JTextPane txtpnPrezzo = new JTextPane();
		txtpnPrezzo.setEditable(false);
		txtpnPrezzo.setText("Nuovo prezzo");
		txtpnPrezzo.setBackground(SystemColor.menu);
		txtpnPrezzo.setBounds(110, 119, 130, 20);
		frmModificaPrezzo.getContentPane().add(txtpnPrezzo);
	}

}
