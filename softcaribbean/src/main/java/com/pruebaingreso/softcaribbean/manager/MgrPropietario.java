package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dao.IntPropietario;
import com.pruebaingreso.softcaribbean.dto.Propietario;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MgrPropietario implements IntMgrPropietario {
    private IntPropietario dao;
    @Override
    public void Save(Propietario p) throws MgrException, DaoException {
        Propietario tp = dao.SelectById(p);
        try {
            if (tp == null){
                dao.Insert(p);
            }else{
                dao.Update(p);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public void Delete(Propietario p) throws MgrException, DaoException {
        Propietario tp = dao.SelectById(p);
        try {
            if (tp != null){
                dao.Delete(p);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public List<Propietario> SelectAll() throws MgrException {
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new MgrException(e);
        }
    }
}
