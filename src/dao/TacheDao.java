/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import metier.Tache;

/**
 *
 * @author Thomas
 * @param <Tache>
 */
public interface TacheDao extends Dao<Tache>{
    
    public Collection<Tache> findAllNotScheduled();
}
