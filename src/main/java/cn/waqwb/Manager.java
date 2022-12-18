package cn.waqwb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends JFrame implements ActionListener {
	public Manager() {
		this.setTitle("管理系统"); //window
		Dimension d = new Dimension(400,300);
		Point p = new Point (250,350);

		this.setSize(d);
		this.setLocation(p);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		JButton button1 = new JButton("添加");
		JButton button2 = new JButton("修改");
		JButton button3 = new JButton("查询");
		JButton button4 = new JButton("删除");
		JButton button5 = new JButton("浏览");

		FlowLayout flow = new FlowLayout(FlowLayout.LEFT,10,10);
		JPanel panel = new JPanel(flow);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);

		this.add(panel);

		//添加
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Add");
				Add add = new Add();
				add.setVisible(true);
			}
		});

		//修改
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

			}
		});

		//查询
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

			}
		});

		//删除
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

			}
		});

		//浏览
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

			}
		});
	}

	/**
	 * 执行操作
	 *
	 * @param e e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}