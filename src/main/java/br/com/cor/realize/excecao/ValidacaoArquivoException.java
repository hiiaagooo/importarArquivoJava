package br.com.correios.realize.excecao;

@SuppressWarnings("serial")
public class ValidacaoArquivoException extends CorreiosException {

    private Integer numeroLinhaErro;

    public ValidacaoArquivoException(String mensagem) {
        super(mensagem);
    }

    public ValidacaoArquivoException(String mensagem,Integer numeroLinhaErro) {
        super(mensagem);

        this.numeroLinhaErro = numeroLinhaErro;
    }

    public Integer getNumeroLinhaErro() {
        return numeroLinhaErro;
    }

}
