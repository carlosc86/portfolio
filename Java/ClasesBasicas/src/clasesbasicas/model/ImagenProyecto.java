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
public class ImagenProyecto {
    
    private String urlImagen;
    private String pieImagen;

    public ImagenProyecto() {
    }

    public ImagenProyecto(String urlImagen, String pieImagen) {
        this.urlImagen = urlImagen;
        this.pieImagen = pieImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getPieImagen() {
        return pieImagen;
    }

    public void setPieImagen(String pieImagen) {
        this.pieImagen = pieImagen;
    }
    
    
    
}
