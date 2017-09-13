package br.com.gasto.Objects;

import android.media.Image;

/**
 * Created by Magno on 06/09/2017.
 */

public class Usuario {

    private int _id;
    private String usuario;
    private String senha;
    private Image fotoPerfil;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Image getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Image fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
