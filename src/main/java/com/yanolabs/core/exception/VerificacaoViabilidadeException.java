package com.yanolabs.core.exception;

public class VerificacaoViabilidadeException extends RuntimeException {
    
    private static final long serialVersionUID = -8935712042044355058L;

    /**
     * Contructor.
     */
    public VerificacaoViabilidadeException(String message) {
            super(message);
    }
    
    /**
     * Contructor.
     */
    public VerificacaoViabilidadeException(Throwable throwable) {
            //super("Cod.: 800901 DATABASE - Operação não permitida." throwable.getMessage(),throwable);
            super(throwable.getMessage(),throwable);
    }
    
    /**
     * Contructor.
     */
    public VerificacaoViabilidadeException(String message, Throwable throwable) {
            super(message, throwable);
    }
}
