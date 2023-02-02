package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.dto.TipoId;
import com.pruebaingreso.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntTipoId {
    public void Insert(TipoId t) throws DaoException;
    public void Update(TipoId t) throws DaoException;
    public void Delete(TipoId t) throws DaoException;
    public List<TipoId> SelectAll() throws DaoException;
    public TipoId SelectById(TipoId t) throws DaoException;
}
