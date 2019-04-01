package com.educomser.dao;

import com.educomser.model.Empleado;
import java.util.List;

public interface EmpleadoDao {
    public List<Empleado> findAllEmpleados();
}
