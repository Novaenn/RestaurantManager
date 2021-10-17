import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;

public class CuocoGUI extends JDialog {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Cuoco bCarlo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuocoGUI window = new CuocoGUI(bCarlo);
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
	public CuocoGUI(Cuoco bCarlo) {
		initialize(bCarlo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Cuoco bCarlo) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
		
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
				frame.dispose();
			}
		});
		btnNewButton.setBounds(110, 557, 135, 65);
		frame.getContentPane().add(btnNewButton);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		for (int i = 0; i < bCarlo.getOrdini().size(); i++) {
			model.addElement("Ordine #"+(i+1));
		}
		
		JList<String> list = new JList<>(model);
		list.setBounds(107, 83, 467, 299);
		frame.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Seleziona");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int indice = list.getSelectedIndex();
					Ordine selezionato = bCarlo.getOrdini().get(indice);
					ListaPiattiGUI.main(new String[0], selezionato, bCarlo);
					frame.dispose();
				}
				catch(Exception ex) {
				}
				
			}
		});
		btnNewButton_1.setBounds(439, 557, 135, 65);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
