package org.iesvdm.je.dao;

import org.iesvdm.je.model.Departamento;
import org.iesvdm.je.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface DepartamentoDAO {
    public void create (Departamento departamento);
    public List<Departamento> getAll();
    public Optional<Departamento> find (int id);
    public void update (Departamento departamento);
    public  void delete (int id);
}
