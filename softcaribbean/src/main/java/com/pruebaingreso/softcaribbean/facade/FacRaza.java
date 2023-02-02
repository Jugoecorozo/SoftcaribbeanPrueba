package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Raza;
import com.pruebaingreso.softcaribbean.exception.FacadeException;
import com.pruebaingreso.softcaribbean.manager.IntMgrRaza;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FacRaza implements IntFacRaza{
    private IntMgrRaza RM;

    public void Process(Raza r) throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            RM.Save(r);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public void Delete(Raza r) throws FacadeException {
        try {
            ManagerConexion.getInstance().Open();
            RM.Delete(r);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public List<Raza> SelectAll() throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            return RM.SelectAll();
        } catch (Exception e) {
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
}
