package com.epf.Persistance;
import com.epf.Core.Plante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanteDAO implements InterPlanteDAO {
    private Connection connection;

    public PlanteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouter(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, plante.getNom());
            stmt.setInt(2, plante.getPointDeVie());
            stmt.setDouble(3, plante.getAttaqueParSeconde());
            stmt.setInt(4, plante.getDegatAttaque());
            stmt.setInt(5, plante.getCout());
            stmt.setDouble(6, plante.getSoleilParSeconde());
            stmt.setString(7, plante.getEffet().toString());
            stmt.setString(8, plante.getCheminImage());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    plante.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plante trouverParId(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Plante(
                            rs.getString("nom"),
                            rs.getInt("point_de_vie"),
                            rs.getDouble("attaque_par_seconde"),
                            rs.getInt("degat_attaque"),
                            rs.getInt("cout"),
                            rs.getDouble("soleil_par_seconde"),
                            Plante.Effet.valueOf(rs.getString("effet").toUpperCase().replace(" ", "_")),
                            rs.getString("chemin_image")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Plante> listerToutes() {
        List<Plante> plantes = new ArrayList<>();
        String sql = "SELECT * FROM Plante";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                plantes.add(new Plante(
                        rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("cout"),
                        rs.getDouble("soleil_par_seconde"),
                        Plante.Effet.valueOf(rs.getString("effet").toUpperCase().replace(" ", "_")),
                        rs.getString("chemin_image")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plantes;
    }

    @Override
    public void mettreAJour(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plante.getNom());
            stmt.setInt(2, plante.getPointDeVie());
            stmt.setDouble(3, plante.getAttaqueParSeconde());
            stmt.setInt(4, plante.getDegatAttaque());
            stmt.setInt(5, plante.getCout());
            stmt.setDouble(6, plante.getSoleilParSeconde());
            stmt.setString(7, plante.getEffet().toString());
            stmt.setString(8, plante.getCheminImage());
            stmt.setInt(9, plante.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(int id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
