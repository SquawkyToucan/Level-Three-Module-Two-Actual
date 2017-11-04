package intro_to_file_io;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList implements MouseListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	ArrayList<String> tasks = new ArrayList<String>();
	ToDoList() {
		//Add to panel
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		//Set Text
		add.setText("Add a new task");
		remove.setText("Remove a task");
		save.setText("Save your to-do list");
		load.setText("Load a to-do list");
		//Frame
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		//Add listener
		panel.addMouseListener(this);
		add.addMouseListener(this);
		remove.addMouseListener(this);
		save.addMouseListener(this);
		load.addMouseListener(this);
	}
	public static void main(String[] args) {
		new ToDoList();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object buttonPressed = e.getSource();
		if(buttonPressed == add) {
			String taskToAdd = JOptionPane.showInputDialog("Please type in the task you would like to add.");
			tasks.add(taskToAdd);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
