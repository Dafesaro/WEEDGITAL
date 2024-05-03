/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.weedgital;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Daniel
 */

    public class conexion  {
    Connection con;
    
    
    
    public void conexion () {
    
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost: /weedgital","root","");
         System.out.println("se ha conectado a la base de datos");
                 
    } 
    
    catch (Exception e) {
        System.err.println("no se puede conectar a la base de datos"+e);
       
}
}
    
    public Connection getConnection (){
    return con;
    }
}

