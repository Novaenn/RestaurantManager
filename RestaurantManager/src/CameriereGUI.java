import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class CameriereGUI {

    private JFrame frmCameriere;

    /**
     * Launch the application.
     */
    public static void main(String[] args, Cameriere camy) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CameriereGUI window = new CameriereGUI(camy);
                    window.frmCameriere.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CameriereGUI(Cameriere camy) {
        initialize(camy);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Cameriere camy) {
    	frmCameriere = new JFrame();
    	frmCameriere.setResizable(false);
    	frmCameriere.setBounds(100, 100, 700, 700);
    	frmCameriere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frmCameriere.getContentPane().setLayout(null);
        
        JTextPane txtpnCameriere = new JTextPane();
        txtpnCameriere.setEditable(false);
        txtpnCameriere.setFont(new Font("Tahoma", Font.PLAIN, 21));
        txtpnCameriere.setText("                                         CAMERIERE");
        txtpnCameriere.setBounds(0, 0, 694, 45);
        frmCameriere.getContentPane().add(txtpnCameriere);
        
        JButton btnNewButton = new JButton("Indietro");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuGUI.main(new String[0]);
                frmCameriere.dispose();
            }
        });
        btnNewButton.setBounds(81, 510, 135, 65);
        frmCameriere.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Finalizza");
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		camy.finalizzaOrdine();
        	}
        });
        btnNewButton_1.setBounds(473, 510, 135, 65);
        frmCameriere.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Prendi ordine");
        btnNewButton_2.setBounds(81, 88, 128, 65);
        frmCameriere.getContentPane().add(btnNewButton_2);
        
        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(btnNewButton_2, popupMenu);
        
        
    }
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}