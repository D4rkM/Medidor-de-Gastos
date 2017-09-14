package br.com.gasto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.gasto.DataBase.DatabaseHelper;
import br.com.gasto.Objects.Contato;

/**
 * Created by Magno on 06/09/2017.
 */

public class ContatoDAO {

    private static ContatoDAO instance;

    public static ContatoDAO getInstance(){
        if (instance ==null){
            instance = new ContatoDAO();
        }
        return instance;
    }

    public void cadastrarContato(Context context, Contato contato){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("idTipoContato", contato.getIdTipoContato());
        dados.put("idUsuario", contato.getIdUsuario());
        dados.put("nome", contato.getNome());

        db.insert("tbl_Contato", null, dados);
        db.close();
    }

    public void deletarContato(Context context, int id){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        db.delete("tbl_Contato", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public ArrayList<Contato> obterTodos(Context context){

        ArrayList<Contato> lstContatos = new ArrayList<>();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        String sql = "SELECT * FROM tbl_Contato;";



        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Contato economia = new Contato();

            economia.setIdTipoContato(cursor.getInt(1));
            economia.setIdUsuario(cursor.getInt(2));
            economia.setNome(cursor.getString(3));

            lstContatos.add(economia);

        }
        cursor.close();

        return lstContatos;
    }

    public Contato obterPorId(Context context, int id){

        Contato contato = new Contato();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Contato WHERE _id=?", new String[]{String.valueOf(id)});

        cursor.moveToFirst();

        contato.setIdTipoContato(cursor.getInt(1));
//        contato.getIdUsuario(cursor.getInt(2));
//        contato.getNome(cursor.getString(3));
//        contato.getDescricao(cursor.getString(4));

        db.close();
        return contato;
    }

    public void atualizarContato(Context context, int id, Contato contato){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("idTipoContato", contato.getIdTipoContato());
        dados.put("idUsuario", contato.getIdUsuario());
        dados.put("nome", contato.getNome());
        dados.put("descricao", contato.getDescricao());

        db.update("tbl_Contato", dados, "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

}
