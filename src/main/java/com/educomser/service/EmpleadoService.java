package com.educomser.service;

import com.educomser.dao.EmpleadoDao;
import com.educomser.dao.impl.EmpleadoDaoImpl;
import com.educomser.model.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "empleadoService")
@SessionScoped
public class EmpleadoService implements Serializable{

    private EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

    public List<Empleado> findAllEmpleados() {
        return empleadoDao.findAllEmpleados();
    }

}
