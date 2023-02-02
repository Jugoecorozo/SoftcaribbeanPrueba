package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dao.IntTipoId;
import com.pruebaingreso.softcaribbean.dto.TipoId;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MgrTipoId implements IntMgrTipoId {
    private IntTipoId dao;
    @Override
    public void Save(TipoId t) throws MgrException, DaoException {
        TipoId tp = dao.SelectById(t);
        try {
            if (tp == null){
                dao.Insert(t);
            }else{
                dao.Update(t);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public void Delete(TipoId t) throws MgrException, DaoException {
        TipoId tp = dao.SelectById(t);
        try {
            if (tp != null){
                dao.Delete(t);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public List<TipoId> SelectAll() throws MgrException, DaoException {
        try {
            return dao.SelectAll();
        } catch (Exception e) {
            throw new MgrException(e);
        }
    }
}
