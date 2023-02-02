package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.database.Conexion;
import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.TipoId;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TipoIdDao implements IntTipoId{
    Conexion con = ManagerConexion.getInstance().getConexion();
    @Override
    public void Insert(TipoId t) throws DaoException {
        String INSERT = "INSERT INTO tipoIdentificacion(idTipo, nomTipo) VALUES (?,?)";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setString(1,t.getIdTipo());
            statement.setString(2,t.getNomTipo());
            statement.executeUpdate();
        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Update(TipoId t) throws DaoException {
        String UPDATE = "UPDATE tipoIdentificacion SET nomTipo = ? where idTipo=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1,t.getNomTipo());
            statement.setString(2,t.getIdTipo());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Delete(TipoId t) throws DaoException {
        String DELETE = "DELETE FROM tipoIdentificacion where idTipo=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setString(1,t.getIdTipo());
            statement.executeUpdate();
        }catch (Exception e){
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<TipoId> SelectAll() throws DaoException {
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        String SQL = "SELECT * FROM tipoIdentificacion ORDER BY idTipo";
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        List<TipoId> lista = new ArrayList<>();
        try {
            statement=connection.prepareStatement(SQL);
            resultSet = statement.executeQuery();
            TipoId t=null;
            while (resultSet.next()){
                t = new TipoId();
                t.setIdTipo(resultSet.getString("idTipo"));
                t.setNomTipo(resultSet.getString("nomTipo"));
                lista.add(t);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public TipoId SelectById(TipoId t) throws DaoException {
        TipoId result = null;
        String SELECT = "SELECT * FROM tipoIdentificacion WHERE idTipo =?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, t.getIdTipo());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result=new TipoId();
                result.setIdTipo(resultSet.getString("idTipo"));
                result.setNomTipo(resultSet.getString("nomTipo"));
            }
        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try {
                resultSet.close();
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
