package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.dto.TipoId;
import com.pruebaingreso.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntFacTipoId {
    public void Process(TipoId t)throws FacadeException;
    public void Delete(TipoId p)throws FacadeException;
    public List<TipoId> SelectAll()throws FacadeException;
}
