package com.gmail.erofeev.st.alexei.controlwork.service;

import com.gmail.erofeev.st.alexei.controlwork.service.model.BusinessCardDTO;

import java.util.List;

public interface BusinessCardService {

    List<BusinessCardDTO> getAllUserCard(Long userId);

    void deleteCardById(Long id);

    void saveCardToUser(BusinessCardDTO cardDTO, Long userId);
}
