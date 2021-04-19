package com.example.googleauth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeLayout extends JPanel {
    public HomeLayout(Layout layout) {
        this.setLayout(new FlowLayout());
        this.setBorder(new EmptyBorder(100,0,0,0));
        JLabel wellcomeTxt = new JLabel("Đăng nhập thành công");
        wellcomeTxt.setBackground(Color.BLACK);
        this.add(wellcomeTxt);
        JButton logout = new JButton("Đăng xuất");
        logout.addActionListener(e -> {
            layout.logout();
        });
        this.add(logout);
        this.setVisible(true);
    }
}
