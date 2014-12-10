/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day;

import java.util.Date;
import java.util.List;
import logitem.LogItem;

/**
 * A <b>Day</b> contains a list of <b>LogItems</b>.
 * @author root
 */
public interface Day {
    
    Date getDate();
    
    List<LogItem> getLogEntries();
    
    void addLogItem(LogItem logItem);
    
    void removeLogItem(int index);
    
    void updateLogItem(int index, LogItem logItem);
    
    LogItem getLogItem(int index);
    
    String toJson();
}
