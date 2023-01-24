boolean[][] array = new boolean[5][5];

boolean redraw = true;

void setup() {
  size(800, 600); //create window of size 800x600
  background(#676767); //set grey background
  fill(#FFFFFF); //set fill to white for drawing background circle
  noStroke();
  ellipse(400, 300, 450, 450); //draw center background ellipse
  rectMode(CENTER);
}
void draw() {
  
  if(redraw == true){
    
  background(#676767); //set grey background
  fill(#FFFFFF); //set fill to white for drawing background circle
  ellipse(400, 300, 450, 450); //draw center background ellipse
  
  for(int o = 0;o<=4;o++){
   for(int i = 0;i<=4;i++){
     array[o][i] = false;
   }
  }

  color randomColor = color(random(100, 200), random(100, 200), random(100, 200)); //set random profile colour
  fill(randomColor); //set the fill to that colour
  
  for (int o = 0; o<=4; o++) {
    for (int i = 0; i<=4; i++) {
      if(o>=3){
        array[o][i] = array[4-o][i];
      }
      else{
      array[o][i] = (random(1) < 0.5);
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


void keyPressed(){
   if(keyCode == ENTER){
     
    redraw = true;
     
   }
  }
