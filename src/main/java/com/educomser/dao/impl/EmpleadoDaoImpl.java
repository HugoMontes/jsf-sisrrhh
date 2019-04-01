package com.educomser.dao.impl;

import com.educomser.dao.EmpleadoDao;
import com.educomser.model.Empleado;
import com.educomser.util.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class EmpleadoDaoImpl implements EmpleadoDao {

    final static Logger LOGGER = Logger.getLogger(Conexion.class);

    private Conexion conexion;

    @Override
    public List<Empleado> findAllEmpleados() {
        List<Empleado> list = new ArrayList<Empleado>();
        try {
            conexion = new Conexion();
            String sql = "SELECT * FROM empleado";
            LOGGER.info(sql);
            Statement statement = conexion.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Empleado emp = new Empleado();
                emp.setId(result.getInt("id"));
                emp.setNombres(result.getString("nombres"));
                emp.setApellidos(result.getString("apellidos"));
                emp.setFechaNac(result.getDate("fecha_nac"));
                emp.setSueldo(result.getFloat("sueldo"));
                list.add(emp);
            }
        } catch (SQLException ex) {
            LOGGER.error("Error al listar: " + ex);
        } finally {
            try {
                conexion.getConnection().close();
            } catch (SQLException ex) {
                LOGGER.error("Error al cerrar conexion");
            }
        }
        return list;
    }

}
