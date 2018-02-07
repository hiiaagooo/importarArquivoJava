package br.com.correios.realize.dto.parser;

import br.com.correios.realize.dto.CargaMetaAgenciaDTO;
import br.com.correios.realize.model.CargaMetaAgencia;
import br.com.correios.realize.util.ArquivoUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CargaMetaAgenciaParser implements Parser<CargaMetaAgencia, CargaMetaAgenciaDTO> {

    public static final String SEPARADOR_ARQUIVO = "_";

    @Override
    public CargaMetaAgencia toEntity(CargaMetaAgenciaDTO dto) {
        CargaMetaAgencia cargaMetaAgencia = new CargaMetaAgencia();
        cargaMetaAgencia.setCmaNu(dto.getIdArquivoImportacao());
        cargaMetaAgencia.setTipoMetaEnum(dto.getTipoArquivoMeta());
        cargaMetaAgencia.setAnoReferencia(dto.getAno());
        cargaMetaAgencia.setCmaTxOrigemCarga(montarCaminhoCompletoArquivoDoDTO(dto.getNomeArquivo(),dto.getDataImportacao()));
        cargaMetaAgencia.setUsuNu(dto.getUsuarioNu());
        cargaMetaAgencia.setCmaDt(dto.getDataImportacao());
        cargaMetaAgencia.setTipoSituacaoImportacaoMetaEnum(dto.getTipoSituacaoImportacaoMetaEnum());


        return cargaMetaAgencia;
    }

    public String montarCaminhoCompletoArquivoDoDTO(String nomeArquivo, LocalDateTime dataImportacao) {
        String caminhoCompletoArquivo = ArquivoUtils.DIRETORIO_TEMPORARIO + File.separator+ montarNomeDoArquivoDoDTO(nomeArquivo,dataImportacao);
        return caminhoCompletoArquivo;
    }

    public String montarNomeDoArquivoDoDTO(String nomeArquivo, LocalDateTime dataImportacao) {
        Date date = Date.from(dataImportacao.atZone(ZoneId.systemDefault()).toInstant());
        nomeArquivo = date.getTime() + SEPARADOR_ARQUIVO + nomeArquivo;
        return nomeArquivo;
    }



    @Override
    public CargaMetaAgenciaDTO toDTO(CargaMetaAgencia cargaMetaAgencia) {
        CargaMetaAgenciaDTO cargaMetaAgenciaDTO = new CargaMetaAgenciaDTO();
        cargaMetaAgenciaDTO.setIdArquivoImportacao(cargaMetaAgencia.getCmaNu());
        cargaMetaAgenciaDTO.setTipoArquivoMeta(cargaMetaAgencia.getTipoMetaEnum());
        cargaMetaAgenciaDTO.setAno(cargaMetaAgencia.getAnoReferencia());
        cargaMetaAgenciaDTO.setNomeArquivo(montarNomeArquivo(cargaMetaAgencia));
        cargaMetaAgenciaDTO.setUsuarioNu(cargaMetaAgencia.getUsuNu());
        cargaMetaAgenciaDTO.setDataImportacao(cargaMetaAgencia.getCmaDt());
        cargaMetaAgenciaDTO.setTipoSituacaoImportacaoMetaEnum(cargaMetaAgencia.getTipoSituacaoImportacaoMetaEnum());
        cargaMetaAgenciaDTO.setMotivoFalha(cargaMetaAgencia.getCmaTxMotivoFalha());

        return cargaMetaAgenciaDTO;
    }

    private String montarNomeArquivo(CargaMetaAgencia cargaMetaAgencia) {
        String caminhoArquivo = cargaMetaAgencia.getCmaTxOrigemCarga();
        return caminhoArquivo.split(caminhoArquivo.split(ArquivoUtils.DIRETORIO_TEMPORARIO)[1].split(SEPARADOR_ARQUIVO)[0]+SEPARADOR_ARQUIVO)[1];
    }


    public List<CargaMetaAgenciaDTO> toListDTO(List<CargaMetaAgencia> cargaMetaAgenciaList) {
        List<CargaMetaAgenciaDTO> listaCargaMetaAgenciaDTO = new ArrayList<>();
        for (CargaMetaAgencia cargaMetaAgencia : cargaMetaAgenciaList) {
            CargaMetaAgenciaDTO cargaMetaAgenciaDTO = this.toDTO(cargaMetaAgencia);
            listaCargaMetaAgenciaDTO.add(cargaMetaAgenciaDTO);
        }

        return listaCargaMetaAgenciaDTO;
    }


}
