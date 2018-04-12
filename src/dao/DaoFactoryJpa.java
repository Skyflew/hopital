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
public class DaoFactoryJpa extends DaoFactory{
    
    @Override
    public  JpaAtelierDao getAtelierDao(){
        return JpaAtelierDao.getInstance();
    }
    
    @Override
    public  JpaMachineDao getMachineDao(){
        return JpaMachineDao.getInstance();
    }
    
    @Override
    public  JpaTacheDao getTacheDao(){
        return JpaTacheDao.getInstance();
    }
    
}
