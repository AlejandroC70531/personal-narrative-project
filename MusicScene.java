import org.code.theater.*;
import org.code.media.*;

public class MusicScene extends Scene{
/*
 * Instance variables representing each 2D array of data
 */
  private String[][] images;
  private String[][] trendingSongs;
  private String[][] albums;
  private int[][] trendingSongsStreams;
  private double[][] monthlyListeners;
/*
 * Constructs the scene object using the 2D arrays
 */
  public MusicScene(String[][] images, String[][] trendingSongs, String[][] albums, int[][] trendingSongsStreams, double[][] monthlyListeners){
    this.images = images;
    this.trendingSongs = trendingSongs;
    this.albums = albums;
    this.trendingSongsStreams = trendingSongsStreams;
    this.monthlyListeners = monthlyListeners;
  }
/*
 * Draws the whole theater scene by calling each scene method one at a time
 */
  public void drawScene(){
    drawBeginningScene();
    drawMetalScene();
    drawRapScene();
    drawClassicalScene();
    drawGenreStatsBeginning();
    drawMetalStats();
    drawRapStats();
    drawClassicalStats();
    drawEnding();
  }
  
/*
 * Draws the welcome message with an image, then waits 5 seconds before continuing to the next method
 */  
  public void drawBeginningScene(){
    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText("Welcome to my music!", 100, 50);
    drawImage("Music_icon.jpg", 100, 100, 200);
    pause(5.0);
  }
/*
 * Draws 4 images of 4 different metal bands one a time
 * Each image is shown for 3 seconds, then a blackout filter is used to cover it up 
 * and display the band's name to represent each band
 */
  public void drawMetalScene(){
    clear("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    setTextColor("red");
    drawText("My favorite metal bands", 60, 40);
    playSound("slowguitar.wav");
    ImageFilter IronMaiden = new ImageFilter(images[0][0]);
    drawImage(IronMaiden, 20, 60, 150);
    pause(3.0);
    IronMaiden.makeBlackOrWhite(true);
    drawImage(IronMaiden, 20, 60, 150);
    drawText(cleanMusicianName(images[0][0]), 20, 110);
    ImageFilter LedZeppelin = new ImageFilter(images[0][1]);
    drawImage(LedZeppelin, 225, 60, 150);
    pause(3.0);
    LedZeppelin.makeBlackOrWhite(true);
    drawImage(LedZeppelin, 225, 60, 150);
    drawText(cleanMusicianName(images[0][1]), 225, 110);
    ImageFilter ACDC = new ImageFilter(images[0][2]);
    drawImage(ACDC, 20, 235, 150);
    pause(3.0);
    ACDC.makeBlackOrWhite(true);
    drawImage(ACDC, 20, 235, 150);
    drawText(cleanMusicianName(images[0][2]), 50, 285);
    ImageFilter JudasPriest = new ImageFilter(images[0][3]);
    drawImage(JudasPriest, 225, 235, 150);
    pause(3.0);
    JudasPriest.makeBlackOrWhite(true);
    drawImage(JudasPriest, 225, 235, 150);
    drawText(cleanMusicianName(images[0][3]), 225, 285);
    pause(3.0);
  }
  
/*
 * Draws 4 images of 4 different rappers one a time
 * Each image is shown for 3 seconds, then a filter that keeps only the blue values is used to cover it up 
 * and display the rapper's name to represent each rapper
 */
  public void drawRapScene(){
    clear("blue");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextColor("yellow");
    drawText("My favorite rap artists", 100, 40);
    playSound("rapbeat.wav");
    ImageFilter IceCube = new ImageFilter(images[1][0]);
    drawImage(IceCube, 20, 60, 150);
    pause(3.0);
    IceCube.keepColor("blue");
    drawImage(IceCube, 20, 60, 150);
    drawText(cleanMusicianName(images[1][0]), 20, 110);
    ImageFilter Eminem = new ImageFilter(images[1][1]);
    drawImage(Eminem, 225, 60, 150);
    pause(3.0);
    Eminem.keepColor("blue");
    drawImage(Eminem, 225, 60, 150);
    drawText(cleanMusicianName(images[1][1]), 225, 110);
    ImageFilter DrDre = new ImageFilter(images[1][2]);
    drawImage(DrDre, 20, 235, 150);
    pause(3.0);
    DrDre.keepColor("blue");
    drawImage(DrDre, 20, 235, 150);
    drawText(cleanMusicianName(images[1][2]), 20, 285);
    ImageFilter SnoopDogg = new ImageFilter(images[1][3]);
    drawImage(SnoopDogg, 225, 235, 150);
    pause(3.0);
    SnoopDogg.keepColor("blue");
    drawImage(SnoopDogg, 225, 235, 150);
    drawText(cleanMusicianName(images[1][3]), 225, 285);
    pause(3.0);
  }

/*
 * Draws 4 images of 4 different composers one a time
 * Each image is shown for 3 seconds, then a whiteout filter is used to cover it up 
 * and display the composer's name to represent each composer
 */
  public void drawClassicalScene(){
    clear("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("gold");
    drawText("My favorite classical composers", 60, 40);
    playSound("violinmusic.wav");
    ImageFilter DmitriShostakovich = new ImageFilter(images[2][0]);
    drawImage(DmitriShostakovich, 20, 60, 150);
    pause(3.0);
    DmitriShostakovich.makeBlackOrWhite(false);
    drawImage(DmitriShostakovich, 20, 60, 150);
    drawText(cleanMusicianName(images[2][0]), 20, 110);
    ImageFilter JohannesBrahms = new ImageFilter(images[2][1]);
    drawImage(JohannesBrahms, 225, 235, 150);
    pause(3.0);
    JohannesBrahms.makeBlackOrWhite(false);
    drawImage(JohannesBrahms, 225, 235, 150);
    drawText(cleanMusicianName(images[2][1]), 20, 160);
    ImageFilter AntoninDvorak = new ImageFilter(images[2][2]);
    drawImage(AntoninDvorak, 20, 235, 150);
    pause(3.0);
    AntoninDvorak.makeBlackOrWhite(false);
    drawImage(AntoninDvorak, 20, 235, 150);
    drawText(cleanMusicianName(images[2][2]), 20, 210);
    ImageFilter NiccoloPaganini = new ImageFilter(images[2][3]);
    drawImage(NiccoloPaganini, 225, 235, 150);
    pause(3.0);
    NiccoloPaganini.makeBlackOrWhite(false);
    drawImage(NiccoloPaganini, 225, 235, 150);
    drawText(cleanMusicianName(images[2][3]), 20, 260);
    pause(3.0);
  }
  
/*
 * Draws 3 icons each representing a different genre in this visualization
 * then a colorize filter is applied to each image to make it pop
 */
  public void drawGenreStatsBeginning(){
    clear("black");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextColor("white");
    ImageFilter Guitar = new ImageFilter("Guitar.jpg");
    ImageFilter Microphone = new ImageFilter("Microphone.jpg");
    ImageFilter Violin = new ImageFilter("Violin.jpg");
    Guitar.colorize();
    Microphone.colorize();
    Violin.colorize();
    drawText("The genres", 150, 40);
    drawImage(Guitar, 25, 150, 100);
    drawImage(Microphone, 150, 150, 100);
    drawImage(Violin, 275, 150, 100);
    drawText("Metal", 25, 300);
    drawText("Rap", 150, 300);
    drawText("Classical", 275, 300);
    pause(5.0);
  }

/*
 * Displays the name of the most popular band out of the 4 previously shown metal bands with
 * their monthly listeners count
 * Afterwards, the most popular song out of all the bands is displayed with the creator's name, streams,
 * and its album cover, which is then pixelated
 */
  public void drawMetalStats(){
    clear("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    setTextColor("red");
    setStrokeColor("red");
    String mostPopularBand = getMostPopularBand(0);
    String mostPopularSong = getMostPopularSong(0);
    String mostPopularSongWriter = getPopularSongWriter(cleanSongName(mostPopularSong));
    ImageFilter album = new ImageFilter(getAlbum(cleanSongName(mostPopularSong)));
    drawText("Metal Stats", 150, 40);
    drawLine(0, 60, 400, 60);
    drawText("Most popular: ", 20, 100);
    drawText(mostPopularBand, 20, 120);
    pause(3.0);
    drawText("Most popular song: ", 20, 150);
    drawText(mostPopularSong, 20, 170);
    drawText(mostPopularSongWriter, 20, 190);
    pause(3.0);
    playSound("applause3.wav");
    drawImage(album, 100, 230, 150);
    pause(3.0);
    album.pixelate(10);
    drawImage(album, 100, 230, 150);
    pause(3.0);
  }

/*
 * Displays the name of the most popular rapper out of the 4 previously shown rappers with
 * their monthly listeners count
 * Afterwards, the most popular song out of all the rappers is displayed with the creator's name, streams,
 * and its album cover, which is then pixelated
 */
  public void drawRapStats(){
    clear("blue");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextColor("yellow");
    setStrokeColor("yellow");
    String mostPopularBand = getMostPopularBand(1);
    String mostPopularSong = getMostPopularSong(1);
    String mostPopularSongWriter = getPopularSongWriter(cleanSongName(mostPopularSong));
    ImageFilter album = new ImageFilter(getAlbum(cleanSongName(mostPopularSong)));
    drawText("Rap Stats", 170, 40);
    drawLine(0, 60, 400, 60);
    drawText("Most popular: ", 20, 100);
    drawText(mostPopularBand, 20, 120);
    pause(3.0);
    drawText("Most popular song: ", 20, 150);
    drawText(mostPopularSong, 20, 170);
    drawText(mostPopularSongWriter, 20, 190);
    pause(3.0);
    playSound("applause3.wav");
    drawImage(album, 100, 230, 150);
    pause(3.0);
    album.pixelate(10);
    drawImage(album, 100, 230, 150);
    pause(3.0);
  }

/*
 * Displays the name of the most popular composer out of the 4 previously shown composers with
 * their monthly listeners count
 * Afterwards, the most popular song out of all the bands is displayed with the creator's name, streams,
 * and its album cover, which is then pixelated
 */
  public void drawClassicalStats(){
    clear("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("gold");
    setStrokeColor("gold");
    String mostPopularBand = getMostPopularBand(2);
    String mostPopularSong = getMostPopularSong(2);
    String mostPopularSongWriter = getPopularSongWriter(cleanSongName(mostPopularSong));
    ImageFilter album = new ImageFilter(getAlbum(cleanSongName(mostPopularSong)));
    drawText("Classical Stats", 125, 40);
    drawLine(0, 60, 400, 60);
    drawText("Most popular: ", 20, 100);
    drawText(mostPopularBand, 20, 120);
    pause(3.0);
    drawText("Most popular song: ", 20, 150);
    drawText(mostPopularSong, 20, 170);
    drawText(mostPopularSongWriter, 20, 190);
    pause(3.0);
    playSound("applause3.wav");
    drawImage(album, 100, 230, 150);
    pause(3.0);
    album.pixelate(10);
    drawImage(album, 100, 230, 150);
    pause(3.0);
  }

/*
 * Draws the ending message with an image, which a contrast-increasing filter is applied to
 */  
  public void drawEnding(){
    clear("white");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextColor("black");
    drawText("Thanks for watching!", 100, 40);
    ImageFilter music = new ImageFilter("Music_Icon.jpg");
    drawImage(music, 100, 100, 200);
    pause(3.0);
    music.adjustContrast(4);
    drawImage(music, 100, 100, 200);
  }

/*
 * Given the genre (row), this method loops through the whole row's list of musicians 
 * and analyzes their monthly listeners
 * The musician with the most listeners is then returned with their amount of listeners
 */  
  public String getMostPopularBand(int desiredRow){
    String chosenBand = "";
    double max = 0.0;
    for(int row = 0; row < images.length; row++){
      for(int col = 0; col < images[row].length; col++){
        if(row == desiredRow && Math.min(monthlyListeners[row][col], max) == max){
          chosenBand = images[row][col];
          max = monthlyListeners[row][col];
        }
      }
    }
    return cleanMusicianName(chosenBand) + "(" + max + " million listeners)";
  }
  
/*
 * Given the genre (row), this method loops through the whole row's list of most trending songs 
 * and analyzes their monthly listeners
 * The song with the most listeners is then returned with their amount of listeners and creator
 */  
  public String getMostPopularSong(int desiredRow){
    String chosenSong = "";
    double max = 0.0;
    for(int row = 0; row < images.length; row++){
      for(int col = 0; col < images[row].length; col++){
        if(row == desiredRow && Math.min(trendingSongsStreams[row][col], max) == max){
          chosenSong = trendingSongs[row][col];
          max = trendingSongsStreams[row][col];
        }
      }
    }
    return chosenSong + "(" + max + " million listeners)";
  }

/*
 * Given the song from the previous method, this method finds the indexes of said song
 * and returns the musician at the same indexes
 */  
  public String getPopularSongWriter(String song){
    for(int row = 0; row < trendingSongs.length; row++){
      for(int col = 0; col < trendingSongs[row].length; col++){
        if(trendingSongs[row][col].equals(song)){
          return cleanMusicianName(images[row][col]);
        }
      }
    }
   return cleanMusicianName(images[0][0]);
  }
  
/*
 * Given the song from a previous method, this method finds the indexes of said song
 * and returns the album image at the same indexes
 */  
  public String getAlbum(String song){    
    for(int row = 0; row < trendingSongs.length; row++){
      for(int col = 0; col < trendingSongs[row].length; col++){
        if(trendingSongs[row][col].equals(song)){
          return albums[row][col];
        }
      }
    }
   return albums[0][0];
  }
  
/*
 * Given the image file of this musician, this method finds the location of the first underscore and
 * the .JPG file type indicator
 * These locations are used to split the name and remove the .JPG mark, which then returns the 
 * musician's name
 */   
public String cleanMusicianName(String musicianName){
    String newName = musicianName.toUpperCase();
    int spaceIndex = newName.indexOf("_");
    int jpgIndex = newName.indexOf(".JPG");
    
    if(spaceIndex != -1){
      String[] splitNames = newName.split("_");
      String vari = splitNames[0] + " " + splitNames[1];
      return vari.substring(0, jpgIndex);
    } else {
      return newName.substring(0, jpgIndex);
    }
  }
  
/*
 * Given the name of the song from the getMostPopularSong() method, this method removes the listener
 * count returned by that method and returns only the song name
 */ 
  public String cleanSongName(String songName){
    String newName = songName;
    int parenthesisIndex = newName.indexOf("(");
    return newName.substring(0, parenthesisIndex);
  }
}
