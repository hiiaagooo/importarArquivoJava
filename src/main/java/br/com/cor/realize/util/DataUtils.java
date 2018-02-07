package br.com.correios.realize.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataUtils {

    private static final String DD_MM_YYYY = "dd/MM/yyyy";
	private DateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);

    public static String getDataString(Date data, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        if (data != null) {
            return sdf.format(data);
        }
        return null;
    }

    // Converte data no formato String(dd/mm/aaaa) para Integer(aaaammdd)
    public Integer converterDataDMAParaAMD(String dataDMA) {

        String ano = dataDMA.substring(6, 10);
        String mes = dataDMA.substring(3, 5);
        String dia = dataDMA.substring(0, 2);
        String dtAMD = ano + mes + dia;
        Integer dataConvertida = new Integer(dtAMD);

        return dataConvertida;
    }

    // Verificar se dataA maior que dataB
    public boolean verificarDataMaiorQueDataB(String dataA, String dataB) {

        Integer dtA = converterDataDMAParaAMD(dataA);
        Integer dtB = converterDataDMAParaAMD(dataB);

        return dtA > dtB;
    }

    // Calcular a quantidade de dias entre datas no formato dd/mm/aaaa
    public Integer calcularQuantidadeDiasEntreDatas(String dataInicial, String dataFinal) throws ParseException {

        sdf.setLenient(false);
        Date dataInicio = sdf.parse(dataInicial);
        Date dataFim = sdf.parse(dataFinal);
        long dt = (dataFim.getTime() - dataInicio.getTime()) + 3600000;
        Long diasCorridosAnoLong = (dt / 86400000L);

        return Integer.valueOf(diasCorridosAnoLong.toString());
    }

    // Calcular a quantidade de dias entre data informada e a data do sistema
    public Integer calcularQuantidadeDiasComDataSistema(String dataDMA) throws ParseException {

        String dataAtual = sdf.format(new Date(System.currentTimeMillis()));

        return calcularQuantidadeDiasEntreDatas(dataDMA, dataAtual);
    }

    public String recuperarDataAtual() {
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);

        return sdf.format(data);
    }

    public String transformarDateParaDMY(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);

        return sdf.format(data);
    }
    
    public static String transformarDateParaDMY(LocalDate data) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        return data.format(formatters);
    }
    
    public static LocalDate obterPrimeiroDiaMes(Integer mes, Integer ano) {
		return LocalDate.of(ano, mes,1);
    }
    
    public static String obterPrimeiroDiaMesDMY(Integer mes, Integer ano) {
		return transformarDateParaDMY(obterPrimeiroDiaMes(mes, ano));
    }
    
    public static LocalDate obterUltimoDiaMes(Integer mes, Integer ano) {
    	return LocalDate.of(ano, mes,1).with(TemporalAdjusters.lastDayOfMonth());
    }
    
    public static String obterUltimoDiaMesDMY(Integer mes, Integer ano) {
    	return transformarDateParaDMY(obterUltimoDiaMes(mes, ano));
    }
    
    public static LocalDate converterDataDMYParaLocalDate(String data) {
    	return (data.equals("")) ? null : LocalDate.parse(data, DateTimeFormatter.ofPattern(DD_MM_YYYY));    	
    }
	

    // Informar mm/aaaa
    public Integer recuperarUltimoDiaMes(String mmAaaa) {
        Integer mes = new Integer(mmAaaa.substring(0, 1));
        Integer ano = new Integer(mmAaaa.substring(3));

        Calendar cal = new GregorianCalendar(ano, mes, 1);

        return cal.getMaximum(Calendar.DAY_OF_MONTH);
    }
}
