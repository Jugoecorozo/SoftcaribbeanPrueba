package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dto.Propietario;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;

import java.util.List;

public interface IntMgrPropietario {
    public void Save(Propietario p) throws MgrException, DaoException;
    public void Delete(Propietario p) throws MgrException, DaoException;
    public List<Propietario> SelectAll()throws MgrException;
}
