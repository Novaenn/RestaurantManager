import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class PrendiOrdineGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Cameriere numel) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrendiOrdineGUI window = new PrendiOrdineGUI(numel);
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
	public PrendiOrdineGUI(Cameriere camerupt) {
		initialize(camerupt);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Cameriere camerupt) {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Finalizza");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				camerupt.finalizzaOrdine();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(55, 197, 100, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Annulla");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				camerupt.annullaOrdine();
				frame.dispose();
			}
		});
		btnNewButton_1_1.setBounds(291, 197, 100, 45);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Scegli un piatto da ordinare");
		comboBox.setBounds(160, 77, 123, 22);
		for (int i = 0; i < camerupt.getListaPiatti().size(); i++) {
			comboBox.addItem(camerupt.getListaPiatti().get(i).toString());
		}
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnScegliIlPiatto = new JTextPane();
		txtpnScegliIlPiatto.setBackground(SystemColor.menu);
		txtpnScegliIlPiatto.setText("Scegli il piatto da aggiungere all'ordine:");
		txtpnScegliIlPiatto.setEditable(false);
		txtpnScegliIlPiatto.setBounds(132, 35, 198, 20);
		frame.getContentPane().add(txtpnScegliIlPiatto);
	}
}


