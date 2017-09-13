package br.com.gasto.DAO;

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

}
