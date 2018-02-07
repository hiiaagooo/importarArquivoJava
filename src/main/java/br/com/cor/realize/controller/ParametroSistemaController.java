//package br.com.correios.realize.controller;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.WebApplicationContext;
//
//import br.com.correios.realize.model.Parametro;
//import br.com.correios.realize.service.ParametroSistemaService;
//import br.com.correios.realize.util.Resposta;
//
//import javax.inject.Inject;
//import java.util.List;
//
///**
// * Controller para Manter Parametro do Sistema
// */
//@Controller
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@RequestMapping(value = "/private/parametro-sistema")
//public class ParametroSistemaController {
//
//    @Inject
//    private ParametroSistemaService parametroSistemaService;
//
//    private List<Parametro> listaResultado;
//
//    /**
//     * Realizará a Pesquisa baseado nos campos informados na tela
//     *
//     * @return Visão contendo a tabela composta pelos parâmetros encontrados na
//     * pesquisa
//     */
//    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Resposta<Parametro>> buscar(
//            @PathVariable Integer id) throws Exception {
//
//        Resposta<Parametro> resposta = new Resposta<>();
//
//        resposta.setDados(parametroSistemaService.buscarPorId(id));
//
//        return new ResponseEntity(resposta, HttpStatus.OK);
//    }
//
//    /**
//     * Realizará a Pesquisa baseado nos campos informados na tela
//     *
//     * @return Visão contendo a tabela composta pelos parâmetros encontrados na
//     * pesquisa
//     */
//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Resposta<List<Parametro>>> pesquisar(
//            @RequestParam(value = "descricao", required = false, defaultValue = "") String descricao) {
//
//        Resposta<List<Parametro>> resposta = new Resposta<>();
//
//        listaResultado = parametroSistemaService.listarFiltroValorParametro(descricao);
//
//        resposta.setDados(listaResultado);
//
//        return new ResponseEntity(resposta, HttpStatus.OK);
//    }
//
//    /**
//     * Realiza alteracao do Parametro de Sistema e aplica na base de dados
//     *
//     * @param parametroSistema dados vindos da visão com os valores a serem atualizados
//     * @return status http indicando se a operação foi bem sucedida ou não
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Resposta> atualizar(@PathVariable Integer id, @RequestBody Parametro parametroSistema) {
//
//        parametroSistemaService.editar(parametroSistema);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Resposta> salvar(@RequestBody Parametro parametroSistema) {
//
//        parametroSistemaService.editar(parametroSistema);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Resposta> excluir(@PathVariable Integer id) {
//
//        parametroSistemaService.excluir(id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
