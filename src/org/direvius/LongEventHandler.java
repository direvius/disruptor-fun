package org.direvius;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent>
{
	private long startTime;
	private long value;
	public LongEventHandler(){
		this.startTime = System.currentTimeMillis();
	}
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
    	value = event.get();
    	if(value % 10000000 == 0){
    		System.out.println("Event: " + event);
    		System.out.println("Value: " + value);
    		long currentTime = System.currentTimeMillis();
    		System.out.println("RPS: " + (value / (currentTime - startTime) * 1000));
    	}
    }
}
