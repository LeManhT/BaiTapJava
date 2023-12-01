/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hieud
 */
public class Controller {
    private Account acc;
    private LoginFrm frm;
    public Controller(){
        frm=new LoginFrm();
        frm.loginListener(new LoginListener() );
        frm.setVisible(true);
    }
    public boolean login(Account acc){
        if(acc.getPassword().equals("admin")&&acc.getUsername().equals("admin")){
            return true;
        }
        return false;
    }
    public class LoginListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                acc=frm.getAccount();
                if(login(acc)){
                    frm.showMessage("Chuẩn rồi e");
                }else{
                    frm.showMessage("Sai mật khẩu hoặc tài khoản");
                }
            
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
    }
}