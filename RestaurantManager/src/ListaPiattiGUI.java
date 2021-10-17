import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		
		DefaultListModel<Piatto> model = new DefaultListModel<>();
		
		for (int i = 0; i < ordine.getPiattiOrdinati().size(); i++) {
			model.addElement(ordine.getPiattiOrdinati().get(i));
			
		}
		JList<Piatto> list = new JList<>(model);
		list.setBounds(26, 23, 496, 280);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Elimina");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
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
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(70, 330, 114, 54);
		frame.getContentPane().add(btnNewButton_1);
	}

}
