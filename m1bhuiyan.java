//Midterm CST112

// MY FIRST NAME IS.... MD. NAYEEM
// MY MIDDLE NAME IS... UDDIN
// MY LAST NAME IS... BHUIYAN

// 3 WORDS
  
  //first word ...... nam
  //second word...... din
  //third word....... yan

//  Global Declaration 

// (assume all diameter is 40) ///

float namX, namY, namDX, namDY;
float dinX, dinY, dinDX, dinDY;
float yanX, yanY, yanDX, yanDY;

//   Other GLobals: strings, pool table, etc ///

String title = "CST112 MIDTERM EXAM";
String news =  "Click any ball to reset it to right half of table.  (r resets all)";
String author = "MD NAYEEM U. BHUIYAN";

// Table boundaries
float left = 60, right = 460, top = 120, bottom = 275;
float middle = 275;
boolean wall = true;

// Green pool table
int tableRed = 150, tableGreen = 250, tableBlue = 150;
int score = 0, m = 0, k = 0;

void setup(){
  size ( 1080, 720);
  
  //table boundaries
  left = 75;
  right = 500;
  top = 150;
  bottom = 275;
  middle = 275;
}

// Next frame: table, bounce off walls, collisions //

void draw(){
  background( 200, 200, 275);
  rectMode( CORNERS );
  table( left, top, right, bottom );
  buttons();
  bounce();
  collisions();
  show();
  messages();
}

// Handlers: keys, click or press

void keyPressed(){
  if (key == 'e') { exit(); }
}

// Scene: draw the table with wall down the midle
void table( float north, float west, float east, float south ){
  //pool table
  fill( tableRed, tableGreen, tableBlue );
  strokeWeight( 40 );
  //green ball
  stroke( 0, 200, 0 );
  rect( east-40, north-40, west+40, south+40 );
  
  //if wall hits
  float tmp,namX=0;
  
  
  //start with a Wall down the middle of the table!
  if (wall){
    float middle = ( east + west )/2;
    stroke( 0, 254, 0);
    line( middle, north+20, middle, south-20 );
  }
  stroke(1);
  strokeWeight(2);
}

//Action: bounce off walls, collisions
void bounce(){
/*
  namX += namDX; if ( namX<west || namX>east ) namDX *= -2;
  namY += namDY; if ( namyY<west || namY>east ) namDY *= -2;
  dinX += dinDX; if ( dinX<west || dinX>east ) dinDX *= -2;
  dinY += dinDY; if ( dinY<west || dinY>east ) dinDY *= -2;
  yanX += yanDX; if ( yanX<west || yanX>east ) yanDX *= -2;
  yanY += yanDY; if ( yanY<west || yanY>east ) yanDY *= -2;
*/
}

void collisions(){
  float east,west;
  //Swap velocities!
  if ( dist( namX, namY, dinX, dinY ) <40 ){
    east = dinDX; dinDX = namDX; namDX = east;
    west = dinDY; dinDY = namDY; namDY = west;
  }
  
  if ( dist( namX, namY, yanX, yanY ) <40 ){
    float yanY = yanDX; yanDX = namDX; namDX = yanY;
    float namY = namDY; namDY = yanDY; yanDY = namY;
  }
}
// show: balls, messages, etc.
void show() { //can't find the error??
  fill( 200, 0, 0); ellipse( namX, namY, 40, 39.99 );
  fill( 0, 200, 0); ellipse( dinX, dinY, 40, 40 );
  fill( 250, 0, 250); ellipse( yanX, yanY, 40, 40 );
}
void messages(){
  fill(1);
  text( title, width/3, 30);
  text( news, width/9, 60);
  text( author, 20, height-10 );
}

void buttons(){
}



  
