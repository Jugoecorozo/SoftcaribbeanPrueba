package com.pruebaingreso.softcaribbean.manager;

import com.pruebaingreso.softcaribbean.dao.IntPaciente;
import com.pruebaingreso.softcaribbean.dto.Paciente;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import com.pruebaingreso.softcaribbean.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MgrPaciente implements IntMgrPaciente{
    private IntPaciente dao;
    @Override
    public void Save(Paciente p) throws MgrException, DaoException {
        Paciente tp = dao.SelectById(p);
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
    public void Delete(Paciente p) throws MgrException, DaoException {
        Paciente tp = dao.SelectById(p);
        try {
            if (tp != null){
                dao.Delete(p);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    @Override
    public List<Paciente> SelectAll() throws MgrException {
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new MgrException(e);
        }
    }
}
