package br.com.correios.realize.filtros;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.correios.realize.constantes.Constantes;
import br.com.correios.realize.excecao.CorreiosException;
import br.com.correios.realize.excecao.CorreiosRuntimeException;
import br.com.correios.realize.seguranca.Usuario;
import br.com.correios.realize.seguranca.UsuarioLogadoFactory;

/**
 * Filtro responsável por verificar se o usuário está corretamente logado na
 * aplicação
 *
 * @author ArivaldoJunior
 */
@Component("loginFilter")
public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private Usuario usuario;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UsuarioLogadoFactory usuarioLogadoFactory;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        if (usuario.getLogin() == null) {

            try {

                usuarioLogadoFactory.constroiUsuarioLogado(request, usuario);

            } catch (CorreiosException e) {

                redirecionaPaginaErro(request, e);

                return;
            }
        }
        
        request.getSession().setAttribute(Constantes.USUARIO_LOGADO, usuario);
        
        // testa se usuario estah logado e testa se o IP de acesso
        // sao os mesmos do login
        if (usuario.getIp().equals(request.getRemoteAddr())) {
            chain.doFilter(request, response);
        } else {
            if (request.getSession(false) != null) {
                request.getSession(false).invalidate();
            }
        }

    }

    /**
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    private void redirecionaPaginaErro(HttpServletRequest request, Exception e)
            throws IOException, ServletException {
        String msgErro = extrairMensagensErro(e, request.getLocale());
        request.setAttribute(Constantes.ATTRIBUTE_ERROR_EXCEPTION, e);
        request.setAttribute(Constantes.ATTRIBUTE_ERROR_EXCEPTION_TYPE, e.getClass());
        request.setAttribute(Constantes.ATTRIBUTE_ERROR_MESSAGE, msgErro);
        request.setAttribute(Constantes.MENSAGEM_EXCECAO_SESSAO, msgErro);
        request.setAttribute(Constantes.ATTRIBUTE_ERROR_REQUEST_URI, request.getRequestURI());
        request.setAttribute(Constantes.ATTRIBUTE_ERROR_STATUS_CODE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    /**
     * Extrai as mensagens de erro desde a exceção original.
     *
     * @param e
     * @param locale
     * @return Msg de erro
     */
    private String extrairMensagensErro(Exception e, Locale locale) {
        String msg;
        if (e.getClass().isAssignableFrom(CorreiosException.class) && ((CorreiosException) e).getMessage() != null
                && !"".equals(((CorreiosException) e).getMessage())) {
            CorreiosException exception = (CorreiosException) e;
            msg = messageSource.getMessage(exception.getMessage(), exception.getArgs(), locale);
        } else if (e.getClass().isAssignableFrom(CorreiosRuntimeException.class)
                && e.getMessage() != null && !"".equals(e.getMessage())) {
            CorreiosRuntimeException exception = (CorreiosRuntimeException) e;
            msg = messageSource.getMessage(exception.getMessage(), exception.getArgs(), locale);
        } else {
            msg = messageSource.getMessage("erro", new String[]{e.getMessage()}, null, locale);
            ;
        }
        return msg;
    }

    @Override
    public void destroy() {
        // não preciso liberar recurso algum aqui.
    }

}
