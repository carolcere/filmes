package br.com.tech4me.filmes;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import br.com.tech4me.filmes.repositorios.FilmeRepositorio;
import br.com.tech4me.filmes.telas.Tela;
import br.com.tech4me.filmes.telas.TelaBuscarPorId;
import br.com.tech4me.filmes.telas.TelaCriarFilme;
import br.com.tech4me.filmes.telas.TelaListarFilmes;

@Component
public class LoopPrincipal {
    @Autowired
    private ApplicationContext context;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void loop() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            Tela tela = null;
            FilmeRepositorio repositorio = null;
            limparTela();

            System.out.println("*****************************");
            System.out.println("MENU PRINCIPAL");
            System.out.println("*****************************");
            System.out.println(" 1 - Buscar Filme");
            System.out.println(" 2 - Incluir Filme");
            System.out.println(" 3 - Listar Filmes");
            System.out.println(" 0 - Sair");
            System.out.println(" opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); //Limpar entrada
                
        
         switch (opcao) {
            case 1:
            tela = new TelaBuscarPorId();
            repositorio = context.getBean(FilmeRepositorio.class);
                
                
                break;
            case 2:
            tela = new TelaCriarFilme();
            repositorio = context.getBean(FilmeRepositorio.class);
                
                
                break;
            case 3 :
            tela = new TelaListarFilmes();
            repositorio = context.getBean(FilmeRepositorio.class);
                
                break;
            case 0 :
                System.out.println("Fim do Programa");
                break;
        
            default:
            System.out.println("\nOpção inválida\n");
            voltarMenu(entrada);
                break;
        }

        if(tela != null) {
            tela.executar(entrada, repositorio);
            voltarMenu(entrada);
        }
    }while(opcao != 0);

    
}

    private void voltarMenu(Scanner entrada) {
    }

    private void limparTela() {
    }
}
