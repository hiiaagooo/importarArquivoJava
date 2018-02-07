package br.com.correios.realize.excecao;

@SuppressWarnings("serial")
public class CorreiosException extends Exception {

    private String[] args;

    public CorreiosException() {
    }

    public CorreiosException(Throwable excecao) {
        super(excecao.getMessage());
        super.initCause(excecao.getCause());
    }

    public CorreiosException(String key, String... args) {
        super(key);
        setArgs(args);
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }


}
