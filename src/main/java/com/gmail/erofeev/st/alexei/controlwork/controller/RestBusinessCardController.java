package com.gmail.erofeev.st.alexei.controlwork.controller;

import com.gmail.erofeev.st.alexei.controlwork.controller.validator.RequestParamsValidator;
import com.gmail.erofeev.st.alexei.controlwork.service.BusinessCardService;
import com.gmail.erofeev.st.alexei.controlwork.service.model.BusinessCardDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gmail.erofeev.st.alexei.controlwork.config.GlobalConstant.SUCCESS_MESSAGE;

@RestController
public class RestBusinessCardController {
    private final BusinessCardService businessCardService;
    private final RequestParamsValidator requestParamsValidator;

    public RestBusinessCardController(BusinessCardService businessCardService, RequestParamsValidator requestParamsValidator) {
        this.businessCardService = businessCardService;
        this.requestParamsValidator = requestParamsValidator;
    }

    @GetMapping("/api/v1/public/users/{id}/cards")
    public List<BusinessCardDTO> getCards(@PathVariable String id) {
        Long validatedId = requestParamsValidator.validateLongRest(id);
        return businessCardService.getAllUserCard(validatedId);
    }

    @DeleteMapping("/api/v1/private/users/{userId}/cards/{cardId}")
    public String deleteCard(@PathVariable String userId,
                             @PathVariable String cardId) {
        requestParamsValidator.validateLongRest(userId);
        Long validatedCardId = requestParamsValidator.validateLongRest(cardId);
        businessCardService.deleteCardById(validatedCardId);
        return SUCCESS_MESSAGE;
    }

    @PostMapping("/api/v1/private/users/{id}/cards")
    public String addCards(@PathVariable String id, @RequestBody BusinessCardDTO cardDTO) {
        Long validatedId = requestParamsValidator.validateLongRest(id);
        requestParamsValidator.validateCard(cardDTO);
        businessCardService.saveCardToUser(cardDTO, validatedId);
        return SUCCESS_MESSAGE;
    }
}
