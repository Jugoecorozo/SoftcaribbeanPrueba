package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.database.Conexion;
import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Especie;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EspecieDao implements IntEspecie{
    Conexion con = ManagerConexion.getInstance().getConexion();

    public void Insert(Especie e) throws DaoException {
        String INSERT = "INSERT INTO especie(idEspecie, nomEspecie) VALUES (?,?)";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setString(1,e.getIdEspecie());
            statement.setString(2,e.getNomEspecie());
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


    public void Update(Especie e) throws DaoException {
        String UPDATE = "UPDATE especie SET nomEspecie = ? WHERE idEspecie=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1,e.getNomEspecie());
            statement.setString(2,e.getIdEspecie());
            statement.executeUpdate();
        }catch (SQLException exe){
            throw new DaoException(exe);
        } finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }


    public void Delete(Especie e) throws DaoException {
        String DELETE = "DELETE FROM especie WHERE idEspecie=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setString(1,e.getIdEspecie());
            statement.executeUpdate();
        }catch (SQLException exe){
            throw new DaoException(exe);
        } finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }


    public List<Especie> SelectAll() throws DaoException {
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        String SQL = "SELECT * FROM especie ORDER BY idEspecie";
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        List<Especie> lista = new ArrayList<>();
        try {
            statement=connection.prepareStatement(SQL);
            resultSet = statement.executeQuery();
            Especie t=null;
            while (resultSet.next()){
                t = new Especie();
                t.setIdEspecie(resultSet.getString("idEspecie"));
                t.setNomEspecie(resultSet.getString("nomEspecie"));
                lista.add(t);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }


    public Especie SelectById(Especie e) throws DaoException {
        Especie result = null;
        String SELECT = "SELECT * FROM especie WHERE idEspecie =?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, e.getIdEspecie());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result=new Especie();
                result.setIdEspecie(resultSet.getString("idEspecie"));
                result.setNomEspecie(resultSet.getString("nomTipo"));
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
