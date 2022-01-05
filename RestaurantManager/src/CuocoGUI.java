import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JPanel;

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
		ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
    	frame.getContentPane().setBackground(new Color(10,28,48));
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setBackground(new Color(223,182,127));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(110, 557, 135, 65);
		frame.getContentPane().add(btnNewButton);
		
		DefaultListModel<Ordine> model = new DefaultListModel<>();
		
		for (int i = 0; i < bCarlo.getOrdini().size(); i++) {
			model.addElement(bCarlo.getOrdini().get(i));
		}
		
		JList<Ordine> list = new JList<>(model);
		list.setForeground(new Color(255, 255, 255));
		list.setBounds(107, 83, 467, 299);
		list.setBackground(new Color(10,28,48));
		frame.getContentPane().add(list);
		
		
		JButton btnNewButton_1 = new JButton("Seleziona");
		btnNewButton_1.setBackground(new Color(223,182,127));
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
		
		JPanel panel = new JPanel();
		panel.setBounds(104, 80, 473, 306);
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(223,182,27)); 
		
		JLabel lblNewLabel = new JLabel("");
        ImageIcon imgCam = new ImageIcon("icons/Cuoco2.png");
        lblNewLabel.setIcon(imgCam);
        lblNewLabel.setBounds(190, 0, 357, 75);
        frame.getContentPane().add(lblNewLabel);
		
	}
}
