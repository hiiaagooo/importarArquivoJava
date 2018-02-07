package br.com.correios.realize.dto.parser;

import br.com.correios.componente.funcionario.Afastamento;
import br.com.correios.realize.dto.AfastamentoDTO;
import br.com.correios.realize.util.DataUtils;

public class AfastamentoParser implements Parser<Afastamento, AfastamentoDTO> {

	@Override
	public Afastamento toEntity(AfastamentoDTO dto) {
		return null;
	}

	@Override
	public AfastamentoDTO toDTO(Afastamento afastamento) {
		return afastamento != null
				? new AfastamentoDTO(
						afastamento.getCodigoSituacao(), 
						afastamento.getCodigoSituacao(),
						DataUtils.converterDataDMYParaLocalDate(afastamento.getDataInicioSituacao()),
						DataUtils.converterDataDMYParaLocalDate(afastamento.getDataFimSituacao()))
				: null;
	}

}
