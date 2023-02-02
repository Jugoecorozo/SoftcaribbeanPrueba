package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dao.IntEspecie;
import com.pruebaingreso.softcaribbean.dto.Especie;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MgrEspecie implements IntMgrEspecie {
    private IntEspecie dao;

    @Override
    public void Save(Especie e) throws MgrException, DaoException {
        Especie tp = dao.SelectById(e);
        try {
            if (tp == null){
                dao.Insert(e);
            }else{
                dao.Update(e);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public void Delete(Especie e) throws MgrException, DaoException {
        Especie tp = dao.SelectById(e);
        try {
            if (tp != null){
                dao.Delete(e);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public List<Especie> SelectAll() throws MgrException {
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new MgrException(e);
        }
    }
}
