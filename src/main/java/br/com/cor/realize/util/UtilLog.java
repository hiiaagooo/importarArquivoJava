package br.com.correios.realize.util;

import java.io.Serializable;

import org.jboss.logging.Logger;



/**
 * Classe utilitária responsável pelo log do sistema.
 * 
 * @author Arivaldo Junior
 */
@SuppressWarnings("serial")
public class UtilLog implements Serializable {

	public static final Logger logger;

	static {
		System.setProperty("org.jboss.logging.provider", "log4j");
		logger = Logger.getLogger("Realize");
		logger.info("Configurando logger do Sistema ...");
		logger.info("Logger do Sistema " + logger.getName() + " Configurado.");
	}

}
