/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld ;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class LoginForm {
    
    public static void main(String[] args){   
        JFrame j= new JFrame();
        GridBagLayout gb= new GridBagLayout();
        j.setLayout(gb);
        j.setSize(300, 200);
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.ipadx=50;
        gbc.ipady=20;
        gbc.fill=GridBagConstraints.BOTH;
        JLabel l1= new JLabel("Tai khoan");
        gb.setConstraints(l1, gbc);
        j.add(l1);
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.ipadx=50;
        gbc.ipady=20;
        gbc.fill=GridBagConstraints.BOTH;
        JTextField t_user= new JTextField("Hay nhap user");
        gb.setConstraints(t_user, gbc);
        j.add(t_user);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.ipadx=50;
        gbc.ipady=20;
        gbc.fill=GridBagConstraints.BOTH;
        JLabel l2= new JLabel("Nhap pass");
        gb.setConstraints(l2, gbc);
        j.add(l2);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.ipadx=50;
        gbc.ipady=20;
        gbc.fill=GridBagConstraints.BOTH;
        JTextField t_pass= new JTextField("Hay nhap password");
        gb.setConstraints(t_pass, gbc);
        j.add(t_pass);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.ipadx=50;
        gbc.ipady=20;
        gbc.fill=GridBagConstraints.BOTH;
        Button bt_dang_Nhap= new Button("Dang nhap");
        gb.setConstraints(bt_dang_Nhap, gbc);
        j.add(bt_dang_Nhap);
        bt_dang_Nhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s="";
                if(t_user.getText().equals("")&&t_pass.getText().equals("")){
                    s+="User và pass khong duoc bo trong";
                }else{
                    if(t_user.getText().equals("")){
                        s+="User khong duoc bo trong";
                    }
                    else {
                        if(t_pass.getText().equals(""))
                                s+="Pass khong duoc bo trong";
                        else{
if(t_user.getText().equals("abc")&& t_pass.getText().equals("123456789")){
                                s+="Dang nhap thanh cong";
                            }   
                            else{
                                s+="user hoặc pass sai";
                            }
                        }
                    }
                
                }
                
                JOptionPane.showMessageDialog(j, s);
            }
        });
        j.setVisible(true);
    }
}
