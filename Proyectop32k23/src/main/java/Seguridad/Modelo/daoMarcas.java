/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsMarcas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarcas {

    private static final String SQL_SELECT = "SELECT marCodigo, marNombre, marExistencias, marPrecios FROM tbl_marcas";
    private static final String SQL_INSERT = "INSERT INTO tbl_marcas(marNombre, marExistencias, marPrecios) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marcas SET marNombre=?, marExistencias=?, marPrecios=? WHERE marCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marcas WHERE marCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT marCodigo, marNombre, marExistencias, marPrecios FROM tbl_marcas WHERE marNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT marCodigo, marNombre, marExistencias, marPrecios FROM tbl_marcas WHERE marCodigo = ?";    

    public List<clsMarcas> consultaMarcas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMarcas> marcas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                String existencias = rs.getString("marExistencias");
                String precio = rs.getString("marPrecios");
                clsMarcas Marcas = new clsMarcas();
                Marcas.setIdMarcas(id);
                Marcas.setNombreMarcas(nombre);
                Marcas.setExistenciasMarcas(existencias);
                Marcas.setPreciosMarcas(precio);
                
                marcas.add(Marcas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return marcas;
    }

    public int ingresaMarcas(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marcas.getNombreMarcas());
            stmt.setString(2, marcas.getExistenciasMarcas());
            stmt.setString(3, marcas.getPreciosMarcas());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaMarcas(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marcas.getNombreMarcas());
            stmt.setString(2, marcas.getExistenciasMarcas());
            stmt.setString(3, marcas.getPreciosMarcas());
            stmt.setInt(4, marcas.getIdMarcas());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarMarcas(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, marcas.getIdMarcas());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsMarcas consultaMarcasPorNombre(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marcas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, marcas.getNombreMarcas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                String existencias = rs.getString("marExistencias");
                String precios = rs.getString("marPrecios");

                //aplicacion = new clsAplicacion();
                marcas.setIdMarcas(id);
                marcas.setNombreMarcas(nombre);
                marcas.setExistenciasMarcas(existencias);
                marcas.setPreciosMarcas(precios);
                System.out.println(" registro consultado: " + marcas);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return marcas;
    }
    public clsMarcas consultaMarcasPorId(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marcas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, marcas.getIdMarcas());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                String existencias = rs.getString("marExistencias");
                String precios = rs.getString("marPrecios");

                //aplicacion = new clsAplicacion();
                marcas.setIdMarcas(id);
                marcas.setNombreMarcas(nombre);
                marcas.setExistenciasMarcas(existencias);
                marcas.setPreciosMarcas(precios);
                System.out.println(" registro consultado: " + marcas);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return marcas;
    }    
}
