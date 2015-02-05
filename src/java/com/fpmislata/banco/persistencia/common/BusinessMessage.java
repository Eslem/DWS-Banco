package com.fpmislata.banco.persistencia.common;

import java.util.ArrayList;

public class BusinessMessage {

    private ArrayList<String[]> messages;

    public BusinessMessage() {
        messages = new ArrayList();
    }

    public BusinessMessage(String propertyName, String message) {
        this();
        addMessage(new String[]{propertyName, message});
    }

    /**
     * Set message list
     * @param list 
     */
    public final void setList(ArrayList<String[]> list) {
        messages = list;
    }

    /**
     * Get message list
     * @return 
     */
    public final ArrayList<String[]> getList() {
        return messages;
    }
    
    /**
     * Empty message list
     */
    public final void clearList() {        
        messages = new ArrayList();
    }
    
    /**
     * Add message to list
     * @param message
     */
    public final void addMessage(String[] message) {
        messages.add(message);        
    }
    
    /**
     * Add message to list
     * @param origin Origin of the exception
     * @param message 
     */
    public final void addMessage(String origin, String message) {
        messages.add(new String[] {origin, message});        
    }

    /**
     * Get message from list
     * @param index Message index
     * @return Message
     */
    public final String[] getMessage(int index) {
        return messages.get(index);
    }

    /**
     * Remove message from list
     * @param index Message index
     */
    public final void removeMessage(int index) {
        messages.remove(index);
    }
}
