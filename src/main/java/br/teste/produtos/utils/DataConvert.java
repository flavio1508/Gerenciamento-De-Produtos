package br.teste.produtos.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataConvert {
    public static LocalDate obterData(String dataEmString) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dataEmString, formato);
    }
}
