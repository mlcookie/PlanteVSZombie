package com.epf.API;

import com.epf.Core.Zombies;
import com.epf.API.ZombieDTO;
import com.epf.Core.Service.ZombieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping
    public ResponseEntity<List<ZombieDTO>> getAllZombies() {
        List<ZombieDTO> zombies = zombieService.getAllZombies()
                .stream()
                .map(ZombieDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getZombieById(@PathVariable("id") int id) {
        Zombies zombie = zombieService.getZombieById(id);
        return ResponseEntity.ok(new ZombieDTO(zombie));
    }

    @PostMapping
    public ResponseEntity<Void> addZombie(@RequestBody ZombieDTO zombieDTO) {
        zombieService.addZombie(zombieDTO.toEntity());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        Zombies zombie = zombieDTO.toEntity();
        zombie.setIdZombie(id);
        zombieService.updateZombie(zombie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable("id") int id) {
        zombieService.deleteZombie(id);
        return ResponseEntity.ok().build();
    }
}
