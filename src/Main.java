import entitdades.Assunto;
import entitdades.Biblioteca;
import entitdades.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var path = "/home/alexandre/IdeaProjects/projeto001-arquivos/arquivos/arquivo.csv";

        List<Livro> livros = new ArrayList<>();

        System.out.println("""
                1 -> Cadastrar livro
                2 -> Buscar livro Por nome
                """);
        var menu = Integer.parseInt(scanner.nextLine());

        switch (menu) {
            case 1 -> {
                while (true) {
                    System.out.print("Nome: ");
                    var nome = scanner.nextLine();
                    System.out.print("Assunto: ");
                    var assunto = scanner.nextLine();

                    livros.add(new Livro(nome, new Assunto(assunto)));

                    System.out.print("Deseja cadastrar outro livro [S/N]: ");
                    var op = scanner.nextLine().toLowerCase();

                    if (!op.startsWith("s")) {
                        break;
                    }

                }
                Biblioteca.adicionarLivro(livros, path);
            }
            case 2 -> {
                livros = Biblioteca.buscarLivros(path);
                livros.forEach(System.out::println);
            }
            default -> System.out.println("Opção inválida");
        }


        scanner.close();
    }
}
