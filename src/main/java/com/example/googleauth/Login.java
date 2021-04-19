package com.example.googleauth;

import com.google.zxing.WriterException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class Login extends JPanel {
    private JButton cancelBtn, submidBtn,barcodeBtn,conifrmBtn;
    private JLabel usernameCodeTxt, TOTPCodeTxt,notifyTxt;
    private JTextField usernameTf, passwordTf;
    private UserInfo userInfo = new UserInfo();
    private Layout layout;

    public Login(Layout layout) {
        this.layout = layout;
        initUI();
        initStates();
    }

    private void initStates() {
        usernameTf.setText(userInfo.getSecretKey());

        cancelBtn.addActionListener(e -> {
            usernameTf.setText("  ");
            barcodeBtn.setIcon(null);
            conifrmBtn.setEnabled(false);
        });

        submidBtn.addActionListener(e->{
            try {
                barcodeBtn.setIcon(new ImageIcon(
                        Utils.createQRCode(
                                usernameCodeTxt.getText(),
                                userInfo.getEmail(),
                                userInfo.getCompanyName(),
                                230,230
                        )
                ));
                conifrmBtn.setEnabled(true);
            } catch (IOException |WriterException ex ) {
                ex.printStackTrace();
            }
        });

        conifrmBtn.addActionListener(e -> {
            if(Utils.getTOTPCode(userInfo.getSecretKey()).equals(passwordTf.getText())){
                layout.loginSuccess();
                return;
            }
            notifyTxt.setText("Mã không hợp lệ !!");
        });
    }

    private void initUI() {
        GridLayout experimentLayout = new GridLayout(0,2);
        this.setLayout(experimentLayout);
        /*-------------------------------------------------*/
        JPanel left = new JPanel(new GridBagLayout());
        usernameCodeTxt = new JLabel();
        usernameCodeTxt.setText("Mã nhân viên:");
        TOTPCodeTxt = new JLabel();
        TOTPCodeTxt.setText("Mã TOTP:");
        usernameTf = new JTextField(15);
        passwordTf = new JPasswordField(15);
        cancelBtn =new JButton("Hủy");
        submidBtn =new JButton("Lấy mã");
        conifrmBtn = new JButton("Xác nhận");
        notifyTxt = new JLabel("");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        left.add(usernameCodeTxt,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth = 2;
        left.add(usernameTf,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth = 1;
        left.add(TOTPCodeTxt,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth = 2;
        left.add(passwordTf,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        left.add(cancelBtn,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        left.add(submidBtn,gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        conifrmBtn.setEnabled(false);
        left.add(conifrmBtn,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth = 2;
        left.add(notifyTxt,gbc);
        this.add(left);
        /*-------------------------------------------------*/
        JPanel right = new JPanel(null);
        right.setBorder(new EmptyBorder(25,25,25,25));
        barcodeBtn = new JButton();
        barcodeBtn.setSize(300,300);
        right.add(barcodeBtn);
        this.add(right);
    }

}
class UserInfo{
    String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
    String email = "test@gmail.com";
    String companyName = "Awesome Company";

    public UserInfo() {
    }

    public UserInfo(String secretKey, String email, String companyName) {
        this.secretKey = secretKey;
        this.email = email;
        this.companyName = companyName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
