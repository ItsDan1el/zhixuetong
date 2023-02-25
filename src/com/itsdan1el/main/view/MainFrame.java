package com.itsdan1el.main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends JFrame{
    public MainFrame() {
        setSize(442, 900);
        addListener();
        setTitle("世外智学通");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("assets/img/logo.png");
        setIconImage(icon);
        Dimension d = getToolkit().getScreenSize();
        setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Color c = new Color(11, 172, 246);


        JMenuBar menuBar = new JMenuBar();

        JMenu unFinished = new JMenu("待完成");
        JMenu homework = new JMenu("作业");
        JMenu daka = new JMenu("打卡任务");
        JMenu announcement = new JMenu("通知");
        // 一级菜单添加到菜单栏
        menuBar.add(unFinished);
        menuBar.add(homework);
        menuBar.add(daka);
        menuBar.add(announcement);
        menuBar.setBackground(c);
        add(menuBar);
        show();


        setJMenuBar(menuBar);

        setVisible(true);
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
