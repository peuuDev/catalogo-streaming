public class Titulo {
    private int codigo;
    private String nome;
    private String tipo;
    private int ano;

    public Titulo(int codigo, String nome, String tipo, int ano) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAno() {
        return ano;
    }

    public String toString() {
        return codigo + " - " + nome + " (" + tipo + ", " + ano + ")";
    }
}
