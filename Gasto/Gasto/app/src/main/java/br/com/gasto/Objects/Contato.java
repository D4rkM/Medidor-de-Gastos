package br.com.gasto.Objects;

/**
 * Created by Magno on 06/09/2017.
 */

public class Contato {

    private int _id;
    private int idTipoContato;
    private int idUsuario;
    private String nome;
    private String descricao;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIdTipoContato() {
        return idTipoContato;
    }

    public void setIdTipoContato(int idTipoContato) {
        this.idTipoContato = idTipoContato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
