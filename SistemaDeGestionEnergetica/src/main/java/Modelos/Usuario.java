package main.java.Modelos;

import java.util.Date;
import java.util.List;

public class Usuario {


    private String documento;
    private Integer telefono;
    private Date fechaDeAlta;
    private Integer puntaje;
    private List<Domicilio> listaDomicilios;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public List<Domicilio> getListaDomicilios() {
        return listaDomicilios;
    }

    public void setListaDomicilios(List<Domicilio> listaDomicilios) {
        this.listaDomicilios = listaDomicilios;
    }

}
