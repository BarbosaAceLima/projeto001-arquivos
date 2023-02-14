package entitdades;

public record Assunto(String nome) {

    @Override
    public String toString() {
        return nome;
    }
}
