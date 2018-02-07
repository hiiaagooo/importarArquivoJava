package br.com.correios.realize.excecao;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.correios.realize.util.Mensagem;
import br.com.correios.realize.util.Resposta;

@ControllerAdvice
public class ExcepionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcepionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Resposta<?>> exceptionHandler(Exception e) {
        String mensagemRaiz = ExceptionUtils.getRootCauseMessage(e);
        LOGGER.error("Exceção lançada: ".concat(mensagemRaiz), e);
        Resposta<?> mensagem = new Resposta<>("Ocorreu um erro inesperado.", Mensagem.TipoMensagem.ERRO);
        return new ResponseEntity(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CorreiosException.class)
    public ResponseEntity correiosExceptionHandler(CorreiosException e) {
        String mensagemRaiz = ExceptionUtils.getRootCauseMessage(e);
        LOGGER.error("Exceção lançada: ".concat(mensagemRaiz), e);
        Resposta<?> mensagem = new Resposta<>(e.getMessage(), Mensagem.TipoMensagem.ERRO);
        return new ResponseEntity(mensagem, HttpStatus.BAD_REQUEST);
    }

}
