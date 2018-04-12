/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import java.util.List;
import javax.persistence.Query;
import metier.Atelier;

/**
 *
 * @author Thomas
 */
public class JpaAtelierDao extends JpaDao<Atelier> implements AtelierDao{
    
    private static JpaAtelierDao instance;
    
    private JpaAtelierDao(){
        super();
    }
    
    static JpaAtelierDao getInstance(){
        if(instance == null){
            instance = new JpaAtelierDao();
        }
        return instance;
    }

    @Override
    public Atelier findFirstAvailable() {
        Query query = entityManager.createQuery("SELECT a from Atelier a");
        List<Atelier> ateliers =  query.getResultList();
        Atelier res = ateliers.get(0);
        long tempo = ateliers.get(0).getDatedispo().getTime();
        for(Atelier a : ateliers){
            if(a.getDatedispo().getTime() < tempo){
                tempo = a.getDatedispo().getTime();
                res= a;
            }
        }   
        return res;
    }

   
    @Override
    public Atelier find(Integer id) {
        return entityManager.find(Atelier.class, id);
    }

    @Override
    public Collection<Atelier> findAll() {
        Query query = entityManager.createQuery("SELECT a from Atelier a");
        return query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        try{
        Query query = entityManager.createQuery("SELECT a from Atelier a");
        for(Object a : query.getResultList()){
            entityManager.remove(a);
        }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean create(Atelier obj) {
        return super.create(obj);
    }

    @Override
    public boolean update(Atelier obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Atelier obj) {
        return super.delete(obj);
    }

    
}
