package com.itsdan1el.zhixuetong.view;

import com.itsdan1el.zhixuetong.service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginDialog extends JDialog {
    private JTextField usernameField = null;
    private JPasswordField passwordField = null;
    private JButton loginBtn = null;
    private JButton cancelBtn = null;
    private final int WIDTH = 300, HEIGHT = 150;

    //Main Frame
    public LoginDialog(Frame owner, boolean modal){
        super(owner, "账号登陆", modal);
        setSize(WIDTH,HEIGHT);
        setLocation(owner.getX() + (owner.getWidth() - WIDTH)/2, owner.getY() + (owner.getHeight() - HEIGHT)/2);
        loginBtn.addActionListener(new ActionListener(){



            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());
                boolean result = AccountService.userLogin(username, password);
                if(result){
                    LoginDialog.this.dispose();
                }else{
                    JOptionPane.showMessageDialog(LoginDialog.this,"用户民或密码错误！");
                }
            }
        });


    }
}


