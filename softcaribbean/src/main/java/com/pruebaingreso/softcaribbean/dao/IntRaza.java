package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.dto.Raza;
import com.pruebaingreso.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntRaza {
    public void Insert(Raza r) throws DaoException;
    public void Update(Raza r) throws DaoException;
    public void Delete(Raza r) throws DaoException;
    public List<Raza> SelectAll() throws DaoException;
    public Raza SelectById(Raza r) throws DaoException;
}
