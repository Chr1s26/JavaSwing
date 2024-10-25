package StudentRegistrationForm;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationForm extends JFrame implements ActionListener {
	
	private JLabel nameLabel;
	private JTextField nameValue;
	
	private JLabel emailLabel;
	private JTextField emailValue;
	
	private JLabel phoneLabel;
	private JTextField phoneValue;
	
	private JLabel genderLabel;
	private JRadioButton option1,option2;
	
	private JLabel courseLabel;
	private JComboBox<String> courseValue;
	
	private JLabel termLabel;
	private JCheckBox termValue;
	
	private JButton submitButton;
	
	public RegistrationForm() {
		
		setTitle("Student Registration Form");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,2,10,10));
		
		
		nameLabel = new JLabel("Name : ");
		nameValue = new JTextField();
		add(nameLabel);add(nameValue);
		
		
		emailLabel = new JLabel("Email : ");
		emailValue = new JTextField();
		add(emailLabel);add(emailValue);
		
		
		phoneLabel = new JLabel("Phone : ");
		phoneValue = new JTextField();
		add(phoneLabel);add(phoneValue);
		
		
		genderLabel = new JLabel("Gender : ");
		option1 = new JRadioButton("Male");
		option2 = new JRadioButton("Female");
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(option1);
		genderGroup.add(option2);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(option1);
		panel.add(option2);
		add(genderLabel);add(panel);
		
 		
		courseLabel = new JLabel("Course : ");
		String[] options = {"Java","Python","C++"};
		courseValue = new JComboBox<String>(options);
		add(courseLabel);add(courseValue);
		
		
		termLabel = new JLabel("Accept Terms : ");
		termValue = new JCheckBox("Accept Terms And Conditions");
		add(termLabel);add(termValue);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		add(submitButton);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(nameValue.getText().isEmpty() || emailValue.getText().isEmpty() || phoneValue.getText().isEmpty() || (!option1.isSelected() && !option2.isSelected())||!termValue.isSelected()) {
			JOptionPane.showMessageDialog(this, "Please fill all fields and accept the terms.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			String gender;
			if(option1.isSelected()) {
				gender = "Male";
			}
			else {
				gender = "Female";
			}
			String course = (String) courseValue.getSelectedItem();
			String message = "Name : "+nameValue.getText()+"\nEmail : "+emailValue.getText()+"\nPhone : "+phoneValue.getText()+"\nGender : "+gender+"\nCourse : "+course;
			
			JOptionPane.showMessageDialog(this, message, "Student Details", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
