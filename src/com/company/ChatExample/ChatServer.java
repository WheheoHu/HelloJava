package com.company.ChatExample;

import javax.swing.*;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
class SocketThread implements Runnable{
	Socket soc;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			soc=ChatServer.server.accept();
			ChatServer.contentText.append("Server recive connect");
			ChatServer.m_output=new PrintWriter(soc.getOutputStream());
			ChatServer.m_input=new BufferedReader(new InputStreamReader(
					soc.getInputStream()));
			ChatServer.m_output.println("conected");
			ChatServer.m_output.flush();
			ChatServer.inputText.setEnabled(true);
			String mes="";
			do{
				mes=(String)ChatServer.m_input.readLine();
				ChatServer.contentText.append("Client:"+mes+"\n");
			}while(!isEnd(mes.trim()));
			ChatServer.m_output.println("quit");
			ChatServer.m_output.flush();
			ChatServer.m_output.close();
			ChatServer.m_input.close();
			soc.close();
			ChatServer.contentText.append("connect finished"+"\n");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
public class ChatServer extends JFrame implements ActionListener{
	TextField ipText;
	static TextField portText;
	public static TextArea contentText;
	public static TextField inputText;
	Button waitForMesButton;
	Button sendButton;
	
	public static BufferedReader m_input;
	public static PrintWriter m_output;
	
	public ChatServer()
	{
		super("Chat Server");
		setLayout(new FlowLayout());
		Choice cb=new Choice();
		Panel ipPanel=new Panel();
		ipPanel.setLayout(new FlowLayout());
		Label ipLabel=new Label("Local IP:");
		ipLabel.setSize(40,40);		
		ipText=new TextField();
		ipPanel.add(ipLabel);
		ipPanel.add(ipText);
		
		Panel portPanel=new Panel();
		portPanel.setLayout(new FlowLayout());
		Label portLabel=new Label("Local port:");
		portLabel.setSize(80,40);		
		portText=new TextField();
		portPanel.add(portLabel);
		portPanel.add(portText);
		
		try {
			ipText.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitForMesButton=new Button("Waitting Massage");
		waitForMesButton.addActionListener(this);
		
		Panel contentPanel=new Panel();
		contentPanel.setLayout(new FlowLayout());
		Label contentLabel=new Label("Com");
		contentLabel.setSize(40,40);		
		contentText=new TextArea();
		contentPanel.add(contentLabel);
		contentPanel.add(contentText);
		
		
		Panel inputPanel=new Panel();
		inputPanel.setLayout(new FlowLayout());
		Label inputLabel=new Label("INPUT");
		inputLabel.setSize(40,40);		
		inputText=new TextField();
		inputPanel.add(inputLabel);
		inputPanel.add(inputText);
		
		sendButton=new Button("SEND");
		sendButton.addActionListener(this);
		
		add(ipPanel);
		add(portPanel);
		add(waitForMesButton);
		add(contentPanel);
		add(inputPanel);		
		add(sendButton);
		
		
		setSize(500,500);
		setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatServer();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getActionCommand());
		if(e.getActionCommand()=="WAITTING")
		{
			CreateServer();
		}
		else if(e.getActionCommand()=="SEND")
		{
			Send();
		}
	}
	public static ServerSocket server;
	void CreateServer()
	{
		contentText.append("SERVER STARTED\n");
		try {
			server=new ServerSocket(Integer.parseInt(ChatServer.portText.getText()));
			System.out.println("SERVER STARTED");

		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		new Thread(new SocketThread()).start();
	}

	void Send()
	{
		contentText.append("SERVER:"+inputText.getText()+"\n");
		m_output.println(inputText.getText()+"\n");
		m_output.flush();
		inputText.setText("");
	}
	
}

