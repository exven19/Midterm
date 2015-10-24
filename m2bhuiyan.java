// Midterm CST112
// MD NAYEEM U. BHUIYAN
// 10.21.15

// 3 WORDS

//first word ...... nam
//second word...... din
//third word....... yan

//  Global Declaration 

float namX, namY, namDX, namDY;
float dinX, dinY, dinDX, dinDY;
float yanX, yanY, yanDX, yanDY;


//   Other GLobals: strings, pool table, etc ///

String title = "CST112 MIDTERM EXAM";
String author = "MD NAYEEM U. BHUIYAN";

// Table boundaries
float left = 50, right = 590, top = 150, bottom = 400;
float middle = ( left + right)/2;
boolean wall = true;
//toggle for mouse
boolean mouse = true;
float miceX, miceY, miceDX;



// Brown pool table
int tableRed = 150, tableGreen = 150, tableBlue = 50;
int score = 0, m = 0, k = 0;
//frame counter
int frame;

void setup() {
  size ( 620, 480);
  reset();
  
}
// Next frame: table, bounce off walls, collisions //

void draw(){
  background( 250, 250, 200);
  rectMode( CORNERS );
  table( left, top, width-50, bottom );
  buttons();
  bounce();
  collisions();
  show();
  mouseDraw();
  messages();
}

void reset(){
  namX = random( middle, right ); namY = random( top, bottom );
  dinX = random( middle, right ); dinY = random( top, bottom );
  yanX = random( middle, right ); yanY = random( top, bottom );
  miceX = width-50;              miceY = 420;  
  
  //Random speeds
  namDX = random( -5,5 ); namDY = random( -5,5 );
  dinDX = random( -5,5 ); dinDY = random( -5,5 );
  yanDX = random( -5,5 ); yanDY = random( -5,5 );
  miceDX = -1;
}

// Handlers: keys, click or press

void keyPressed() {
  if (key == 'e') { exit(); }
  if (key == 'r') { reset(); }
  if (key == 'w') { wall = true; }
  if (key == 'p') { tablePink(); }
  if (key == 'm') {mouse = true; }
  
}

// Scene: draw the table with wall down the midle
void table( float east, float north, float west, float south ) {
  //pool table
  fill( tableRed, tableGreen, tableBlue );
  strokeWeight( 20 );
  //brown ball
  stroke( 127, 0, 0 );
  rect( east-20, north-20, west+20, south+20 );

  //start with a Wall down the middle of the table!
  if (wall) {
    float middle = ( east + west )/2;
    stroke( 0, 127, 0);
    line( middle, north+10, middle, south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

//Action: bounce off walls, collisions
void bounce() {
  if ( wall ){
   namX += namDX;  if ( namX<middle || namX>right ) namDX *= -1;
   namY += namDY;  if ( namY<top || namY>bottom ) namDY *= -1;
   dinX += dinDX;  if ( dinX<middle || dinX>right ) dinDX *= -1;
   dinY += dinDY;  if ( dinY<top || dinY>bottom ) dinDY *= -1;
   yanX += yanDX;  if ( yanX<middle || yanX>right ) yanDX *= -1;
   yanY += yanDY;  if ( yanY<top || yanY>bottom ) yanDY *= -1;
 } else {
   namX += namDX;  if ( namX<left || namX>right ) namDX *= -1;
   namY += namDY;  if ( namY<top || namY>bottom ) namDY *= -1;
   dinX += dinDX;  if ( dinX<left || dinX>right ) dinDX *= -1;
   dinY += dinDY;  if ( dinY<top || dinY>bottom ) dinDY *= -1;
   yanX += yanDX;  if ( yanX<left || yanX>right ) yanDX *= -1;
   yanY += yanDY;  if ( yanY<top || yanY>bottom ) yanDY *= -1;
   }
}

void collisions() {
  float tmp;
  //Swap velocities!
  if ( dist( namX, namY, dinX, dinY ) <30 ) {
    tmp = dinDX; dinDX = namDX; namDX = tmp;
    tmp = dinDY; dinDY = namDY; namDY = tmp;
    k += 1;
   }

  if ( dist( namX, namY, yanX, yanY ) <30 ) {
    tmp = yanDX; yanDX = namDX; namDX = tmp;
    tmp = yanDY; yanDY = namDY; namDY = tmp;
    k += 1;
  }
  
  if ( dist( yanX, yanY, dinX, dinY ) <30 ) {
    tmp = dinDX; dinDX = yanDX; yanDX = tmp;
    tmp = dinDY; dinDY = yanDY; yanDY = tmp;
    k += 1;
  }
}

// show: display code for balls, messages, mouse, etc.
void show() {
  stroke(0);
  strokeWeight(1);
  fill( 255, 0, 0); ellipse( namX, namY, 30, 30 );
  fill(255, 255, 0); ellipse( dinX, dinY, 30, 30 );
  fill( 0, 0, 255); ellipse( yanX, yanY, 30, 30 );
  fill(0);
  text( "1", namX, namY );
  text( "2", dinX, dinY );
  text( "3", yanX, yanY );
}
// code for mouse
void mouseDraw(){
  if (mouse){
    fill( 128, 128, 128 );
    ellipse( miceX,miceY, 20, 20 );
    miceX += miceDX;
    frame = frame + 1;
    if ( miceX<left || miceX>right ) miceDX *= -1;
    if ( miceDX == -1 ){
      if (frame/30 % 2 == 0 ){
        line( miceX + 10, miceY + 4, miceX + 20, miceY + 4);
      }else{
        line( miceX + 10, miceY + 4, miceX + 20, miceY - 1 );
      }
    }else if ( miceDX == 1 ){
      if ( frame/30 % 2 == 0 ){
        line( miceX - 10, miceY + 4, miceX - 20, miceY + 4 );
      }else{
        line( miceX - 10, miceY + 4, miceX -20, miceY -1 );
      }
    }
}
}

void tablePink(){
  tableRed = 255;
  tableGreen = 192;
  tableBlue = 203;
}

void buttons(){
  rectMode( CORNER );
  fill(0);
  strokeWeight(4);
  stroke( 255 );
  rect( 50, 50, 100, 50 );
  rect( 170, 50, 100, 50 );
  rect( 290, 50, 100, 50 );
  rect( 410, 50, 100, 50 );
  fill( 255 );
  text( "Reset Balls 'R' ", 70, 70 );
  text( "Remove Wall", 190, 70 );
  text( " 'W' ", 190, 90 );
  text( "Turn Table", 310, 70 );
  text( "Pink 'P' ", 310, 90 );
  text( "Spawn Mouse", 430, 70 );
  text( " 'M' ", 430, 90 );
  //text( width-50, 100, 100 );
}

void messages() {
  fill(0);
  text( title, width/3, 15);
  text( "Collisions", 50, 450);
  text( k, 120, 450 );
  text( author, 10, height-5 );
}

void mousePressed(){
  if ( mouseX>50 && mouseX<150 && mouseY>50 && mouseY<100 ){
    reset();
  }
  if ( mouseX>170 && mouseX<270 && mouseY>50 && mouseY<100 ){
    wall = false;
  }
  if ( mouseX>290 && mouseX<390 && mouseY>50 && mouseX<100 ){
    tablePink();
  }
  if ( mouseX>410 && mouseX<510 && mouseY>50 && mouseY<100 ){
    mouse = true;
  }
}
