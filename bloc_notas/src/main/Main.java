/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
     import models.ModelBloc;
     import Views.BlocNotas;
     import Controllers.ControllerBloc;
/**
 *
 * @author fanny
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModelBloc modelBloc = new ModelBloc();
        BlocNotas blocNotas = new BlocNotas ();
        ControllerBloc controllerBloc = new ControllerBloc(modelBloc,blocNotas);
        
    }
    
}
