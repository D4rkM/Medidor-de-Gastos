package br.com.gasto.Objects;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by Magno on 06/09/2017.
 */

public class Categoria {

    private int _id;
    private int idUsuario;
    private String categoria;
    private String descricao;
    private Bitmap icone;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Bitmap getIcone() {
        return icone;
    }

    public void setIcone(Bitmap icone) {
        this.icone = icone;
    }
}
