package br.com.gasto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import br.com.gasto.DataBase.DatabaseHelper;
import br.com.gasto.Objects.Movimentacao;

/**
 * Created by 16254861 on 06/09/2017.
 */

public class MovimentacaoDAO {

    private static MovimentacaoDAO instance;

    public static MovimentacaoDAO getInstance(){
        if (instance ==null){
            instance = new MovimentacaoDAO();
        }
        return instance;
    }

    public void cadastrarMovimentacao(Context context, Movimentacao mov){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        ContentValues dados = new ContentValues();

        dados.put("consumo", mov.getConsumo());
        dados.put("descricao", mov.getDescricao());
        dados.put("nome", mov.getNome());
        dados.put("idUsuario", mov.getIdUsuario());
        dados.put("idCategoria", mov.getIdCategoria());
        dados.put("idIntermedio", mov.getIdIntermedio());
        dados.put("fotoNotaFiscal", mov.getFotoNotaFiscal().getFormat());

        db.insert("tbl_Movimentacao", null, dados);
        db.close();
    }

    public void deletarMovimentacao(Context context, int id){
        SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();

        db.delete("tbl_Movimentacao", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Movimentacao obterPorId(Context context, int id){

        Movimentacao mov = new Movimentacao();

        SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Movimentacao WHERE _id=?", new String[]{String.valueOf(id)});

        cursor.moveToFirst();
        

        db.close();
        return mov;
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
