package com.epf.Core.Service;

import com.epf.Core.Plante;
import com.epf.Persistance.InterPlanteDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService implements InterPlanteService {

    private final InterPlanteDAO planteDAO;

    public PlanteService(InterPlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public List<Plante> getAllPlantes() {
        return planteDAO.getAllPlantes();
    }

    @Override
    public Plante getPlanteById(int id) {
        return planteDAO.getPlanteById(id);
    }

    @Override
    public void addPlante(Plante plante) {
        planteDAO.addPlante(plante);
    }

    @Override
    public void updatePlante(Plante plante) {
        planteDAO.updatePlante(plante);
    }

    @Override
    public void deletePlante(int id) {
        planteDAO.deletePlante(id);
    }
}

