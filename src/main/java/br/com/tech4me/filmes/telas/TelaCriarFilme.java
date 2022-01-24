package br.com.tech4me.filmes.telas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.springframework.data.repository.Repository;

import br.com.tech4me.filmes.model.Filme;
import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public class TelaCriarFilme implements Tela<Filme, Integer> {

    @Override
    public void executar(Scanner entrada, Repository<Filme, Integer> repositorio){
        FilmeRepositorio repo = (FilmeRepositorio)repositorio;

        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite o Id: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o titulo: ");
        String titulo = entrada.nextLine();
        System.out.println("Digite o ano de lançamento: ");
        int ano = entrada.nextInt();
        System.out.println("Digite a duração: ");
        int duracao = entrada.nextInt();
        System.out.println("Digite o idioma: "); 
        String idioma = entrada.nextLine(); 
        System.out.println("Digite um data de lançamento: ");
        LocalDate dataLancamento = LocalDate.parse(entrada.nextLine(), formataData);
        System.out.println("Digite o pais de origem: ");
        String paisLancamento  = entrada.nextLine(); 
        
        Filme filme = new Filme();

        filme.setId(id);
        filme.setTitulo(titulo);
        filme.setAno(ano);
        filme.setDuracao(duracao);
        filme.setIdioma(idioma);
        filme.setDataLancamento(dataLancamento);
        filme.setPaisLancamento(paisLancamento);

        repo.save(filme);
    }
    
}
