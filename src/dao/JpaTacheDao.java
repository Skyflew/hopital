/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import static dao.JpaDao.entityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;
import metier.Machine;
import metier.Tache;

/**
 *
 * @author Thomas
 */
public class JpaTacheDao extends JpaDao<Tache> implements TacheDao{
    
    private static JpaTacheDao instance;
    
    private JpaTacheDao(){
        super();
    }
    
    static JpaTacheDao getInstance(){
        if(instance == null){
            instance = new JpaTacheDao();
        }
        return instance;
    }

    @Override
    public boolean create(Tache obj) {
        return super.create(obj);
    }

    @Override
    public Tache find(Integer id) {
        return entityManager.find(Tache.class, id);
    }

    @Override
    public Collection<Tache> findAll() {
        Query query = entityManager.createQuery("SELECT t from Tache t");
        return query.getResultList();
    }

    @Override
    public boolean update(Tache obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(Tache obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        try{
        Query query = entityManager.createQuery("SELECT t FROM Tache t");
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
    public Collection<Tache> findAllNotScheduled() {
        Query query = entityManager.createQuery("SELECT t from Tache t");
        List<Tache> taches =  query.getResultList();
        List<Tache> res = new ArrayList<>();
        for(Tache t : taches){
            if(t.getNmachine() == null){
                res.add(t);
            }
        }
        return res;
    }
    
}
