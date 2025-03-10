package com.epf.Persistance;
import com.epf.Core.Plante;

import java.util.List;

public interface InterPlanteDAO {
    void ajouter(Plante plante);
    Plante trouverParId(int id);
    List<Plante> listerToutes();
    void mettreAJour(Plante plante);
    void supprimer(int id);
}
