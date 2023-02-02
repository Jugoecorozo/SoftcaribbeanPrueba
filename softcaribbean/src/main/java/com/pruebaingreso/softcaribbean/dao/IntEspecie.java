package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.dto.Especie;
import com.pruebaingreso.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntEspecie {
    public void Insert(Especie e) throws DaoException;
    public void Update(Especie e) throws DaoException;
    public void Delete(Especie e) throws DaoException;
    public List<Especie> SelectAll() throws DaoException;
    public Especie SelectById(Especie e) throws DaoException;
}
