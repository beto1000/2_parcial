package controllers;
import javax.swing.JOptionPane;
import models.ModelPeliculas;
import views.ViewPeliculas;

public final class ControllerPeliculas {
    private final ModelPeliculas modelpeliculas;
    private final ViewPeliculas viewpeliculas;
    
    public ControllerPeliculas(ModelPeliculas modelpeliculas, ViewPeliculas viewpeliculas){
        this.modelpeliculas = modelpeliculas;
        this.viewpeliculas = viewpeliculas;
        viewpeliculas.jbtn_primero.addActionListener(e-> jbtn_primero_clic());
        viewpeliculas.jbtn_anterior.addActionListener(e-> jbtn_anterior_clic());
        viewpeliculas.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_clic());
        viewpeliculas.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_clic());
        viewpeliculas.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_clic());
        viewpeliculas.jbtn_agregar.addActionListener(e-> jbtn_agregar_clic());
        viewpeliculas.jbtn_quitar.addActionListener(e-> jbtn_quitar_clic());
        viewpeliculas.jbtn_modificar.addActionListener(e-> jbtn_modificar_clic());
        initView();
    }
    
    public void initView(){
        modelpeliculas.Conectar();
        modelpeliculas.seleccionarTodos();
        modelpeliculas.moverPrimero();
        
        
        viewpeliculas.jbtn_agregar.setEnabled(false);//cush
        viewpeliculas.jtf_id_peliculas.setEditable(false);        
        
        getValores();
    }
    public void getValores(){
        viewpeliculas.jtf_id_peliculas.setText("" + modelpeliculas.getId_peliculas());
        viewpeliculas.jtf_nombrepelicula.setText(modelpeliculas.getNombrepelicula());
        viewpeliculas.jcb_formato.setSelectedItem(modelpeliculas.getFormato());
        viewpeliculas.jtf_duracion.setText(modelpeliculas.getDuracion());
        viewpeliculas.jtf_descripcion.setText(modelpeliculas.getDescripcion());
        
    }
    public void setvalores(){
        modelpeliculas.setId_peliculas(Integer.parseInt(viewpeliculas.jtf_id_peliculas.getText()));
        modelpeliculas.setNombrepelicula(viewpeliculas.jtf_nombrepelicula.getText());
        modelpeliculas.setFormato(""+viewpeliculas.jcb_formato.getSelectedItem());
        modelpeliculas.setDuracion(viewpeliculas.jtf_duracion.getText());
        modelpeliculas.setDescripcion(viewpeliculas.jtf_descripcion.getText());
        
    }
    public void jbtn_nuevo_clic(){
        agregar_true();
        
        viewpeliculas.jtf_id_peliculas.setText("0");
        viewpeliculas.jtf_nombrepelicula.setText("");
        viewpeliculas.jcb_formato.setSelectedItem("DVD");
        viewpeliculas.jtf_duracion.setText("");
        viewpeliculas.jtf_descripcion.setText("");
        
        
    }
    public void jbtn_agregar_clic(){
        
        if(viewpeliculas.jtf_nombrepelicula.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setvalores();
        modelpeliculas.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_modificar_clic(){
        setvalores();
        modelpeliculas.actualizar();
        getValores();
    }
    public void jbtn_quitar_clic(){
        setvalores();
        modelpeliculas.borrar();
        getValores();
    }
    public void jbtn_primero_clic(){
        modelpeliculas.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_clic(){
        modelpeliculas.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_clic(){
        modelpeliculas.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_clic(){
        modelpeliculas.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        viewpeliculas.jbtn_agregar.setEnabled(false);
        viewpeliculas.jbtn_modificar.setEnabled(true);
        viewpeliculas.jbtn_quitar.setEnabled(true);          
    }
    public void agregar_true(){
        viewpeliculas.jbtn_agregar.setEnabled(true);
        viewpeliculas.jbtn_quitar.setEnabled(false);
        viewpeliculas.jbtn_modificar.setEnabled(false);        
    }
    
}
