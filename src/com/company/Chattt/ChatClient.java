package com.company.Chattt;

import javax.swing.*;

public class ChatClient {
    public static void main(String[] args) {
        ClientGUI clientGUI=new ClientGUI();

    }

}
class ClientGUI{
    private JFrame mainFrame=new JFrame("Client");

    public ClientGUI() {
        setGUI();
    }

   private void setGUI(){
        mainFrame.setVisible(true);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
