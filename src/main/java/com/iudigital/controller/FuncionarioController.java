package com.iudigital.controller;

import com.iudigital.dao.FuncionarioDAO;
import com.iudigital.domain.Funcionario;
import java.util.List;

public class FuncionarioController {

    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarioDAO.seleccionar();
    }

    public void create(Funcionario funcionario) {
        this.funcionarioDAO.insertar(funcionario);
    }

    public Funcionario getFuncionario(int id) {
        return this.funcionarioDAO.seleccionarFucionario(id);
    }

    public void updateFuncionario(Funcionario funcionario) {
        this.funcionarioDAO.actualizar(funcionario);
    }

    public void deleteFuncionario(Funcionario funcionario) {
        this.funcionarioDAO.eliminar(funcionario);
    }
}
