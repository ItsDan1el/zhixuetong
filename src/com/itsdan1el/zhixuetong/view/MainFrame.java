package com.itsdan1el.zhixuetong.view;

import com.itsdan1el.zhixuetong.session.Session;
import jdk.jfr.internal.tool.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends JFrame{



    public MainFrame() {
        Dimension d = getToolkit().getScreenSize();
        setSize((int) ((d.width - getWidth())/3.5), (d.height - getHeight()));
        addListener();
        setTitle("世外智学通");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("assets/img/logo.png");
        setIconImage(icon);

        setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Color c = new Color(11, 172, 246);

       JMenuBar menuBar = new JMenuBar();

       JMenu unFinished = new JMenu("待完成");
       JMenu homework = new JMenu("作业");
       JMenu daka = new JMenu("打卡任务");
       JMenu announcement = new JMenu("通知");
       JMenu loginOptions = new JMenu("登陆");

        // 一级菜单添加到菜单栏
        menuBar.add(unFinished);
        menuBar.add(homework);
        menuBar.add(daka);
        menuBar.add(announcement);
        menuBar.add(loginOptions);

        //登陆选项
        JMenuItem login = new JMenuItem("账号登录");
        JMenuItem register = new JMenuItem("注册账号");

        loginOptions.add(login);
        loginOptions.add(register);


        menuBar.setBackground(c);
        add(menuBar);
        show();

        setJMenuBar(menuBar);

        setVisible(true);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame MainFrame = new MainFrame();
                LoginDialog ld = new LoginDialog(MainFrame);
                    ld.setVisible(true);

            }
        });

        }



    private void addListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int closeCode = JOptionPane.showConfirmDialog(MainFrame.this, "是否退出智学通？"
                        ,"提示！",JOptionPane.YES_NO_OPTION);
                if(closeCode == JOptionPane.YES_OPTION){
                    System.exit(0);

                }
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Image icon = toolkit.getImage("assets/img/logo.png");
                setIconImage(icon);
            }
        });

    }


    public void setPanel(JPanel panel){
        Container c = getContentPane();
        c.removeAll();
        c.add(panel);
        c.validate();
    }



}
