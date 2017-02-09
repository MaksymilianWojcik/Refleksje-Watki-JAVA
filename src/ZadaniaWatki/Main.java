package ZadaniaWatki;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	Executor service;
	Random rand;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//2 thrady, wypiswanie losowej wiadomosci co 3 i 5 sekund
		
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Dzieñ dobry!");
        messages.add("Dobarnoc !");
        messages.add("Dowidzenia !");
        messages.add("Dobry wieczór !");
        messages.add("Siema !");
        messages.add("Narazie !");
 
        ExecutorService exec = Executors.newFixedThreadPool(2);
 
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
            for (int i = 0; i < messages.size(); i++){
                System.out.println("W¹tek 1:" + messages.get(i));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        };
 
        
        
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = (messages.size()) - 1 ; i >= 0; i--){
                    System.out.println("W¹tek 2:" + messages.get(i));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
 
            }
        };
 
        exec.execute(task1);
        exec.execute(task2);
        exec.shutdown();
 
    }
}
