import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.awt.SystemColor;




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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuGUI window = new MenuGUI(Luca, Cracco, cMenu, Bottura);
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
    public MenuGUI(Cameriere cameriere, Chef chef, Menu iMenu, Cuoco carlo) {
        initialize(cameriere, chef, iMenu, carlo);
    }
    

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Cameriere cameriere, Chef chef, Menu iMenu, Cuoco carlo) {
    	
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 700, 700);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        
        ImageIcon img = new ImageIcon("ShellKrustyKrab.png");
    	frame.setIconImage(img.getImage());
        
        JButton btnNewButton = new JButton("Esci");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon imgExit = new ImageIcon("ExitIcon.png");
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
        
        
        JButton btnNewButton_1 = new JButton("Chef");
        ImageIcon imgChef = new ImageIcon("Chef.png");
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
        ImageIcon imgCameriere = new ImageIcon("Posate.png");
        btnNewButton_2.setIcon(imgCameriere);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CameriereGUI.main(new String[0], cameriere, chef, carlo);
            }
        });
        btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_2.setBounds(454, 368, 135, 65);
        frame.getContentPane().add(btnNewButton_2);
        
        
        JButton btnNewButton_3 = new JButton("Cuoco");
        ImageIcon imgCuoco = new ImageIcon("Cuoco.png");
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
        ImageIcon imgCassa = new ImageIcon("Cassa.png");
        btnNewButton_4.setIcon(imgCassa);
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ResponsabileDiCassaGUI.main(new String[0]);
                
            }
        });
        btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_4.setBounds(454, 482, 135, 65);
        frame.getContentPane().add(btnNewButton_4);
        
        
        JButton btnNewButton_5 = new JButton("Aggiorna");
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
        btnNewButton_5.setBounds(538, 319, 89, 23);
        frame.getContentPane().add(btnNewButton_5);
        
        
        JTextPane txtpnMenu_1 = new JTextPane();
        txtpnMenu_1.setEditable(false);
        txtpnMenu_1.setBackground(SystemColor.menu);
        txtpnMenu_1.setText("MENU");
        txtpnMenu_1.setBounds(56, 34, 89, 20);
        frame.getContentPane().add(txtpnMenu_1);
        
        
    }
}