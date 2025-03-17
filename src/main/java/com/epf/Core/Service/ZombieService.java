package com.epf.Core.Service;
import com.epf.Core.Zombies;
import com.epf.Persistance.InterZombieDAO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZombieService implements InterZombieService {

    private final InterZombieDAO zombieDAO;

    public ZombieService(InterZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public List<Zombies> getAllZombies() {
        return zombieDAO.getAllZombies();
    }

    @Override
    public Zombies getZombieById(int id) {
        return zombieDAO.getZombieById(id);
    }

    @Override
    public void addZombie(Zombies zombie) {
        zombieDAO.addZombie(zombie);
    }

    @Override
    public void updateZombie(Zombies zombie) {
        zombieDAO.updateZombie(zombie);
    }

    @Override
    public void deleteZombie(int id) {
        zombieDAO.deleteZombie(id);
    }

    @Override
    public List<Zombies> getZombiesByMapId(int mapId) {
        return zombieDAO.getZombiesByMapId(mapId);
    }
}
