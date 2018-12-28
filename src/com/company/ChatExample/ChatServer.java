package com.company.ChatExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

class SocketThread implements Runnable {
    @Override
    public void run() {
        try {
            Socket soc = ChatServer.server.accept();
            ChatServer.contentText.append("Server receive connect\n");
            ChatServer.ServerOutput = new PrintWriter(soc.getOutputStream());
            ChatServer.ServerInput = new BufferedReader(new InputStreamReader(
                    soc.getInputStream()));
            ChatServer.ServerOutput.println("Connected");
            ChatServer.ServerOutput.flush();
            ChatServer.inputText.setEnabled(true);
            String mes;
            do {
                mes = ChatServer.ServerInput.readLine();
                ChatServer.contentText.append("Client:" + mes + "\n");
            } while (!isEnd(mes.trim()));
            ChatServer.ServerOutput.println("quit");
            ChatServer.ServerOutput.flush();
            ChatServer.ServerOutput.close();
            ChatServer.ServerInput.close();
            soc.close();
            ChatServer.contentText.append("connect finished" + "\n");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isEnd(String m) {
        return m.equalsIgnoreCase("quit");
    }

}

public class ChatServer extends JFrame implements ActionListener {
    private static JTextField portText;
    static JTextArea contentText;
    static JTextField inputText;
    static BufferedReader ServerInput;
    static PrintWriter ServerOutput;

    private ChatServer() {
        super("Chat Server");
        setLayout(new BorderLayout());


        JPanel ipPanel = new JPanel();
        ipPanel.setLayout(new FlowLayout());
        JLabel ipLabel = new JLabel("Local IP:");
        ipLabel.setSize(40, 40);
        JTextField ipText = new JTextField();
        try {
            ipText.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
        ipPanel.add(ipLabel);
        ipPanel.add(ipText);

        JPanel portPanel = new JPanel();
        portPanel.setLayout(new FlowLayout());
        JLabel portLabel = new JLabel("Local port:");
        portLabel.setSize(80, 40);
        portText = new JTextField();
        portText.setText("9999");
        portPanel.add(portLabel);
        portPanel.add(portText);


        JButton waitForMesButton = new JButton("Start Server");
        waitForMesButton.addActionListener(this);




        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("INPUT");
        inputLabel.setSize(40, 40);
        inputText = new JTextField();
        inputText.setColumns(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputText);

        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(this);

        JPanel netpanel=new JPanel();
        netpanel.setLayout(new FlowLayout());
        netpanel.add(ipPanel);
        netpanel.add(portPanel);
        netpanel.add(waitForMesButton);

        JPanel leftpanel=new JPanel();
        leftpanel.setLayout(new BorderLayout());
        leftpanel.add(netpanel,BorderLayout.NORTH);
        leftpanel.add(inputPanel,BorderLayout.CENTER);
        leftpanel.add(sendButton,BorderLayout.PAGE_END);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        JLabel contentLabel = new JLabel("CONTENT");
        contentLabel.setSize(100, 40);
        contentText = new JTextArea();
        contentPanel.add(contentLabel);
        contentPanel.add(contentText);


        JLabel timelabel = new JLabel();
        class timeThread implements Runnable {
            @Override
            public void run() {

                while (true) {
                    timelabel.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
            }

        }
        new Thread(new timeThread()).start();


       add(leftpanel,BorderLayout.WEST);
        add(contentPanel,BorderLayout.EAST);


        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//                | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }


    }

    public static void main(String[] args) {
        new ChatServer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Start Server")) {
            CreateServer();
        } else if (e.getActionCommand().equals("SEND")) {
            Send();
        }
    }

    static ServerSocket server;

    private void CreateServer() {
        contentText.append("SERVER STARTED\n");
        try {
            //System.out.println(Integer.parseInt(ChatServer.portText.getText()));
            server = new ServerSocket(Integer.parseInt(ChatServer.portText.getText()));
            // System.out.println("SERVER STARTED");

        } catch (NumberFormatException | IOException e1) {
            e1.printStackTrace();
        }

        new Thread(new SocketThread()).start();
    }

    private void Send() {
        contentText.append("SERVER:" + inputText.getText() + "\n");
        ServerOutput.println(inputText.getText() + "\n");
        ServerOutput.flush();
        inputText.setText("");
    }

}

