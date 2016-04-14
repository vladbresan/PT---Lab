package GUI;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Operations.OpWith1Term;
import Operations.OpWith2Terms;
import Polynomial.Polynom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*Graphic User Interface . This class creates the frame ,text fields,
 *  panels, the buttons , labels and the action listeners for each button. 
 *  In each action listener methods from the other classes are called in
 *  order to perform the specific action that button is meant for*/
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblFx;
	private JLabel lblGx;
	private JButton btnSubmit;
	private JButton btnFx;
	private JButton btnGx;
	private JButton btnFx_1;
	private JButton btnGx_1;
	private JLabel lblDefiniteIntegral;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField textField_2;
	private JLabel label;
	private JButton button;
	private JButton button_1;
	private JPanel panel;
	private JLabel label_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label_2;
	private JButton button_2;
	private JButton button_3;
	private JPanel panel_1;
	private JButton btnFxGx;
	private JPanel panel_5;
	private JButton btnFxGx_1;
	private JButton btnGxFx;
	private JPanel panel_6;
	private JButton btnFxGx_2;
	private JButton btnGxFx_1;
	private JPanel panel_7;
	private JButton btnFxGx_3;
	private JPanel panel_8;
	private JButton btnFxGx_4;
	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblNewLabel;
	private JTextField textField_5;
	private JLabel lblTudorVladBresan;
	private JLabel lblGroup;
	private JLabel lblTechnicalUniversityOf;
	private JPanel panel_11;
	private JLabel label_3;
	Polynom p1 = new Polynom(0, 0);
	Polynom p2 = new Polynom(0, 0);
	Polynom rez = new Polynom(0, 0);
	OpWith2Terms op2 = new OpWith2Terms();
	OpWith1Term op1 = new OpWith1Term();
	double x = 0;
	int a = 0;
	int b = 0;
	double res = 0;
	boolean ok = false;
	String string1, string2;

	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		this.setTitle("Polynomials");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(64, 25, 541, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(64, 67, 541, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblFx = new JLabel("f(x)");
		lblFx.setBounds(23, 33, 29, 14);
		contentPane.add(lblFx);

		lblGx = new JLabel("g(x)");
		lblGx.setBounds(23, 75, 31, 14);
		contentPane.add(lblGx);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string1 = textField.getText();
				string2 = textField_1.getText();
				p1 = p1.parseToPoly(string1);
				p2 = p2.parseToPoly(string2);
				textField_5.setText("Please select an operation");
			}
		});
		btnSubmit.setBounds(615, 33, 159, 56);
		contentPane.add(btnSubmit);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Operations on one Polynomial", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_2.setBounds(34, 120, 250, 340);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Derivative", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 20, 230, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		btnFx = new JButton("f'(x)");
		btnFx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1 = p1.parseToPoly(string1);
				rez = op1.diff(p1);
				textField_5.setText(rez.toString());
			}
		});
		btnFx.setBounds(6, 16, 100, 23);
		panel_3.add(btnFx);

		btnGx = new JButton("g'(x)");
		btnGx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op1.diff(p2);
				textField_5.setText(rez.toString());
			}
		});
		btnGx.setBounds(116, 16, 100, 23);
		panel_3.add(btnGx);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Antiderivative", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(6, 81, 230, 50);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		btnFx_1 = new JButton("F(x)");
		btnFx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op1.integr(p1);
				textField_5.setText(rez.toString());
			}
		});
		btnFx_1.setBounds(6, 16, 100, 23);
		panel_4.add(btnFx_1);

		btnGx_1 = new JButton("G(x)");
		btnGx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op1.integr(p2);
				textField_5.setText(rez.toString());
			}
		});
		btnGx_1.setBounds(116, 16, 100, 23);
		panel_4.add(btnGx_1);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Evaluation at point x", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 142, 230, 70);
		panel_2.add(panel);
		panel.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(70, 16, 150, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		label = new JLabel("Input x :");
		label.setBounds(10, 19, 59, 14);
		panel.add(label);

		button = new JButton("f(x)");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = Double.parseDouble(textField_2.getText());
				res = op1.evaluate(p1, x);
				textField_5.setText(Double.toString(res));
			}
		});
		button.setBounds(20, 41, 92, 23);
		panel.add(button);

		button_1 = new JButton("g(x)");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = Double.parseDouble(textField_2.getText());
				res = op1.evaluate(p2, x);
				textField_5.setText(Double.toString(res));
			}
		});
		button_1.setBounds(128, 41, 92, 23);
		panel.add(button_1);

		panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Definite Integral", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 210, 230, 101);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		label_1 = new JLabel("Input a :");
		label_1.setBounds(6, 19, 52, 14);
		panel_1.add(label_1);

		textField_3 = new JTextField();
		textField_3.setBounds(68, 16, 152, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(68, 41, 152, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		label_2 = new JLabel("Input b :");
		label_2.setBounds(6, 44, 52, 14);
		panel_1.add(label_2);

		button_2 = new JButton("F(x)");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(textField_3.getText());
				b = Integer.parseInt(textField_4.getText());
				res = op1.integrAtoB(p1, a, b);
				textField_5.setText(Double.toString(res));
			}
		});
		button_2.setBounds(20, 66, 92, 23);
		panel_1.add(button_2);

		button_3 = new JButton("G(x)");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(textField_3.getText());
				b = Integer.parseInt(textField_4.getText());
				res = op1.integrAtoB(p2, a, b);
				textField_5.setText(Double.toString(res));
			}
		});
		button_3.setBounds(128, 66, 92, 23);
		panel_1.add(button_3);

		lblDefiniteIntegral = new JLabel("Definite Integral");
		lblDefiniteIntegral.setBounds(99, 384, 78, 14);
		contentPane.add(lblDefiniteIntegral);

		panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Operations on two Polynomials", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_10.setBounds(294, 120, 250, 340);
		contentPane.add(panel_10);
		panel_10.setLayout(null);

		panel_5 = new JPanel();
		panel_5.setBounds(10, 22, 227, 55);
		panel_10.add(panel_5);
		panel_5.setBorder(new TitledBorder(null, "Addition", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setLayout(null);

		btnFxGx = new JButton("f(x) + g(x)");
		btnFxGx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op2.add(p1, p2);
				textField_5.setText(rez.toString());
			}
		});
		btnFxGx.setBounds(72, 21, 89, 23);
		panel_5.add(btnFxGx);

		panel_6 = new JPanel();
		panel_6.setBounds(10, 79, 227, 55);
		panel_10.add(panel_6);
		panel_6.setBorder(new TitledBorder(null, "Substraction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setLayout(null);

		btnFxGx_1 = new JButton("f(x) - g(x)");
		btnFxGx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op2.sub(p1, p2);
				textField_5.setText(rez.toString());
			}
		});
		btnFxGx_1.setBounds(10, 21, 89, 23);
		panel_6.add(btnFxGx_1);

		btnGxFx = new JButton("g(x) - f(x)");
		btnGxFx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op2.sub(p2, p1);
				textField_5.setText(rez.toString());
			}
		});
		btnGxFx.setBounds(128, 21, 89, 23);
		panel_6.add(btnGxFx);

		panel_7 = new JPanel();
		panel_7.setBounds(10, 136, 227, 55);
		panel_10.add(panel_7);
		panel_7.setBorder(new TitledBorder(null, "Division", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setLayout(null);

		btnFxGx_2 = new JButton("f(x) / g(x)");
		btnFxGx_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p1.degree < p2.degree || p2.degree == 0)
					textField_5.setText("Invalid operation. Division by 0 or grade of g(x)> grade of f(x)");
				else {
					rez = op2.div(p1, p2);
					textField_5.setText("Quotient: " + rez.toString() + "   Remainder: " + p1.toString());
				}
				p1 = p1.parseToPoly(string1);
			}
		});
		btnFxGx_2.setBounds(10, 21, 89, 23);
		panel_7.add(btnFxGx_2);

		btnGxFx_1 = new JButton("g(x) / f(x)");
		btnGxFx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p2.degree < p1.degree || p1.degree == 0)
					textField_5.setText("Invalid operation. Division by 0 or grade of f(x)> grade of g(x)");
				else {
					rez = op2.div(p2, p1);
					textField_5.setText("Quotient: " + rez.toString() + "   Remainder: " + p2.toString());
				}
				p2 = p2.parseToPoly(string2);
			}
		});
		btnGxFx_1.setBounds(128, 21, 89, 23);
		panel_7.add(btnGxFx_1);

		panel_8 = new JPanel();
		panel_8.setBounds(10, 208, 227, 55);
		panel_10.add(panel_8);
		panel_8.setBorder(new TitledBorder(null, "Multiplication", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setLayout(null);

		btnFxGx_3 = new JButton("f(x) * g(x)");
		btnFxGx_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rez = op2.mul(p1, p2);
				textField_5.setText(rez.toString());
			}
		});
		btnFxGx_3.setBounds(73, 21, 89, 23);
		panel_8.add(btnFxGx_3);

		panel_9 = new JPanel();
		panel_9.setBounds(10, 274, 227, 55);
		panel_10.add(panel_9);
		panel_9.setBorder(
				new TitledBorder(null, "Is f(x) equal to g(x)?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setLayout(null);

		btnFxGx_4 = new JButton("f(x) = g(x)");
		btnFxGx_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok = op2.equality(p1, p2);
				textField_5.setText(String.valueOf(ok));
			}
		});
		btnFxGx_4.setBounds(73, 21, 89, 23);
		panel_9.add(btnFxGx_4);

		lblNewLabel = new JLabel("Output");
		lblNewLabel.setBounds(34, 497, 46, 14);
		contentPane.add(lblNewLabel);

		textField_5 = new JTextField();
		textField_5.setBounds(91, 489, 541, 31);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Credits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(554, 160, 220, 94);
		contentPane.add(panel_11);
		panel_11.setLayout(null);

		lblTudorVladBresan = new JLabel("Tudor Vlad Bresan");
		lblTudorVladBresan.setBounds(6, 24, 175, 14);
		panel_11.add(lblTudorVladBresan);

		lblGroup = new JLabel("Group 30423");
		lblGroup.setBounds(6, 49, 175, 14);
		panel_11.add(lblGroup);

		lblTechnicalUniversityOf = new JLabel("Technical University of Cluj Napoca");
		lblTechnicalUniversityOf.setBounds(6, 74, 204, 14);
		panel_11.add(lblTechnicalUniversityOf);

		label_3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/sigla.png")).getImage();
		label_3.setIcon(new ImageIcon(img));
		label_3.setBounds(578, 265, 175, 175);
		contentPane.add(label_3);

		JButton btnClearOutputField = new JButton("Clear output field");
		btnClearOutputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_5.setText("");
			}
		});
		btnClearOutputField.setBounds(634, 493, 140, 23);
		contentPane.add(btnClearOutputField);

		JLabel lblInputExamplexxx = new JLabel("Input example: 3x^3-10x^2+1x^0+1x^10");
		lblInputExamplexxx.setBounds(10, 547, 764, 14);
		contentPane.add(lblInputExamplexxx);

		JLabel lblOrderOfMonomials = new JLabel(
				"Order of monomials does not matter as long as they have x^power. No spacing allowed between monomials i.e. 3x^3 -10x^2 +1x^0");
		lblOrderOfMonomials.setBounds(10, 566, 764, 14);
		contentPane.add(lblOrderOfMonomials);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 586, 46, 14);
		contentPane.add(label_4);
	}
}
