package _01_methods._1_houses;


import java.util.Random;

import javax.swing.JOptionPane;
import org.jointheleague.graphical.robot.Robot;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	static Robot rob = new Robot();
	static Random ran = new Random();
		public static void main(String[] args) {
			
			rob.setX(30);
			rob.setY(400);
			rob.hide();
			rob.penDown();
			rob.setSpeed(30);
			int r = 0;
			String heightS = null;
			for(int i = 0;i<10;i++) {
				r = ran.nextInt(3);
				switch (r) {
				case 0:
					heightS = "small";
					break;
				case 1:
					heightS = "medium";
					break;
				case 2:
					heightS = "large";
				}
			drawHouse(heightS, ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
			}
		}
	public static void drawHouse(String heightStr, int cRed, int cGreen, int cBlue) {
		// Check the recipe to find out what code to put here
		int height = 0;
		switch(heightStr) {
		
		case "small":
			 height = 60;
			break;
		case "medium":
			 height = 120;
			break;
		case "large":
			height = 250;
		}
		rob.setPenColor(cRed,cGreen,cBlue);
		rob.move(height);
		if(heightStr.equals("large")) {
			rob.turn(90);
			rob.move(height/8);
			rob.turn(90);
		}
		else {
		rob.turn(45);
		rob.move(height/4);
		rob.turn(90);
		rob.move(height/4);
		rob.turn(45);
		}
		rob.move(height);
		rob.setPenColor(0,180,0);
		rob.turn(-90);
		rob.move(20);
		rob.turn(-90);
		rob.setPenColor(0,0,0);
		
		
	}
		
}
		
