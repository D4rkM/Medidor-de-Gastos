package br.com.gasto.DAO;

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
}
