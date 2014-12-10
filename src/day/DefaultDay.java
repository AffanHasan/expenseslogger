/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day;

import com.sun.istack.internal.logging.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import logitem.LogItem;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author root
 */
public class DefaultDay implements Day{
    
    private final List<LogItem> logEntries = new ArrayList<>();
    

    
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

    @Override
    public void addLogItem(LogItem logItem) {
        try{
            this.logEntries.add(logItem);
        }catch(NullPointerException e){
            Logger.getLogger(DefaultDay.class).log(Level.INFO, e.getMessage());
        }
    }

    @Override
    public void removeLogItem(int index) {
        try{
            this.logEntries.remove(index);
        }catch(NullPointerException e){
            Logger.getLogger(DefaultDay.class).log(Level.INFO, e.getMessage());
        }
    }

    @Override
    public void updateLogItem(int index, LogItem logItem) throws IndexOutOfBoundsException {
        try{
            LogItem set = this.logEntries.set(index, logItem);
        }catch(NullPointerException e){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public LogItem getLogItem(int index) throws IndexOutOfBoundsException {
        try{
            return this.logEntries.get(index);
        }catch(NullPointerException e){
            Logger.getLogger(DefaultDay.class).log(Level.INFO, e.getMessage());
            return null;
        }catch(IndexOutOfBoundsException e){
            Logger.getLogger(DefaultDay.class).log(Level.INFO, e.getMessage());
            throw new IndexOutOfBoundsException();
        }
    }
}