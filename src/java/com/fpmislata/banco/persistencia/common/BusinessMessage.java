package com.fpmislata.banco.persistencia.common;

import java.util.ArrayList;

public class BusinessMessage {

    private ArrayList<String[]> messages;

    public BusinessMessage() {
        messages = new ArrayList();
    }

    public BusinessMessage(String propertyName, String message) {
        this();
        messages.add(new String[]{propertyName, message});
    }

    public void setList(ArrayList<String[]> list) {
        messages = list;
    }

    public ArrayList<String[]> getList() {
        return messages;
    }

    public String getPropertyName(int index) {
        return messages.get(index)[0];
    }

    public void setPropertyName(int index, String propertyName) {
        messages.get(index)[0] = propertyName;
    }

    public String getMessage(int index) {
        return messages.get(index)[1];
    }

    public void setMessage(int index, String message) {
        messages.get(index)[1] = message;
    }
}
