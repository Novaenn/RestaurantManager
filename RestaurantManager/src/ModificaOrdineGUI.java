import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModificaOrdineGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Cameriere numel, Chef cooking) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaOrdineGUI window = new ModificaOrdineGUI(numel, cooking);
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
	public ModificaOrdineGUI(Cameriere camerupt, Chef cookingMama) {
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
		ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
    	frame.getContentPane().setBackground(new Color(10,28,48));
    	
		JButton btnNewButton_1_1 = new JButton("Annulla");
		btnNewButton_1_1.setBackground(new Color(223,182,127));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1_1.setBounds(291, 197, 100, 45);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(223,182,127));
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					camerupt.rimuoviNellOrdine((Piatto) comboBox.getSelectedItem());
					//System.out.println(camerupt.ordine.toString());
					frame.dispose();
				}
			}
		});
		comboBox.setToolTipText("Scegli un piatto da ordinare");
		comboBox.setBounds(160, 77, 123, 22);
		for (int i = 0; i < camerupt.ordine.getPiattiOrdinati().size(); i++) {
			comboBox.addItem(camerupt.ordine.getPiattiOrdinati().get(i));
		}
		frame.getContentPane().add(comboBox);
		
		//JComboBox<Piatto> comboBox = new JComboBox<Piatto>(new Vector<Piatto>(camerupt.getListaPiatti()));
		
		JButton btnNewButton_1 = new JButton("Rimuovi");
		btnNewButton_1.setBackground(new Color(223,182,127));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					camerupt.rimuoviNellOrdine((Piatto) comboBox.getSelectedItem());
					//System.out.println(camerupt.ordine.toString());
					frame.dispose();
				}
				catch (Exception ex) {
					
				}
			}
		});
		btnNewButton_1.setBounds(55, 197, 100, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnScegliIlPiatto = new JTextPane();
		txtpnScegliIlPiatto.setForeground(new Color(255, 255, 255));
		txtpnScegliIlPiatto.setBackground(SystemColor.menu);
		txtpnScegliIlPiatto.setText("Scegli il piatto da rimuovere dall'ordine:");
		txtpnScegliIlPiatto.setEditable(false);
		txtpnScegliIlPiatto.setBounds(132, 35, 198, 20);
		txtpnScegliIlPiatto.setBackground(new Color(10,28,48));
		frame.getContentPane().add(txtpnScegliIlPiatto);
	}
}
