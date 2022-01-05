import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class ListaPiattiGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Ordine ordine, Cuoco cuoco) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPiattiGUI window = new ListaPiattiGUI(ordine, cuoco);
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
	public ListaPiattiGUI(Ordine ordine, Cuoco cuoco) {
		initialize(ordine, cuoco);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Ordine ordine, Cuoco cuoco) {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(10,28,48));
		
		ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
		
		DefaultListModel<Piatto> model = new DefaultListModel<>();
		
		for (int i = 0; i < ordine.getPiattiOrdinati().size(); i++) {
			model.addElement(ordine.getPiattiOrdinati().get(i));
			
		}
		JList<Piatto> list = new JList<>(model);
		list.setForeground(new Color(255, 255, 255));
		list.setBounds(26, 23, 496, 280);
		list.setBackground(new Color(10,28,48));
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Elimina");
		btnNewButton.setBackground(new Color(223,182,127));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ordine.addPiattoScontrino(ordine.getPiattiOrdinati().get(list.getSelectedIndex()));
					ordine.removePiattoOrdinato(ordine.getPiattiOrdinati().get(list.getSelectedIndex()));
					model.removeElementAt(list.getSelectedIndex());
					if (ordine.getPiattiOrdinati().size() == 0) {
						cuoco.cancellaOrdine(ordine);
						CuocoGUI.main(null, cuoco);
						frame.dispose();
					}
				}
				catch (Exception ex) {
				}
			
			}
		});
		btnNewButton.setBounds(353, 330, 114, 54);
		
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.setBackground(new Color(223,182,127));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CuocoGUI.main(null, cuoco);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(70, 330, 114, 54);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 19, 504, 289);
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(223,182,27));
	}

}

