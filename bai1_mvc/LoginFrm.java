/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1_mvc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hieud
 */
public class LoginFrm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginBtn;
    public LoginFrm(){
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);
        loginBtn=new JButton("Đăng nhập");
        JPanel panel = new JPanel();
        GridBagLayout gb= new GridBagLayout();
        panel.setLayout(gb);
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        panel.add(new JLabel("Username:"),gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        panel.add(usernameField,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        panel.add(new JLabel("Password:"),gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        panel.add(passwordField,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        panel.add(loginBtn,gbc);
        loginBtn.addActionListener(this);
        this.add(panel);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student Information");
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public Account getAccount(){
        Account acc=new Account();
        acc.setUsername(usernameField.getText());
        acc.setPassword(passwordField.getText());
        return  acc;
    }
    public void loginListener(ActionListener ac){
        loginBtn.addActionListener(ac);
    }
    public void showMessage(String mgs){
        JOptionPane.showMessageDialog(this, mgs);
    }
}
