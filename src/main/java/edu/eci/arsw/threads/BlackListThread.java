package edu.eci.arsw.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import  edu.eci.arsw.spamkeywordsdatasource.*;
import  edu.eci.arsw.blacklistvalidator.*;

public class BlackListThread extends Thread{
    private int lowServer;
    private int highServer;

    private String ipAddress;

    private List<Integer> blackListOcurrences;
    private int ocurrencesCount = 0;

    public BlackListThread(int low, int high, String ipAddress){
        this.lowServer = low;
        this.highServer = high;
        this.ipAddress = ipAddress;
        this.blackListOcurrences = new LinkedList<>();
    }

    public int getLowServer() {
        return lowServer;
    }

    public int getHighServer() {
        return highServer;
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

        for (int i=this.getLowServer();i<this.getHighServer();i++){

            if (skds.isInBlackListServer(i, this.getIpAddress())){

                blackListOcurrences.add(i);

            }
        }

        System.out.println("High " + this.getHighServer());
        System.out.println("Low " + this.getLowServer());
        System.out.println("Black List " + this.getBlackList());

    }
}
