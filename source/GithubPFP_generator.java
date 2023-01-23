import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class GithubPFP_generator extends PApplet {

boolean[][] array = new boolean[5][5];

boolean redraw = true;

public void setup() {
   //create window of size 800x600
  background(0xff676767); //set grey background
  fill(0xffFFFFFF); //set fill to white for drawing background circle
  noStroke();
  ellipse(400, 300, 450, 450); //draw center background ellipse
  rectMode(CENTER);
}
public void draw() {
  
  if(redraw == true){
    
  background(0xff676767); //set grey background
  fill(0xffFFFFFF); //set fill to white for drawing background circle
  ellipse(400, 300, 450, 450); //draw center background ellipse
  
  for(int o = 0;o<=4;o++){
   for(int i = 0;i<=4;i++){
     array[o][i] = false;
   }
  }

  int randomColor = color(random(100, 200), random(100, 200), random(100, 200)); //set random profile colour
  fill(randomColor); //set the fill to that colour
  
  for (int o = 0; o<=4; o++) {
    for (int i = 0; i<=4; i++) {
      if(o>=3){
        array[o][i] = array[4-o][i];
      }
      else{
      array[o][i] = (random(1) < 0.5f);
    }
    }
  }
  for (int out = 0; out<=4; out++) {
    for (int in = 0; in<=4; in++) {
      if(array[out][in] == true){
       rect(280+(60*out),180+(60*in),60,60);
      }
      
    }
  }
  
  redraw = false;
  
  }

}


public void keyPressed(){
   if(keyCode == ENTER){
     
    redraw = true;
     
   }
  }
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GithubPFP_generator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
