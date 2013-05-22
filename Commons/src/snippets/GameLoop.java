package snippets;

import math.MathService;

/**
 * Example implementation of Game loop
 * 
 * @author rafcio
 * 
 */
public class GameLoop extends Loop {

   double time = 0.0;
   private final static int SIMULATION_TIME = 10;// seconds
   int updateCounter = 0;
   int renderCounter = 0;

   @Override
   public void startup() {
      System.out.println("Hello, this game loop will run for " + SIMULATION_TIME + " seconds");
      try {
         Thread.sleep(1000);
         System.out.println("3...");
         Thread.sleep(750);
         System.out.println("2...");
         Thread.sleep(750);
         System.out.println("1...");
         Thread.sleep(750);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

   }

   @Override
   public void shutdown() {
      System.out.println("Loop have been stopped");
      System.out.println("Frame rate: " + renderCounter / SIMULATION_TIME + " (fps)");
      System.out.println("Update rate: " + updateCounter / SIMULATION_TIME);
   }

   @Override
   public void update() {
      time += 0.01;
      updateCounter++;
      if (time > SIMULATION_TIME) {
         stop();
      }
   }

   @Override
   public void draw() {
      System.out.println("Seconds: " + MathService.round(time, 2));
      try {
         Thread.sleep(12);// simulate time delay spent on rendering process
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      renderCounter++;

   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      GameLoop gameLoop = new GameLoop();
      gameLoop.run(0.01);

   }

}
