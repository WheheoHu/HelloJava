package com.company.Chattt;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class URLtest {
    public static void main(String[] args) {
        try {
            URL url1=new URL("http://www.ncut.edu.cn/xxjs1/xxgk.htm");
            InputStream inputStream=url1.openStream();InputStreamReader inputStreamReader=new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter("test.html")));
            String str;
            while ((str=bufferedReader.readLine())!=null){
                printWriter.println(str);
            }
            bufferedReader.close();
            printWriter.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }

    }
}
