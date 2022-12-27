package com.maxi.app_colegio.entities.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ObjetoNaoEncontradoException {

    private String msg;

    public ObjetoNaoEncontradoException() {
    }

    public ObjetoNaoEncontradoException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    
}
