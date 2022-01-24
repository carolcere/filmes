package br.com.tech4me.filmes.telas;

import java.util.List;
import java.util.Scanner;
import org.springframework.data.repository.Repository;

import br.com.tech4me.filmes.model.Filme;
import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public class TelaBuscarPorId implements Tela<Filme, Integer>{

    @Override
    public void executar(Scanner entrada, Repository<Filme, Integer>repositorio){
        FilmeRepositorio repo = (FilmeRepositorio)repositorio;
       
        System.out.println("Digite o Id do filme que deseja procurar: ");
        int id = entrada.nextInt();

        List<Filme> filme = repo.findFilmeById(id);

        if(filme == null){
            System.out.println("Nenhum filme com este Id foi encontrado!");
            return;
        }else{
            System.out.printf("Filme com o Id: %d encontrado: \n%s\n", id, filme);
        }
    }
    
}
