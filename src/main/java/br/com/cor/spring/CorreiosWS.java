package br.com.correios.spring;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import br.com.correios.componente.funcionario.FuncionarioService;
import br.com.correios.componente.idautorizador.usuario.IdAutorizadorUsuarioService;
import br.com.correios.componente.unidadenegocio.UnidadeNegocioService;
import br.com.correios.realize.model.enums.AmbientePublicacaoEnum;
import br.com.correios.sroservice.ws.ServiceSRO.WSSRO;

@Configuration
public class CorreiosWS {

    @Autowired
    Environment env;

    private AmbientePublicacaoEnum ambientePublicacaoEnum;

    private Map<AmbientePublicacaoEnum, String> adressLocationDosAmbientesIdCorreios;

    @PostConstruct
    void init() {

        if (env.getProperty("ambiente.publicacao") == null) {
            ambientePublicacaoEnum = AmbientePublicacaoEnum.LOCAL;
        } else {
            ambientePublicacaoEnum = AmbientePublicacaoEnum.valueOf(env.getProperty("ambiente.publicacao"));
        }

        carregaConfiguracaoDoAdressLocationIdCorreios();
    }

    @Bean
    @Scope("singleton")
    public WSSRO createWSSRO() {
        return createServicePortSRO(WSSRO.class, new QName("http://ws.sroservice.correios.com.br/", "ServiceSRO"),
                env.getProperty("sroService"));
    }


    @Bean
    public IdAutorizadorUsuarioService getIdAutorizadorUsuarioService() {
        JaxWsProxyFactoryBean jaxWsClientFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsClientFactoryBean.setAddress(adressLocationDosAmbientesIdCorreios.get(ambientePublicacaoEnum));
        jaxWsClientFactoryBean.setServiceClass(IdAutorizadorUsuarioService.class);
        jaxWsClientFactoryBean.setUsername(env.getProperty("usuarioComponentes"));
        jaxWsClientFactoryBean.setPassword(env.getProperty("pwdComponentes"));
        IdAutorizadorUsuarioService client = (IdAutorizadorUsuarioService) jaxWsClientFactoryBean.create();
        return (IdAutorizadorUsuarioService) client;
    }

    @Bean
    public UnidadeNegocioService getUnidadeNegocioService() {
        JaxWsProxyFactoryBean jaxWsClientFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsClientFactoryBean.setAddress(env.getProperty("unidadesDeNegocioServiceAddressLocation"));
        jaxWsClientFactoryBean.setServiceClass(UnidadeNegocioService.class);
        jaxWsClientFactoryBean.setUsername(env.getProperty("usuarioComponentes"));
        jaxWsClientFactoryBean.setPassword(env.getProperty("pwdComponentes"));
        UnidadeNegocioService client = (UnidadeNegocioService) jaxWsClientFactoryBean.create();
        return (UnidadeNegocioService) client;
    }
    
    @Bean
	public FuncionarioService getFuncionarioService(){
    	JaxWsProxyFactoryBean jaxWsClientFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsClientFactoryBean.setAddress(env.getProperty("funcionarioServiceAddressLocation"));
        jaxWsClientFactoryBean.setServiceClass(FuncionarioService.class);
        jaxWsClientFactoryBean.setUsername(env.getProperty("usuarioComponentes"));
        jaxWsClientFactoryBean.setPassword(env.getProperty("pwdComponentes"));
        FuncionarioService client = (FuncionarioService) jaxWsClientFactoryBean.create();
        return (FuncionarioService) client;
	}


    private void carregaConfiguracaoDoAdressLocationIdCorreios() {
        adressLocationDosAmbientesIdCorreios = new HashMap<>();
        adressLocationDosAmbientesIdCorreios.put(AmbientePublicacaoEnum.LOCAL, env.getProperty("idAutorizadorLocalAdressLocation"));
        adressLocationDosAmbientesIdCorreios.put(AmbientePublicacaoEnum.DESENVOLVIMENTO, env.getProperty("idAutorizadorDesenvolvimentoAdressLocation"));
        adressLocationDosAmbientesIdCorreios.put(AmbientePublicacaoEnum.HOMOLOGACAO, env.getProperty("idAutorizadorHomologacaoAdressLocation"));
        adressLocationDosAmbientesIdCorreios.put(AmbientePublicacaoEnum.PRODUCAO, env.getProperty("idAutorizadorProducaoAdressLocation"));
    }

    private <T> T createServicePortSRO(Class<T> classe, QName qname, String endpoint) {
        T servicePort = Service.create(qname).getPort(classe);
        ((BindingProvider) servicePort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

        return servicePort;
    }

}