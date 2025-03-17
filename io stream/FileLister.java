package baitap;

import java.io.*;

public class FileLister {
    public static void main(String[] args) {
        File directory = new File("D:/MyFolder");
        
        if (directory.exists() && directory.isDirectory()) {
            String[] fileList = directory.list();
            System.out.println("Danh sách các file trong thư mục " + directory.getAbsolutePath() + ":");
            for (String file : fileList) {
                System.out.println(file);
            }
        } else {
            System.out.println("Đường dẫn không hợp lệ hoặc không phải là thư mục.");
        }
    }
}