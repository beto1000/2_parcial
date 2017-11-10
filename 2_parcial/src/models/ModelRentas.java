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
        

public class ModelRentas {

    /**
     * @return the id_rentas
     */
    public int getId_rentas() {
        return id_rentas;
    }


  
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_rentas;
    private int id;
    private int id_peliculas;
    private String formato;
    private String costo_dia;
    private String dias;
    private String totalrenta;

    /**
     * @param id_rentas the id_rentas to set
     */
    public void setId_rentas(int id_rentas) {
        this.id_rentas = id_rentas;
    }

    /**
     * @return the id
     */
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
     * @return the id_peliculas
     */
    public int getId_peliculas() {
        return id_peliculas;
    }

    /**
     * @param id_peliculas the id_peliculas to set
     */
    public void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
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
     * @return the costo_dia
     */
    public String getCosto_dia() {
        return costo_dia;
    }

    /**
     * @param costo_dia the costo_dia to set
     */
    public void setCosto_dia(String costo_dia) {
        this.costo_dia = costo_dia;
    }

    /**
     * @return the dias
     */
    public String getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(String dias) {
        this.dias = dias;
    }

    /**
     * @return the totalrenta
     */
    public String getTotalrenta() {
        return totalrenta;
    }

    /**
     * @param totalrenta the totalrenta to set
     */
    public void setTotalrenta(String totalrenta) {
        this.totalrenta = totalrenta;
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
            setId_rentas(rs.getInt("id_rentas"));
            setId(rs.getInt("id"));
            setId_peliculas(rs.getInt("id_peliculas"));
            setFormato(rs.getString("formato"));
            setCosto_dia(rs.getString("costo_dia"));
            setDias(rs.getString("dias"));
            setTotalrenta(rs.getString("totalrenta"));
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
            sql="SELECT * FROM rentas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 107" + ex);
        }
    }
    public void insertar(){ //String nombre, String telefono, String email
        try{
            sql = "INSERT INTO rentas(id, id_peliculas, formato, costo_dia, dias, totalrenta) VALUES (?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id_peliculas);
            ps.setString(3, formato);
            ps.setString(4, costo_dia);
            ps.setString(5, dias);
            ps.setString(6, totalrenta);
            ps.executeUpdate();
            
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 108" + ex);
        }
    }
    public void borrar(){ //int id_persona
        try{
            sql = "DELETE FROM rentas WHERE id_rentas = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, getId_rentas());
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
            sql = "UPDATE rentas SET id=? , id_peliculas=? , formato=?, costo_dia=?, dias=? , totalrenta=?WHERE id_rentas= ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(7, getId_rentas());
            ps.setInt(1, id);
            ps.setInt(2, id_peliculas);
            ps.setString(3, formato);
            ps.setString(4, costo_dia);
            ps.setString(5, dias);
            ps.setString(6, totalrenta);
            
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

