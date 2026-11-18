public class NoABB {
    Titulo titulo;
    NoABB filhoEsquerdo;
    NoABB filhoDireito;

    public NoABB(Titulo titulo) {
        this.titulo = titulo;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }
}
