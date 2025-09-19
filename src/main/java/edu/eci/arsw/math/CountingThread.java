package edu.eci.arsw.math;

import java.util.concurrent.CopyOnWriteArrayList;

public class CountingThread extends Thread{

    public boolean paused = false;

    public int start = 1;

    public int count = 1000000;

    public int numThreads = 5;

    public CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    @Override
    public void run(){
        while(true){


            int interval = count / numThreads;
            if(interval > count){
                break;
            }

            byte[] digits = new byte[count];
            for(int i = 0; i < numThreads; i++) {
                try{
                list.add(i, PiDigits.getDigits(start, interval, numThreads));

                this.join();
                }
                catch(InterruptedException e){
                    e.getMessage();
                }
                start = interval + 1;
                interval += interval;


            }

            for(int i = 0; i < list.size(); i++){
                digits[i] = (byte) list.get(i);
            }

            System.out.printf("%d", list.size());

        }
    }

}

