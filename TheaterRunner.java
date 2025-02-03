import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

// Image files of the musicians
String[][] musicianImages = {{"Iron_Maiden.jpg", "Led_Zeppelin.jpg", "AC_DC.jpg", "Judas_Priest.jpg"},
                          {"Ice_Cube.jpg", "Eminem.jpg", "Dr_Dre.jpg", "Snoop_Dogg.jpg"},
                          {"Dmitri_Shostakovich.jpg", "Johannes_Brahms.jpg", "Antonin_Dvorak.jpg", "Niccolo_Paganini.jpg"}};
    
// Each musician's monthly listeners on Spotify in millions    
double[][] monthlyListenersMillions = {{7.5, 19.0, 33.6, 4.0},
                                       {15.8, 73.9, 24.7, 30.2},
                                       {3.4, 4.8, 3.0, 1.4}};
    
// Each musician's most trending song on Spotify
String[][] mostTrendingSong = {{"The Trooper 2015 Remaster", "Stairway to Heaven - Remaster", "Highway to Hell", "Breaking the Law"},
                              {"Check Yo Self - Remix", "Without Me", "Nuthin' But A 'G' Thang", "Young, Wild & Free feat. Bruno Mars"},
                              {"Jazz Suite No. 2", "16 Waltzes, Op. 39", "Symphony No. 8 in G Major", "Sonata for Violin and Guitar in A Minor"}};

// The number of streams on each trending song in millions
int[][] mostTrendingSongStreamsMillions = {{493, 1074, 1849, 304},
                                          {284, 2497, 464, 1567},
                                          {68, 50, 17, 25}};

// The album cover of each trending song
String[][] musicAlbums = {{"Piece'Of_Mind.jpg", "Led'Zeppelin_IV.jpg", "Highway'To_Hell.jpg", "British_Steel.jpg"},
                          {"Bootlegs'and_B-sides.jpg", "Eminem_Show.jpg", "The_Chronic.jpg", "Mac'and_Devin.jpg"},
                          {"Jazz_Suites.jpg", "Hungarian_Dances.jpg", "Greatest_Melodies.jpg", "Violin_Guitar.jpg"}};

// Creates and plays the music scene in the theater
MusicScene scene = new MusicScene(musicianImages, mostTrendingSong, musicAlbums, mostTrendingSongStreamsMillions, monthlyListenersMillions);
scene.drawScene();
Theater.playScenes(scene);
    
  }
}
