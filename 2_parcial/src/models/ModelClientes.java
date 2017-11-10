/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
        

public class ModelClientes {

  
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id;
    private String nombre;
    private int telefono;
    private String email;
    private String direccion;
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
     
    public void Conectar(){
        
            try { //jdbc:mysql://mysql-t.sourceforge.net:33060/acme_mvc //jdbc:mysql://localhost:/acme_mvc:4040
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/segundoparcial","root","tuyyoa3msc");
                st = conexion.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error 101" + ex);
        }
    }
    public void llenarValores(){
        try{
            setId(rs.getInt("id"));
            setNombre(rs.getString("nombre"));
            setTelefono(rs.getInt("telefono"));
            setEmail(rs.getString("email"));
            setDireccion(rs.getString("direccion"));
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 102" + ex);
        }
    }
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 103" + ex);
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 104" + ex);
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
                llenarValores();
                }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 105" + ex);
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
                llenarValores();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 106" + ex);
        }
    }
    public void seleccionarTodos(){
        try{
            sql="SELECT * FROM clientes;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 107" + ex);
        }
    }
    public void insertar(){ //String nombre, String telefono, String email
        try{
            sql = "INSERT INTO clientes(nombre, telefono, email,direccion) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, telefono);
            ps.setString(3, email);
            ps.setString(4, direccion);
            ps.executeUpdate();
            
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 108" + ex);
        }
    }
    public void borrar(){ //int id_persona
        try{
            sql = "DELETE FROM clientes WHERE id = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, getId());
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 109" + ex);
        }
    }
    public void actualizar(){ 
        try{
            System.out.println("nel 1");
            sql = "UPDATE clientes SET nombre=? , telefono=? , email=?, direccion=? WHERE id= ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, getId());
            ps.setString(1, nombre);
            ps.setInt(2, telefono);
            ps.setString(3, email);
            ps.setString(4, direccion);
            
            ps.executeUpdate();
            System.out.println("nel");
            moverPrimero();
            seleccionarTodos();
        }
        catch(Exception a){
            JOptionPane.showMessageDialog(null, "asdasd" + a);
        }
    }
} 

