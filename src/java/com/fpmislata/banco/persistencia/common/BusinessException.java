package com.fpmislata.banco.persistencia.common;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;

public class BusinessException extends Exception {

    private ArrayList<BusinessMessage> bussinessMessages = new ArrayList();

    public BusinessException(List<BusinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

    public BusinessException(BusinessMessage bussinessMessage) {
        this.bussinessMessages.add(bussinessMessage);
    }

    public BusinessException(Exception ex) {
        bussinessMessages.add(new BusinessMessage(null, ex.toString()));
    }

    public BusinessException(javax.validation.ConstraintViolationException cve) {
        for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
            String message = constraintViolation.getMessage();
            String fieldName = constraintViolation.getPropertyPath().toString();

            bussinessMessages.add(new BusinessMessage(fieldName, message));
        }
    }

    public BusinessException(org.hibernate.exception.ConstraintViolationException cve) {
        bussinessMessages.add(new BusinessMessage(null, cve.getLocalizedMessage()));
    }

    public List<BusinessMessage> getBusinessMessages() {
        return bussinessMessages;
    }
    
     public BusinessException(String fieldName, String message) {
        BusinessMessage bussinessMessage = new BusinessMessage(fieldName, message);
        this.bussinessMessages.add(bussinessMessage);
    }
}
