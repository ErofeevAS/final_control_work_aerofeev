package com.gmail.erofeev.st.alexei.controlwork.service.converter;

import com.gmail.erofeev.st.alexei.controlwork.repository.model.BusinessCard;
import com.gmail.erofeev.st.alexei.controlwork.service.model.BusinessCardDTO;

import java.util.List;

public interface BusinessCardConverter {
    BusinessCardDTO toDTO(BusinessCard card);

    BusinessCard fromDTO(BusinessCardDTO cardDTO);

    List<BusinessCardDTO> toListDTO(List<BusinessCard> cards);
}
