import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PrendiOrdineGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Cameriere numel, Chef cooking) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrendiOrdineGUI window = new PrendiOrdineGUI(numel, cooking);
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
	public PrendiOrdineGUI(Cameriere camerupt, Chef cookingMama) {
		initialize(camerupt, cookingMama);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Cameriere camerupt, Chef cookingMama) {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());

		
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
		comboBox.setBounds(268, 44, 123, 22);
		for (int i = 0; i < cookingMama.getMenu().getListaPiatti().size(); i++) {
			comboBox.addItem(cookingMama.getMenu().getListaPiatti().get(i));
		}
		frame.getContentPane().add(comboBox);
		
		//JComboBox<Piatto> comboBox = new JComboBox<Piatto>(new Vector<Piatto>(camerupt.getListaPiatti()));
		

		
		JTextPane txtpnScegliIlPiatto = new JTextPane();
		txtpnScegliIlPiatto.setBackground(SystemColor.menu);
		txtpnScegliIlPiatto.setText("Scegli il piatto da aggiungere all'ordine:");
		txtpnScegliIlPiatto.setEditable(false);
		txtpnScegliIlPiatto.setBounds(55, 44, 198, 20);
		frame.getContentPane().add(txtpnScegliIlPiatto);
		
		JTextPane txtpnScegliLaQunatit = new JTextPane();
		txtpnScegliLaQunatit.setBackground(SystemColor.menu);
		txtpnScegliLaQunatit.setText("Scegli la quantit\u00E0 da inserire:");
		txtpnScegliLaQunatit.setEditable(false);
		txtpnScegliLaQunatit.setBounds(55, 120, 198, 20);
		frame.getContentPane().add(txtpnScegliLaQunatit);
		
		int[] quantità = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					for (int x = 0; x <= comboBox_1.getSelectedIndex(); x++) {
						camerupt.aggiungiNellOrdine((Piatto) comboBox.getSelectedItem());
					}
					frame.dispose();
				}
			}
		});
		
		for (int k = 0; k < quantità.length; k++) {
			comboBox_1.addItem(quantità[k]);
		}
		
		comboBox_1.setBounds(268, 120, 60, 22);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("Aggiungi");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int x = 0; x <= comboBox_1.getSelectedIndex(); x++) {
					camerupt.aggiungiNellOrdine((Piatto) comboBox.getSelectedItem());
				}
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(55, 197, 100, 45);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}


