/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.Atelier;

/**
 *
 * @author Thomas
 * @param <Atelier>
 */
public interface AtelierDao extends Dao<Atelier>{
    
    public Atelier findFirstAvailable();
    
}
