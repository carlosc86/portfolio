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
public class MedioContacto {
    
    private String link;
    private TipoMedioContacto tipo;

    public MedioContacto() {
    }

    public MedioContacto(String link, TipoMedioContacto tipo) {
        this.link = link;
        this.tipo = tipo;
    }
    
    

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TipoMedioContacto getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedioContacto tipo) {
        this.tipo = tipo;
    }
    
    
    
}
