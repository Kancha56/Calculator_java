package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main
{
	private static JPanel panel;
	private static double firstnum;
	private static String operation;

	public static void main(String[] args)
	{

		JFrame frame = new JFrame("Calculator");
		frame.setSize(350, 500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.decode("#6D6D6D"));

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		p.setBackground(null);

		JLabel label = new JLabel("0");
		label.setOpaque(true);
		label.setBackground(Color.decode("#E0E0E0"));
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		p.add(label, BorderLayout.CENTER);

		panel = new JPanel(new GridLayout(5, 4, 15, 15));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		JButton on = btn("ON");
		on.setEnabled(false);

		JButton off = btn("OFF");
		JButton ac = btn("AC");
		JButton divide = btn("/");
		JButton btn7 = btn("7");
		JButton btn8 = btn("8");
		JButton btn9 = btn("9");
		JButton mul = btn("X");
		JButton btn4 = btn("4");
		JButton btn5 = btn("5");
		JButton btn6 = btn("6");
		JButton minus = btn("-");
		JButton btn1 = btn("1");
		JButton btn2 = btn("2");
		JButton btn3 = btn("3");
		JButton plus = btn("+");
		JButton del = btn("DEL");
		JButton zero = btn("0");
		JButton point = btn(".");
		JButton equal = btn("=");

		JButton[] mainbtns =
		{ off, ac, divide, btn7, btn8, btn9, mul, btn4, btn5, btn6, minus, btn1, btn2, btn3, plus, del, zero, point,
				equal };

		off.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				on.setEnabled(true);

				for (JButton b : mainbtns)
				{

					b.setEnabled(false);
				}
				label.setText("Kancha Calculator");
				label.setHorizontalAlignment(SwingConstants.CENTER);

			}
		});

		on.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				on.setEnabled(false);

				for (JButton b : mainbtns)
				{

					b.setEnabled(true);
				}
				label.setText("0");
				label.setHorizontalAlignment(SwingConstants.LEFT);

			}
		});

		ac.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				label.setText("0");

			}
		});

		JButton[] numbtns =
		{ btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, zero };

		for (JButton b : numbtns)
		{
			b.setBackground(Color.white);
			b.setBorder(null);
			b.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (!label.getText().toString().equals("0"))
					{

						label.setText(label.getText().toString() + b.getText().toString());

					} else
					{
						label.setText(b.getText().toString() + "");
					}

				}
			});

		}

		JButton[] operBtns =
		{ divide, mul, minus, plus };

		for (JButton btn : operBtns)
		{
			btn.setBackground(Color.green);
			btn.setBorder(null);
			btn.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					firstnum = Double.parseDouble(label.getText().toString());
					operation = btn.getText().toString();
					label.setText("0");

				}
			});

		}

		point.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (!label.getText().toString().contains("."))
				{

					label.setText(label.getText().toString() + ".");
				}

			}
		});

		del.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = label.getText().toString();
				if (num.length() >= 1)
				{

					label.setText(num.substring(0, num.length() - 1));

				} else if (num.length() == 0 && !num.equals("0"))
				{

					label.setText("0");
				}

			}
		});

		equal.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				double secondNum = Double.parseDouble(label.getText().toString());
				double result;

				switch (operation)
				{
				case "/":
					result = firstnum / secondNum;
					break;
				case "X":
					result = firstnum * secondNum;
					break;
				case "-":
					result = firstnum - secondNum;
					break;
				case "+":
					result = firstnum + secondNum;
					break;
				default:
					result = firstnum + secondNum;
					break;
				}
				
				label.setText(String.valueOf(result));
				firstnum = result;

			}
		});
		
		JButton[] arr = {on,off,equal,ac,del};
		for(JButton btn:arr) {
			
			btn.setBackground(Color.pink);
			btn.setBorder(null);
		}
		
		point.setBackground(Color.white);
		point.setBorder(null);

		frame.add(panel, BorderLayout.CENTER);

		frame.add(p, BorderLayout.NORTH);
		frame.setVisible(true);

	}

	private static JButton btn(String s)
	{

		JButton btn = new JButton(s);
		btn.setFont(new Font("Tahoma", Font.BOLD, 20));

		panel.add(btn);

		return btn;
	}

}
