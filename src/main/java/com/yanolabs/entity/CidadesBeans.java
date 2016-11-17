package com.yanolabs.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;



/**
 * Bean da tabela "Cidades" contendo seus campos, beans de classe que se
 * relacionam com esta classe e o método para inicializá-los.
 * 
 *  Created by willames on 03/11/16.
 * 
 */
@XmlRootElement
@Entity
@Table(name = "cidades")
public class CidadesBeans implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Chave do tipo inteiro da tabela "Cidades". Campo obrigatório. */
	@Id
	@SequenceGenerator(name = "cidades_seq", sequenceName = "cidades_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidades_seq")
	@Column(name = "codigocidade")
	private int codigoCidade;

	/**
	 * Chave estrangeira do tipo inteiro contendo o código do estado oriundo da
	 * tabela "UFs". Campo obrigatório.
	 */
	@Column(name = "codigouf")
	private int codigoUF;

	/** Texto de até 100 caracteres contendo a descrição do nome da cidade. */
	@Column(name = "cidade")
	private String cidade;

	/**
	 * Bean da classe UFs a ser populado com os dados do registro de código
	 * igual a codigoUF desta bean, através do método setarObjetos().
	 */
	//@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigouf", referencedColumnName = "codigouf", insertable=false,updatable=false)	
	@Fetch(FetchMode.JOIN)
	private UFsBeans objUFsBeans;

	/**
	 * @return Retorna cidade.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            cidade a ser setado.
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return Retorna codigoCidade.
	 */
	public int getCodigoCidade() {
		return codigoCidade;
	}

	/**
	 * @param codigoCidade
	 *            codigoCidade a ser setado.
	 */
	public void setCodigoCidade(int codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	/**
	 * @return Retorna the codigoUF.
	 */
	public int getCodigoUF() {
		return codigoUF;
	}

	/**
	 * @param codigoUF
	 *            codigoUF a ser setado.
	 */
	public void setCodigoUF(int codigoUF) {
		this.codigoUF = codigoUF;
	}

	/**
	 * @return Retorna objUfsBeans.
	 */
	public UFsBeans getObjUFsBeans() {
		return objUFsBeans;
	}

	/**
	 * @param objUFsBeans
	 *            objUfsBeans a ser setado.
	 */
	public void setObjUFsBeans(UFsBeans objUFsBeans) {
		this.objUFsBeans = objUFsBeans;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof CidadesBeans) {
			CidadesBeans objCidadesBeans = (CidadesBeans) obj;
			return objCidadesBeans.getCodigoCidade() == this.getCodigoCidade();
		}
		return false;
	}
}
