/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;
/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){

        Thread countThread1 = new CountThread(0,99);
        Thread countThread2 = new CountThread(99,199);
        Thread countThread3 = new CountThread(200,299);

        countThread1.start();
        countThread2.start();
        countThread3.start();

        countThread1.run();
        countThread2.run();
        countThread3.run();
    }
    
}
