package com.gmail.erofeev.st.alexei.controlwork.service.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.BusinessCardRepository;
import com.gmail.erofeev.st.alexei.controlwork.repository.UserRepository;
import com.gmail.erofeev.st.alexei.controlwork.repository.model.BusinessCard;
import com.gmail.erofeev.st.alexei.controlwork.repository.model.User;
import com.gmail.erofeev.st.alexei.controlwork.service.BusinessCardService;
import com.gmail.erofeev.st.alexei.controlwork.service.converter.BusinessCardConverter;
import com.gmail.erofeev.st.alexei.controlwork.service.model.BusinessCardDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusinessCardServiceImpl implements BusinessCardService {
    private final UserRepository userRepository;
    private final BusinessCardRepository businessCardRepository;
    private final BusinessCardConverter businessCardConverter;

    public BusinessCardServiceImpl(UserRepository userRepository,
                                   BusinessCardRepository businessCardRepository,
                                   BusinessCardConverter businessCardConverter) {
        this.userRepository = userRepository;
        this.businessCardRepository = businessCardRepository;
        this.businessCardConverter = businessCardConverter;
    }

    @Override
    @Transactional
    public List<BusinessCardDTO> getAllUserCard(Long userId) {
        User user = userRepository.findById(userId);
        List<BusinessCard> cards = user.getCards();
        return businessCardConverter.toListDTO(cards);
    }

    @Override
    @Transactional
    public void deleteCardById(Long id) {
        BusinessCard card = businessCardRepository.findById(id);
        businessCardRepository.remove(card);
    }

    @Override
    @Transactional
    public void saveCardToUser(BusinessCardDTO cardDTO, Long userId) {
        User user = userRepository.findById(userId);
        BusinessCard card = businessCardConverter.fromDTO(cardDTO);
        card.setUser(user);
        businessCardRepository.persist(card);
    }
}
