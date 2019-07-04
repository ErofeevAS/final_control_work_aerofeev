package com.gmail.erofeev.st.alexei.controlwork.service.converter.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.model.BusinessCard;
import com.gmail.erofeev.st.alexei.controlwork.service.converter.BusinessCardConverter;
import com.gmail.erofeev.st.alexei.controlwork.service.model.BusinessCardDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusinessCardConverterImpl implements BusinessCardConverter {
    @Override
    public BusinessCardDTO toDTO(BusinessCard card) {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        businessCardDTO.setId(card.getId());
        businessCardDTO.setFullName(card.getFullName());
        businessCardDTO.setTitle(card.getTitle());
        businessCardDTO.setWorkingTelephone(card.getWorkingTelephone());
        return businessCardDTO;
    }

    @Override
    public BusinessCard fromDTO(BusinessCardDTO cardDTO) {
        BusinessCard card = new BusinessCard();
        card.setId(cardDTO.getId());
        card.setFullName(cardDTO.getFullName());
        card.setTitle(cardDTO.getTitle());
        card.setWorkingTelephone(cardDTO.getWorkingTelephone());
        return card;
    }

    @Override
    public List<BusinessCardDTO> toListDTO(List<BusinessCard> cards) {
        return cards.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
