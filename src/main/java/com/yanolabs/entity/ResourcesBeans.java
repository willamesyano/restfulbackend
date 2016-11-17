package com.yanolabs.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Bean da tabela "Resources" contendo seus campos, beans de classe que se
 * relacionam com esta classe e o método para inicializá-los.
 *
 * Created by willames on 03/11/16.
 */

@XmlRootElement
@Entity
@Table(name = "resources")
public class ResourcesBeans implements Cloneable, Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** Chave do tipo inteiro da tabela "Resources". Campo obrigatório. */
    @Id
    @SequenceGenerator(name = "resources_seq", sequenceName = "resources_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resources_seq")
    @Column(name = "codigoresource")
    private int codigoResource;

    /** Texto de até 350 caracteres contendo o nome do Resource. */
    @Column(length = 350, nullable = false)
    private String descricao;


    public int getCodigoResource() {
        return codigoResource;
    }

    public void setCodigoResource(int codigoResource) {
        this.codigoResource = codigoResource;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourcesBeans)) return false;

        ResourcesBeans that = (ResourcesBeans) o;

        if (getCodigoResource() != that.getCodigoResource()) return false;
        return getDescricao() != null ? getDescricao().equals(that.getDescricao()) : that.getDescricao() == null;

    }

    @Override
    public int hashCode() {
        int result = getCodigoResource();
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        return result;
    }
}
