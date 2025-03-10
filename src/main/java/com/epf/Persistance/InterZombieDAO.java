package com.epf.Persistance;
import com.epf.Core.Zombies;

import java.util.List;

public interface InterZombieDAO {
    List<Zombies> getAllZombies();
    Zombies getZombieById(int id);
    void addZombie(Zombies zombie);
    void updateZombie(Zombies zombie);
    void deleteZombie(int id);
    List<Zombies> getZombiesByMapId(int mapId);
}
