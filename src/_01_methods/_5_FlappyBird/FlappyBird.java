package _01_methods._5_FlappyBird;

import java.util.Random;

import com.apple.eawt.AppEvent.SystemSleepEvent;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    	boolean hasGameStarted = false;
    	double gravity = 1.5;
    	int yVel = 0;
    	int xVel = 5;
    	double bXVel = 0.3;
        double birdX = 50;
        int birdY = 300;
        int pipeY = 0;
        int pipeX = 0;
        int pipeHeight = 0;
        int bottomHeight = 0;
        int pipeSpace = 500;
        boolean isPipeDone = true;
        int score = 0;
        int highScore = 0;
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        size(800,600);
    }

    @Override
    public void draw() {
    	Random ran = new Random();
     
    	background(100,200,255);
        fill(255,255,0);
        stroke(0,0,0);
        
        if(!hasGameStarted) {
        	 score = 0;
        	 gravity = 1.5;
        	 yVel = 0;
        	 xVel = 5;
        	 bXVel = 0.3;
             birdX = 50;
             birdY = 200;
             pipeY = 0;
             pipeX = 0;
             pipeHeight = 0;
             bottomHeight = 0;
             //Lower number, more space, 200 default
             pipeSpace = 200;
             isPipeDone = true;
        	textSize(50);
        	text("FLAPPY BIRD!",250,100);
        	fill(0,0,0);
        	textSize(25);
        	
        	
        	text("Press any key to start.", 250,200);
        	if(keyPressed) {
        		hasGameStarted=true;
        	}
        }
        else {
        //scorekeeping
        	fill(0,0,0);
        	textSize(30);
        	text(score,400,100);
        	textSize(20);
        	text("Record: "+highScore,360,140);
        	if(score>highScore) {
        		highScore=score;
        	}
        	
        	fill(255,255,0);
        //control the flapping
        
        birdY -= yVel;
       birdX += bXVel;
        if(yVel>-25) {
        	yVel-=gravity;
        }
        if(yVel<-25) {
        	yVel = -25;
        }
         if(birdX>815) {
        	birdX = -15;
        }
        
        if(mousePressed) {
        	yVel = 11;

        	
        }
        else {
        	birdY+=3;
        }
        ellipse((float) birdX,birdY,30,30);
        
        //control the pipes
        fill(0,140,0);
      
        if(isPipeDone) {
        	isPipeDone=false;
        	pipeX = 770;
        pipeHeight = ran.nextInt(426);
        bottomHeight = 225+pipeSpace-pipeHeight;
        } 
        //top pipe
        rect(pipeX,0,30,pipeHeight);
        //bottom pipe
        rect(pipeX,600-bottomHeight,30,bottomHeight);
        pipeX-=xVel;
        if(pipeX<-30) {
        	if(!isPipeDone) {
        		score+=1;
        	}
        	isPipeDone=true;
        	
        }
        if(birdY<20) {
        	birdY = 20;
        }
        if(birdY>815) {
        	hasGameStarted=false;
        }
        if(birdX+30-pipeX>30) {
        	if(birdY<600-bottomHeight&&birdY>pipeHeight) {
        		
        	}
        	else {
        		hasGameStarted=false;        	}
        }
       
        }
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
 