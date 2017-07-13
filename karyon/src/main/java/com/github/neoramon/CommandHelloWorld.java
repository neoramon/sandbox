package com.github.neoramon;

import java.util.Random;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandHelloWorld extends HystrixCommand<String> {

  private final String name;
  
  public CommandHelloWorld(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("HystrixGroup"), 100);
    this.name = name;
    
  }

  @Override
  protected String run() {
    Random r = new Random();
    if (System.currentTimeMillis() % 3 == 0) {
      try {        
        int randomInt = r.nextInt(5000) + 1;
        Thread.sleep(randomInt);
      } catch(InterruptedException e) {
        // np
      }
           
      throw new RuntimeException("Ops....");      
    }
    
    return "Hello " + name + "!";
  }
  
  @Override
  protected String getFallback() {
    return "Hello... What is your name?";
  }
}
