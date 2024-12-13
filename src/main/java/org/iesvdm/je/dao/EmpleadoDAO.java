package org.iesvdm.je.dao;

import org.iesvdm.je.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoDAO {

    public void create (Empleado empleado);
    public List<Empleado> getAll();
    public Optional<Empleado> find (int id);
    public void update (Empleado empleado);
    public  void delete (int id);

}
