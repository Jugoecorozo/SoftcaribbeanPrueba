package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.database.Conexion;
import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Propietario;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PropietarioDao implements IntPropietario{
    Conexion con= ManagerConexion.getInstance().getConexion();
    @Override
    public void Insert(Propietario p) throws DaoException {
        String INSERT = "INSERT INTO propietario (idPropietario, nomPropietario,tipoId,numId" +
                "ciudad,direccion,tel) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setString(1,p.getIdPropietario());
            statement.setString(2,p.getNomPropietario());
            statement.setString(3,p.getTipoId());
            statement.setString(4,p.getNumId());
            statement.setString(5,p.getCiudad());
            statement.setString(6,p.getDireccion());
            statement.setString(7,p.getTel());
            statement.executeUpdate();

        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Update(Propietario p) throws DaoException {
        String UPDATE = "UPDATE propietario " +
                "SET nomPropietario = ?," +
                "tipoId =?," +
                "numId=?," +
                "ciudad=?," +
                "direccion=?," +
                "tel=?" +
                "WHERE idPropietario = ?) ";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,p.getNomPropietario());
            statement.setString(2,p.getTipoId());
            statement.setString(3,p.getNumId());
            statement.setString(4,p.getCiudad());
            statement.setString(5,p.getDireccion());
            statement.setString(6,p.getTel());
            statement.setString(7,p.getIdPropietario());
            statement.executeUpdate();

        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void Delete(Propietario p) throws DaoException {
        String DELETE = "DELETE FROM propietario WHERE idPropietario = ?) ";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(DELETE);
            statement.setString(1,p.getIdPropietario());
            statement.executeUpdate();
        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Propietario> SelectAll() throws DaoException {
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        String SQL = "SELECT idPropietario, nomPropietario,nomTipo, numId, ciudad, direccion, tel " +
                "FROM propietario JOIN tipoIdentificacion ON propietario.tipoId= tipoIdentificacion.idTipo " +
                "ORDER BY idPropietario";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List<Propietario> lista= new ArrayList<>();

        try {
            statement = connection.prepareStatement(SQL);
            resultSet= statement.executeQuery();
            Propietario p = null;

            while(resultSet.next()){
                p = new Propietario();
                p.setIdPropietario(resultSet.getString("idPropietario"));
                p.setNomPropietario(resultSet.getString("nomPropietario"));
                p.setTipoId(resultSet.getString("tipoId"));
                p.setNumId(resultSet.getString("numId"));
                p.setCiudad(resultSet.getString("ciudad"));
                p.setDireccion(resultSet.getString("direccion"));
                p.setTel(resultSet.getString("tel"));
                lista.add(p);
            }
        }catch (Exception e){
            throw new DaoException(e);
        }
        return lista;
    }

    @Override
    public Propietario SelectById(Propietario p) throws DaoException {
        Propietario result=null;
        String SELECT = "SELECT * FROM propietario WHERE sku=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1,p.getIdPropietario());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result= new Propietario();
                result.setIdPropietario(resultSet.getString("idPropietario"));
                result.setNomPropietario(resultSet.getString("nomPropietario"));
                result.setTipoId(resultSet.getString("tipoId"));
                result.setNumId(resultSet.getString("numId"));
                result.setCiudad(resultSet.getString("ciudad"));
                result.setDireccion(resultSet.getString("direccion"));
                result.setTel(resultSet.getString("tel"));
            }
        }catch (Exception E){
            throw new DaoException(E);

        }finally {
            try{
                resultSet.close();
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
