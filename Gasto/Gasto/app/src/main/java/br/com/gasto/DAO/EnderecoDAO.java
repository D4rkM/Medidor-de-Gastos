package br.com.gasto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import br.com.gasto.DataBase.DatabaseHelper;
import br.com.gasto.Objects.Endereco;

/**
 * Created by 16254861 on 06/09/2017.
 */

public class EnderecoDAO {

    private static EnderecoDAO instance;

    public static EnderecoDAO getInstance(){
        if (instance ==null){
            instance = new EnderecoDAO();
        }
        return instance;
    }

    public void cadastrarEndereco(Context context, Endereco endereco){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("idTipo_Endereco", endereco.getIdTipo_endereco());
        dados.put("idUsuario", endereco.getIdUsuario());
        dados.put("idMovimentacao", endereco.getIdMovimentacao());
        dados.put("numero", endereco.getNumero());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("cidade", endereco.getCidade());
        dados.put("estado", endereco.getEstado());
        dados.put("bairro", endereco.getBairro());
        dados.put("CEP", endereco.getCEP());

        db.insert("tbl_Endereco", null, dados);
        db.close();
    }

    public void deletarEndereco(Context context, int id){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        db.delete("tbl_Endereco", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public ArrayList<Endereco> obterTodos(Context context){

        ArrayList<Endereco> lstEnderecos = new ArrayList<>();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        String sql = "SELECT * FROM tbl_Endereco;";



        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Endereco end = new Endereco();

            end.setIdTipo_endereco(cursor.getInt(1));
            end.setIdUsuario(cursor.getInt(2));
            end.setIdMovimentacao(cursor.getInt(3));
            end.setNumero(cursor.getString(4));
            end.setLogradouro(cursor.getString(5));
            end.setCidade(cursor.getString(6));
            end.setEstado(cursor.getString(7));
            end.setBairro(cursor.getString(8));
            end.setCEP(cursor.getString(9));

            lstEnderecos.add(end);

        }
        cursor.close();

        return lstEnderecos;
    }

    public Endereco obterPorId(Context context, int id){

        Endereco end = new Endereco();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Endereco WHERE _id=?", new String[]{String.valueOf(id)});

        cursor.moveToFirst();

        end.setIdTipo_endereco(cursor.getInt(1));
        end.setIdUsuario(cursor.getInt(2));
        end.setIdMovimentacao(cursor.getInt(3));
        end.setNumero(cursor.getString(4));
        end.setLogradouro(cursor.getString(5));
        end.setCidade(cursor.getString(6));
        end.setEstado(cursor.getString(7));
        end.setBairro(cursor.getString(8));
        end.setCEP(cursor.getString(9));

        db.close();
        return end;
    }

    public void atualizarEndereco(Context context, int id, Endereco endereco){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("idTipo_Endereco", endereco.getIdTipo_endereco());
        dados.put("idUsuario", endereco.getIdUsuario());
        dados.put("idMovimentacao", endereco.getIdMovimentacao());
        dados.put("numero", endereco.getNumero());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("cidade", endereco.getCidade());
        dados.put("estado", endereco.getEstado());
        dados.put("bairro", endereco.getBairro());
        dados.put("CEP", endereco.getCEP());

        db.update("tbl_Endereco", dados, "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }


}
