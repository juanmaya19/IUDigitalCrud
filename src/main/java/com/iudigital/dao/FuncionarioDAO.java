package com.iudigital.dao;

import static com.iudigital.util.Conexion.*;
import com.iudigital.domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static final String SELECT = "SELECT funcionarios.id_funcionario, funcionarios.tipo_identificacion, funcionarios.numero_identificacion, funcionarios.nombres, funcionarios.apellidos," +
            "funcionarios.direccion, funcionarios.telefono, estado.nombre, sexo.nombre FROM funcionarios " +
            "INNER JOIN estado ON funcionarios.estado_civil = estado.id_estado " +
            "INNER JOIN sexo ON funcionarios.sexo = sexo.id_sexo";

    private static final String SELECT_BY_ID = "SELECT funcionarios.id_funcionario, funcionarios.tipo_identificacion, funcionarios.numero_identificacion, funcionarios.nombres, funcionarios.apellidos," +
            "funcionarios.direccion, funcionarios.telefono, estado.nombre, sexo.nombre FROM funcionarios " +
            "INNER JOIN estado ON funcionarios.estado_civil = estado.id_estado " +
            "INNER JOIN sexo ON funcionarios.sexo = sexo.id_sexo WHERE id_funcionario = ?";
    private static final String SQL_INSERT = "INSERT INTO funcionarios(tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE funcionarios SET tipo_identificacion = ?, numero_identificacion = ?, nombres = ?, apellidos = ?, estado_civil = ?, sexo = ?, direccion = ?, telefono = ? WHERE id_funcionario = ?";

    private static final String SQL_DELETE = "DELETE FROM funcionarios WHERE id_funcionario = ?";

    public List<Funcionario> seleccionar(){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idFuncionario = rs.getInt("id_funcionario");
                String tipoIdentificacion = rs.getString("tipo_identificacion");
                String numeroIdentificacion = rs.getString("numero_identificacion");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String estadoCivil = rs.getString("estado.nombre");
                String sexo = rs.getString("sexo.nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                funcionario = new Funcionario(idFuncionario,tipoIdentificacion,numeroIdentificacion,nombres,apellidos,estadoCivil,sexo,direccion,telefono);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return funcionarios;
    }

    public Funcionario seleccionarFucionario(int id){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idFuncionario = rs.getInt("id_funcionario");
                String tipoIdentificacion = rs.getString("tipo_identificacion");
                String numeroIdentificacion = rs.getString("numero_identificacion");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String estadoCivil = rs.getString("estado.nombre");
                String sexo = rs.getString("sexo.nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                funcionario = new Funcionario(idFuncionario,tipoIdentificacion,numeroIdentificacion,nombres,apellidos,estadoCivil,sexo,direccion,telefono);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return funcionario;
    }

    public int insertar(Funcionario funcionario){
        int estado = 0;
        int sexo = 0;
        if(funcionario.getEstadoCivil().equals("Soltero")){
            estado = 1;
        } else if (funcionario.getEstadoCivil().equals("Casado")) {
            estado = 2;
        } else if (funcionario.getEstadoCivil().equals("Separado")) {
            estado = 3;
        }

        if(funcionario.getSexo().equals("Femenino")){
            sexo = 1;
        } else if (funcionario.getSexo().equals("Masculino")) {
            sexo = 2;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, funcionario.getTipoIdentificacion());
            stmt.setString(2, funcionario.getNumeroIdentificacion());
            stmt.setString(3, funcionario.getNombres());
            stmt.setString(4, funcionario.getApellidos());
            stmt.setInt(5, estado);
            stmt.setInt(6, sexo);
            stmt.setString(7, funcionario.getDireccion());
            stmt.setString(8, funcionario.getTelefono());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int actualizar(Funcionario funcionario){
        int estado = 0;
        int sexo = 0;
        if(funcionario.getEstadoCivil().equals("Soltero")){
            estado = 1;
        } else if (funcionario.getEstadoCivil().equals("Casado")) {
            estado = 2;
        } else if (funcionario.getEstadoCivil().equals("Separado")) {
            estado = 3;
        }

        if(funcionario.getSexo().equals("Femenino")){
            sexo = 1;
        } else if (funcionario.getSexo().equals("Masculino")) {
            sexo = 2;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, funcionario.getTipoIdentificacion());
            stmt.setString(2, funcionario.getNumeroIdentificacion());
            stmt.setString(3, funcionario.getNombres());
            stmt.setString(4, funcionario.getApellidos());
            stmt.setInt(5, estado);
            stmt.setInt(6, sexo);
            stmt.setString(7, funcionario.getDireccion());
            stmt.setString(8, funcionario.getTelefono());
            stmt.setInt(9, funcionario.getIdFuncionario());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int eliminar(Funcionario funcionario){

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, funcionario.getIdFuncionario());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }
}
