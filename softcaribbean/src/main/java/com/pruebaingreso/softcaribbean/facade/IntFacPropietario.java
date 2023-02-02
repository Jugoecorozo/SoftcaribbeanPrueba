package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.dto.Propietario;
import com.pruebaingreso.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntFacPropietario {
    public void Process(Propietario p)throws FacadeException;
    public void Delete(Propietario p)throws FacadeException;
    public List<Propietario> SelectAll()throws FacadeException;
}
