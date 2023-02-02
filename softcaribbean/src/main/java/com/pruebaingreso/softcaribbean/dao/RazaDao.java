package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.database.Conexion;
import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Raza;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RazaDao implements IntRaza{

    Conexion con = ManagerConexion.getInstance().getConexion();
    @Override
    public void Insert(Raza r) throws DaoException {
        String INSERT = "INSERT INTO raza (idRaza,nomRaza) VALUES (?,?)";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setString(1,r.getIdRaza());
            statement.setString(2,r.getNomRaza());
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
    public void Update(Raza r) throws DaoException {
        String UPDATE = "UPDATE raza SET nomRaza = ? where idRaza=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1,r.getNomRaza());
            statement.setString(2,r.getIdRaza());

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
    public void Delete(Raza r) throws DaoException {
        String DELETE = "DELETE FROM raza  where idRaza=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setString(1,r.getIdRaza());
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
    public List<Raza> SelectAll() throws DaoException {
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        String SQL = "SELECT * FROM raza ORDER BY idRaza";
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        List<Raza> lista = new ArrayList<>();
        try {
            statement=connection.prepareStatement(SQL);
            resultSet = statement.executeQuery();
            Raza t=null;
            while (resultSet.next()){
                t = new Raza();
                t.setIdRaza(resultSet.getString("idRaza"));
                t.setNomRaza(resultSet.getString("nomRaza"));
                lista.add(t);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public Raza SelectById(Raza r) throws DaoException {
        Raza result = null;
        String SELECT = "SELECT * FROM raza WHERE idRaza =?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, r.getIdRaza());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result=new Raza();
                result.setIdRaza(resultSet.getString("idRaza"));
                result.setNomRaza(resultSet.getString("nomRaza"));
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
