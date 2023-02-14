package entitdades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    public static void adicionarLivro(List<Livro> livros, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

            for (var x : livros) {
                bw.write(x.nome() + ", " + x.assunto().nome());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static List<Livro> buscarLivros(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            var line = br.readLine();
            List<Livro> livros = new ArrayList<>();

            while (line != null) {
                var lines = line.split(",");
                var nome = lines[0];
                var assunto = lines[1];

                livros.add(new Livro(nome, new Assunto(assunto)));
                line = br.readLine();
            }

            return livros;

        } catch (IOException e) {
            return null;
        }
    }

}
