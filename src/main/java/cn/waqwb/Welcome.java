package cn.waqwb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Classname Welcome
 * @Description TODO
 * @Date 2022/12/14 19:08:09
 * @Created by Administrator
 */
public class Welcome extends JFrame implements ActionListener {
    public static final int FRAME_WIDTH = 350;
    public static final int FRAME_HEIGHT = 200;
    JButton button1,button2;
    JLabel label1,label2;
    JTextField textField1,textField2;

    Login login;
    public Welcome()  {
        this.setTitle("登录");
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        login = new Login();
        login.setLayout(null);
//        GridLayout gridLayout = new GridLayout(3, 2);
//        login.setLayout(gridLayout);
        label1 = new JLabel("用 户 名");
        label1.setBounds(10,20,80,25);
        login.add(label1);

        textField1 = new JTextField(10);
        textField1.setBounds(100,20,165,25);
        login.add(textField1);

        label2 = new JLabel("密       码");
        label2.setBounds(10,50,80,25);
        login.add(label2);
        textField2 = new JTextField(10);
        textField2.setBounds(100,50,165,25);
        login.add(textField2);

        button1 = new JButton("登录");
        button1.setBounds(10, 80, 115, 25);
        login.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("注册");
        button2.setBounds(150, 80, 115, 25);
        login.add(button2);
        button2.addActionListener(this);

        this.add(login);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "登录"){
            if (!textField1.getText().isEmpty() && !textField2.getText().isEmpty()){
                try {
                    Connection con = DBUtils.getCon();
                    String sql = "select * from student where username=? and password=?";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1,textField1.getText());
                    preparedStatement.setString(2,textField2.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
//                        System.out.println("登录成功");
                        this.setVisible(false);
                        Manager manager = new Manager();
                    } else {
                        System.out.println("用户名或密码错误，请重新输入");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else if (textField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"请输入用户名","提示消息",JOptionPane.WARNING_MESSAGE);
            }else if (textField2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"请输入密码","提示消息",JOptionPane.WARNING_MESSAGE);
            }

        }else if (e.getActionCommand() == "注册"){

        }
    }
}
