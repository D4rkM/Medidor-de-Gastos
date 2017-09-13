package br.com.gasto.DAO;

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

}
