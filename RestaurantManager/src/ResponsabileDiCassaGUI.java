import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JPanel;

public class ResponsabileDiCassaGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ResponsabileDiCassa Jasmin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponsabileDiCassaGUI window = new ResponsabileDiCassaGUI(Jasmin);
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
	public ResponsabileDiCassaGUI(ResponsabileDiCassa Jasmin) {
		initialize(Jasmin);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ResponsabileDiCassa Jasmin) {
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
		btnNewButton.setBounds(91, 548, 135, 65);
		frame.getContentPane().add(btnNewButton);
		
		
		DefaultListModel<Ordine> model = new DefaultListModel<>();
		
		for (int i = 0; i < Jasmin.getOrdiniDaPagare().size(); i++) {
			model.addElement(Jasmin.getOrdiniDaPagare().get(i));
			
		}
		
		JList<Ordine> list = new JList<>(model);
		list.setForeground(new Color(255, 255, 255));
		list.setBounds(77, 81, 544, 353);
		list.setBackground(new Color(10,28,48));
		frame.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Genera Scontrino");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int index = list.getSelectedIndex();
					if (Jasmin.getOrdiniDaPagare().get(index).getPiattiOrdinati().size() == 0) {					
						model.removeElement(Jasmin.getOrdiniDaPagare().get(index));
						Jasmin.creaScontrino(Jasmin.getOrdiniDaPagare().get(index));
					}
					else {
						ErrorGUI2.main(null);
					}
				}
				catch (Exception ex) {
					
				}
			}
		});
		btnNewButton_1.setBounds(474, 548, 135, 65);
		btnNewButton_1.setBackground(new Color(223,182,127));
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(73, 76, 552, 363);
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(223,182,27));
		
		JLabel lblNewLabel = new JLabel("");
        ImageIcon imgCam = new ImageIcon("icons/Resp.png");
        lblNewLabel.setIcon(imgCam);
        lblNewLabel.setBounds(101, 0, 486, 75);
        frame.getContentPane().add(lblNewLabel);
		
	}
}
