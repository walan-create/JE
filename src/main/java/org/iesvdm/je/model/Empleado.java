package org.iesvdm.je.model;

import java.util.Objects;

public class Empleado {

    private int empleadoId;
    private String nombre;
    private String apellido;
    private String rol;
    private int departamentoId;

    public Empleado() {
    }

    public Empleado(int departamentoId, String rol, String apellido, String nombre, int empleadoId) {
        this.departamentoId = departamentoId;
        this.rol = rol;
        this.apellido = apellido;
        this.nombre = nombre;
        this.empleadoId = empleadoId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return empleadoId == empleado.empleadoId && departamentoId == empleado.departamentoId && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(rol, empleado.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoId, nombre, apellido, rol, departamentoId);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "empleadoId=" + empleadoId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rol='" + rol + '\'' +
                ", departamentoId=" + departamentoId +
                '}';
    }
}
