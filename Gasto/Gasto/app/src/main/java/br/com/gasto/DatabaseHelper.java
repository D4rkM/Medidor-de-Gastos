package br.com.gasto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 16254861 on 28/08/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "gastos.db";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                // Criando tabela com dados de USUARIO
                "CREATE TABLE tblUsuario(" +
                "id INTEGER PRIMARY KEY," +
                "nome TEXT not null," +
                "usuario TEXT not null" +
                "senha TEXT not null," +
                "email TEXT" +
                ");" +
                // Criando tabela com a movimentacao
                "CREATE TABLE tblMovimentacao(" +
                "id INTEGER PRIMARY KEY," +
                "idUsuario INTEGER," +
                "idCategoria INTEGER," +
                ");" +
                // Criando tabela de Categoria de Gastos
                "CREATE TABLE tblCategoria(" +
                "id INTEGER PRIMARY KEY," +
                "categoria TEXT not null," +
                "descricao TEXT" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "INSERT INTO tblUsuario";
    }
}
