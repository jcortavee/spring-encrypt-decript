package com.josecarlos.jcdecrypt.models;

public class EncryptRequest {

    private String seed;
    private String texto;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
