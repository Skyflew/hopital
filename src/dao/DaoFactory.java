/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Thomas
 */
public abstract class DaoFactory {
    
    public abstract JpaAtelierDao getAtelierDao();
 
    public abstract JpaMachineDao getMachineDao();
    
    public abstract JpaTacheDao getTacheDao();
    
}
