package lekcja15sroda07grud;

import java.security.Provider.Service;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
	Executor service;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

	public Main(){
		service = Executors.newFixedThreadPool(2);
		
		Runnable komenda = new Runnable(){
			public void run(){
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
				for(int i =0; i<500;i++){
					System.out.println("Zadanie 0: " +i);
					//Thread.yield();
				}
			}
			
		};
		
		
		Runnable komenda1 = new Runnable(){
			public void run(){
				Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
				for(int i =0; i<500;i++){
					System.out.println("Zadanie 1: " +i);
					//Thread.yield();
				}
			}
		};
		
		
	}
}
