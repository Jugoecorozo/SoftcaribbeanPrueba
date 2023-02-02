package com.pruebaingreso.softcaribbean.facade;

import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Propietario;
import com.pruebaingreso.softcaribbean.exception.FacadeException;
import com.pruebaingreso.softcaribbean.manager.IntMgrPropietario;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FacPropietario implements IntFacPropietario{
    private IntMgrPropietario PM;

    public void Process(Propietario p) throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            PM.Save(p);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public void Delete(Propietario p) throws FacadeException {
        try {
            ManagerConexion.getInstance().Open();
            PM.Delete(p);
            ManagerConexion.getInstance().Commit();
        } catch (Exception ex) {
            throw new FacadeException(ex);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }


    public List<Propietario> SelectAll() throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            return PM.SelectAll();
        } catch (Exception e) {
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
}
