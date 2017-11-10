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
import java.sql.Time;
        

public class ModelPeliculas {

 
  
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_peliculas;
    private String nombrepelicula;
    private String formato;
    private String duracion;
    private String descripcion;
    
    /**
     * @return the id
     */
    public int getId_peliculas() {
        return id_peliculas;
    }

    /**
     * @param id_peliculas the id to set
     */
    public void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
    }

    /**
     * @return the nombrepelicula
     */
    public String getNombrepelicula() {
        return nombrepelicula;
    }

    /**
     * @param nombrepelicula the nombrepelicula to set
     */
    public void setNombrepelicula(String nombrepelicula) {
        this.nombrepelicula = nombrepelicula;
    }

    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
            setId_peliculas(rs.getInt("id_peliculas"));
            setNombrepelicula(rs.getString("nombrepelicula"));
            setFormato(rs.getString("formato"));
            setDuracion(rs.getString("duracion"));
            setDescripcion(rs.getString("descripcion"));
            
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
            sql="SELECT * FROM peliculas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 107" + ex);
        }
    }
    public void insertar(){ //String nombre, String telefono, String email
        try{
            sql = "INSERT INTO peliculas(nombrepelicula, formato, duracion,descripcion) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombrepelicula);
            ps.setString(2, formato);
            ps.setTime(3,Time.valueOf(duracion));
            ps.setString(4, descripcion);
            ps.executeUpdate();
            
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 108" + ex);
        }
    }
    public void borrar(){ //int id
        try{
            sql = "DELETE FROM peliculas WHERE id_peliculas = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, getId_peliculas());
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
            sql = "UPDATE peliculas SET nombrepelicula=? , formato=? , duracion=?, descripcion=? WHERE id_peliculas= ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, getId_peliculas());
            ps.setString(1, nombrepelicula);
            ps.setString(2, formato);
            ps.setTime(3,Time.valueOf(duracion));
            ps.setString(4, descripcion);
            
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


