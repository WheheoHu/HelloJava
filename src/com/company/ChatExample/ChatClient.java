package com.company.ChatExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientSocketThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ChatClient.contentText.append("Waitting Connect"+"\n");
			Socket s=new Socket(ChatClient.ipText.getText(), Integer.parseInt(ChatClient.portText.getText()));
			
			
			ChatClient.m_output=new PrintWriter(s.getOutputStream());
			ChatClient.m_input=new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			ChatClient.inputText.setEnabled(true);
			String mes="";		//来自服务器的信息
			while(true)
			{
				do{
					mes=(String)ChatClient.m_input.readLine();
					System.out.println(mes);
					ChatClient.contentText.append("SERVER:"+mes+"\n");
				}while(!isEnd(mes.trim()));
				ChatClient.m_output.println("quit");
				System.out.println("Connection interruption");
				ChatClient.m_output.flush();
				ChatClient.m_output.close();
				ChatClient.m_input.close();
				s.close();
				ChatClient.contentText.append("Connection interruption"+"\n");
				System.exit(0);
			}

		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	boolean isEnd(String m)
	{
		if(m.equalsIgnoreCase("quit"))
			return true;
		else
			return false;
	}
	
}
public class ChatClient extends JFrame implements ActionListener {
	public static TextField ipText;
	static TextField portText;
	public static TextArea contentText;
	public static TextField inputText;
	Button connectButton;
	Button sendButton;
	
	public static BufferedReader m_input;
	public static PrintWriter m_output;
	
	public ChatClient()
	{
		super("Chat Client");

		setLayout(new FlowLayout());
		Panel ipPanel=new Panel();
		ipPanel.setLayout(new FlowLayout());
		Label ipLabel=new Label("SERVER IP:");
		ipLabel.setSize(40,40);		
		ipText=new TextField(40);
		ipPanel.add(ipLabel);
		ipPanel.add(ipText);
		
		Panel portPanel=new Panel();
		portPanel.setLayout(new FlowLayout());
		Label portLabel=new Label("SERVER port:");
		portLabel.setSize(40,40);		
		portText=new TextField(10);
		portPanel.add(portLabel);
		portPanel.add(portText);
	
		connectButton=new Button("CONNECT");
		connectButton.addActionListener(this);
		
		Panel contentPanel=new Panel();
		contentPanel.setLayout(new FlowLayout());
		Label contentLabel=new Label("CONTENT");
		contentLabel.setSize(40,40);		
		contentText=new TextArea();
		contentPanel.add(contentLabel);
		contentPanel.add(contentText);
		
		
		Panel inputPanel=new Panel();
		inputPanel.setLayout(new FlowLayout());
		Label inputLabel=new Label("INPUT");
		inputLabel.setSize(40,40);		
		inputText=new TextField(40);
		inputPanel.add(inputLabel);
		inputPanel.add(inputText);
		
		sendButton=new Button("SENT");
		sendButton.addActionListener(this);
		
		add(ipPanel);
		add(portPanel);
		add(connectButton);
		add(contentPanel);
		add(inputPanel);		
		add(sendButton);
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient();
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="连接")
		{
			ConnectServer();
		}
		else if(e.getActionCommand()=="发送")
		{
			Send();
		}
	}
	void ConnectServer()
	{
		new Thread(new ClientSocketThread()).start();
	}

	void Send()
	{
		contentText.append("客户端:"+inputText.getText()+"\n");
		m_output.println(inputText.getText()+"\n");
		m_output.flush();
		inputText.setText("");
	}
}
