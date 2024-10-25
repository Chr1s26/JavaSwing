package ToDoListManager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListManager extends JFrame implements ActionListener {
	
	private JLabel taskLabel;
	private JTextField taskValue;
	
	private JButton taskButton;
	
	private DefaultListModel<String> taskListModel;
	private JList taskList;
	
	private JButton removeButton;
	private JButton clearButton;
	
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	
	public ToDoListManager() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		setTitle("To-Do List Manager");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		inputPanel = new JPanel();
		taskLabel = new JLabel("Task : ");
		taskValue = new JTextField(20);
		taskButton = new JButton("Add Task");
		taskButton.addActionListener(this);
		inputPanel.add(taskLabel);
		inputPanel.add(taskValue);
		inputPanel.add(taskButton);
		
		taskListModel = new DefaultListModel<>();
		taskList = new JList<>(taskListModel);
		scrollPane = new JScrollPane(taskList);
		
		buttonPanel = new JPanel();
		removeButton = new JButton("Remove Task");
		removeButton.addActionListener(this);
		clearButton = new JButton("Clear All");
		clearButton.addActionListener(this);
		buttonPanel.add(removeButton);
		buttonPanel.add(clearButton);
		
		add(inputPanel,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Add Task")) {
			String task = taskValue.getText().trim();
			if(!task.isEmpty()) {
				taskListModel.addElement(task);
				taskValue.setText("");
			}
			else {
				 JOptionPane.showMessageDialog(this, "Please enter a task.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(command.equals("Remove Task")) {
			int selectedIndex = taskList.getSelectedIndex();
			if(selectedIndex != -1) {
				taskListModel.remove(selectedIndex);
			}
			else {
				JOptionPane.showMessageDialog(this, "Please select a task to remove.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(command.equals("Clear All")){
			taskListModel.clear();
		}
		
	}
	
}
