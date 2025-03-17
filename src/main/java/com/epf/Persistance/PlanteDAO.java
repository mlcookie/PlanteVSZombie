package com.epf.Persistance;

import com.epf.Core.Plante;
import com.epf.Core.Plante.Effet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteDAO implements InterPlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Plante> planteMapper = (rs, rowNum) -> {
        Plante plante = new Plante();
        plante.setId(rs.getInt("id_plante"));
        plante.setNom(rs.getString("nom"));
        plante.setPointDeVie(rs.getInt("point_de_vie"));
        plante.setAttaqueParSeconde(rs.getDouble("attaque_par_seconde"));
        plante.setDegatAttaque(rs.getInt("degat_attaque"));
        plante.setCout(rs.getInt("cout"));
        plante.setSoleilParSeconde(rs.getDouble("soleil_par_seconde"));

        String effetStr = rs.getString("effet");
        plante.setEffet(Effet.valueOf(effetStr.toUpperCase().replace(" ", "_")));

        plante.setCheminImage(rs.getString("chemin_image"));
        return plante;
    };

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, planteMapper);
    }

    @Override
    public Plante getPlanteById(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, planteMapper, id);
    }

    @Override
    public void addPlante(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet().toString(), plante.getCheminImage());
    }

    @Override
    public void updatePlante(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet().toString(), plante.getCheminImage(), plante.getId());
    }

    @Override
    public void deletePlante(int id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
