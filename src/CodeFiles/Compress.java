/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;



/**
 *
 * @author USER
 */
public class Compress 
{
 public static void method(File file) throws IOException
 {
     String fileDirectory = file.getParent();
     System.out.println(fileDirectory);
     FileInputStream fis = new FileInputStream(file);
     FileOutputStream fos = new FileOutputStream(fileDirectory + "/Compressedfile.gz");
     GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
     
     byte [] buffer = new byte[3];
     int len;
     
     while((len=fis.read(buffer))!=-1)
     {
         gzipOS.write(buffer,0,len);
         for(int i=0;i<buffer.length;i++)
         {
             System.out.print(buffer[i]+" ");
         }
         System.out.println(len);
     }
     
     fis.close();
     gzipOS.close();
     fos.close();
 }
 public static void main(String args[]) throws IOException
 {
     File Path = new File("C:\\Users\\USER\\Desktop\\Hello.txt");
     method(Path);
     
 }
}
