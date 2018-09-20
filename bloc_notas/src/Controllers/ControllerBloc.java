/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelBloc;
import Views.BlocNotas;

/**
 *
 * @author fanny
 */
public class ControllerBloc {
   ModelBloc modelBloc;
   BlocNotas blocNotas;
    ActionListener al = new ActionListener (){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==blocNotas.jmleer){
                System.out.println("e.getSource()==blocNotas.jmleer");
                 jmleer_action_performed();
            }
            else if(e.getSource()==blocNotas.jmguardar){
                System.out.println("e.getSource()==blocNotas.jmguardar");
                jmguardar_action_performed();
            }
        }

    };
    
    public ControllerBloc(ModelBloc modelBloc, BlocNotas blocNotas){
        blocNotas.setVisible(true);
        this.modelBloc = modelBloc;
        this.blocNotas = blocNotas;
        this.blocNotas.jmleer.addActionListener(al);
        this.blocNotas.jmguardar.addActionListener(al);
    }
       private void jmleer_action_performed()  {                                      
          this.readFile(modelBloc.getPath());
    }                  
      private void jmguardar_action_performed() {                                      
           this.writeFile(modelBloc.getPath(), modelBloc.getMessage());
    }    
     /**
      * metodo para leer 
      * @param path
      * @return 
      */
      public String readFile(String path){
          try{
              String row;//fila 
              try (FileReader file = new FileReader(path)){
                  BufferedReader bufferedReader = new BufferedReader(file);
                  while ((row = bufferedReader.readLine()) != null){
                      
                      blocNotas.jta_area.setText(row);
                      
                  }
                  bufferedReader.close();
              }
              }catch(FileNotFoundException err){
              JOptionPane.showMessageDialog(null,"FILE NOT FOUND"+err.getMessage());
         
          }catch(IOException err){
             JOptionPane.showMessageDialog(null,"ERROR ON I/O OPERATION"+err.getMessage());
      }
          return null;
}
      /**
       * metodo para sobreescribir una linea
       * @param path ruta 
       * @param message
       * @return 
       */
      public String writeFile(String path, String message){ 
          try{
              File file = new File (path);
              FileWriter fileWriter = new FileWriter(file,true);
              try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                  printWriter.println(blocNotas.jta_area.getText());
                  printWriter.close();
              }
          }catch(FileNotFoundException err){
              JOptionPane.showMessageDialog(null,"FILE NOT FOUND"+err.getMessage());
          } catch(IOException err){
             JOptionPane.showMessageDialog(null,"ERROR ON I/O OPERATION"+err.getMessage());
      }
          return null;
      }
}
