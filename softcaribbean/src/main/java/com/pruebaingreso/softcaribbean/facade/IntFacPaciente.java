package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.dto.Paciente;
import com.pruebaingreso.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntFacPaciente {
    public void Process(Paciente p)throws FacadeException;
    public void Delete(Paciente p)throws FacadeException;
    public List<Paciente> SelectAll()throws FacadeException;
}
