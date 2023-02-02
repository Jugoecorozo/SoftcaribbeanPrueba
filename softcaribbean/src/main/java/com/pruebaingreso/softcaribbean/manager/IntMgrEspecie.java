package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dto.Especie;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;

import java.util.List;

public interface IntMgrEspecie {
    public void Save(Especie e) throws MgrException, DaoException;
    public void Delete(Especie e) throws MgrException, DaoException;
    public List<Especie> SelectAll()throws MgrException;
}
