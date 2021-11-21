package _05_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /* 
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons. 
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list. 
     */

	public static void main(String[] args) {
		_02_LogSearch logSearch = new _02_LogSearch();
		logSearch.setup();
	}
	
	HashMap<Integer, String> logSearch = new HashMap<Integer, String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton("add entry");
	JButton searchByID = new JButton("search by ID");
	JButton viewList = new JButton("view list");
	JButton removeEntry = new JButton("remove entry");
	
	void setup() {
	addEntry.addActionListener(this);
	searchByID.addActionListener(this);
	viewList.addActionListener(this);
	removeEntry.addActionListener(this);
	
	frame.setSize(400, 400);
	
	panel.add(addEntry);
	panel.add(searchByID);
	panel.add(viewList);
	panel.add(removeEntry);
	
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (addEntry == e.getSource()) {
			String entry = JOptionPane.showInputDialog("Enter an ID number:");
			System.out.println(entry);
			String name = JOptionPane.showInputDialog("Enter a name:");
			System.out.println(name);
			logSearch.put(Integer.parseInt(entry), name);
		}
		
		if (searchByID == e.getSource()) {
			String ID = JOptionPane.showInputDialog("Enter an ID number:");
			if(logSearch.containsKey(Integer.parseInt(ID))) {
				System.out.println("The name of this user is: ");
				System.out.println(logSearch.get(Integer.parseInt(ID)));
			}
			else {
				System.out.println("The ID entered does not exist");
			}
			}
		
		if (viewList == e.getSource()) {
			for (Integer i : logSearch.keySet()) {
				System.out.println("ID: " + i + " Name: " + logSearch.get(i));
			}
		}
		
		if (removeEntry == e.getSource()) {
			String remove = JOptionPane.showInputDialog("Enter an ID number:");
			if(logSearch.containsKey(Integer.parseInt(remove))) {
				logSearch.remove(Integer.parseInt(remove));
			}
				else {
					System.out.println("The ID entered does not exist");
				}
			}
			
		}
		}
		
	

