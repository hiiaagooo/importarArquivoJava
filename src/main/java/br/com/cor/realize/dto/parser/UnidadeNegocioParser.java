package br.com.correios.realize.dto.parser;

import br.com.correios.componente.unidadenegocio.UnidadeNegocioCF;
import br.com.correios.realize.dto.UnidadeNegocioDTO;

public class UnidadeNegocioParser implements Parser<UnidadeNegocioCF, UnidadeNegocioDTO> {

	@Override
	public UnidadeNegocioCF toEntity(UnidadeNegocioDTO dto) {
		return null;
	}

	@Override
	public UnidadeNegocioDTO toDTO(UnidadeNegocioCF unidadeNegocio) {
		return unidadeNegocio != null ? 
				new UnidadeNegocioDTO(
						unidadeNegocio.getCodigo(), 
						unidadeNegocio.getDenominacao())
				: null;
	}

}
