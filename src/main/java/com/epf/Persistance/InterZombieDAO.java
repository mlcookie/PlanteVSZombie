package com.epf.Persistance;
import com.epf.Core.Zombies;

import java.util.List;

public interface InterZombieDAO {
    void ajouter(Zombies zombie);
    Zombies trouverParId(int id);
    List<Zombies> listerToutes();
    void mettreAJour(Zombies zombie);
    void supprimer(int id);
}
