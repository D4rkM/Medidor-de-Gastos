package br.com.gasto.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 16254861 on 28/08/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "financas.db";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                // Criando tabela com dados de USUARIO
                "CREATE TABLE tbl_Usuario(" +
                    "_id INTEGER PRIMARY KEY," +
                    "usuario TEXT not null," +
                    "senha TEXT not null," +
                    "foto BLOB"+
                ");" +

                // Criando tabela de Contato
                "CREATE TABLE tbl_Contato(" +
                    "_id INTEGER PRIMARY KEY," +
                    "idTipoContato INTEGER," +
                    "idUsuario INTEGER," +
                    "nome TEXT not null," +
                    "descricao TEXT" +
                ");" +

                //Criando tabela de tipo contato
                "CREATE TABLE tbl_TipoContato(" +
                    "_id INTEGER PRIMARY KEY," +
                    "tipo_contato TEXT not null," +
                    "icone BLOB" +
                ");" +

                //Criando tabela de Endereço
                "CREATE TABLE tbl_Endereco(" +
                    "_id INTEGER PRIMARY KEY," +
                    "idTipo_Endereco INTEGER," +
                    "idUsuario INTEGER," +
                    "idMovimentacao INTEGER," +
                    "numero TEXT," +
                    "logradouro TEXT not null," +
                    "cidade TEXT not null," +
                    "estado TEXT not null," +
                    "bairro TEXT," +
                    "CEP TEXT" +
                ");" +

                //Criando tabela tipo_endereco
                "CREATE TABLE tbl_tipo_endereco(" +
                    "_id INTEGER PRIMARY KEY," +
                    "tipo_endereco TEXT not null," +
                    "icone BLOB" +
                ");" +

                // Criando tabela com a movimentacao
                "CREATE TABLE tbl_Movimentacao(" +
                    "_id INTEGER PRIMARY KEY," +
                    "idUsuario INTEGER not null," +
                    "idCategoria INTEGER not null," +
                    "idIntermedio INTEGER," +
                    "fotoNotaFiscal BLOB," +
                    "descricao TEXT," +
                    "nome TEXT not null," +
                    "consumo REAL not null" +
                ");" +

                // Criando tabela de Intermedio
                "CREATE TABLE tbl_Intermedio(" +
                    "_id INTEGER PRIMARY KEY," +
                    "idMovimentacao INTEGER," +
                    "idEconomia INTEGER" +
                ");" +

                // Tabela de Economias
                "CREATE TABLE tbl_Economia(" +
                    "_id INTEGER PRIMARY KEY," +
                    "idTipo_economia INTEGER," +
                    "idIntermedio INTEGER," +
                    "idUsuario INTEGER," +
                    "economia TEXT," +
                    "descricao TEXT," +
                    "quantia REAL" +
                ");" +

                // Criando tabela de Categoria de Gastos
                "CREATE TABLE tbl_Categoria(" +
                    "_id INTEGER PRIMARY KEY," +
                    "idUsuario INTEGER," +
                    "categoria TEXT not null," +
                    "descricao TEXT," +
                    "icone BLOB" +
                ");" ; //Fim da criação do banco

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "INSERT INTO tblUsuario";
    }
}
