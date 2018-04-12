/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import dao.AtelierDao;
import dao.DaoFactoryJpa;
import dao.JpaAtelierDao;
import dao.JpaMachineDao;
import dao.JpaTacheDao;
import dao.MachineDao;
import dao.TacheDao;
import java.util.Date;
import metier.Atelier;
import metier.Machine;
import metier.Tache;

/**
 *
 * @author Thomas
 */
public class Test2 {
    public static void main(String[] args) {
        Atelier a = new Atelier();
        Machine m1 = new Machine();
        Machine m2 = new Machine();
        long timeMillis = System.currentTimeMillis();
        Tache t1 = new Tache(45, new Date(timeMillis+60000*120), 5.0);
        Tache t2 = new Tache(120, new Date(timeMillis+60000*150), 10.0);
        Tache t3 = new Tache(70, new Date(timeMillis+60000*180), 4.0);
        Tache t4 = new Tache(60, new Date(timeMillis+60000*300), 12.0);
        AtelierDao atelierManager = DaoFactoryJpa.getAtelierDao();
        MachineDao machineManager = DaoFactoryJpa.getMachineDao();
        TacheDao tacheManager = DaoFactoryJpa.getTacheDao();
        tacheManager.deleteAll();
        machineManager.deleteAll();
        atelierManager.deleteAll();
        a.addMachine(m1);
        a.addMachine(m2);
        atelierManager.create(a);
        tacheManager.create(t1);
        tacheManager.create(t2);
        tacheManager.create(t3);
        tacheManager.create(t4);
        // doit afficher les 4 taches
        for(Tache t : tacheManager.findAllNotScheduled()) {
        System.out.println(t);
        }
        m1.addTache(t1);
        m1.addTache(t2);
        m2.addTache(t3);
        m2.addTache(t4);
        tacheManager.update(t1);
        tacheManager.update(t2);
        tacheManager.update(t3);
        tacheManager.update(t4);
        TacheDao tacheManager2 = JpaTacheDao.getIntstance();
        tacheManager2.create(t1);
        tacheManager.create(t1);
        System.out.println(tacheManager.findAll().size());
    }
}
