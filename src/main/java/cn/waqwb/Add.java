package cn.waqwb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Classname Add
 * @Description TODO
 * @Date 2022/12/18 23:06:23
 * @Created by Administrator
 */
public class Add extends JFrame implements ActionListener {
    JTextField text1,text2,text3,text4;
    JButton button1,button2,button3,button4,button5,button6;
    public Add() {
        this.setTitle("新增信息");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        button1 = new JButton("姓名");
        text1 = new JTextField(25);
        button2 = new JButton("密码");
        text2 = new JTextField(25);
        button3 = new JButton("年龄");
        text3 = new JTextField(25);
        button4 = new JButton("学号");
        text4 = new JTextField(25);
        button5 = new JButton("添加");
        button6 = new JButton("重置");
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 10, 10);
        JPanel panel = new JPanel(flow);
        panel.add(button1);
        panel.add(text1);
        panel.add(button2);
        panel.add(text2);
        panel.add(button3);
        panel.add(text3);
        panel.add(button4);
        panel.add(text4);
        panel.add(button5);
        panel.add(button6);

        this.add(panel);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = text1.getText().toString().trim();
                    String password = text2.getText().toString().trim();
                    int age = Integer.parseInt(text3.getText().toString().trim());
                    String stuno = text4.getText().toString().trim();
                    Connection con = DBUtils.getCon();
                    String sql = "insert into student(username,password,age,stuno) values(?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,name);
                    ps.setString(2,password);
                    ps.setInt(3,age);
                    ps.setString(4,stuno);
                    int i = ps.executeUpdate();
                    if (i>0){
                        JOptionPane.showMessageDialog(null,"录入成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,"录入失败！","提示消息",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
            }
        });
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
