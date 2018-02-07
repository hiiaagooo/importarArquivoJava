package br.com.correios.realize.controller;

import br.com.correios.realize.dto.CargaMetaAgenciaDTO;
import br.com.correios.realize.excecao.CorreiosException;
import br.com.correios.realize.model.enums.TipoMetaEnum;
import br.com.correios.realize.service.ImportacaoMetaService;
import br.com.correios.realize.util.Resposta;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.util.List;


/**
 * Controller para Manter Importação de Meta
 */

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/private/importacao-meta")
public class ImportacaoMetaController {

    @Inject
    private ImportacaoMetaService importacaoMetaService;


    @RequestMapping(value = "/importar-arquivo-meta", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ResponseEntity uploadHandler(@RequestPart("properties") CargaMetaAgenciaDTO cargaMetaAgenciaDTO,
                                        @RequestPart("file") MultipartFile file)
            throws CorreiosException {

        importacaoMetaService.importarArquivoMeta(cargaMetaAgenciaDTO, file);
        return new ResponseEntity(HttpStatus.OK);
        
    }


    @RequestMapping(value = "/obter-carga-meta-agencia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta<List<CargaMetaAgenciaDTO>>> obterCargaMetaAgencia() {

        List<CargaMetaAgenciaDTO> listaResultado = importacaoMetaService.listarTodosCargaMetaAgencia();

        Resposta<List<CargaMetaAgenciaDTO>> resposta = new Resposta<>(listaResultado);

        return new ResponseEntity(resposta, HttpStatus.OK);
    }


    @RequestMapping(value = "/obter-tipos-meta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta<List<TipoMetaEnum>>> obterTiposMeta() {

        List<TipoMetaEnum> listaResultado = importacaoMetaService.listarTodosTiposMeta();

        Resposta<List<TipoMetaEnum>> resposta = new Resposta<>(listaResultado);

        return new ResponseEntity(resposta, HttpStatus.OK);
    }


    @RequestMapping(value = "/obter-anos-referencia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta<List<String>>> obterAnosReferencia() {

        List<String> listaResultado = importacaoMetaService.listarAnosReferenciaImportacao();

        Resposta<List<String>> resposta = new Resposta<>(listaResultado);

        return new ResponseEntity(resposta, HttpStatus.OK);
    }
}
