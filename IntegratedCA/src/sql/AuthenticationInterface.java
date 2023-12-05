/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sql;

import UserGetSet.User;
import java.sql.ResultSet;
/**
 *
 * @author carol
 */
public interface AuthenticationInterface {
    
     public ResultSet autenticationUesr(User objUserRTE);
}
