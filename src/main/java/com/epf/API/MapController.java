package com.epf.API;


import com.epf.Core.Map;
import com.epf.API.MapDTO;
import com.epf.Core.Service.MapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
public class MapController {

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

    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getMapById(@PathVariable int id) {
        Map map = mapService.getMapById(id);
        return ResponseEntity.ok(new MapDTO(map));
    }

    @PostMapping
    public ResponseEntity<Void> addMap(@RequestBody MapDTO mapDTO) {
        mapService.addMap(mapDTO.toEntity());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMap(@PathVariable int id, @RequestBody MapDTO mapDTO) {
        Map map = mapDTO.toEntity();
        map.setId(id);
        mapService.updateMap(map);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable int id) {
        mapService.deleteMap(id);
        return ResponseEntity.ok().build();
    }
}
