package helloworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Maytinh extends JFrame implements ActionListener {

    private JTextField tfResult;

    private double kq = 0;

    private String phep = "=";

    private boolean click = true;

    public Maytinh() {
        setTitle("Calculator");
        setSize(300, 350);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(245,245,220));
        this.add(contentPane);
        contentPane.setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 16);
        Font font1 = new Font("Arial", Font.BOLD, 18);

        tfResult = new JTextField("0");
        tfResult.setBounds(10, 11, 264, 31);
        contentPane.add(tfResult);
        tfResult.setBackground(Color.white);
        tfResult.setColumns(10);
        tfResult.setForeground(Color.white);
        tfResult.setEditable(false);

        JButton btnNewButton = new JButton("0");
        btnNewButton.setBounds(10, 209, 128, 39);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(this);
        btnNewButton.setBackground(Color.white);
        
        JButton btnNewButton_2 = new JButton(".");
        btnNewButton_2.setBounds(10, 259, 60, 39);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(this);
        btnNewButton_2.setBackground(Color.white);
        
        JButton btnNewButton_2_1 = new JButton("C");
        btnNewButton_2_1.setBounds(78, 259, 60, 39);
        contentPane.add(btnNewButton_2_1);
        btnNewButton_2_1.addActionListener(this);
btnNewButton_2_1.setBackground(Color.white);
        JButton btnNewButton_2_2 = new JButton("+");
        btnNewButton_2_2.setBounds(214, 209, 60, 89);
        contentPane.add(btnNewButton_2_2);
        btnNewButton_2_2.addActionListener(this);
 btnNewButton_2_2.setBackground(Color.white);
//        JButton btnNewButton_2_4 = new JButton("CE");
//        btnNewButton_2_4.setBounds(148, 209, 60, 39);
//        contentPane.add(btnNewButton_2_4);
//        btnNewButton_2_4.addActionListener(this);
// btnNewButton_2_4.setBackground(Color.white);
        JButton btnNewButton_2_5 = new JButton("=");
        btnNewButton_2_5.setBounds(148, 259, 60, 39);
        contentPane.add(btnNewButton_2_5);
        btnNewButton_2_5.addActionListener(this);
btnNewButton_2_5.setBackground(Color.white);
        JButton btnNewButton_2_3 = new JButton("7");
        btnNewButton_2_3.setBounds(10, 159, 60, 39);
        contentPane.add(btnNewButton_2_3);
        btnNewButton_2_3.addActionListener(this);
btnNewButton_2_3.setBackground(Color.white);
        JButton btnNewButton_2_6 = new JButton("8");
        btnNewButton_2_6.setBounds(78, 159, 60, 39);
        contentPane.add(btnNewButton_2_6);
        btnNewButton_2_6.addActionListener(this);
 btnNewButton_2_6.setBackground(Color.white);
        JButton btnNewButton_2_7 = new JButton("9");
        btnNewButton_2_7.setBounds(148, 159, 60, 39);
        contentPane.add(btnNewButton_2_7);
        btnNewButton_2_7.addActionListener(this);
 btnNewButton_2_7.setBackground(Color.white);
        JButton btnNewButton_2_8 = new JButton("-");
        btnNewButton_2_8.setBounds(214, 159, 60, 39);
        contentPane.add(btnNewButton_2_8);
        btnNewButton_2_8.addActionListener(this);
        btnNewButton_2_8.setBackground(Color.white);
        JButton btnNewButton_2_7_1 = new JButton("6");
        btnNewButton_2_7_1.setBounds(148, 109, 60, 39);
        contentPane.add(btnNewButton_2_7_1);
        btnNewButton_2_7_1.addActionListener(this);
btnNewButton_2_7_1.setBackground(Color.white);
        JButton btnNewButton_2_6_1 = new JButton("5");
        btnNewButton_2_6_1.setBounds(78, 109, 60, 39);
        contentPane.add(btnNewButton_2_6_1);
        btnNewButton_2_6_1.addActionListener(this);
btnNewButton_2_6_1.setBackground(Color.white);
        JButton btnNewButton_2_3_1 = new JButton("4");
        btnNewButton_2_3_1.setBounds(10, 109, 60, 39);
        contentPane.add(btnNewButton_2_3_1);
        btnNewButton_2_3_1.addActionListener(this);
btnNewButton_2_3_1.setBackground(Color.white);
        JButton btnNewButton_2_8_1 = new JButton("/");
        btnNewButton_2_8_1.setBounds(214, 109, 60, 39);
        contentPane.add(btnNewButton_2_8_1);
        btnNewButton_2_8_1.addActionListener(this);
btnNewButton_2_8_1.setBackground(Color.white);
        JButton btnNewButton_2_7_2 = new JButton("3");
        btnNewButton_2_7_2.setBounds(148, 53, 60, 39);
        contentPane.add(btnNewButton_2_7_2);
        btnNewButton_2_7_2.addActionListener(this);
btnNewButton_2_7_2.setBackground(Color.white);
        JButton btnNewButton_2_6_2 = new JButton("2");
        btnNewButton_2_6_2.setBounds(78, 53, 60, 39);
        contentPane.add(btnNewButton_2_6_2);
        btnNewButton_2_6_2.addActionListener(this);
btnNewButton_2_6_2.setBackground(Color.white);
        JButton btnNewButton_2_3_2 = new JButton("1");
        btnNewButton_2_3_2.setBounds(10, 53, 60, 39);
        contentPane.add(btnNewButton_2_3_2);
        btnNewButton_2_3_2.addActionListener(this);
btnNewButton_2_3_2.setBackground(Color.white);
        JButton btnNewButton_2_8_2 = new JButton("*");
        btnNewButton_2_8_2.setBounds(214, 53, 60, 39);
        contentPane.add(btnNewButton_2_8_2);
        btnNewButton_2_8_2.addActionListener(this);
btnNewButton_2_8_2.setBackground(Color.white);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ('0' <= s.charAt(0) && s.charAt(0) <= '9' || s.equals(".")) {
            if (click) {
                tfResult.setText(s);
            } else {
                tfResult.setText(tfResult.getText());
            }

            click = false;
        } else {
            if (click) {
                if (s.equals("-")) {
                    tfResult.setText(s);
                    click = false;
                } else {
                    phep = s;
                }
            } else {
                double x = Double.valueOf(tfResult.getText());
                calculator(x);
                phep = s;
                click = true;
            }
        }
        if (s.equals("C") || s.equals("CE")) {
            tfResult.setText("0");
        }

    }

    public void calculator(double n) {
        if (phep.equals("+")) {
            kq += n;
        } else if (phep.equals("-")) {
            kq -= n;
        } else if (phep.equals("*")) {
            kq *= n;
        } else if (phep.equals("/")) {
            kq /= n;
        } else if (phep.equals("=")) {
            kq = n;
        }
        tfResult.setText(kq + "");
    }

    public static void main(String[] args) {
        new Maytinh();
    }

}
