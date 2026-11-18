public class FilaAssistirMaisTarde {
    private NoFila primeiroNo;
    private NoFila ultimoNo;

    public FilaAssistirMaisTarde() {
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public boolean estaVazia() {
        return primeiroNo == null;
    }

    public void enfileirarTitulo(Titulo tituloParaEnfileirar) {
        Titulo tituloJaNaFila = buscarTituloPorCodigo(tituloParaEnfileirar.getCodigo());

        if (tituloJaNaFila != null) {
            System.out.println("Titulo ja esta na lista.");
        } else {
            NoFila novoNoDaFila = new NoFila(tituloParaEnfileirar);

            if (estaVazia()) {
                primeiroNo = novoNoDaFila;
                ultimoNo = novoNoDaFila;
            } else {
                ultimoNo.proximoNo = novoNoDaFila;
                ultimoNo = novoNoDaFila;
            }
        }
    }

    public Titulo desenfileirarTitulo() {
        if (estaVazia()) {
            return null;
        }

        Titulo tituloRemovido = primeiroNo.titulo;

        primeiroNo = primeiroNo.proximoNo;

        if (primeiroNo == null) {
            ultimoNo = null;
        }

        return tituloRemovido;
    }

    public boolean removerTituloPorCodigo(int codigoParaRemover) {
        NoFila noAtual = primeiroNo;
        NoFila noAnterior = null;
        boolean encontrouTitulo = false;

        while (noAtual != null && encontrouTitulo == false) {
            if (noAtual.titulo.getCodigo() == codigoParaRemover) {
                encontrouTitulo = true;
            } else {
                noAnterior = noAtual;
                noAtual = noAtual.proximoNo;
            }
        }

        if (encontrouTitulo == false) {
            return false;
        }

        if (noAnterior == null) {
            primeiroNo = noAtual.proximoNo;
        } else {
            noAnterior.proximoNo = noAtual.proximoNo;
        }

        if (noAtual == ultimoNo) {
            ultimoNo = noAnterior;
        }

        return true;
    }

    public Titulo buscarTituloPorCodigo(int codigoProcurado) {
        NoFila noAtual = primeiroNo;

        while (noAtual != null) {
            if (noAtual.titulo.getCodigo() == codigoProcurado) {
                return noAtual.titulo;
            }
            noAtual = noAtual.proximoNo;
        }

        return null;
    }

    public void listarTitulosDaFila() {
        if (estaVazia()) {
            System.out.println("Lista vazia.");
        } else {
            NoFila noAtual = primeiroNo;

            while (noAtual != null) {
                System.out.println(noAtual.titulo);
                noAtual = noAtual.proximoNo;
            }
        }
    }
}
