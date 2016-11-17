package com.yanolabs.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 * Bean da tabela "UFs" contendo seus campos, beans de classe
 * que se relacionam com esta classe e o método para inicializá-los.
 * 
 *  Created by willames on 03/11/16.
 */
@XmlRootElement
@Entity
@Table(name="ufs")
public class UFsBeans implements Cloneable, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

	/** Chave do tipo inteiro da tabela "UFs". Campo obrigatório. */
    @Id
	@SequenceGenerator(name="ufs_seq", sequenceName="ufs_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ufs_seq")
	@Column(name="codigouf")
	private int codigoUF;
	
	/** Texto de até 100 caracteres contendo a descrição do nome da
	 *  federação. Campo obrigatorio. */
	@Column(name="uf")
    private String UF;
	
	/** Sigla da federação. */
	@Column(name="sigla")
	private String sigla;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="codigoUF")
	private Collection <CidadesBeans> objListaCidadesBeans;
	
	/**
	 * @return Retorna codigoUF.
	 */
	public int getCodigoUF() {
		return codigoUF;
	}

	/**
	 * @param codigoUF codigoUF a ser setado.
	 */
	public void setCodigoUF(int codigoUF) {
		this.codigoUF = codigoUF;
	}

	/**
	 * @return Retorna sigla.
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla sigla a ser setado.
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * @return Retorna uF.
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * @param uf uF a ser setado.
	 */
	public void setUF(String uf) {
		UF = uf;
	}
		
	public Collection<CidadesBeans> getObjListaCidadesBeans() {
		return objListaCidadesBeans;
	}

	public void setObjListaCidadesBeans(
			Collection<CidadesBeans> objListaCidadesBeans) {
		this.objListaCidadesBeans = objListaCidadesBeans;
	}

	@Override
	public boolean equals(Object obj) {
		
    if(obj instanceof UFsBeans){
    	UFsBeans objUFsBeanss = (UFsBeans) obj;
        return objUFsBeanss.getCodigoUF() == this.getCodigoUF();
    }	 
    return false;
	}
}
