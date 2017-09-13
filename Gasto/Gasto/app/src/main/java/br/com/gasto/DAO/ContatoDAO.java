package br.com.gasto.DAO;

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


}
