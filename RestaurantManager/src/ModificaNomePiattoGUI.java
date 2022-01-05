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

public class ModificaNomePiattoGUI {

	private JFrame frmModificaNome;
	private JTextField txtNomePiatto;
	private JTextField txtNuovoNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Chef modificatore) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaNomePiattoGUI window = new ModificaNomePiattoGUI(modificatore);
					window.frmModificaNome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificaNomePiattoGUI(Chef nomeChef) {
		initialize(nomeChef);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Chef nomeChef) {
		frmModificaNome = new JFrame();
		frmModificaNome.setTitle("Modifica nome");
		frmModificaNome.setBounds(100, 100, 460, 310);
		frmModificaNome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificaNome.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frmModificaNome.setIconImage(img.getImage());
    	frmModificaNome.getContentPane().setBackground(new Color(10,28,48));
    	
		
		txtNomePiatto = new JTextField();
		txtNomePiatto.setName("");
		txtNomePiatto.setBackground(new Color(223,182,127));
		txtNomePiatto.setForeground(Color.BLACK);
		txtNomePiatto.setToolTipText("Inserisci qui il nome del piatto da modificare");
		txtNomePiatto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePiatto.setBounds(110, 57, 228, 20);
		frmModificaNome.getContentPane().add(txtNomePiatto);
		txtNomePiatto.setColumns(10);
		
		txtNuovoNome = new JTextField();
		txtNuovoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					nomeChef.modificaNome(txtNuovoNome.getText(), txtNomePiatto.getText());
					frmModificaNome.dispose();
				}
			}
		});
		txtNuovoNome.setToolTipText("Inserisci qui il nuovo nome del piatto");
		txtNuovoNome.setBackground(new Color(223,182,127));
		txtNuovoNome.setForeground(Color.BLACK);
		txtNuovoNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuovoNome.setBounds(110, 138, 228, 20);
		frmModificaNome.getContentPane().add(txtNuovoNome);
		txtNuovoNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.setBackground(new Color(223,182,127));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeChef.modificaNome(txtNuovoNome.getText(), txtNomePiatto.getText());
				frmModificaNome.dispose();
			}
		});
		btnNewButton.setBounds(60, 203, 100, 45);
		frmModificaNome.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmModificaNome.dispose();
			}
		});
		btnNewButton_1.setBounds(280, 203, 100, 45);
		btnNewButton_1.setBackground(new Color(223,182,127));
		frmModificaNome.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setForeground(new Color(255, 255, 255));
		txtpnNome.setBackground(SystemColor.menu);
		txtpnNome.setEditable(false);
		txtpnNome.setRequestFocusEnabled(false);
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(110, 38, 50, 20);
		txtpnNome.setBackground(new Color(10,28,48));
		frmModificaNome.getContentPane().add(txtpnNome);
		
		JTextPane txtpnPrezzo = new JTextPane();
		txtpnPrezzo.setForeground(new Color(255, 255, 255));
		txtpnPrezzo.setEditable(false);
		txtpnPrezzo.setText("Nuovo nome");
		txtpnPrezzo.setBackground(SystemColor.menu);
		txtpnPrezzo.setBounds(110, 119, 130, 20);
		txtpnPrezzo.setBackground(new Color(10,28,48));
		frmModificaNome.getContentPane().add(txtpnPrezzo);
	}

}
