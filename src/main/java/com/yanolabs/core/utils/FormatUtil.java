package com.yanolabs.core.utils;

import org.apache.commons.lang.ArrayUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatUtil {
    

    /**
     * Detect if the current browser is a mobile one
     */
    public static final boolean isMobile(HttpServletRequest request) {
	String userAgent = request.getHeader("user-agent").toLowerCase();
	return userAgent.contains("android") || userAgent.contains("iphone") || userAgent.contains("blackberry");
    }

    /**
     * Format the document size for human readers
     */
    public static String formatSize(long size) {
	DecimalFormat df = new DecimalFormat("#0.0");
	String str;

	if (size / 1024 < 1) {
	    str = size + " B";
	} else if (size / 1048576 < 1) {
	    str = df.format(size / 1024.0) + " KB";
	} else if (size / 1073741824 < 1) {
	    str = df.format(size / 1048576.0) + " MB";
	} else if (size / 1099511627776L < 1) {
	    str = df.format(size / 1073741824.0) + " GB";
	} else if (size / 1125899906842624L < 1) {
	    str = df.format(size / 1099511627776.0) + " TB";
	} else {
	    str = "BIG";
	}

	return str;
    }

    /**
     * Format time for human readers
     */
    public static String formatTime(long time) {
	DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
	String str = df.format(time);
	return str;
    }

    /**
     * Format time interval for humans
     */
    public static String formatSeconds(long time) {
	long hours, minutes, seconds;
	time = time / 1000;
	hours = time / 3600;
	time = time - (hours * 3600);
	minutes = time / 60;
	time = time - (minutes * 60);
	seconds = time;
	return (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds);
    }

    /**
     * Format time interval for humans
     */
    public static String formatMiliSeconds(long time) {
	long hours, minutes, seconds, mseconds;
	mseconds = time % 1000;
	time = time / 1000;
	hours = time / 3600;
	time = time - (hours * 3600);
	minutes = time / 60;
	time = time - (minutes * 60);
	seconds = time;
	return (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds) + "."
		+ (mseconds < 10 ? "00" + mseconds : (mseconds < 100 ? "0" + mseconds : mseconds));
    }

    /**
     * Format calendar date
     */
    public static String formatDate(Calendar cal) {
	return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
    }

    /**
     * Format string array
     */
    public static String formatArray(String[] values) {
	if (values != null) {
	    if (values.length == 1) {
		return values[0];
	    } else {
		return ArrayUtils.toString(values);
	    }
	} else {
	    return "NULL";
	}
    }

    /**
     * Format object
     */
    public static String formatObject(Object value) {
	if (value != null) {
	    if (value instanceof Object[]) {
		return ArrayUtils.toString(value);
	    } else {
		return value.toString();
	    }
	} else {
	    return "NULL";
	}
    }

    /**
     * Escape html tags
     */
    public static String escapeHtml(String str) {
	return str.replace("<", "&lt;").replace(">", "&gt;");
    }

    /**
     * Método utilizado para gerar o digito verificador a partir do numero do
     * processo no formato do SPU
     * 
     * @param numeroProcesso
     *            Número do processo no formato do SPU(AAPPPPPP).
     * 
     * @return Inteiro contendo o digito verificador.
     */
    public static int calcularDigitoVerificador(String numeroProcesso) throws Exception {
	if (numeroProcesso.length() == 8) {
	    int soma;
	    char[] numeros = numeroProcesso.toCharArray();

	    soma = (numeros[7] * 2) + (numeros[6] * 3) + (numeros[5] * 4) + (numeros[4] * 5) + (numeros[3] * 6) + (numeros[2] * 7) + (numeros[1] * 8)
		    + (numeros[0] * 9);
	    int resto = soma % 11;

	    if ((resto == 0) || (resto == 1))
		return 0;

	    return 11 - resto;
	} else
	    throw new Exception("Não foi possível calcular o dígito verificador");
    }

    /**
     * Método utilizado para verificar o digito verificador a partir do número e
     * ano do processo
     * 
     * @param numeroProcesso
     *            Número do processo
     * 
     * @param anoProcesso
     *            Ano do processo
     * 
     * @return Boolean contendo true se o digito verificador está correto e
     *         false caso contrário.
     */
    public static boolean verificarDigitoVerificadorProcesso(String numeroProcesso, String anoProcesso) throws Exception {
	boolean retorno = false;

	int digitoVerificador = calcularDigitoVerificador(anoProcesso.substring(2, 4) + numeroProcesso.substring(0, 6));

	if (Integer.parseInt(numeroProcesso.substring(6, 7)) == digitoVerificador)
	    retorno = true;

	return retorno;
    }
}
