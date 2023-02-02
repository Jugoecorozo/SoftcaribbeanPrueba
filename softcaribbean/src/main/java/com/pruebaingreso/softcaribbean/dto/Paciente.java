package com.pruebaingreso.softcaribbean.dto;

public class Paciente {

    private String idPaciente;
    private String nomPaciente;
    private String especie;
    private String raza;
    private String fechaNac; //dar formato a la fecha YYYY-MM-DD
    private String idProMascota;
    private String FechaIng;

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getIdProMascota() {
        return idProMascota;
    }

    public void setIdProMascota(String idProMascota) {
        this.idProMascota = idProMascota;
    }

    public String getFechaIng() {
        return FechaIng;
    }

    public void setFechaIng(String fechaIng) {
        FechaIng = fechaIng;
    }

}
