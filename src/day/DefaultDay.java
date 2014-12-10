/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logitem.LogItem;

/**
 *
 * @author root
 */
public class DefaultDay implements Day{
    
    private List<LogItem> logEntries = new ArrayList<>();
    
    private final Date date;
    
    public DefaultDay(){
        date = new Date(System.currentTimeMillis());
    }
    
    public DefaultDay(Date date){
        this.date = date;
    }

    @Override
    public List<LogItem> getLogEntries() {
        return logEntries;
    }

    @Override
    public Date getDate() {
        return date;
    }
    
}