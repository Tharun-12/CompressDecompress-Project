/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

;



import java.io.File;
import javax.swing.JOptionPane;
import CodeFiles.Decompress;
import CodeFiles.Compress;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class View extends JFrame implements ActionListener
{
    JButton compressButton;
    JButton decompressButton;
    
    
    View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        
        compressButton = new JButton("Select File to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 30);
        
        
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(200, 100, 200, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
      
        
       this.setSize(500,200);
    }
  @Override
  public void actionPerformed(ActionEvent e)
  {
      if(e.getSource()== compressButton)
      {
          JFileChooser fileChooser =new JFileChooser();
          int response= fileChooser.showSaveDialog(null);
          
          if(response == JFileChooser.APPROVE_OPTION)
          {
              File file= new File(fileChooser.getSelectedFile().getAbsolutePath());
              try
              {
                Compress.method(file);
              }
              catch(Exception excp)
              {
                  JOptionPane.showMessageDialog(rootPane, excp.toString());
              }
          }
      }
      if(e.getSource()== decompressButton)
      {
          JFileChooser fileChooser =new JFileChooser();
          int response= fileChooser.showSaveDialog(null);
          
          if(response == JFileChooser.APPROVE_OPTION)
          {
              File file= new File(fileChooser.getSelectedFile().getAbsolutePath());
              try
              {
                Decompress.method(file);
              }
              catch(Exception excp)
              {
                  JOptionPane.showMessageDialog(rootPane, excp.toString());
              }
          }
      }
      
      
  }
  
  public static void main(String args[])
  {
      View view= new View();
      view.setVisible(true);
  }
}
