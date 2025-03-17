package com.epf.Persistance;

import com.epf.Core.Zombies;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombiesDAO implements InterZombieDAO {

    private final JdbcTemplate jdbcTemplate;

    public ZombiesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Zombies> zombieMapper = (rs, rowNum) -> {
        Zombies zombie = new Zombies(
                rs.getInt("id_zombie"),
                rs.getString("nom_zombie"),
                rs.getInt("point_de_vie_zombie"),
                rs.getDouble("attaque_par_seconde_zombie"),
                rs.getInt("degat_par_seconde"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
        );
        return zombie;
    };

    @Override
    public List<Zombies> getAllZombies() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, zombieMapper);
    }

    @Override
    public Zombies getZombieById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, zombieMapper, id);
    }

    @Override
    public void addZombie(Zombies zombie) {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNomZombie(), zombie.getPointDeVieZombie(), zombie.getAttaqueParSecondeZombie(), zombie.getDegatParSeconde(), zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getIdMap());
    }

    @Override
    public void updateZombie(Zombies zombie) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNomZombie(), zombie.getPointDeVieZombie(), zombie.getAttaqueParSecondeZombie(), zombie.getDegatParSeconde(), zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getIdMap(), zombie.getIdZombie());
    }

    @Override
    public void deleteZombie(int id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombies> getZombiesByMapId(int mapId) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, zombieMapper, mapId);
    }
}
