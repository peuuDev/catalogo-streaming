public class ArvoreABB {
    private NoABB raiz;

    public ArvoreABB() {
        this.raiz = null;
    }

    public void inserirTitulo(Titulo novoTitulo) {
        raiz = inserirTituloNaArvore(raiz, novoTitulo);
    }

    private NoABB inserirTituloNaArvore(NoABB noAtual, Titulo novoTitulo) {
        if (noAtual == null) {
            NoABB novoNo = new NoABB(novoTitulo);
            return novoNo;
        }

        int codigoDoNovoTitulo = novoTitulo.getCodigo();
        int codigoDoNoAtual = noAtual.titulo.getCodigo();

        if (codigoDoNovoTitulo < codigoDoNoAtual) {
            noAtual.filhoEsquerdo = inserirTituloNaArvore(noAtual.filhoEsquerdo, novoTitulo);
        } else if (codigoDoNovoTitulo > codigoDoNoAtual) {
            noAtual.filhoDireito = inserirTituloNaArvore(noAtual.filhoDireito, novoTitulo);
        } else {
            System.out.println("Codigo ja existe: " + codigoDoNovoTitulo);
        }

        return noAtual;
    }

    public Titulo buscarTituloPorCodigo(int codigoProcurado) {
        NoABB noAtual = raiz;

        while (noAtual != null) {
            int codigoDoNoAtual = noAtual.titulo.getCodigo();

            if (codigoProcurado == codigoDoNoAtual) {
                return noAtual.titulo;
            } else if (codigoProcurado < codigoDoNoAtual) {
                noAtual = noAtual.filhoEsquerdo;
            } else {
                noAtual = noAtual.filhoDireito;
            }
        }

        return null;
    }

    public void excluirTitulo(int codigoParaExcluir) {
        raiz = excluirTituloDaArvore(raiz, codigoParaExcluir);
    }

    private NoABB excluirTituloDaArvore(NoABB noAtual, int codigoParaExcluir) {
        if (noAtual == null) {
            return null;
        }

        int codigoDoNoAtual = noAtual.titulo.getCodigo();

        if (codigoParaExcluir < codigoDoNoAtual) {
            noAtual.filhoEsquerdo = excluirTituloDaArvore(noAtual.filhoEsquerdo, codigoParaExcluir);
        } else if (codigoParaExcluir > codigoDoNoAtual) {
            noAtual.filhoDireito = excluirTituloDaArvore(noAtual.filhoDireito, codigoParaExcluir);
        } else {
            if (noAtual.filhoEsquerdo == null && noAtual.filhoDireito == null) {
                return null;
            } else if (noAtual.filhoEsquerdo == null) {
                return noAtual.filhoDireito;
            } else if (noAtual.filhoDireito == null) {
                return noAtual.filhoEsquerdo;
            } else {
                NoABB noSucessor = encontrarNoComMenorCodigo(noAtual.filhoDireito);

                noAtual.titulo = noSucessor.titulo;

                int codigoDoSucessor = noSucessor.titulo.getCodigo();
                noAtual.filhoDireito = excluirTituloDaArvore(noAtual.filhoDireito, codigoDoSucessor);
            }
        }

        return noAtual;
    }

    private NoABB encontrarNoComMenorCodigo(NoABB noInicial) {
        NoABB noMaisAEsquerda = noInicial;

        while (noMaisAEsquerda.filhoEsquerdo != null) {
            noMaisAEsquerda = noMaisAEsquerda.filhoEsquerdo;
        }

        return noMaisAEsquerda;
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemAPartirDoNo(raiz);
    }

    private void percorrerEmOrdemAPartirDoNo(NoABB noAtual) {
        if (noAtual != null) {
            percorrerEmOrdemAPartirDoNo(noAtual.filhoEsquerdo);
            System.out.println(noAtual.titulo);
            percorrerEmOrdemAPartirDoNo(noAtual.filhoDireito);
        }
    }

    public void percorrerPreOrdem() {
        percorrerPreOrdemAPartirDoNo(raiz);
    }

    private void percorrerPreOrdemAPartirDoNo(NoABB noAtual) {
        if (noAtual != null) {
            System.out.println(noAtual.titulo);
            percorrerPreOrdemAPartirDoNo(noAtual.filhoEsquerdo);
            percorrerPreOrdemAPartirDoNo(noAtual.filhoDireito);
        }
    }

    public void percorrerPosOrdem() {
        percorrerPosOrdemAPartirDoNo(raiz);
    }

    private void percorrerPosOrdemAPartirDoNo(NoABB noAtual) {
        if (noAtual != null) {
            percorrerPosOrdemAPartirDoNo(noAtual.filhoEsquerdo);
            percorrerPosOrdemAPartirDoNo(noAtual.filhoDireito);
            System.out.println(noAtual.titulo);
        }
    }
}
