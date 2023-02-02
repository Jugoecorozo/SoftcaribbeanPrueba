package com.pruebaingreso.softcaribbean.dao;

import com.pruebaingreso.softcaribbean.database.Conexion;
import com.pruebaingreso.softcaribbean.database.ManagerConexion;
import com.pruebaingreso.softcaribbean.dto.Paciente;
import com.pruebaingreso.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDao implements IntPaciente{
    Conexion con= ManagerConexion.getInstance().getConexion();
    @Override
    public void Insert(Paciente p) throws DaoException {
        String INSERT = "INSERT INTO paciente (idPaciente, nomPaciente, especie, raza, fechaNac, idPromascota, fechaIng" +
                "ciudad,direccion,tel) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setString(1,p.getIdPaciente());
            statement.setString(2,p.getNomPaciente());
            statement.setString(3,p.getEspecie());
            statement.setString(4,p.getRaza());
            statement.setString(5,p.getFechaNac());
            statement.setString(6,p.getIdProMascota());
            statement.setString(7,p.getFechaIng());
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
    public void Update(Paciente p) throws DaoException {
        String UPDATE = "UPDATE paciente " +
                "SET nomPaciente = ?," +
                "especie =?," +
                "raza=?," +
                "fechaNac=?," +
                "idProMascota=?," +
                "fechaIng=?" +
                "WHERE idPaciente = ?) ";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,p.getNomPaciente());
            statement.setString(2,p.getEspecie());
            statement.setString(3,p.getRaza());
            statement.setString(4,p.getFechaNac());
            statement.setString(5,p.getIdProMascota());
            statement.setString(6,p.getFechaIng());
            statement.setString(7,p.getIdPaciente());
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
    public void Delete(Paciente p) throws DaoException {
        String DELETE = "DELETE FROM paciente WHERE idPaciente = ?) ";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(DELETE);
            statement.setString(1,p.getIdPaciente());
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
    public List<Paciente> SelectAll() throws DaoException {
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        String SQL = "SELECT idPaciente, nomPaciente, nomEspecie, nomRaza,fechaNac, numId, fechaIng " +
                "FROM paciente " +
                "JOIN especie ON paciente.especie = especie.idEspecie " +
                "JOIN raza ON paciente.raza = raza.idRaza " +
                "JOIN propietario ON paciente.idProMascota = propietario.idPropietario";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List<Paciente> lista= new ArrayList<>();

        try {
            statement = connection.prepareStatement(SQL);
            resultSet= statement.executeQuery();
            Paciente p = null;

            while(resultSet.next()){
                p = new Paciente();
                p.setIdPaciente(resultSet.getString("idPaciente"));
                p.setNomPaciente(resultSet.getString("nomPaciente"));
                p.setEspecie(resultSet.getString("nomEspecie"));
                p.setRaza(resultSet.getString("nomRaza"));
                p.setFechaNac(resultSet.getString("fechaNac"));
                p.setIdProMascota(resultSet.getString("numId"));
                p.setFechaIng(resultSet.getString("fechaIng"));
                lista.add(p);
            }
        }catch (Exception e){
            throw new DaoException(e);
        }
        return lista;
    }

    @Override
    public Paciente SelectById(Paciente p) throws DaoException {
        Paciente result=null;
        String SELECT = "SELECT idPaciente, nomPaciente, nomEspecie, nomRaza,fechaNac, numId, fechaIng " +
                "FROM paciente "+
                "JOIN especie ON paciente.especie = especie.idEspecie "+
                "JOIN raza ON paciente.raza = raza.idRaza " +
                "JOIN propietario ON paciente.idProMascota = propietario.idPropietario " +
                "WHERE sku=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1,p.getIdPaciente());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result= new Paciente();
                result.setIdPaciente(resultSet.getString("idPaciente"));
                result.setNomPaciente(resultSet.getString("nomPaciente"));
                result.setEspecie(resultSet.getString("nomEspecie"));
                result.setRaza(resultSet.getString("nomRaza"));
                result.setFechaNac(resultSet.getString("fechaNac"));
                result.setIdProMascota(resultSet.getString("numId"));
                result.setFechaIng(resultSet.getString("fechaIng"));
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
