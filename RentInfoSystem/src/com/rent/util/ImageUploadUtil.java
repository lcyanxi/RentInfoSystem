package com.rent.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Random;

public class ImageUploadUtil {
	 public static  String imageUpload (File file,String uploadContentType,String uploadFileName, String uploadPath){
       	String fileName=new Random().nextInt(9999)+uploadFileName;
		 String  fn=uploadPath+fileName;
       		 FileOutputStream fos;
       		 InputStream is;
    		try {
    			fos = new FileOutputStream(fn);
    			is =new FileInputStream(file);   //文件输入流
    		   		byte[] buffer = new byte[8192];
    		   		int count=0;
    		   	 while((count=is.read(buffer))>0)   //输入流中读，存到数组中
    				 {
    					 fos.write(buffer, 0, count);   //数组中的写到输出流
    				 }
    				 fos.close();
    				 is.close();    			
    				 return fileName;
    		} catch (Exception e) {
    			e.printStackTrace();
                return null;
    		} 
        }
}
