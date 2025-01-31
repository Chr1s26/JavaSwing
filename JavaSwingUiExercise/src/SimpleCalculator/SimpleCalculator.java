package SimpleCalculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator extends JFrame implements ActionListener {

	private JPanel panel;
	private JTextField answer;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] operatorButtons = new JButton[6];
	private String currentOperator;
	private double num1,num2;
	
	public SimpleCalculator() {
		calculatorUI();
	}
	
	public void calculatorUI() {
		initializeBaseFrame();
		initializeComponent();
	}

	public void initializeComponent() {
		answer = new JTextField();
		answer.setEditable(false);
		answer.setFont(new Font("Arial", Font.PLAIN, 36));
		this.add(answer, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,10,10));
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFont(new Font("Arial",Font.PLAIN,24));
			numberButtons[i].addActionListener(this);
		}
		
		operatorButtons[0] = new JButton("+");
		operatorButtons[1] = new JButton("-");
		operatorButtons[2] = new JButton("*");
		operatorButtons[3] = new JButton("/");
		operatorButtons[4] = new JButton("C");
		operatorButtons[5] = new JButton("=");
		
		for(int i = 0; i < 6; i++) {
			operatorButtons[i].setFont(new Font("Arial",Font.PLAIN,24));
			operatorButtons[i].addActionListener(this);
		}
		
		panel.add(numberButtons[7]);panel.add(numberButtons[8]);panel.add(numberButtons[9]);panel.add(operatorButtons[0]);
		panel.add(numberButtons[4]);panel.add(numberButtons[5]);panel.add(numberButtons[6]);panel.add(operatorButtons[1]);
		panel.add(numberButtons[1]);panel.add(numberButtons[2]);panel.add(numberButtons[3]);panel.add(operatorButtons[2]);
		panel.add(numberButtons[0]);panel.add(operatorButtons[4]);panel.add(operatorButtons[5]);panel.add(operatorButtons[3]);
		
		add(panel,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void initializeBaseFrame() {
		setTitle("Simple Calculator");
		setSize(400,600);
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		for(int i = 0; i <= 9; i++) {
			if(command.equals(String.valueOf(i))){
				answer.setText(answer.getText()+i);
			}
		}
		
		for(int i = 0;i < 4; i++) {
			if(command.equals(operatorButtons[i].getText())) {
				num1 = Double.parseDouble(answer.getText());
				currentOperator = command;
				answer.setText("");
			}
		}
		
		if(command.equals(operatorButtons[5].getText())) {
			num2 = Double.parseDouble(answer.getText());
			double result = 0;
			
			switch(currentOperator){
			 case "+":
                 result = num1 + num2;
                 break;
             case "-":
                 result = num1 - num2;
                 break;
             case "*":
                 result = num1 * num2;
                 break;
             case "/":
                 if (num2 != 0) {
                     result = num1 / num2;
                 } else {
                     answer.setText("Error: Div by 0");
                     return;
                 }
                 break;
			}
			answer.setText(String.valueOf(result));
  		}
		if(command.equals(operatorButtons[4].getText())) {
			answer.setText("");
			num1 = 0;
			num2 = 0;
			currentOperator = null;
		}
		
	}

}
