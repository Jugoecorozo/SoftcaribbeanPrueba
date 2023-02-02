package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.dto.Especie;
import com.pruebaingreso.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntFacEspecie {
    public void Process(Especie e)throws FacadeException;
    public void Delete(Especie e)throws FacadeException;
    public List<Especie> SelectAll()throws FacadeException;
}
