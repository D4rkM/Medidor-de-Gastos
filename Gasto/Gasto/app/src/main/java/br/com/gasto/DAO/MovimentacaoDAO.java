package br.com.gasto.DAO;

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

}
