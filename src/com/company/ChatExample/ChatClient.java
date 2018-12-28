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
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientSocketThread implements Runnable {
    @Override
    public void run() {
        try {
            ChatClient.contentText.append("Waiting Connect" + "\n");
            Socket s = new Socket(ChatClient.ipText.getText(), Integer.parseInt(ChatClient.portText.getText()));


            ChatClient.m_output = new PrintWriter(s.getOutputStream());
            ChatClient.m_input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ChatClient.inputText.setEnabled(true);
            String mes;
            while (true) {
                do {
                    mes = ChatClient.m_input.readLine();
                    System.out.println(mes);
                    ChatClient.contentText.append("SERVER:" + mes + "\n");
                } while (!isEnd(mes.trim()));

                ChatClient.m_output.println("quit");
                System.out.println("Connection interruption");
                ChatClient.m_output.flush();
                ChatClient.m_output.close();
                ChatClient.m_input.close();
                s.close();
                ChatClient.contentText.append("Connection interruption" + "\n");
                System.exit(0);
            }

        } catch (NumberFormatException | IOException e1) {
            e1.printStackTrace();
        }
    }

    private boolean isEnd(String m) {
        return m.equalsIgnoreCase("quit");
    }

}

public class ChatClient extends JFrame implements ActionListener {
    static TextField ipText;
    static TextField portText;
    static JTextArea contentText;
    static TextField inputText;

    static BufferedReader m_input;
    static PrintWriter m_output;

    private ChatClient() {
        super("Chat Client");

        setLayout(new FlowLayout());
        Panel ipPanel = new Panel();
        ipPanel.setLayout(new FlowLayout());
        Label ipLabel = new Label("SERVER IP:");
        ipLabel.setSize(40, 40);
        ipText = new TextField(30);
        try {
            ipText.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        ipPanel.add(ipLabel);
        ipPanel.add(ipText);

        Panel portPanel = new Panel();
        portPanel.setLayout(new FlowLayout());
        Label portLabel = new Label("SERVER port:");
        portLabel.setSize(40, 40);
        portText = new TextField(10);
        portPanel.add(portLabel);
        portPanel.add(portText);

        Button connectButton = new Button("CONNECT");
        connectButton.addActionListener(this);

        Panel contentPanel = new Panel();
        contentPanel.setLayout(new FlowLayout());
        Label contentLabel = new Label("CONTENT");
        contentLabel.setSize(40, 40);
        contentText = new JTextArea();
        contentPanel.add(contentLabel);
        contentPanel.add(contentText);


        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());
        Label inputLabel = new Label("INPUT");
        inputLabel.setSize(40, 40);
        inputText = new TextField(40);
        inputPanel.add(inputLabel);
        inputPanel.add(inputText);

        Button sendButton = new Button("SEND");
        sendButton.addActionListener(this);

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

        add(ipPanel);
        add(portPanel);
        add(connectButton);
        add(contentPanel);
        add(inputPanel);
        add(sendButton);


        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new ChatClient();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("CONNECT")) {
            ConnectServer();
        } else if (e.getActionCommand().equals("SEND")) {
            Send();
        }
    }

    private void ConnectServer() {
        new Thread(new ClientSocketThread()).start();
    }

    private void Send() {
        contentText.append("Client:" + inputText.getText() + "\n");
        m_output.println(inputText.getText() + "\n");
        m_output.flush();
        inputText.setText("");
    }
}
