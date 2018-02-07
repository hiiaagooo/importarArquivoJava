package br.com.correios.realize.dto;

import br.com.correios.realize.model.enums.TipoMetaEnum;
import br.com.correios.realize.model.enums.TipoSituacaoImportacaoMetaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CargaMetaAgenciaDTO {
    private Long idArquivoImportacao;
    private Long ano;
    private String nomeArquivo;
    private long tamanhoArquivo;
    private TipoMetaEnum tipoArquivoMeta;
    private Long usuarioNu;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataImportacao;
    private TipoSituacaoImportacaoMetaEnum tipoSituacaoImportacaoMetaEnum;

    private String motivoFalha;

    public TipoSituacaoImportacaoMetaEnum getTipoSituacaoImportacaoMetaEnum() {
        return tipoSituacaoImportacaoMetaEnum;
    }

    public void setTipoSituacaoImportacaoMetaEnum(TipoSituacaoImportacaoMetaEnum tipoSituacaoImportacaoMetaEnum) {
        this.tipoSituacaoImportacaoMetaEnum = tipoSituacaoImportacaoMetaEnum;
    }

    public LocalDateTime getDataImportacao() {
        return dataImportacao;
    }

    public void setDataImportacao(LocalDateTime dataImportacao) {
        this.dataImportacao = dataImportacao;
    }

    public Long getUsuarioNu() {
        return usuarioNu;
    }

    public void setUsuarioNu(Long usuarioNu) {
        this.usuarioNu = usuarioNu;
    }

    public Long getIdArquivoImportacao() {
        return idArquivoImportacao;
    }

    public void setIdArquivoImportacao(Long idArquivoImportacao) {
        this.idArquivoImportacao = idArquivoImportacao;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public long getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(long tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public TipoMetaEnum getTipoArquivoMeta() {
        return tipoArquivoMeta;
    }

    public void setTipoArquivoMeta(TipoMetaEnum tipoArquivoMeta) {
        this.tipoArquivoMeta = tipoArquivoMeta;
    }

    public String getMotivoFalha() {
        return motivoFalha;
    }

    public void setMotivoFalha(String motivoFalha) {
        this.motivoFalha = motivoFalha;
    }

}
