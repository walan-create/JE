package org.iesvdm.je.model;

import java.util.Objects;

public class Departamento {

    private int departamentoId;
    private String nombre;
    private String ubicacion;
    private int presupuesto;
    private int gastos;

    public Departamento() {
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getGastos() {
        return gastos;
    }

    public void setGastos(int gastos) {
        this.gastos = gastos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return departamentoId == that.departamentoId && presupuesto == that.presupuesto && gastos == that.gastos && Objects.equals(nombre, that.nombre) && Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamentoId, nombre, ubicacion, presupuesto, gastos);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "departamentoId=" + departamentoId +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", presupuesto=" + presupuesto +
                ", gastos=" + gastos +
                '}';
    }
}
