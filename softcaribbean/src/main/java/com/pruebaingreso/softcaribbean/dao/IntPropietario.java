package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.dto.Propietario;
import com.pruebaingreso.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntPropietario {
    public void Insert(Propietario p) throws DaoException;
    public void Update(Propietario p) throws DaoException;
    public void Delete(Propietario p) throws DaoException;
    public List<Propietario> SelectAll() throws DaoException;
    public Propietario SelectById(Propietario p) throws DaoException;
}
