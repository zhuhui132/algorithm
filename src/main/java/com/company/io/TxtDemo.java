package com.company.io;

import java.io.*;

public class TxtDemo {
    public static void main(String[] args) {

    }

    public static String readFile(File file,String charset) {
        if (charset == null) {
            charset = "UTF-8";
        }

        if (file.isFile() && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer sb = new StringBuffer();
                String text = null;

                while ((text = bufferedReader.readLine()) != null) {
                    sb.append(text);
                }
                return sb.toString();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return  null;
    }


    public static void writeToFile(){
        try {
            String content = "测试使用字符串";
            File file = new File("./File/test1.txt");
            if(file.exists()){
                FileWriter fw = new FileWriter(file,false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close(); fw.close();
                System.out.println("test1 done!");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}