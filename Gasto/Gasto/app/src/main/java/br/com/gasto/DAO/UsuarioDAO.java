package br.com.gasto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import br.com.gasto.DataBase.DatabaseHelper;
import br.com.gasto.Objects.Usuario;

/**
 * Created by 16254861 on 06/09/2017.
 */

public class UsuarioDAO {

    private static UsuarioDAO instance;

    public static UsuarioDAO getInstance(){
        if (instance ==null){
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public void cadastrarUsuario(Context context, Usuario usuario){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("usuario", usuario.getUsuario());
        dados.put("senha", usuario.getSenha());
        dados.put("foto", usuario.getFotoPerfil().getFormat());

        db.insert("tbl_Usuario", null, dados);
        db.close();
    }

    public void deletarUsuario(Context context, int id){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        db.delete("tbl_Usuario", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Usuario obterPorId(Context context, int id){

        Usuario user = new Usuario();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_usuario WHERE _id=?", new String[]{String.valueOf(id)});

        cursor.moveToFirst();

        user.setUsuario(cursor.getColumnName(2));
        user.setSenha(cursor.getColumnName(3));
//        user.setFotoPerfil(cursor.getColumnName(4));
        db.close();
        return user;
    }

    public void atualizarUsuario(Context context, int id, String nome, String senha, Bitmap foto){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("nome", nome);
        dados.put("senha", senha);
        dados.put("foto", foto.getByteCount());

        db.update("tbl_Usuario", dados, "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

}
