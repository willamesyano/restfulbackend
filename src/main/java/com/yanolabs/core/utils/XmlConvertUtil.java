package com.yanolabs.core.utils;

import javax.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Classe responsavel por converter objetos em xml e vice-e-versa.
 * 
 * @author Jocelio Otavio
 *
 */
public class XmlConvertUtil {
	
	/**
	 * Método que recebe como parametro a instancia da classe passada como
	 * parametro, e retorna uma string com o xml que representa o objeto
	 * passado. 
	 * 
	 * @param object Objeto que deve ser convertido
	 * @param objectType Tipo do objeto passado no primeiro parametro
	 * 
	 * @return Xml que representa o objeto passado como parametro
	 * @throws JAXBException
	 */
	public static <T> String convertObjToXml(T object, Class<T> objectType) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(objectType);
		
		Marshaller jaxbmarshaller = jaxbContext.createMarshaller();
		
		StringWriter stringWriter = new StringWriter();
		jaxbmarshaller.marshal(object, stringWriter);
		
		return stringWriter.toString();
	}
	
	/**
	 * Método que recebe um xml e a classe para a qual deve ser convertido
	 * o xml.  
	 * 
	 * @param xml String contendo o xml que deve ser convertido
	 * @param objectType Classe do objeto que deve ser retornado
	 *   	
	 * @return Objeto que representa o xml passado como parâmetro
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertXmlToObj(String xml, Class<T> objectType) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(objectType);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		return (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
	}	
	
	/**
	 * Método que recebe um xml, a classe para a qual deve ser convertido
	 * o xml e a ObjectFactory que deve ser utilizada para instanciar o objeto
	 * de retorno.  
	 * 
	 * @param xml String contendo o xml que deve ser convertido
	 * @param objectType Classe do objeto que deve ser retornado
	 * @param objectFactory	Fabrica de objetos que deve ser utilizada para 
	 * instanciar o objeto de retorno
	 *  
	 * @return Objeto que representa o xml passado como parametro
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertXmlToObj(String xml, Class<T> objectType, Class<?> objectFactory) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(objectFactory != null ? objectFactory : objectType);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<T> jaxbElement = (JAXBElement<T>) jaxbUnmarshaller.unmarshal(new StringReader(xml));
		
		return jaxbElement.getValue();
	}	
	
}
