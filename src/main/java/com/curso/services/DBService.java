package com.curso.services;

import com.curso.domains.GrupoProduto;
import com.curso.domains.Produto;
import com.curso.domains.enums.Status;
import com.curso.repositories.GrupoProdutoRepository;
import com.curso.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service

public class DBService {

    @Autowired
    private GrupoProdutoRepository grupoProdutoRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    public void initDB(){
        GrupoProduto grupo01 = new GrupoProduto(0,Status.ATIVO,"Limpeza");
        GrupoProduto grupo02 = new GrupoProduto(0,Status.ATIVO,"Alimenticio");

        Produto produto01 = new Produto(0,"1111","Coca Cola",new BigDecimal("100"),new BigDecimal("3.5"),
                LocalDate.now(),grupo02,Status.ATIVO);
        Produto produto02 = new Produto(0,"2222","Guaraná Antartica",new BigDecimal("200"),new BigDecimal("3.0"),
                LocalDate.now(),grupo02,Status.ATIVO);
        Produto produto03 = new Produto(0,"3333","Detergente Limpol",new BigDecimal("300"),new BigDecimal("4.0"),
                LocalDate.now(),grupo01,Status.ATIVO);
        Produto produto04 = new Produto(0,"4444","Sabão em Pó",new BigDecimal("400"),new BigDecimal("15.5"),
                LocalDate.now(),grupo01,Status.ATIVO);

        grupoProdutoRepo.save(grupo01);
        grupoProdutoRepo.save(grupo02);
        produtoRepo.save(produto01);
        produtoRepo.save(produto02);
        produtoRepo.save(produto03);
        produtoRepo.save(produto04);
    }
}
