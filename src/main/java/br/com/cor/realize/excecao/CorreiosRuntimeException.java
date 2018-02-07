package br.com.correios.realize.excecao;

public class CorreiosRuntimeException extends RuntimeException {

    private String[] args;

    public CorreiosRuntimeException() {
    }

    public CorreiosRuntimeException(String key) {
        super(key);
    }


    public CorreiosRuntimeException(Throwable excecao) {
        super(excecao.getMessage());
        super.initCause(excecao.getCause());
    }

    public CorreiosRuntimeException(String key, String... args) {
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
