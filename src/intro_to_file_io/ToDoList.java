package intro_to_file_io;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList implements MouseListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton viewList = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	static ArrayList<String> tasks = new ArrayList<String>();
	ToDoList() {
		//Add to panel
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		panel.add(viewList);
		//Set Text
		add.setText("Add a new task");
		remove.setText("Remove a task");
		save.setText("Save your to-do list");
		load.setText("Load a to-do list");
		viewList.setText("View the to-do list");
		//Frame
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		//Add listener
		viewList.addMouseListener(this);
		panel.addMouseListener(this);
		add.addMouseListener(this);
		remove.addMouseListener(this);
		save.addMouseListener(this);
		load.addMouseListener(this);
	}
	public static void main(String[] args) {
		loadList();
		JOptionPane.showMessageDialog(null, tasks.toString());
		new ToDoList();
	}
	public static void loadList() {
		for(int i = 0; i < tasks.size(); i++) {
			tasks.remove(i);
		}
		try {
			BufferedReader read = new BufferedReader(new FileReader("src/intro_to_file_io/To-Do List"));
			for(int i = 0; i < 100; i++) {
				String temp = read.readLine();
				if(temp != null) {
					tasks.add(temp);
				}
				else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			System.out.println("Task added: " + taskToAdd);
		}
		if(buttonPressed == viewList) {
			JOptionPane.showMessageDialog(null, tasks.toString());
		}
		if(buttonPressed == remove) {
			JOptionPane.showMessageDialog(null, "Here's a list of all of your items on the to do list:\n" + tasks.toString() + "\nBe prepared to type in the one that is being removed.");
			tasks.remove(JOptionPane.showInputDialog("What is the name of the object?"));
		}
		if(buttonPressed == save) {
			try {
				FileWriter write = new FileWriter(new File("src/intro_to_file_io/To-Do List"));
				for(int i = 0; i < tasks.size(); i++) {
					write.write(tasks.get(i)+"\n");
				}
				write.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(buttonPressed == load) {
			loadList();
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
