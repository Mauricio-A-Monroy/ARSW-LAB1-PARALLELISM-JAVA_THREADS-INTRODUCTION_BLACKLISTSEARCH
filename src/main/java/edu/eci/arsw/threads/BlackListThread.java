package edu.eci.arsw.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import  edu.eci.arsw.spamkeywordsdatasource.*;
import  edu.eci.arsw.blacklistvalidator.*;

public class BlackListThread extends Thread{

    private int lowServer;
    private int highServer;
    private int checkedListsCount;

    private String ipAddress;

    private List<Integer> blackListOcurrences;

    public BlackListThread(int low, int high, String ipAddress){
        this.lowServer = low;
        this.highServer = high;
        this.ipAddress = ipAddress;
        this.blackListOcurrences = new ArrayList<>();
        this.checkedListsCount = 0;
    }

    public int getLowServer() {
        return lowServer;
    }

    public int getHighServer() {
        return highServer;
    }

    public int getCheckedListsCount(){
        return checkedListsCount;
    }

    public int getOcurrencesCount(){
        return blackListOcurrences.size();
    }

    public List<Integer> getBlackList(){
        return blackListOcurrences;
    }

    public String getIpAddress(){
        return ipAddress;
    }

    public void run(){

        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        for (int i = this.getLowServer(); i <= this.getHighServer(); i++){
            this.checkedListsCount++;
            if (skds.isInBlackListServer(i, this.getIpAddress())){
                blackListOcurrences.add(i);
            }
        }

        /**
         System.out.println("Low: " + this.lowServer);
        System.out.println("High: " + this.highServer);
        System.out.println("Ocurrences Count: " + this.blackListOcurrences);
        System.out.println("Checked Lists: " + this.checkedListsCount);
        System.out.println("Black Lists: " + this.blackListOcurrences);
         **/

    }
}
