package com.gmail.erofeev.st.alexei.controlwork.repository.impl;

import com.gmail.erofeev.st.alexei.controlwork.repository.BusinessCardRepository;
import com.gmail.erofeev.st.alexei.controlwork.repository.model.BusinessCard;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessCardRepositoryImpl extends GenericRepositoryImpl<Long, BusinessCard> implements BusinessCardRepository {
}
