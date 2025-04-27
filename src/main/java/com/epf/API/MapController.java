package com.epf.API;

import com.epf.Core.Map;
import com.epf.Core.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
public class MapController {

    private static final Logger logger = LoggerFactory.getLogger(MapController.class);
    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping
    public ResponseEntity<List<MapDTO>> getAllMaps() {
        List<MapDTO> maps = mapService.getAllMaps()
                .stream()
                .map(MapDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(maps);
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-connexion")
    public String testConnexion() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "Connexion réussie à la base de données! Résultat : " + result;
        } catch (Exception e) {
            return "Échec de la connexion : " + e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getMapById(@PathVariable("id") int id) {
        Map map = mapService.getMapById(id);
        if (map == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new MapDTO(map));
    }

    @PostMapping
    public ResponseEntity<Void> addMap(@RequestBody MapDTO mapDTO) {
        mapService.addMap(mapDTO.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMap(@PathVariable("id") int id, @RequestBody MapDTO mapDTO) {
        Map map = mapDTO.toEntity();
        map.setId(id);
        mapService.updateMap(map);
        logger.info("Map with id {} updated successfully", id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable("id") int id) {
        mapService.deleteMap(id);
        logger.info("Map with id {} deleted successfully", id);
        return ResponseEntity.ok().build();
    }
}
