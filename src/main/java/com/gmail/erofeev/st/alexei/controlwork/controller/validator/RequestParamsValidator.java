package com.gmail.erofeev.st.alexei.controlwork.controller.validator;

import com.gmail.erofeev.st.alexei.controlwork.controller.exception.IllegalRestRequestParameterException;
import com.gmail.erofeev.st.alexei.controlwork.service.model.BusinessCardDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestParamsValidator {
    private static final Logger logger = LoggerFactory.getLogger(RequestParamsValidator.class);
    private static final String ERROR_MESSAGE = "wrong parameter. Can not parse %s to number ";


    public int validateIntRest(String param) {
        try {
            return defaultValidateInt(param);
        } catch (NumberFormatException e) {
            String message = String.format(ERROR_MESSAGE, param);
            logger.error(message, e);
            throw new IllegalRestRequestParameterException(message + e.getMessage(), e);
        }
    }

    public Long validateLongRest(String param) {
        try {
            return defaultValidateLong(param);
        } catch (NumberFormatException e) {
            String message = String.format(ERROR_MESSAGE, param);
            logger.error(message, e);
            throw new IllegalRestRequestParameterException(message + e.getMessage(), e);
        }
    }

    public void validateCard(BusinessCardDTO card) {
        List<String> errors = new ArrayList<>();
        String title = card.getTitle();
        if (title == null || "".equals(title)) {
            errors.add("title must be not null");
        }
        String workingTelephone = card.getWorkingTelephone();
        if (workingTelephone == null || "".equals(workingTelephone)) {
            errors.add("workingTelephone must be not null");
        } else if (workingTelephone.length() > 20) {
            errors.add("workingTelephone must be less than 20");
        }
        if (!errors.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (String error : errors) {
                message.append(error).append("; ");
            }
            throw new IllegalRestRequestParameterException(message.toString());
        }
    }

    private Long defaultValidateLong(String param) throws NumberFormatException {
        Long longParameter;
        longParameter = Long.parseLong(param);
        if (longParameter < 0) {
            throw new NumberFormatException();
        }
        return longParameter;
    }

    private Integer defaultValidateInt(String param) throws NumberFormatException {
        int intParameter;
        intParameter = Integer.parseInt(param);
        if (intParameter < 0) {
            throw new NumberFormatException();
        }
        return intParameter;
    }
}
