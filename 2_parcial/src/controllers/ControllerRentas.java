package controllers;
import javax.swing.JOptionPane;
import models.ModelRentas;
import views.ViewRentas;

public final class ControllerRentas {
    private final ModelRentas model_rentas;
    private final ViewRentas view_rentas;
    
    public ControllerRentas(ModelRentas model_rentas, ViewRentas view_rentas){
        this.model_rentas = model_rentas;
        this.view_rentas = view_rentas;
        view_rentas.jbtn_primero.addActionListener(e-> jbtn_primero_clic());
        view_rentas.jbtn_anterior.addActionListener(e-> jbtn_anterior_clic());
        view_rentas.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_clic());
        view_rentas.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_clic());
        view_rentas.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_clic());
        view_rentas.jbtn_agregar.addActionListener(e-> jbtn_agregar_clic());
        view_rentas.jbtn_quitar.addActionListener(e-> jbtn_quitar_clic());
        view_rentas.jbtn_modificar.addActionListener(e-> jbtn_modificar_clic());
        initView();
    }
    
    public void initView(){
        model_rentas.Conectar();
        model_rentas.seleccionarTodos();
        model_rentas.moverPrimero();
        
        
        view_rentas.jbtn_agregar.setEnabled(false);//cush
        view_rentas.jtf_id_rentas.setEditable(false);        
        
        getValores();
    }
    public void getValores(){
        view_rentas.jtf_id_rentas.setText("" + model_rentas.getId_rentas());
        view_rentas.jtf_id.setText("" + model_rentas.getId());
     view_rentas.jtf_id_peliculas.setText("" + model_rentas.getId_peliculas());
//        view_rentas.jcb_formato.addItem(model_rentas.getFormato());
        view_rentas.jtf_costo_dia.setText(model_rentas.getCosto_dia());
        view_rentas.jtf_dias.setText(model_rentas.getDias());
         view_rentas.jtf_totalrenta.setText(model_rentas.getTotalrenta());
    }
    public void setvalores(){
        model_rentas.setId_rentas(Integer.parseInt(view_rentas.jtf_id_rentas.getText()));
        model_rentas.setId(Integer.parseInt(view_rentas.jtf_id.getText()));
         model_rentas.setId_peliculas(Integer.parseInt(view_rentas.jtf_id_peliculas.getText()));
        model_rentas.setFormato(""+view_rentas.jcb_formato.getSelectedItem());
        model_rentas.setCosto_dia(view_rentas.jtf_costo_dia.getText());
        model_rentas.setDias(view_rentas.jtf_dias.getText());
        model_rentas.setTotalrenta(view_rentas.jtf_totalrenta.getText());
        
    }
    public void jbtn_nuevo_clic(){
        agregar_true();
        
        view_rentas.jtf_id_rentas.setText("0");
        view_rentas.jtf_id.setText("0");
        view_rentas.jtf_id_peliculas.setText("0");
        view_rentas.jcb_formato.setSelectedItem("DVD");
        view_rentas.jtf_costo_dia.setText("");
        view_rentas.jtf_dias.setText("");
        view_rentas.jtf_totalrenta.setText("");
        
        
    }
    public void jbtn_agregar_clic(){
        
        if(view_rentas.jtf_costo_dia.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "llena este campo! >:(");
        }else{
        setvalores();
        model_rentas.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_modificar_clic(){
        setvalores();
        model_rentas.actualizar();
        getValores();
    }
    public void jbtn_quitar_clic(){
        setvalores();
        model_rentas.borrar();
        getValores();
    }
    public void jbtn_primero_clic(){
        model_rentas.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_clic(){
        model_rentas.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_clic(){
        model_rentas.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_clic(){
        model_rentas.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        view_rentas.jbtn_agregar.setEnabled(false);
        view_rentas.jbtn_modificar.setEnabled(true);
        view_rentas.jbtn_quitar.setEnabled(true);          
    }
    public void agregar_true(){
        view_rentas.jbtn_agregar.setEnabled(true);
        view_rentas.jbtn_quitar.setEnabled(false);
        view_rentas.jbtn_modificar.setEnabled(false);        
    }
    
}

