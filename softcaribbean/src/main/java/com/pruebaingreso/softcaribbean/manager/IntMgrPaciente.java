package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dto.Paciente;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;

import java.util.List;

public interface IntMgrPaciente {
    public void Save(Paciente p) throws MgrException, DaoException;
    public void Delete(Paciente p) throws MgrException, DaoException;
    public List<Paciente> SelectAll()throws MgrException;
}
