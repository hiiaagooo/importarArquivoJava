package br.com.correios.realize.dto.parser;

import br.com.correios.componente.funcionario.Funcionario;
import br.com.correios.realize.dto.FuncionarioDTO;

public class FuncionarioParser implements Parser<Funcionario, FuncionarioDTO> {

	@Override
	public Funcionario toEntity(FuncionarioDTO dto) {
		return null;
	}

	@Override
	public FuncionarioDTO toDTO(Funcionario funcionario) {
		return funcionario != null
				? new FuncionarioDTO(
						funcionario.getRegistro(), 
						funcionario.getPessoa().getNomePessoa(),
						funcionario.getFuncao().getNome())
				: null;
	}
	
}
