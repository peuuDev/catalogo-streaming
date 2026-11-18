public class PilhaHistorico {
    private NoPilha noDoTopo;

    public PilhaHistorico() {
        this.noDoTopo = null;
    }

    public boolean estaVazia() {
        return noDoTopo == null;
    }

    public void empilharTitulo(Titulo tituloParaEmpilhar) {
        NoPilha novoNoDaPilha = new NoPilha(tituloParaEmpilhar);

        novoNoDaPilha.proximoNo = noDoTopo;

        noDoTopo = novoNoDaPilha;
    }

    public Titulo desempilharTitulo() {
        if (estaVazia()) {
            return null;
        }

        Titulo tituloRemovido = noDoTopo.titulo;

        noDoTopo = noDoTopo.proximoNo;

        return tituloRemovido;
    }

    public Titulo consultarTituloDoTopo() {
        if (estaVazia()) {
            return null;
        }

        return noDoTopo.titulo;
    }

    public Titulo buscarTituloPorCodigo(int codigoProcurado) {
        NoPilha noAtual = noDoTopo;

        while (noAtual != null) {
            if (noAtual.titulo.getCodigo() == codigoProcurado) {
                return noAtual.titulo;
            }
            noAtual = noAtual.proximoNo;
        }

        return null;
    }

    public boolean removerTituloPorCodigo(int codigoParaRemover) {
        NoPilha noAtual = noDoTopo;
        NoPilha noAnterior = null;
        boolean algumTituloFoiRemovido = false;

        while (noAtual != null) {
            if (noAtual.titulo.getCodigo() == codigoParaRemover) {
                if (noAnterior == null) {
                    noDoTopo = noAtual.proximoNo;
                } else {
                    noAnterior.proximoNo = noAtual.proximoNo;
                }
                algumTituloFoiRemovido = true;
            } else {
                noAnterior = noAtual;
            }

            noAtual = noAtual.proximoNo;
        }

        return algumTituloFoiRemovido;
    }

    public void listarTitulosDoHistorico() {
        if (estaVazia()) {
            System.out.println("Historico vazio.");
        } else {
            NoPilha noAtual = noDoTopo;

            while (noAtual != null) {
                System.out.println(noAtual.titulo);
                noAtual = noAtual.proximoNo;
            }
        }
    }
}
