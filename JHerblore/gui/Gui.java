package JHerblore.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import JHerblore.enums.Potions;


public class Gui extends JFrame {

	 public static void main(String[] args)
	    {
	        javax.swing.SwingUtilities.invokeLater(new Runnable()
	        {
	            public void run()
	            {
	                Gui gui = new Gui();
	                gui.setVisible(true);
	            }
	        });
	    }
	

    public boolean guiWait = true;
    private JComboBox<Potions> potionComboBox;

    public Gui() // Gui for JHerbs
    {
    	setTitle("JAIOHerblore");
    	setResizable(false);
        setSize(401, 257);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        potionComboBox = new JComboBox<>();
        potionComboBox.setBounds(146, 47, 150, 22);
        getContentPane().add(potionComboBox);
        for (Potions p : Potions.values()) { // For each loop to add values to the Combobox 
            potionComboBox.addItem(p);
        }

        JLabel lblSelectedPotions = new JLabel("Selected Potion:");
        lblSelectedPotions.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSelectedPotions.setBounds(10, 49, 126, 14);
        getContentPane().add(lblSelectedPotions);
        
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() { // If I click on button then dispose(); happens. 
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        
        btnStart.setBounds(146, 166, 105, 23);
        getContentPane().add(btnStart); // Adds the start button 
   
    }
   
    public Potions getPotion()
    {
        return (Potions) potionComboBox.getSelectedItem();
    }
}

   