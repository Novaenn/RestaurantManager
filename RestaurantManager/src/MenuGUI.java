import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Font;




public class MenuGUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	Menu cMenu = new Menu();
    	Chef Cracco = new Chef(cMenu);
        Cameriere Luca = new Cameriere();
        Cuoco Bottura = new Cuoco();
        ResponsabileDiCassa John = new ResponsabileDiCassa();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuGUI window = new MenuGUI(Luca, Cracco, cMenu, Bottura, John);
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
    public MenuGUI(Cameriere cameriere, Chef chef, Menu iMenu, Cuoco carlo, ResponsabileDiCassa John) {
        initialize(cameriere, chef, iMenu, carlo, John);
    }
    

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Cameriere cameriere, Chef chef, Menu iMenu, Cuoco carlo, ResponsabileDiCassa John) {
    	
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 700, 700);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(10,28,48));
        
        
        ImageIcon img = new ImageIcon("icons/ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
        
        JButton btnNewButton = new JButton("Esci");
        btnNewButton.setBackground(new Color(223, 182, 127));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon imgExit = new ImageIcon("icons/ExitIcon.png");
        btnNewButton.setIcon(imgExit);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        btnNewButton.setBounds(278, 582, 125, 55);
        frame.getContentPane().add(btnNewButton);
        
        
        JTextPane txtpnMenu = new JTextPane();
        txtpnMenu.setFont(new Font("Segoe Script", Font.PLAIN, 13));
        txtpnMenu.setForeground(new Color(255, 255, 255));
        txtpnMenu.setEditable(false);
        
        String menuString = "";
        
        try {
	        Scanner fileIn = new Scanner(new File("MenuCartaceo.txt"));
	        while (fileIn.hasNext()) {
	        	menuString += fileIn.nextLine() + "\n";
	        }
	        fileIn.close();
        }
        catch (IOException e) {
			e.getMessage();
		}
        
        
        txtpnMenu.setText(menuString);
        txtpnMenu.setBounds(56, 67, 571, 253);
        frame.getContentPane().add(txtpnMenu);
        txtpnMenu.setBackground(new Color(10,28,48));
        
        
        JButton btnNewButton_1 = new JButton("Chef   ");
        btnNewButton_1.setBackground(new Color(223,182,127));
        ImageIcon imgChef = new ImageIcon("icons/Chef.png");
        btnNewButton_1.setIcon(imgChef);
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChefGUI.main(new String[0], chef);
                  
            }
        });
        btnNewButton_1.setBounds(82, 368, 135, 65);
        frame.getContentPane().add(btnNewButton_1);
        JButton btnNewButton_2 = new JButton("Cameriere");
        btnNewButton_2.setToolTipText("Cameriere");
        btnNewButton_2.setBackground(new Color(223,182,127));
        ImageIcon imgCameriere = new ImageIcon("icons/Posate.png");
        btnNewButton_2.setIcon(imgCameriere);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CameriereGUI.main(new String[0], cameriere, chef, carlo, John);
            }
        });
        btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_2.setBounds(467, 368, 135, 65);
        frame.getContentPane().add(btnNewButton_2);
        
        
        JButton btnNewButton_3 = new JButton("Cuoco");
        ImageIcon imgCuoco = new ImageIcon("icons/Cuoco.png");
        btnNewButton_3.setBackground(new Color(223,182,127));
        btnNewButton_3.setIcon(imgCuoco);
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CuocoGUI.main(new String[0], carlo);
                
            }
        });
        btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_3.setBounds(82, 482, 135, 65);
        frame.getContentPane().add(btnNewButton_3);
        
        
        JButton btnNewButton_4 = new JButton("Responsabile di cassa");
        btnNewButton_4.setToolTipText("Responsabile di cassa");
        ImageIcon imgCassa = new ImageIcon("icons/Cassa.png");
        btnNewButton_4.setBackground(new Color(223,182,127));
        btnNewButton_4.setIcon(imgCassa);
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ResponsabileDiCassaGUI.main(new String[0], John);
                
            }
        });
        btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_4.setBounds(467, 482, 135, 65);
        frame.getContentPane().add(btnNewButton_4);
        
        
        JButton btnNewButton_5 = new JButton("Aggiorna");
        btnNewButton_5.setBackground(new Color(223,182,127));
        btnNewButton_5.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        		String menu_String = "";
        		for(Piatto a : iMenu.getListaPiatti()){
        			menu_String += a.toString() + "\n";
                }
        		txtpnMenu.setText(menu_String);
        	}
        });
        btnNewButton_5.setBounds(293, 331, 89, 23);
        frame.getContentPane().add(btnNewButton_5);
        
        JPanel panel = new JPanel();
        panel.setBounds(52, 63, 579, 261);
        frame.getContentPane().add(panel);
        panel.setBackground(new Color(223,182,27));
        
        ImageIcon imgMenu = new ImageIcon("icons/Menu2.png");
        
        JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(263, -6, 229, 74);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(imgMenu);
        
        
    }
}