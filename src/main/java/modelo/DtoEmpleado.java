/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author ferna
 */
public class DtoEmpleado {
    private int idEmpeado;
    private String apellidoPaterno, apellidoMaterno, nombre;
    private Date fechaContratacion;
    private float salarioDiario;

    public int getIdEmpeado() {
        return idEmpeado;
    }

    public void setIdEmpeado(int idEmpeado) {
        this.idEmpeado = idEmpeado;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apelidoPaterno) {
        this.apellidoPaterno = apelidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apelidoMaterno) {
        this.apellidoMaterno = apelidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public float getSalarioDiario() {
        return salarioDiario;
    }

    public void setSalarioDiario(float salarioDiario) {
        this.salarioDiario = salarioDiario;
    }
    
    
}
