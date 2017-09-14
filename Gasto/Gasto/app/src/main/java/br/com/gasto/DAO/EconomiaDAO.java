package br.com.gasto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.util.ArrayList;

import br.com.gasto.DataBase.DatabaseHelper;
import br.com.gasto.Objects.Economia;

/**
 * Created by Magno on 06/09/2017.
 */

public class EconomiaDAO {

    private static EconomiaDAO instance;

    public static EconomiaDAO getInstance(){
        if (instance ==null){
            instance = new EconomiaDAO();
        }
        return instance;
    }

    public void cadastrarEndereco(Context context, Economia economia){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("_id", economia.get_id());
        dados.put("idTipo_economia", economia.getIdTipo_economia());
        dados.put("idIntermedio", economia.getIdIntermedio());
        dados.put("idUsuario", economia.getIdUsuario());
        dados.put("economia", economia.getEconomia());
        dados.put("descricao", economia.getDescricao());
        dados.put("quantia", economia.getQuantia());

        db.insert("tbl_Economia", null, dados);
        db.close();
    }

    public void deletarEconomia(Context context, int id){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        db.delete("tbl_Economia", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public ArrayList<Economia> obterTodos(Context context){

        ArrayList<Economia> lstEconomias = new ArrayList<>();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        String sql = "SELECT * FROM tbl_Economia;";



        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Economia economia = new Economia();

            economia.set_id(cursor.getInt(0));
            economia.setIdTipo_economia(cursor.getInt(1));
            economia.setIdIntermedio(cursor.getInt(2));
            economia.setIdUsuario(cursor.getInt(3));
            economia.setEconomia(cursor.getString(4));
            economia.setDescricao(cursor.getString(5));
            economia.setQuantia(cursor.getFloat(6));

            lstEconomias.add(economia);

        }
        cursor.close();

        return lstEconomias;
    }

    public Economia obterPorId(Context context, int id){

        Economia economia = new Economia();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Economia WHERE _id=?", new String[]{String.valueOf(id)});

        cursor.moveToFirst();

        economia.set_id(cursor.getInt(0));
        economia.setIdTipo_economia(cursor.getInt(1));
        economia.setIdIntermedio(cursor.getInt(2));
        economia.setIdUsuario(cursor.getInt(3));
        economia.setEconomia(cursor.getString(4));
        economia.setDescricao(cursor.getString(5));
        economia.setQuantia(cursor.getFloat(6));

        db.close();
        return economia;
    }

    public void atualizarEconomia(Context context, int id, Economia economia){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("_id", economia.get_id());
        dados.put("idTipo_economia", economia.getIdTipo_economia());
        dados.put("idIntermedio", economia.getIdIntermedio());
        dados.put("idUsuario", economia.getIdUsuario());
        dados.put("economia", economia.getEconomia());
        dados.put("descricao", economia.getDescricao());
        dados.put("quantia", economia.getQuantia());

        db.update("tbl_Economia", dados, "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

}
