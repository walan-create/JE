package org.iesvdm.je.dao;

import org.iesvdm.je.model.Departamento;
import org.iesvdm.je.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO{
    @Override
    public void create(Departamento departamento) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try{
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO departamento (nombre,ubicacion,presupuesto,gastos) VALUES(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            //Aplicamos los valores al INSERT dependiendo de que tipo sean los valores
            ps.setString(1,departamento.getNombre());
            ps.setString(2,departamento.getUbicacion());
            ps.setInt(3,departamento.getPresupuesto());
            ps.setInt(4,departamento.getGastos());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                departamento.setDepartamentoId(rsGenKeys.getInt(1));


        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Departamento> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamento> list = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento");
            while (rs.next()) {
                Departamento departamento= new Departamento();

                departamento.setDepartamentoId(rs.getInt("departamentoID"));
                departamento.setNombre(rs.getString("nombre"));
                departamento.setUbicacion(rs.getString("ubicacion"));
                departamento.setPresupuesto(rs.getInt("presupuesto"));
                departamento.setGastos(rs.getInt("gastos"));
                list.add(departamento);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return list;
    }

    @Override
    public Optional<Departamento> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM departamento WHERE departamentoID = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Departamento departamento = new Departamento();

                departamento.setDepartamentoId(rs.getInt("departamentoID"));
                departamento.setNombre(rs.getString("nombre"));
                departamento.setUbicacion(rs.getString("ubicacion"));
                departamento.setPresupuesto(rs.getInt("presupuesto"));
                departamento.setGastos(rs.getInt("gastos"));

                return Optional.of(departamento);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

    @Override
    public void update(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE departamento SET nombre = ?, ubicacion = ?, presupuesto = ?, gastos = ?  WHERE departamentoID = ?");
            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setString(idx++, departamento.getUbicacion());
            ps.setInt(idx++, departamento.getPresupuesto());
            ps.setInt(idx++, departamento.getGastos());

            ps.setInt(idx++, departamento.getDepartamentoId());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update con 0 registros actualizados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public void delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM departamento WHERE departamentoID = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete con 0 registros eliminados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }
}

