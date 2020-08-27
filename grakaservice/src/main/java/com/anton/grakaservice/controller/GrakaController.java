package com.anton.grakaservice.controller;

import com.anton.grakaservice.exception.IncompleteGrakaException;
import com.anton.grakaservice.exception.ResourceNotFoundException;
import com.anton.grakaservice.repository.GrakaRepository;
import com.anton.grakaservice.repository.model.Graka;
import com.anton.grakaservice.service.GrakaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class GrakaController {

    @Autowired
    private GrakaService grakaService;

    /**
     *
     * @return Liste mit allen Grafikkarten
     */
    @GetMapping("graka")
    public List<Graka> getAllGraphicCards() {
            return this.grakaService.getAllGraphicCards();
    }

    /**
     *
     * @param grakaId = Id der gesuchten Grafikkarte
     * @return Grafikkarte mit der gesuchten Id
     * @throws ResourceNotFoundException = Gesuchte Id ist keiner Grafikkarte zugewiesen
     */
    @GetMapping("graka/{id}")
    public ResponseEntity<Graka> getGraphicCardById(@PathVariable(value = "id") Long grakaId) throws ResourceNotFoundException {
            Graka grakaToReturn = this.grakaService.getGraphicCardById(grakaId);
            return ResponseEntity.ok().body(grakaToReturn);
    }

    /**
     *
     * @param graka = Grafikkarte, die hinzugefügt werden soll
     * @return = Die eben erstellte Grafikkarte
     * @throws IncompleteGrakaException = Attribute sind nicht vollständig
     */
    @PostMapping("graka")
    public Long addGraphicCard(@RequestBody Graka graka) throws IncompleteGrakaException {
        return this.grakaService.addGraphicCard(graka);
    }


}
