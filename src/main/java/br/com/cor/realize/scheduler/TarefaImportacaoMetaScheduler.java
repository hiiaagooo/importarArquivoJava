package br.com.correios.realize.scheduler;

import br.com.correios.realize.constantes.Constantes;
import br.com.correios.realize.excecao.ValidacaoArquivoException;
import br.com.correios.realize.model.CargaMetaAgencia;
import br.com.correios.realize.model.enums.TipoSituacaoImportacaoMetaEnum;
import br.com.correios.realize.repository.CargaMetaAgenciaRepository;
import br.com.correios.realize.service.MetaAgenciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class TarefaImportacaoMetaScheduler {

    private static final Logger log = LoggerFactory.getLogger(TarefaImportacaoMetaScheduler.class);

    @Autowired
    private CargaMetaAgenciaRepository cargaMetaAgenciaRepository;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private MetaAgenciaService metaAgenciaService;

    @Scheduled(fixedRate = 300000)
    public void reportCurrentTime() {
        List<CargaMetaAgencia> listaCargaMetaAgencia = cargaMetaAgenciaRepository.listarTodosPorTipoSituacaoImportacao(TipoSituacaoImportacaoMetaEnum.EP);

        Collection<Thread> workers = recuperarWorkersExecutor();

        listaCargaMetaAgencia.stream().forEach(cargaMetaAgencia -> verificarFalhaCargaMeta(cargaMetaAgencia,workers));

    }

    private void verificarFalhaCargaMeta(CargaMetaAgencia cargaMetaAgencia, Collection<Thread> workers) {

        for (Thread thread: workers) {
            if(thread.getName().equals(cargaMetaAgencia.getCmaTxOrigemCarga())){
                return;
            }
        }

        LocalDateTime dataHoraAtual = LocalDateTime.now().minusMinutes(Constantes.MINUTOS_VERIFICACAO_IMPORTACAO);
        if(dataHoraAtual.isAfter(cargaMetaAgencia.getCmaDt())) {
            ValidacaoArquivoException validacaoArquivoException = new ValidacaoArquivoException("Não foi possível importar o arquivo, tente novamente.");
            metaAgenciaService.registrarErroImportarDadosArquivo(cargaMetaAgencia, validacaoArquivoException);
        }

    }

    private Collection<Thread> recuperarWorkersExecutor() {
        Collection<Object> workers = (Collection<Object>) ReflectionTestUtils.getField(threadPoolTaskExecutor.getThreadPoolExecutor(), "workers");
        List<Thread> listaWorkerThread = new ArrayList<>();
        for(Object worker : workers){
            Thread workerThread = (Thread)ReflectionTestUtils.getField(worker, "thread");
            listaWorkerThread.add(workerThread);
        }

        return listaWorkerThread;
    }
}