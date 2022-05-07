/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas.model;

/**
 *
 * @author carlos
 */
public class TipoMedioContacto {
    
    private String empresa;
    private String rutaIcono;

    public TipoMedioContacto() {
    }

    public TipoMedioContacto(String empresa, String rutaIcono) {
        this.empresa = empresa;
        this.rutaIcono = rutaIcono;
    }
    
    

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRutaIcono() {
        return rutaIcono;
    }

    public void setRutaIcono(String rutaIcono) {
        this.rutaIcono = rutaIcono;
    }
    
    
    
}
