

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;

public class Main {
    private static ViewPrincipal viewprincipal;
    private static ModelMain modelmain;
    private static ControllerPrincipal controllerprincipal;
    
    private static ViewClientes viewclientes;
    private static ModelClientes modelclientes;
    private static ControllerClientes controllerclientes; 
    
    private static ViewPeliculas viewpeliculas;
    private static ModelPeliculas modelpeliculas;
    private static ControllerPeliculas controllerpeliculas;
    
        private static ViewRentas viewrentas;
    private static ModelRentas modelrentas;
    private static ControllerRentas controllerrentas;
    
    
    
    public static void main (String jagb[]){
       viewclientes = new ViewClientes();
       modelclientes = new ModelClientes();
       controllerclientes = new ControllerClientes(modelclientes, viewclientes);
       
        viewpeliculas = new ViewPeliculas();
        modelpeliculas = new ModelPeliculas();
        controllerpeliculas = new ControllerPeliculas(modelpeliculas, viewpeliculas);
        
        viewrentas = new ViewRentas();
        modelrentas = new ModelRentas();
        controllerrentas = new ControllerRentas(modelrentas, viewrentas);
       
       viewprincipal = new ViewPrincipal();
       modelmain = new ModelMain();
       controllerprincipal = new ControllerPrincipal(viewprincipal, viewclientes, viewpeliculas, viewrentas, modelmain);
      
    }
    
}
