package com.germangascon.testviewholder;

public class Alumno {
    private String nia;
    private String nombre;
    private String apellidos;

    public Alumno(String nia, String nombre, String apellidos) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
}
