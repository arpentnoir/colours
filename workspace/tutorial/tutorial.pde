void setup(){
size(1280, 2048);
  background(205, 200, 177, 255);
  
PImage img1 = loadImage("red+blue.png");
PImage img2 = loadImage("yellow+blue.png");
PImage img3 = loadImage("yellow+red.png");

PImage img4 = loadImage("orange+blue.png");
PImage img5 = loadImage("green+red.png");
PImage img6 = loadImage("yellow+purple.png");

image(img1, 0, 0);
image(img2, 0, 341);
image(img3, 0, 682);
image(img6, 0, 1023);
image(img4, 0, 1364);
image(img5, 0, 1705);

saveFrame("tutorial.png");
}
