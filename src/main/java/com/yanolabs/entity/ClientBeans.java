package com.yanolabs.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Bean da tabela "Client" contendo seus campos, beans de classe que se
 * relacionam com esta classe e o método para inicializá-los.
 *
 * Created by willames on 03/11/16.
 */
@XmlRootElement
@Entity
@Table(name = "clients")
public class ClientBeans implements Cloneable, Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** Chave do tipo inteiro da tabela "Client". Campo obrigatório. */
    @Id
    @SequenceGenerator(name = "clients_seq", sequenceName = "clients_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_seq")
    @Column(name = "codigoclient")
    private int codigoClient;

    /** Texto de até 35 caracteres contendo o username de Client. */
    @Column(length = 35, nullable = false)
    private String username;

    /** Texto de até 50 caracteres contendo o password de Client. */
    @Column(length = 50, nullable = false)
    private String password;

    /** Texto de até 250 caracteres contendo o token de Client. */
    @Column(length = 250, nullable = false)
    private String token;

    /** Boolean contendo o status autenticação de Client. */
    @Column
    private boolean logged;

    public int getCodigoClient() {
        return codigoClient;
    }

    public void setCodigoClient(int codigoClient) {
        this.codigoClient = codigoClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientBeans)) return false;

        ClientBeans that = (ClientBeans) o;

        if (getCodigoClient() != that.getCodigoClient()) return false;
        if (isLogged() != that.isLogged()) return false;
        if (!getUsername().equals(that.getUsername())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        return getToken().equals(that.getToken());

    }

    @Override
    public int hashCode() {
        int result = (int) (getCodigoClient() ^ (getCodigoClient() >>> 32));
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getToken().hashCode();
        result = 31 * result + (isLogged() ? 1 : 0);
        return result;
    }
}
