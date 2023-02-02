package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dto.Raza;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;

import java.util.List;

public interface IntMgrRaza {
    public void Save(Raza r) throws MgrException, DaoException;
    public void Delete(Raza r) throws MgrException, DaoException;
    public List<Raza> SelectAll()throws MgrException;
}
