import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AggiungiPiattoGUI {

	private JFrame frmAggiungiPiatto;
	private JTextField txtNomePiatto;
	private JTextField txtPrezzoPiatto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Chef modificatore) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiPiattoGUI window = new AggiungiPiattoGUI(modificatore);
					window.frmAggiungiPiatto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AggiungiPiattoGUI(Chef nomeChef) {
		initialize(nomeChef);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Chef nomeChef) {
		frmAggiungiPiatto = new JFrame();
		frmAggiungiPiatto.setTitle("Aggiungi piatto");
		frmAggiungiPiatto.setBounds(100, 100, 460, 310);
		frmAggiungiPiatto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAggiungiPiatto.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("ShellKrustyKrab.png");
    	frmAggiungiPiatto.setIconImage(img.getImage());
		
		txtNomePiatto = new JTextField();
		txtNomePiatto.setName("");
		txtNomePiatto.setForeground(Color.BLACK);
		txtNomePiatto.setToolTipText("Inserisci qui il nome del piatto");
		txtNomePiatto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePiatto.setBounds(110, 57, 228, 20);
		frmAggiungiPiatto.getContentPane().add(txtNomePiatto);
		txtNomePiatto.setColumns(10);
		
		txtPrezzoPiatto = new JTextField();
		txtPrezzoPiatto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {	
						nomeChef.aggiungiPiatto(txtNomePiatto.getText(), Float.valueOf(txtPrezzoPiatto.getText()));
						frmAggiungiPiatto.dispose();
						//System.out.println(nomeChef.stampa());
					}
					catch (NumberFormatException ex){
						ErrorGUI.main(new String[0]);
						frmAggiungiPiatto.dispose();
					}
				}
			}
		});
		txtPrezzoPiatto.setToolTipText("Inserisci qui il prezzo del piatto (usare il . per i decimali)");
		txtPrezzoPiatto.setForeground(Color.BLACK);
		txtPrezzoPiatto.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrezzoPiatto.setBounds(110, 138, 228, 20);
		frmAggiungiPiatto.getContentPane().add(txtPrezzoPiatto);
		txtPrezzoPiatto.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {	
					nomeChef.aggiungiPiatto(txtNomePiatto.getText(), Float.valueOf(txtPrezzoPiatto.getText()));
					frmAggiungiPiatto.dispose();
					//System.out.println(nomeChef.stampa());
				}
				catch (NumberFormatException ex){
					ErrorGUI.main(new String[0]);
					frmAggiungiPiatto.dispose();
				}
			}
		});
		btnNewButton.setBounds(60, 203, 100, 45);
		frmAggiungiPiatto.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAggiungiPiatto.dispose();
			}
		});
		btnNewButton_1.setBounds(280, 203, 100, 45);
		frmAggiungiPiatto.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBackground(SystemColor.menu);
		txtpnNome.setEditable(false);
		txtpnNome.setRequestFocusEnabled(false);
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(110, 38, 50, 20);
		frmAggiungiPiatto.getContentPane().add(txtpnNome);
		
		JTextPane txtpnPrezzo = new JTextPane();
		txtpnPrezzo.setEditable(false);
		txtpnPrezzo.setText("Prezzo");
		txtpnPrezzo.setBackground(SystemColor.menu);
		txtpnPrezzo.setBounds(110, 119, 50, 20);
		frmAggiungiPiatto.getContentPane().add(txtpnPrezzo);
	}
}
