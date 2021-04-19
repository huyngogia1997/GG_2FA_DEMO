package com.example.googleauth;

import com.google.zxing.WriterException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class Layout extends JFrame {
    void loginSuccess(){
        this.setContentPane(new HomeLayout(this));
        this.validate();
        this.repaint();

    }
    public Layout() throws HeadlessException, IOException, WriterException {
        this.setLayout(new BorderLayout());
        this.setSize(600,300);
        this.setContentPane(new Login(this));
        this.setVisible(true);
    }

    public void logout() {
        this.setContentPane(new Login(this));
        this.validate();
        this.repaint();
    }
}
