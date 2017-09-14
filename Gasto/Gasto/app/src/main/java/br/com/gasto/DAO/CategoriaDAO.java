package br.com.gasto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import br.com.gasto.DataBase.DatabaseHelper;
import br.com.gasto.Objects.Categoria;

/**
 * Created by Magno on 06/09/2017.
 */

public class CategoriaDAO {

    private static CategoriaDAO instance;

    public static CategoriaDAO getInstance(){
        if (instance ==null){
            instance = new CategoriaDAO();
        }
        return instance;
    }

    public void adicionarCategoria(Context context, Categoria categoria){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("idUsuario", categoria.getIdUsuario());
        valores.put("categoria", categoria.getCategoria());
        valores.put("descricao", categoria.getDescricao());
        //valores.put("icone", categoria.getIcone());

        db.insert("tbl_Categoria", null, valores);
        db.close();
    }

    public void deletarCategoria(Context context, int id){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        db.delete("tbl_Categoria", "_id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public ArrayList<Categoria> obterTodas(Context context){

        ArrayList<Categoria> lstCategoria = new ArrayList<>();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        String sql = "SELECT * FROM tbl_Categoria;";



        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Categoria cat = new Categoria();

            cat.set_id(cursor.getInt(0));
            cat.setIdUsuario(cursor.getInt(1));
            cat.setCategoria(cursor.getString(2));
            cat.setDescricao(cursor.getString(3));

            try {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(cursor.getBlob(4));
                Bitmap foto = BitmapFactory.decodeStream(inputStream);
                cat.setIcone(foto);
            } catch (Exception e){

            }

            lstCategoria.add(cat);

        }
        cursor.close();

        return lstCategoria;
    }

    public Categoria obterPorId(Context context, int id){

        Categoria cat = new Categoria();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Categoria WHERE _id=?", new String[]{String.valueOf(id)});

        cursor.moveToFirst();

        cat.setCategoria(cursor.getColumnName(2));
        cat.setDescricao(cursor.getColumnName(3));
//        cat.setIcone(cursor.getColumnName());
        db.close();
        return cat;
    }

    public void atualizarCategoria(Context context, int id, String nome, String descricao, Image icone){

        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("categoria", nome);
        valores.put("descricao", descricao);
        valores.put("icone", icone.getFormat());

        db.update("tbl_Categoria", valores, "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

}
