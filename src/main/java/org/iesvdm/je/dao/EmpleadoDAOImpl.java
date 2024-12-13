package org.iesvdm.je.dao;

import org.iesvdm.je.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadoDAO{

    @Override
    public void create(Empleado empleado) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try{
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO empleado (nombre,apellido,rol,departamento_id) VALUES(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            //Aplicamos los valores al INSERT dependiendo de que tipo sean los valores
            ps.setString(1,empleado.getNombre());
            ps.setString(2,empleado.getApellido());
            ps.setString(3,empleado.getRol());
            ps.setInt(4,empleado.getDepartamentoId());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                empleado.setEmpleadoId(rsGenKeys.getInt(1));


        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Empleado> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Empleado> list = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM empleado");
            while (rs.next()) {
                Empleado empleado= new Empleado();

                empleado.setEmpleadoId(rs.getInt("empleadoID"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setRol(rs.getString("rol"));
                empleado.setDepartamentoId(rs.getInt("departamento_id"));
                list.add(empleado);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return list;
    }

    @Override
    public Optional<Empleado> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM empleado WHERE empleadoID = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Empleado empleado = new Empleado();

                empleado.setEmpleadoId(rs.getInt("empleadoID"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setRol(rs.getString("rol"));
                empleado.setDepartamentoId(rs.getInt("departamento_id"));

                return Optional.of(empleado);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

    @Override
    public void update(Empleado empleado) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE empleado SET nombre = ?, apellido = ?, rol = ?, departamento_id = ?  WHERE empleadoID = ?");
            int idx = 1;
            ps.setString(idx++, empleado.getNombre());
            ps.setString(idx++, empleado.getApellido());
            ps.setString(idx++, empleado.getRol());
            ps.setInt(idx++, empleado.getDepartamentoId());

            ps.setInt(idx++, empleado.getEmpleadoId());

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

            ps = conn.prepareStatement("DELETE FROM empleado WHERE empleadoID = ?");
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
