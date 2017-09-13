package br.com.gasto.Objects;

import android.media.Image;

/**
 * Created by Magno on 06/09/2017.
 */

public class Movimentacao {

    private int _id;
    private int idUsuario;
    private int idCategoria;
    private int idIntermedio;
    private Image fotoNotaFiscal;
    private String descricao;
    private String nome;
    private Float consumo;

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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdIntermedio() {
        return idIntermedio;
    }

    public void setIdIntermedio(int idIntermedio) {
        this.idIntermedio = idIntermedio;
    }

    public Image getFotoNotaFiscal() {
        return fotoNotaFiscal;
    }

    public void setFotoNotaFiscal(Image fotoNotaFiscal) {
        this.fotoNotaFiscal = fotoNotaFiscal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getConsumo() {
        return consumo;
    }

    public void setConsumo(Float consumo) {
        this.consumo = consumo;
    }

}
