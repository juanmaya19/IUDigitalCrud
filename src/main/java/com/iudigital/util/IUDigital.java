package com.iudigital.util;

import com.iudigital.controller.FuncionarioController;
import com.iudigital.domain.Funcionario;

public class IUDigital {

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        
        Funcionario funcionario = funcionarioController.getFuncionario(1);
        System.out.println(funcionario);

    }
}
