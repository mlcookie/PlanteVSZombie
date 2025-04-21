package com.epf.API;

import com.epf.Core.Plante;
import com.epf.API.PlanteDTO;
import com.epf.Core.Service.PlanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @GetMapping
    public ResponseEntity<List<PlanteDTO>> getAllPlantes() {
        List<PlanteDTO> plantes = planteService.getAllPlantes()
                .stream()
                .map(PlanteDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanteDTO> getPlanteById(@PathVariable int id) {
        Plante plante = planteService.getPlanteById(id);
        return ResponseEntity.ok(new PlanteDTO(plante));
    }

    @PostMapping
    public ResponseEntity<Void> addPlante(@RequestBody PlanteDTO planteDTO) {
        planteService.addPlante(planteDTO.toEntity());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlante(@PathVariable int id, @RequestBody PlanteDTO planteDTO) {
        Plante plante = planteDTO.toEntity();
        plante.setId(id);
        planteService.updatePlante(plante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlante(@PathVariable int id) {
        planteService.deletePlante(id);
        return ResponseEntity.ok().build();
    }
}
