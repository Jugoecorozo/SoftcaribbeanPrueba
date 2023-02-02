package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Especie;
import com.pruebaingreso.softcaribbean.exception.FacadeException;
import com.pruebaingreso.softcaribbean.manager.IntMgrEspecie;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FacEspecie implements IntFacEspecie {
    private IntMgrEspecie EM;

    public void Process(Especie e) throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            EM.Save(e);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public void Delete(Especie e) throws FacadeException {
        try {
            ManagerConexion.getInstance().Open();
            EM.Delete(e);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public List<Especie> SelectAll() throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            return EM.SelectAll();
        } catch (Exception e) {
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
}
