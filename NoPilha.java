public class NoPilha {
    Titulo titulo;
    NoPilha proximoNo;

    public NoPilha(Titulo titulo) {
        this.titulo = titulo;
        this.proximoNo = null;
    }
}
