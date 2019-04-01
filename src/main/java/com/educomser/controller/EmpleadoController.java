package com.educomser.controller;

import com.educomser.model.Empleado;
import com.educomser.service.EmpleadoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "empleadoController")
@ViewScoped
public class EmpleadoController implements Serializable {

    private List<Empleado> empleados;

    @ManagedProperty("#{empleadoService}")
    private EmpleadoService service;

    @PostConstruct
    public void init() {
        empleados = service.findAllEmpleados();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public EmpleadoService getService() {
        return service;
    }

    public void setService(EmpleadoService service) {
        this.service = service;
    }
}
