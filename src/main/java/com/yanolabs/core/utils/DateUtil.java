package com.yanolabs.core.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author pavila
 * 
 */
public class DateUtil {

	public static final Calendar converterDataCalendar(String timestamp) throws ParseException {
		return converterDataCalendar(timestamp, "dd-mm-yyyy hh:mm:ss");
	}

	public static final Calendar converterDataCalendar(String timestamp, String formato) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(formato);
		Calendar calendar = Calendar.getInstance();
		Date date = df.parse(timestamp);
		calendar.setTime(date);
		return calendar;
	}

	public static final Timestamp converterDataTimestamp(String timestamp) throws ParseException {
		return converterDataTimestamp(timestamp, "dd-mm-yyyy hh:mm:ss");
	}

	public static final Timestamp converterDataTimestamp(String timestampstring, String formato) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(formato);
		Date date = df.parse(timestampstring);
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}

	public static final Calendar getDataAtual() {
		return Calendar.getInstance();
	}

	public static final int getMesAtual() {
		return getDataAtual().get(Calendar.MONTH);
	}

	public static final int getAnoAtual() {
		return getDataAtual().get(Calendar.YEAR);
	}

	public static final long getDiffMinutosTimestamp(Timestamp dataHoraAtual, Timestamp dataEntrada) {
		return (dataHoraAtual.getTime() - dataEntrada.getTime()) / (60 * 1000) % 60;
	}
	
	public static final long getDiffHorasTimestamp(Timestamp dataHoraAtual, Timestamp dataEntrada) {
		return (dataHoraAtual.getTime() - dataEntrada.getTime()) / (60 * 60 * 1000) % 24;
	}
	
	public static final long getDiffSegundosTimestamp(Timestamp dataHoraAtual, Timestamp dataEntrada) {
		return (dataHoraAtual.getTime() - dataEntrada.getTime()) / 1000 % 60;
	}

	public static final long getDiffDiasTimestamp(Timestamp dataHoraAtual, Timestamp dataEntrada) {
		return (dataHoraAtual.getTime() - dataEntrada.getTime()) / (24 * 60 * 60 * 1000);
	}

}
