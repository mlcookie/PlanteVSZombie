package com.epf.Persistance;

import com.epf.Core.Map;
import com.epf.Persistance.InterMapDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapDAO implements InterMapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Map> mapMapper = (rs, rowNum) -> {
        Map map = new Map();
        map.setId(rs.getInt("id_map"));
        map.setLigne(rs.getInt("ligne"));
        map.setColonne(rs.getInt("colonne"));
        map.setCheminImage(rs.getString("chemin_image"));
        return map;
    };

    @Override
    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, mapMapper);
    }

    @Override
    public Map getMapById(int id) {
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, mapMapper, id);
    }

    @Override
    public void addMap(Map map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    @Override
    public void updateMap(Map map) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getId());
    }

    @Override
    public void deleteMap(int id) {
        String deleteZombiesSql = "DELETE FROM Zombie WHERE id_map = ?";
        jdbcTemplate.update(deleteZombiesSql, id);

        String deleteMapSql = "DELETE FROM Map WHERE id_map = ?";
        jdbcTemplate.update(deleteMapSql, id);
    }

}
