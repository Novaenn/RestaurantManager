import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;

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
		
		txtNomePiatto = new JTextField();
		txtNomePiatto.setName("");
		txtNomePiatto.setForeground(Color.BLACK);
		txtNomePiatto.setToolTipText("Inserisci qui il nome del piatto da modificare");
		txtNomePiatto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePiatto.setBounds(110, 57, 228, 20);
		frmModificaNome.getContentPane().add(txtNomePiatto);
		txtNomePiatto.setColumns(10);
		
		txtNuovoNome = new JTextField();
		txtNuovoNome.setToolTipText("Inserisci qui il nuovo nome del piatto");
		txtNuovoNome.setForeground(Color.BLACK);
		txtNuovoNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuovoNome.setBounds(110, 138, 228, 20);
		frmModificaNome.getContentPane().add(txtNuovoNome);
		txtNuovoNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeChef.modificaNome(txtNuovoNome.getText(), txtNomePiatto.getText());
				System.out.println(nomeChef.stampa());
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
		frmModificaNome.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setBackground(SystemColor.menu);
		txtpnNome.setEditable(false);
		txtpnNome.setRequestFocusEnabled(false);
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(110, 38, 50, 20);
		frmModificaNome.getContentPane().add(txtpnNome);
		
		JTextPane txtpnPrezzo = new JTextPane();
		txtpnPrezzo.setEditable(false);
		txtpnPrezzo.setText("Nuovo nome");
		txtpnPrezzo.setBackground(SystemColor.menu);
		txtpnPrezzo.setBounds(110, 119, 130, 20);
		frmModificaNome.getContentPane().add(txtpnPrezzo);
	}

}
