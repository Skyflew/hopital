/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.util.Date;
import metier.Atelier;
import metier.Machine;
import metier.Tache;

/**
 *
 * @author Thomas
 */
public class Test {
    public static void main(String[] args) {
        Atelier a = new Atelier();
        Machine m1 = new Machine();
        Machine m2 = new Machine();
        long timeMillis = System.currentTimeMillis();
        Tache t1 = new Tache(45, new Date(timeMillis+60000*120), 5.0);
        Tache t2 = new Tache(120, new Date(timeMillis+60000*150), 10.0);
        Tache t3 = new Tache(70, new Date(timeMillis+60000*180), 4.0);
        Tache t4 = new Tache(60, new Date(timeMillis+60000*300), 12.0);
        a.addMachine(m1);
        a.addMachine(m2);
        m1.addTache(t1);
        m1.addTache(t2);
        m2.addTache(t3);
        m2.addTache(t4);
        // Afficher l’atelier avec ses machines et les taches sur les machines
        // Verifier dates de début des taches
        // Verifier dates de disponibilité des machines
        // Verifier pénalité totale des machines
        System.out.println(a);
    }
    
}
