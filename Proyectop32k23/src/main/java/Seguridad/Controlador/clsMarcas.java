/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoMarcas;
/**
 *
 * @author visitante
 */
public class clsMarcas {
    private int IdMarcas;
    private String NombreMarcas;
    private String ExistenciasMarcas;
    private String PreciosMarcas;

    public int getIdMarcas() {
        return IdMarcas;
    }

    public void setIdMarcas(int IdMarcas) {
        this.IdMarcas = IdMarcas;
    }

    public String getNombreMarcas() {
        return NombreMarcas;
    }

    public void setNombreMarcas(String NombreMarcas) {
        this.NombreMarcas = NombreMarcas;
    }

    public String getExistenciasMarcas() {
        return ExistenciasMarcas;
    }

    public void setExistenciasMarcas(String ExistenciasMarcas) {
        this.ExistenciasMarcas = ExistenciasMarcas;
    }

    public String getPreciosMarcas() {
        return PreciosMarcas;
    }

    public void setPreciosMarcas(String PreciosMarcas) {
        this.PreciosMarcas = PreciosMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas, String ExistenciasMarcas, String PreciosMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
        this.PreciosMarcas = PreciosMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas, String ExistenciasMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
    }

    public clsMarcas(int IdMarcas) {
        this.IdMarcas = IdMarcas;
    }

    public clsMarcas() {
    }
    
    //Metodos de acceso a la capa controlador
    public clsMarcas getBuscarInformacionMarcasPorNombre(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.consultaMarcasPorNombre(Marcas);
    }
    public clsMarcas getBuscarInformacionMarcasPorId(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.consultaMarcasPorId(Marcas);
    }
    public List<clsMarcas> getListadoMarcas()
    {
        daoMarcas daomarcas = new daoMarcas();
        List<clsMarcas> listadoMarcas = daomarcas.consultaMarcas();
        return listadoMarcas;
    }
    public int setBorrarMarcas(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.borrarMarcas(Marcas);
    }
    public int setIngresarMarcas(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.ingresaMarcas(Marcas);
    }              
    public int setModificarMarcas(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.actualizaMarcas(Marcas);
    }

    public void add(List<clsMarcas> Marcas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
