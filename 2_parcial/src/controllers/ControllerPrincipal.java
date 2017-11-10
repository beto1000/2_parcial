/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewClientes;
import views.ViewPeliculas;
import views.ViewRentas;

import views.ViewPrincipal;
import models.ModelMain;
import models.ModelClientes;
import models.ModelPeliculas;
import models.ModelRentas;


public class ControllerPrincipal {
    ViewPrincipal viewprincipal;
    ViewClientes viewclientes;
    ViewPeliculas viewpeliculas;
    ViewRentas viewrentas;

    ModelMain model_main;
    ModelClientes modelclientes;
    ModelPeliculas model_peliculas;
    ModelRentas modelrentas;
    
    
    public ControllerPrincipal(ViewPrincipal viewprincipal,ViewClientes viewclientes,ViewPeliculas viewpeliculas,ViewRentas viewrentas,ModelMain model_main){
        this.viewprincipal = viewprincipal;
        this.viewclientes = viewclientes;
        this.viewpeliculas = viewpeliculas;
        this.viewrentas = viewrentas;

        this.model_main = model_main;
        this.viewprincipal.jmi_clientes.addActionListener(e -> jmi_clientesActionPerformed());
        this.viewprincipal.jmi_salir.addActionListener(e-> jmi_salirActionPerformed());
        this.viewprincipal.jmi_peliculas.addActionListener(e-> jmi_peliculasActionPerformed());
                this.viewprincipal.jmi_rentas.addActionListener(e-> jmi_rentasActionPerformed());

        viewprincipal.setVisible(true);
        viewprincipal.setResizable(false); //tamaño
        viewprincipal.setLocationRelativeTo(null);
    }
     public void jmi_peliculasActionPerformed(){
        this.viewprincipal.setContentPane(viewpeliculas);
        this.viewprincipal.revalidate();
        this.viewprincipal.repaint();
    }

    
     public void jmi_clientesActionPerformed(){
        this.viewprincipal.setContentPane(viewclientes);
        this.viewprincipal.revalidate();
        this.viewprincipal.repaint();
    }
     public void jmi_rentasActionPerformed(){
        this.viewprincipal.setContentPane(viewrentas);
        this.viewprincipal.revalidate();
        this.viewprincipal.repaint();
    }
       public void jmi_salirActionPerformed(){
        System.exit(0);
    }
}

