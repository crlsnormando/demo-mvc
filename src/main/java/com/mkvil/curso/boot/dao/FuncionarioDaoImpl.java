package com.mkvil.curso.boot.dao;


import org.springframework.stereotype.Repository;

import com.mkvil.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

}
