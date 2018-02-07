package br.com.correios.realize.service;
import br.com.correios.realize.dto.CargaMetaAgenciaDTO;
import br.com.correios.realize.dto.parser.CargaMetaAgenciaParser;
import br.com.correios.realize.excecao.CorreiosException;
import br.com.correios.realize.model.CargaMetaAgencia;
import br.com.correios.realize.model.enums.TipoMetaEnum;
import br.com.correios.realize.model.enums.TipoSituacaoImportacaoMetaEnum;
import br.com.correios.realize.repository.CargaMetaAgenciaRepository;
import br.com.correios.realize.seguranca.Usuario;
import br.com.correios.realize.util.ArquivoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ImportacaoMetaService {

    @Autowired
    private CargaMetaAgenciaRepository cargaMetaAgenciaRepository;

    @Autowired
    private CargaMetaAgenciaParser cargaMetaAgenciaParser;

    @Autowired
    private MetaAgenciaService metaAgenciaService;

    @Autowired
    private Usuario usuario;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importarArquivoMeta(CargaMetaAgenciaDTO cargaMetaAgenciaDTO, MultipartFile file) throws CorreiosException {

        completarDadosDTOComFile(cargaMetaAgenciaDTO,file);

        cargaMetaAgenciaDTO.setTipoSituacaoImportacaoMetaEnum(TipoSituacaoImportacaoMetaEnum.AP);

        CargaMetaAgencia cargaMetaAgencia = cargaMetaAgenciaParser.toEntity(cargaMetaAgenciaDTO);
        cargaMetaAgenciaRepository.save(cargaMetaAgencia);

        try {
            this.salvarArquivo(cargaMetaAgenciaDTO,file);
        } catch (IOException e) {
            throw new CorreiosException("Ocorreu um erro ao salvar arquivo no filesystem.");
        }

        metaAgenciaService.importarDadosArquivo(cargaMetaAgencia);

    }

    private void completarDadosDTOComFile(CargaMetaAgenciaDTO cargaMetaAgenciaDTO, MultipartFile file) {
        if(cargaMetaAgenciaDTO.getDataImportacao() == null){
            cargaMetaAgenciaDTO.setDataImportacao(LocalDateTime.now());
        }

        if(usuario.getLogin() != null) {
            cargaMetaAgenciaDTO.setUsuarioNu(new Long(usuario.getLogin()));
        }

        cargaMetaAgenciaDTO.setNomeArquivo(file.getOriginalFilename());
        cargaMetaAgenciaDTO.setTamanhoArquivo(file.getSize());
        cargaMetaAgenciaDTO.setIdArquivoImportacao(null);
    }

    private void salvarArquivo(CargaMetaAgenciaDTO cargaMetaAgenciaDTO, MultipartFile file) throws IOException {
        String nomeArquivoMontado = cargaMetaAgenciaParser.montarNomeDoArquivoDoDTO(cargaMetaAgenciaDTO.getNomeArquivo(),cargaMetaAgenciaDTO.getDataImportacao());
        ArquivoUtils.salvarArquivo(file.getBytes(), ArquivoUtils.DIRETORIO_TEMPORARIO ,nomeArquivoMontado);
    }

    public List<CargaMetaAgenciaDTO> listarTodosCargaMetaAgencia() {
        List<CargaMetaAgencia> listaCargaMetaAgencia = cargaMetaAgenciaRepository.listarTodos();
        CargaMetaAgenciaParser cargaMetaAgenciaParser = new CargaMetaAgenciaParser();
        return cargaMetaAgenciaParser.toListDTO(listaCargaMetaAgencia);
    }


    public List<TipoMetaEnum> listarTodosTiposMeta() {
        return Arrays.asList(TipoMetaEnum.values());
    }

    public List<String> listarAnosReferenciaImportacao() {
        Calendar cal = Calendar.getInstance();
        Integer anoAnteriorNum = cal.get(Calendar.YEAR) - 1;

        String anoAnterior = (anoAnteriorNum).toString();
        String anoAtual = (++anoAnteriorNum).toString();
        String anoPosterior = (++anoAnteriorNum).toString();


        String array[] = {anoAnterior,anoAtual,anoPosterior};
        return Arrays.asList(array);
    }
}