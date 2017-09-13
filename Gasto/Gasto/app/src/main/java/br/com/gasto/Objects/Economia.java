package br.com.gasto.Objects;

/**
 * Created by Magno on 06/09/2017.
 */

public class Economia {

    private int _id;
    private int idTipo_economia;
    private int idIntermedio;
    private int idUsuario;
    private String economia;
    private String descricao;
    private Float quantia;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIdTipo_economia() {
        return idTipo_economia;
    }

    public void setIdTipo_economia(int idTipo_economia) {
        this.idTipo_economia = idTipo_economia;
    }

    public int getIdIntermedio() {
        return idIntermedio;
    }

    public void setIdIntermedio(int idIntermedio) {
        this.idIntermedio = idIntermedio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEconomia() {
        return economia;
    }

    public void setEconomia(String economia) {
        this.economia = economia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getQuantia() {
        return quantia;
    }

    public void setQuantia(Float quantia) {
        this.quantia = quantia;
    }
}
