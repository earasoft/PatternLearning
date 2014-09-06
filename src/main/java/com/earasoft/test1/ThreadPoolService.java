package com.earasoft.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolService {
	private int processors = Runtime.getRuntime().availableProcessors();
	private int  corePoolSize  =    processors;
	private int  maxPoolSize   =   processors;
	private long keepAliveTime = 5000;
	private ExecutorService executorService;
	
	public ThreadPoolService(){
		this.executorService = new ThreadPoolExecutor(corePoolSize, 
				maxPoolSize,
				keepAliveTime,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}
	
	
	public void shutdown(boolean wait){
		this.shutdown();
		if(wait == true){
			 while (!executorService.isTerminated()) {
		     }
		     System.out.println("Finished all threads");
		}
	}
	
	public void shutdown(){
		this.executorService.shutdown();
       
	}
	
	public void execute(Runnable runnable){
		this.executorService.execute(runnable);
	}
	
	public static void main(String[] args) {
		ThreadPoolService test = new ThreadPoolService();
		
		for(int i = 0 ; i<=100; i++){
			test.execute(new Runnable() {
			    public void run() {
			    	System.out.println(Thread.currentThread().getName());
			        System.out.println("Asynchronous task-Start");
			        
			        for(long a = 0 ; a<=1000000000; a++){
				        for(long b = 0 ; b<=1000000000; b++){
				        	
				        }
			        }
			    	System.out.println("Asynchronous task-End");
			    }
			});
		}

		test.shutdown();
	}
}
