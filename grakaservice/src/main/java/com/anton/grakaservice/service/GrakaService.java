package com.anton.grakaservice.service;


import com.anton.grakaservice.exception.IncompleteGrakaException;
import com.anton.grakaservice.exception.ResourceNotFoundException;
import com.anton.grakaservice.repository.GrakaRepository;
import com.anton.grakaservice.repository.model.Graka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrakaService {

    @Autowired
    private GrakaRepository grakaRepository;

    private static final Logger logger = LoggerFactory.getLogger(GrakaService.class);

    /**
     *
     * @param graka = das Grafikkartenobjekt
     * @return Id der eben erstellten Grafikkarte
     * @throws IncompleteGrakaException
     */
    public Long addGraphicCard(Graka graka) throws IncompleteGrakaException {

        if (graka.getName().equals("")) {
            logger.error("IncompleteGrakaException: Name is empty!");
            throw new IncompleteGrakaException("Name is empty!");
        } else {
            this.grakaRepository.save(graka);
            logGraka("addGraphicCard", graka);
            return graka.getId();
        }
    }

    /**
     *
     * @return Liste mit allen Grafikkarten in der Datenbank
     */
    public List<Graka> getAllGraphicCards() {
        List<Graka> listOfGrakas = this.grakaRepository.findAll();
        logger.debug("listOfGrakas will be returned! size of list: " + listOfGrakas.size());

        return listOfGrakas;
    }

    /**
     *
     * @param id = Id der gesuchten Grafikkarte
     * @return Grafikkarte mit der gesuchten Id
     * @throws ResourceNotFoundException = Gesuchte Id ist keiner Grafikkarte zugewiesen
     */
    public Graka getGraphicCardById(Long id) throws ResourceNotFoundException {
        Optional<Graka> optionalGraka = this.grakaRepository.findById(id);

        if (!optionalGraka.isEmpty()) {
            Graka grakaToReturn = optionalGraka.get();
            logGraka("getGraphicCardById", grakaToReturn);

            return grakaToReturn;
        } else {
            logger.error("ResourceNotFoundException: No Graphiccard was found!");
            throw new ResourceNotFoundException("No Graphiccard was found!");
        }

    }

    /**
     *
     * @param message = Identifier um Log in der Ausgabe zu erkennen
     * @param grakaToLog = Grafikkarte die geloggt werden soll bzw. dessen Attribute
     */
    public void logGraka(String message, Graka grakaToLog) {
        logger.debug(message);
        logger.debug("GrakaToReturn Id: " + grakaToLog.getId());
        logger.debug("GrakaToReturn Name: " + grakaToLog.getName());
        logger.debug("GrakaToReturn Preis: " + grakaToLog.getPreis());
        logger.debug("GrakaToReturn Manufacturer: " + grakaToLog.getManufacturer());
    }
}
