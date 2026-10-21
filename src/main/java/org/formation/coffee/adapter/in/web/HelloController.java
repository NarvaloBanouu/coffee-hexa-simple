package org.formation.coffee.adapter.in.web;

import org.formation.coffee.domain.exception.DomainValidationException;
import org.formation.coffee.domain.model.Coffee;
import org.formation.coffee.domain.model.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller temporaire pour vérifier que l'application démarre. À supprimer à l'étape 7.
 */
@RestController
class HelloController {

    @GetMapping("/hello")
    String hello(@RequestParam(defaultValue = "Espresso") String name,
                 @RequestParam(defaultValue = "3") int price) {
        try {
            return Coffee.create(name, new Price(price)).toString();
        } catch (DomainValidationException e) {
            return "Erreur métier : " + e.getMessage();
        }
    }
}
