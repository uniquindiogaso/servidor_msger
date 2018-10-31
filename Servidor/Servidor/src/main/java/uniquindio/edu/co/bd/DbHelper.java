/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.bd;

import org.sql2o.Sql2o;

/**
 *
 * @author gusta
 */
public class DbHelper {

    private static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost/msger", "r00t", "$clave$UQ");

    public static Sql2o getSql2o() {
        return sql2o;
    }

}
