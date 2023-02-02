package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dto.TipoId;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;

import java.util.List;

public interface IntMgrTipoId {
    public void Save(TipoId t) throws MgrException, DaoException;
    public void Delete(TipoId t) throws MgrException, DaoException;
    public List<TipoId> SelectAll()throws MgrException, DaoException;
}
