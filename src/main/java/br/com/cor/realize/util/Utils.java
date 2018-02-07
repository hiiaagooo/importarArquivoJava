package br.com.correios.realize.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

public class Utils {

    /**
     * Verifica se uma String corresponde a uma data com dia, mês e ano
     *
     * @param data    data no formato String ex: 01-12-2014 ou 2016/10/01...
     * @param pattern formato da data da String passada ex: dd/MM/yyyy ou YYYY/dd/MM
     *                ...
     * @return true caso seja uma data válida, false caso contrário
     */
    public static boolean dataEhValida(String data, String pattern) {
        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter();
        try {
            LocalDate.parse(data, format);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Verifica se uma String corresponde a uma data com mês e ano
     *
     * @param data    data no formato String ex: 12-2014 ou 2016/10 ...
     * @param pattern formato da data da String passada ex: MM/yyyy ou YYYY/MM ...
     * @return true caso seja uma data válida, false caso contrário
     */
    public static boolean dataMesAnoEhValida(String data, String pattern) {
        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter();
        try {
            YearMonth.parse(data, format);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Verifica se uma data é menor que outra
     *
     * @param datax data que deve ser menor
     * @param datay data que deve ser maior
     * @return true caso datax seja menor que datay, false caso contrário
     */
    public static boolean dataxEhMenorDatay(LocalDate datax, LocalDate datay) {
        return datax.isBefore(datay);
    }

    /**
     * Verifica se uma data é menor que outra
     *
     * @param datax data que deve ser menor
     * @param datay data que deve ser maior
     * @return true caso datax seja menor que datay, false caso contrário
     */
    public static boolean dataxEhMenorDatay(YearMonth datax, YearMonth datay) {
        return datax.isBefore(datay);
    }


    /**
     * Converte uma String em uma data do tipo LocalDate (data deve conter ano,
     * mês e dia)
     *
     * @param data    data no formato String
     * @param pattern formato da data ex dd/MM/yyyy ou dd-MM-YYY ...
     * @return LocalDate oriundo do @param data
     */
    public static LocalDate converterStringEmData(String data, String pattern) {
        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter();
        return LocalDate.parse(data, format);
    }


    /***
     * Metodo para reutilizar condicao, MAIOR.
     * @param num1
     * @param num2
     * @return Boolean
     */
    public static Boolean validaMaior(Double num1, Double num2) {
        return num1 > num2;
    }

    /***
     * Metodo para reutilizar condicao, ENTRE.
     * @param num1
     * @param lim1
     * @param lim2
     * @return Boolean
     */
    public static Boolean validaEntre(Double numero, Double limiteMenor, Double limiteMaior) {
        return numero >= limiteMenor && numero <= limiteMaior;
    }

    /***
     * Metodo para reutilizar condicao, MENOR.
     * @param num1
     * @param num2
     * @return Boolean
     */
    public static Boolean validaMenor(Double num1, Double num2) {
        return num1 < num2;
    }

    /***
     * Metodo para particionar String em uma lista
     * @param codigos
     * @return List - String
     */
    public static String[] particionaStringEmCodigos(String codigos, String delimitador) {
        String strings[] = codigos.split("[" + delimitador + "]");
        return strings;
    }

    /**
     * Retorna valor com simbolo de porcentagem
     *
     * @param valor      com ponto flutuante
     *                   data no formato String ex: 01-12-2014 ou 2016/10/01...
     * @param quantidade de casas apos a virgula
     * @return string com o valor formatado
     */
    public static String formatarValorPorcentagem(Float valor, Integer quantidadeCasasAposVirgula) {
        String valorFormatado = "";
        String partes[] = particionaStringEmCodigos(String.valueOf(valor), ".");

        if (valor == Math.round(valor)) {
            valorFormatado = partes[0].concat("%");
        } else {
            if (quantidadeCasasAposVirgula <= partes[1].length()) {
                valorFormatado = partes[0] + "." + partes[1].substring(0, quantidadeCasasAposVirgula) + "%";
            } else {
                valorFormatado = partes[0] + "." + partes[1].substring(0, partes[1].length()) + "%";
            }
        }
        return valorFormatado;
    }
}
