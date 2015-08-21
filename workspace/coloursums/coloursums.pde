void setup(){
  size(1280, 256);
  background(205, 200, 177, 255);
  PImage img1 = loadImage("orange.png");
  image(img1, 0, 0);
  
  PImage img2 = loadImage("blue.png");
  image(img2, 512, 0);
  
  PImage img3 = loadImage("plus.png");
  image(img3, 256, 0);
  
  PImage img4 = loadImage("equals.png");
  image(img4, 768, 0);
  
  PImage img5 = loadImage("brown.png");
  image(img5, 1024, 0);
  saveFrame("orange+blue.png");
}
