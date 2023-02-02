package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.TipoId;
import com.pruebaingreso.softcaribbean.exception.FacadeException;
import com.pruebaingreso.softcaribbean.manager.IntMgrTipoId;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FacTipoId implements  IntFacTipoId{
    private IntMgrTipoId TM;

    public void Process(TipoId t) throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            TM.Save(t);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public void Delete(TipoId p) throws FacadeException {
        try {
            ManagerConexion.getInstance().Open();
            TM.Delete(p);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public List<TipoId> SelectAll() throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            return TM.SelectAll();
        } catch (Exception e) {
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
}
