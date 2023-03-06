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

    //Main Dialog Pannel
    public LoginDialog(Frame owner, boolean modal){
        super(owner, "账号登陆", modal);
        setSize(WIDTH,HEIGHT);
        setLocation(owner.getX() + (owner.getWidth() - WIDTH)/2, owner.getY() + (owner.getHeight() - HEIGHT)/2);
        init();
        addListener();
    }

    public LoginDialog(MainFrame parent) {
    }

    private void init() {
        JLabel usernameLabel = new JLabel("用户名", JLabel.CENTER);
        JLabel passwordLabel = new JLabel("密 码", JLabel.CENTER);
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginBtn = new JButton("登陆");
        cancelBtn = new JButton("取消");

        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 2));// 3��2�е����񲼾�
        c.add(usernameLabel);
        c.add(usernameField);
        c.add(passwordLabel);
        c.add(passwordField);
        c.add(loginBtn);
        c.add(cancelBtn);
    }

    /**
     * Ϊ�����Ӽ���
     */
    private void addListener() {
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog.this.dispose();
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText().trim();

                String password = new String(passwordField.getPassword());

                boolean result = AccountService.userLogin(username, password);
                if (result) {
                    LoginDialog.this.dispose();
                } else {

                    JOptionPane.showMessageDialog(LoginDialog.this, "用户名或密码错误！");
                }
            }
        });
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginBtn.doClick();
            }
        });

        usernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.grabFocus();
            }
        });
    }
}


