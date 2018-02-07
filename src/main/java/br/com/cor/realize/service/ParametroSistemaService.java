//package br.com.correios.realize.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.correios.realize.model.Parametro;
//import br.com.correios.realize.repository.ParametroSistemaRepository;
//
//import java.util.List;
//
///**
// * Service Responsavel por Manter Parâmetro do Sistema
// *
// */
//
//@Service
//public class ParametroSistemaService {
//
//    @Autowired
//    private ParametroSistemaRepository parametroSistemaRepository;
//
//    public Parametro editar(Parametro entity) {
//        return parametroSistemaRepository.save(entity);
//    }
//
//    public List<Parametro> listarFiltroValorParametro(String parametro) {
//        List<Parametro> listaResultado = parametroSistemaRepository.listarFiltroValorParametro(parametro);
//        if (listaResultado.isEmpty()) {
//            return null;
//        }
//        return listaResultado;
//    }
//
//    public Parametro buscarPorId(Integer id) {
//        return parametroSistemaRepository.findOne(id);
//    }
//
//    public void excluir(Integer id) {
//        parametroSistemaRepository.delete(id);
//    }
//
//    public void setParametroSistemaRepository(ParametroSistemaRepository parametroSistemaRepository) {
//        this.parametroSistemaRepository = parametroSistemaRepository;
//    }
//}
