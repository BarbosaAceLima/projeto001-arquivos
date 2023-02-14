package entitdades;

public record Livro(String nome, Assunto assunto) {

    @Override
    public String toString() {
        return "Nome: " + nome + " Assunto:" + assunto;
    }
}
