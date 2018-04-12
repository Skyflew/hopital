/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.JpaDao.entityManager;
import java.util.Collection;
import javax.persistence.Query;
import metier.Atelier;
import metier.Machine;

/**
 *
 * @author Thomas
 */
public class JpaMachineDao extends JpaDao<Machine> implements MachineDao{
    
   private static JpaMachineDao instance;
    
    private JpaMachineDao(){
        super();
    }
    
    static JpaMachineDao getInstance(){
        if(instance == null){
            instance = new JpaMachineDao();
        }
        return instance;
    }

    @Override
    public boolean create(Machine obj) {
        return super.create(obj);
    }

    @Override
    public Machine find(Integer id) {
        return entityManager.find(Machine.class, id);
    }

    @Override
    public Collection findAll() {
        Query query = entityManager.createQuery("SELECT m FROM Machine m");
        return query.getResultList();
    }

    @Override
    public boolean update(Machine obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Machine obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        try{
        Query query = entityManager.createQuery("SELECT m FROM Machine m");
        for(Object a : query.getResultList()){
            entityManager.remove(a);
        }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
