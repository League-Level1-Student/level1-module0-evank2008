package _01_methods._5_FlappyBird;

import java.util.Random;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    	int gravity = 2;
    	int yVel = -10;
    	int xVel = 3;
        int birdX = 50;
        int birdY = 300;
        int pipeY = 0;
        int pipeX = 0;
        int pipeHeight = 0;
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
        birdX += xVel;
        if(yVel>-20) {
        	yVel-=gravity;
        }
        if(yVel<-20) {
        	yVel = -20;
        }
        if(birdX>815) {
        	birdX = -15;
        }
        if(mousePressed) {
        	yVel = 15;
        }
        ellipse(birdX,birdY,30,30);
        
        //control the pipes
        fill(0,140,0);
      //ADD MORE CODE HERE
        rect(pipeX,pipeY,30,pipeHeight);
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
