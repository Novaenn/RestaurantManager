import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CameriereGUI {

    private JFrame frmCameriere;

    /**
     * Launch the application.
     */
    public static void main(String[] args, Cameriere camy, Chef mama, Cuoco carloBottura, ResponsabileDiCassa Jasmin) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CameriereGUI window = new CameriereGUI(camy, mama, carloBottura, Jasmin);
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
    public CameriereGUI(Cameriere camy, Chef cooking, Cuoco carloB, ResponsabileDiCassa Jasmin) {
        initialize(camy, cooking, carloB, Jasmin);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Cameriere camy, Chef cooking, Cuoco carloB, ResponsabileDiCassa Jasmin) {
    	frmCameriere = new JFrame();
    	frmCameriere.getContentPane().setBackground(new Color(10,28,48));
    	frmCameriere.setResizable(false);
    	frmCameriere.setBounds(100, 100, 700, 700);
    	frmCameriere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frmCameriere.getContentPane().setLayout(null);
    	ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frmCameriere.setIconImage(img.getImage());
        
        
        DefaultListModel<Piatto> model = new DefaultListModel<>();
        
        for (int x = 0; x < camy.ordine.getPiattiOrdinati().size(); x++) {
        	model.addElement(camy.ordine.getPiattiOrdinati().get(x));
        }
        
        JList<Piatto> list = new JList<>(model);
        list.setFocusable(false);
        list.setForeground(new Color(255, 255, 255));
        list.setBounds(169, 191, 357, 278);
        frmCameriere.getContentPane().add(list);
        list.setBackground(new Color(10,28,48));
        
        JButton btnNewButton_4 = new JButton("Controlla ordine");
        btnNewButton_4.setBackground(new Color(223,182,127));
        btnNewButton_4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		model.removeAllElements();
        		
        		for (int x = 0; x < camy.ordine.getPiattiOrdinati().size(); x++) {
                	model.addElement(camy.ordine.getPiattiOrdinati().get(x));
                }
                
                JList<Piatto> list = new JList<>(model);
                list.setBounds(169, 191, 357, 278);
                frmCameriere.getContentPane().add(list);
                list.setBackground(new Color(10,28,48));
                
        	}
        });
        btnNewButton_4.setBounds(286, 480, 128, 45);
        frmCameriere.getContentPane().add(btnNewButton_4);
        
        JPanel panel = new JPanel();
        panel.setBounds(165, 187, 365, 286);
        frmCameriere.getContentPane().add(panel);
        panel.setBackground(new Color(223,182,27));
        
        
        JButton btnNewButton = new JButton("Indietro");
        btnNewButton.setBackground(new Color(223,182,127));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmCameriere.dispose();
            }
        });
        btnNewButton.setBounds(81, 518, 135, 65);
        frmCameriere.getContentPane().add(btnNewButton);
       
        
        JButton btnNewButton_1 = new JButton("Finalizza");
        
        ImageIcon imgNull = new ImageIcon("");
        ImageIcon imgDone = new ImageIcon("icons/Done.png");
        btnNewButton_1.setIcon(imgNull);
        btnNewButton_1.setBackground(new Color(223,182,127));
        
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if (camy.ordine.getPiattiOrdinati().size() > 0) {
        			
        			model.removeAllElements();
        			
        			int referenceNumber = camy.ordine.getNum();
	        		
        			btnNewButton_1.setIcon(imgDone);
	        		
	        		Ordine daAggiungere = new Ordine();
	        		
	        		for (Piatto p : camy.ordine.getPiattiOrdinati()) {
	        			daAggiungere.addPiattoOrdinato(p);
	        		}
	        		daAggiungere.setNum(referenceNumber);
	        		
	        		carloB.addOrdine(daAggiungere);
	        		Jasmin.addOrdineDaPagare(daAggiungere);
	        		
	        		camy.finalizzaOrdine();
	        		
        		}
        		
        		
        	}
        });
        btnNewButton_1.setBounds(479, 518, 135, 65);
        frmCameriere.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Prendi ordine");
        btnNewButton_2.setBackground(new Color(223,182,127));
        btnNewButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		btnNewButton_1.setIcon(imgNull);
        		
        		PrendiOrdineGUI.main(new String[0], camy, cooking);
        	}
        });
        btnNewButton_2.setBounds(81, 88, 128, 65);
        frmCameriere.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Modifica Ordine");
        btnNewButton_3.setBackground(new Color(223,182,127));
        btnNewButton_3.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		ModificaOrdineGUI.main(new String[0], camy, cooking);
        	}
        });
        btnNewButton_3.setBounds(486, 88, 128, 65);
        frmCameriere.getContentPane().add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("");
        ImageIcon imgCam = new ImageIcon("icons/Cameriere.png");
        lblNewLabel.setIcon(imgCam);
        lblNewLabel.setBounds(198, 0, 357, 75);
        frmCameriere.getContentPane().add(lblNewLabel);
        
        
        
        
    }
}