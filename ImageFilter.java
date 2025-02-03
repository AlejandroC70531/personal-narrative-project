import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{

  public ImageFilter(String filename) {
    super(filename);
  }
  
  /*
   * Inverts the colors in the image by setting the red,
   * green, and blue color values of each Pixel object to
   * the result of 255 minus their current values
   */
  public void makeNegative() {
  Pixel[][] pixels = getPixelsFromImage();
  for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[row].length; col++){
      Pixel currentPixel = pixels[row][col];
      currentPixel.setRed(255 - currentPixel.getRed());
      currentPixel.setGreen(255 - currentPixel.getGreen());
      currentPixel.setBlue(255 - currentPixel.getBlue());
    }
  }  
 }
  /*
   * Mirrors the image vertically
   */
  public void mirrorVertical() {
    Pixel[][] pixels = getPixelsFromImage();
    int length = pixels.length - 1;
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[row].length / 2; col++){
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(pixels[row][length - col].getRed());
        currentPixel.setGreen(pixels[row][length - col].getGreen());
        currentPixel.setBlue(pixels[row][length - col].getBlue());
      }
      length = pixels.length - 1;
    }
  }

  /*
   * Sharpens the image by calculating the difference between the color values of the current
   * and neighboring Pixel objects and adjust the color values to emphasize the edges
   */
  public void sharpen() {
   Pixel[][] pixels = getPixelsFromImage();
    int redDifference = 0;
    int greenDifference = 0;
    int blueDifference = 0;
    int average = 0;
   for(int row = 1; row < pixels.length - 1; row++){
     for(int col = 1; col < pixels[row].length - 1; col++){
       Pixel currentPixel = pixels[row][col];
       redDifference = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
       greenDifference = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
       blueDifference = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
       
       average = redDifference + greenDifference + blueDifference;
       average = average / 3;
       
       currentPixel.setRed(currentPixel.getRed() + average);
       currentPixel.setGreen(currentPixel.getGreen() + average);
       currentPixel.setBlue(currentPixel.getBlue() + average);

       if(currentPixel.getRed() > 255){
         currentPixel.setRed(255);
       }
       
       if(currentPixel.getGreen() > 255){
         currentPixel.setGreen(255);
       }
       
       if(currentPixel.getBlue() > 255){
         currentPixel.setBlue(255);
       }
     }
     redDifference = 0;
     greenDifference = 0;
     blueDifference = 0;
     average = 0;
   }
  }

  /*
   * Shifts the color of each Pixel object by a fixed amount
   */
    public void colorShift(int value) {
    Pixel[][] pixels = getPixelsFromImage();
    int newRed = 0;
    int newGreen = 0;
    int newBlue = 0;
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[row].length; col++){
        Pixel currentPixel = pixels[row][col];
        newRed = currentPixel.getRed() + value;
        newGreen = currentPixel.getGreen() + value;
        newBlue = currentPixel.getBlue() + value;
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
        if(currentPixel.getRed() > 255){
          currentPixel.setRed(255);
        }
        if(currentPixel.getGreen() > 255){
          currentPixel.setGreen(255);
        }
        if(currentPixel.getBlue() > 255){
          currentPixel.setBlue(255);
        }
      }
    }    
  }
  
  /*
   * Adjusts the contrast of the image by multiplying the
   * red, green, and blue values by the multiplier
   */
   public void adjustContrast(int multiplier) {
   Pixel[][] pixels = getPixelsFromImage();

   for(int row = 0; row < pixels.length; row++){
     for(int col = 0; col < pixels[row].length; col++){
       Pixel currentPixel = pixels[row][col];
       currentPixel.setRed(currentPixel.getRed() * multiplier);
       currentPixel.setGreen(currentPixel.getGreen() * multiplier);
       currentPixel.setBlue(currentPixel.getBlue() * multiplier);
       if(currentPixel.getRed() > 255){
          currentPixel.setRed(255);
        }
        if(currentPixel.getGreen() > 255){
          currentPixel.setGreen(255);
        }
        if(currentPixel.getBlue() > 255){
          currentPixel.setBlue(255);
        }
     }
   } 
 }

  /*
   * Applies a Gaussian blur by finding the average of the red,
   * green, and blue color values of the current Pixel object and
   * its top-left neighboring Pixel object using a weighted average
   */
  public void applyBlur() {
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 1; row < pixels.length - 1; row++){
      for(int col = 1; col < pixels[row].length - 1; col++){
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(calcWeightedRed(pixels, row, col));
        currentPixel.setGreen(calcWeightedGreen(pixels, row, col));
        currentPixel.setBlue(calcWeightedBlue(pixels, row, col));

      }
    } 
  }

  /*
   * Applies an emboss filter by calculating the difference between
   * the red, green, and blue color values of the current and neighboring
   * Pixel objects and setting the current Pixel object to the result
   */
    public void emboss() {
   Pixel[][] pixels = getPixelsFromImage();
   int maxDiff = 0;
    for(int row = 1; row < pixels.length; row++){
      for(int col = 1; col < pixels[row].length; col++){
        Pixel currentPixel = pixels[row][col];
        Pixel neighborPixel = pixels[row - 1][col - 1];
        int redDifference = Math.abs(currentPixel.getRed() - neighborPixel.getRed());
        int greenDifference = Math.abs(currentPixel.getGreen() - neighborPixel.getGreen());
        int blueDifference = Math.abs(currentPixel.getBlue() - neighborPixel.getBlue());
        if(redDifference > greenDifference && redDifference > blueDifference){
        maxDiff = redDifference + 128;
        currentPixel.setRed(maxDiff);
        currentPixel.setGreen(maxDiff);
        currentPixel.setBlue(maxDiff);        
        } else if(greenDifference > redDifference && greenDifference > blueDifference){
        maxDiff = greenDifference + 128;
        currentPixel.setRed(maxDiff);
        currentPixel.setGreen(maxDiff);
        currentPixel.setBlue(maxDiff);        
        } else {
        maxDiff = blueDifference + 128;
        currentPixel.setRed(maxDiff);
        currentPixel.setGreen(maxDiff);
        currentPixel.setBlue(maxDiff);
        }
        if(currentPixel.getRed() > 255){
         currentPixel.setRed(255);
        }
       
        if(currentPixel.getGreen() > 255){
         currentPixel.setGreen(255);
        }
       
        if(currentPixel.getBlue() > 255){
         currentPixel.setBlue(255);
        }

      }
    }
  }

  /*
   * Applies a pixelate filter to each Pixel object by dividing the image into a grid
   * of equal-sized rectangular regions and setting the color of each Pixel object in
   * a region to the color of the first Pixel object in the region
   */
  public void pixelate(int gridSize) {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);
        int avgRed = 0;
        int avgGreen = 0;
        int avgBlue = 0;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            avgRed += pixels[regionRow][regionCol].getRed();
            avgGreen += pixels[regionRow][regionCol].getGreen();
            avgBlue += pixels[regionRow][regionCol].getBlue();
          }
        }

        int totalPixelsInRegion = (endRow - row) * (endCol - col);
        avgRed /= totalPixelsInRegion;
        avgGreen /= totalPixelsInRegion;
        avgBlue /= totalPixelsInRegion;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            pixels[regionRow][regionCol].setRed(avgRed);
            pixels[regionRow][regionCol].setGreen(avgGreen);
            pixels[regionRow][regionCol].setBlue(avgBlue);
          }
        }
      }
    }
    
  }
  
  /*
   * Applies a saturation filter to the image
   */
    public void saturate(int factor) {
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[row].length; col++){
        Pixel currentPixel = pixels[row][col];
        int average = (currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen()) / 3;
        int adjustedGrayscale = average + (average - 255) * factor;
        int redGrayscale = 2 * adjustedGrayscale - currentPixel.getRed(); 
        int greenGrayscale = 2 * adjustedGrayscale - currentPixel.getGreen(); 
        int blueGrayscale = 2 * adjustedGrayscale - currentPixel.getBlue(); 
        currentPixel.setRed(redGrayscale);
        currentPixel.setGreen(greenGrayscale);
        currentPixel.setBlue(blueGrayscale);
        if(currentPixel.getRed() > 255){
         currentPixel.setRed(255);
       }
       
       if(currentPixel.getGreen() > 255){
         currentPixel.setGreen(255);
       }
       
       if(currentPixel.getBlue() > 255){
         currentPixel.setBlue(255);
       }
      }
    } 
  }

  /*
   * Applies a threshold filter to an image
   */
  public void threshold(int value) {
  Pixel[][] pixels = getPixelsFromImage();
  for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[row].length; col++){
      Pixel currentPixel = pixels[row][col];
      int average = (currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen()) / 3;
      if(average < value){
        currentPixel.setRed(0);
        currentPixel.setBlue(0);
        currentPixel.setGreen(0);
      } else {
        currentPixel.setRed(255);
        currentPixel.setGreen(255);
        currentPixel.setBlue(255);
      }
    }
  }    
}

  /*
   * Applies a colorize filter by converting each Pixel to grayscale and applying
   * a color to it based on its grayscale value
   */
 public void colorize() {
   Pixel[][] pixels = getPixelsFromImage();
  for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[row].length; col++){
      Pixel currentPixel = pixels[row][col];
      int average = (currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen()) / 3;
      if(average < 85){
        currentPixel.setRed(255);
        currentPixel.setGreen(0);
        currentPixel.setBlue(0);
      } else if(average < 170){
        currentPixel.setRed(0);
        currentPixel.setGreen(255);
        currentPixel.setBlue(0);
      } else {
        currentPixel.setRed(0);
        currentPixel.setGreen(0);
        currentPixel.setBlue(255);
      }  
   }
  }
 }
  /*
   * Applies a motion blur to the image
   */
    public void motionBlur(int length, String direction) {
    Pixel[][] pixels = getPixelsFromImage();
    int count = 0;
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[row].length; col++){
         int x = col;
         int y = row;
        int redTotal = 0;
        int greenTotal = 0;
        int blueTotal = 0;
      while(count < length && y < pixels.length && x < pixels[0].length){
        Pixel currentPixel = pixels[y][x];
        redTotal += currentPixel.getRed();
        greenTotal += currentPixel.getGreen();
        blueTotal += currentPixel.getBlue();
      count++;
      if(direction.equals("vertical")){
        y++;
      } else if(direction.equals("horizontal")){
        x++;
      } else {
        x++;
        y++;
      }      
      }
      int redAverage = redTotal / count;
      int greenAverage = greenTotal / count;
      int blueAverage = blueTotal / count;
      Pixel currenttPixel = pixels[row][col];
      currenttPixel.setRed(redAverage);
      currenttPixel.setBlue(blueAverage);
      currenttPixel.setGreen(greenAverage);
        if(currenttPixel.getRed() > 255){
          currenttPixel.setRed(255);
        }
        if(currenttPixel.getGreen() > 255){
          currenttPixel.setGreen(255);
        }
        if(currenttPixel.getBlue() > 255){
          currenttPixel.setBlue(255);
        }
      count = 0;
     }
    }  
   }

  /*
   * Student developed; Given either true or false, this method makes all color values equal to 0
   * if given true resulting in black, but if given false, all color values are set to 255 resulting in white
   */
  public void makeBlackOrWhite(boolean isBlack){
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[row].length; col++){
        Pixel currentPixel = pixels[row][col];
        if(isBlack == true){
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0);
        } else {
          currentPixel.setRed(255);
          currentPixel.setGreen(255);
          currentPixel.setBlue(255);
        }
      }
    }
  }

  /*
   * Sets the red value for all pixels to 0
   */
   public void zeroRed() {
   Pixel[][] imagePixels = getPixelsFromImage();
    for (int row = 0; row < imagePixels.length; row++) {
      for (int col = 0; col < imagePixels[0].length; col++) {
        Pixel currentPixel = imagePixels[row][col];

        currentPixel.setRed(0);
       
      }
    }
  }

  /*
   * Sets the blue value for all pixels to 0
   */
 public void zeroBlue() {
   Pixel[][] imagePixels = getPixelsFromImage();
    for (int row = 0; row < imagePixels.length; row++) {
      for (int col = 0; col < imagePixels[0].length; col++) {
        Pixel currentPixel = imagePixels[row][col];

        currentPixel.setBlue(0);
       
      }
    }
  }

  /*
   * Sets the green value for all pixels to 0
   */
   public void zeroGreen() {
   Pixel[][] imagePixels = getPixelsFromImage();
    for (int row = 0; row < imagePixels.length; row++) {
      for (int col = 0; col < imagePixels[0].length; col++) {
        Pixel currentPixel = imagePixels[row][col];

        currentPixel.setGreen(0);
       
      }
    }
  }

  /*
   * Sets all the colors values to 0 except for those of the specified color
   */
   public void keepColor(String color) {

        if(color.equals("red")){
          zeroGreen();
          zeroBlue();
        } else if(color.equals("blue")){
          zeroRed();
          zeroGreen();
        } else {
          zeroRed();
          zeroBlue();
        } 
      }

  /*
   * Returns a weighted red average of the pixels around the specified row and col 
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  
  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }
}
