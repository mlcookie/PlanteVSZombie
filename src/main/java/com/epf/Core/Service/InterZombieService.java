package com.epf.Core.Service;

import com.epf.Core.Zombies;
import java.util.List;

public interface InterZombieService {
    List<Zombies> getAllZombies();
    Zombies getZombieById(int id);
    void addZombie(Zombies zombie);
    void updateZombie(Zombies zombie);
    void deleteZombie(int id);
    List<Zombies> getZombiesByMapId(int mapId);
}
