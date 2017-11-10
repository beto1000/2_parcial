package controllers;
import javax.swing.JOptionPane;
import models.ModelClientes;
import views.ViewClientes;

public final class ControllerClientes {
    private final ModelClientes model_clientes;
    private final ViewClientes view_clientes;
    
    public ControllerClientes(ModelClientes model_clientes, ViewClientes view_clientes){
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        view_clientes.jbtn_primero.addActionListener(e-> jbtn_primero_clic());
        view_clientes.jbtn_anterior.addActionListener(e-> jbtn_anterior_clic());
        view_clientes.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_clic());
        view_clientes.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_clic());
        view_clientes.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_clic());
        view_clientes.jbtn_agregar.addActionListener(e-> jbtn_agregar_clic());
        view_clientes.jbtn_quitar.addActionListener(e-> jbtn_quitar_clic());
        view_clientes.jbtn_modificar.addActionListener(e-> jbtn_modificar_clic());
        initView();
    }
    
    public void initView(){
        model_clientes.Conectar();
        model_clientes.seleccionarTodos();
        model_clientes.moverPrimero();
        
        
        view_clientes.jbtn_agregar.setEnabled(false);//cush
        view_clientes.jtf_id.setEditable(false);        
        
        getValores();
    }
    public void getValores(){
        view_clientes.jtf_id.setText("" + model_clientes.getId());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(""+ model_clientes.getTelefono());
        view_clientes.jtf_email.setText(model_clientes.getEmail());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
        
    }
    public void setvalores(){
        model_clientes.setId(Integer.parseInt(view_clientes.jtf_id.getText()));
        model_clientes.setNombre(view_clientes.jtf_nombre.getText());
        model_clientes.setTelefono(Integer.parseInt(view_clientes.jtf_telefono.getText()));
        model_clientes.setEmail(view_clientes.jtf_email.getText());
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());
        
    }
    public void jbtn_nuevo_clic(){
        agregar_true();
        
        view_clientes.jtf_id.setText("0");
        view_clientes.jtf_nombre.setText("");
        view_clientes.jtf_telefono.setText("");
        view_clientes.jtf_email.setText("");
        view_clientes.jtf_direccion.setText("");
        
        
    }
    public void jbtn_agregar_clic(){
        
        if(view_clientes.jtf_telefono.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "llena este campo! >:(");
        }else{
        setvalores();
        model_clientes.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_modificar_clic(){
        setvalores();
        model_clientes.actualizar();
        getValores();
    }
    public void jbtn_quitar_clic(){
        setvalores();
        model_clientes.borrar();
        getValores();
    }
    public void jbtn_primero_clic(){
        model_clientes.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_clic(){
        model_clientes.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_clic(){
        model_clientes.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_clic(){
        model_clientes.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        view_clientes.jbtn_agregar.setEnabled(false);
        view_clientes.jbtn_modificar.setEnabled(true);
        view_clientes.jbtn_quitar.setEnabled(true);          
    }
    public void agregar_true(){
        view_clientes.jbtn_agregar.setEnabled(true);
        view_clientes.jbtn_quitar.setEnabled(false);
        view_clientes.jbtn_modificar.setEnabled(false);        
    }
    
}
