package _01_methods._5_FlappyBird;

import java.util.Random;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    	int gravity = 2;
    	int yVel = 0;
    	int xVel = 5;
    	double bXVel = 0.3;
        double birdX = 50;
        int birdY = 300;
        int pipeY = 0;
        int pipeX = 0;
        int pipeHeight = 0;
        int bottomHeight = 0;
        int pipeSpace = 200;
        boolean isPipeDone = true;
        
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
        	yVel = 13;

        	
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
        	isPipeDone=true;
        }
        if(birdY<-15) {
        	birdY = -15;
        }
        if(birdY>815) {
        	System.exit(0);
        }
        if(birdX+30-pipeX>30) {
        	if(birdY<600-bottomHeight&&birdY>pipeHeight) {
        		
        	}
        	else {
        		System.exit(0);
        	}
        }
       
       
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
 