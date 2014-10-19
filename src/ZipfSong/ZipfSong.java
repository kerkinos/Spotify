package ZipfSong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Simple class describing a song
class Song {

    String name;
    double times, quality;
    int number;

    //Basic constructor
    public Song(double times, String name, int number) {
        this.times = times;
        this.name = name;
        this.number = number;
        this.quality = getQuality();
    }

    //The necessary getters
    public int getNumber() {
      return number;
    }

    public String getName() {
          return name;
      }

    //Return the quality according to the description
    public double getQuality() {
        return number * times;
    }

}

//Custom comparator used to compare songs according to quality
//or if quality is the same, according to the number they have
class CustomComparator implements Comparator<Song> {
    @Override
    public int compare(Song o2, Song o1) {
        if (o1.getQuality() > o2.getQuality()) {
            return 1;
        }

        if (o1.getQuality() == o2.getQuality()) {
            if (o1.getNumber() < o2.getNumber()){
                return 1;
            }
        }
        return -1;
    }
}

//Main
public class ZipfSong{

    public static void main(String[] args) {

        //Used BufferedReader and BufferedWriter for quicker results
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            //Read first line
            StringTokenizer st = new StringTokenizer(in.readLine());

            int numberOfSongs = Integer.parseInt(st.nextToken());
            int numberOfSongsToSelect = Integer.parseInt(st.nextToken());

            //Now that you know the number of songs create the table
            Song[] songs = new Song[numberOfSongs];

            //Read the rest of the lines
            for (int i = 0; i < numberOfSongs; i++) {
                st = new StringTokenizer(in.readLine());
                double foo = Double.parseDouble(st.nextToken());
                songs[i] = new Song(foo, st.nextToken(), i+1);
            }

            //Use our CustomComparator to sort the table
            Arrays.sort(songs, new CustomComparator());

            //Print the results
            for (int s = 0; s < numberOfSongsToSelect; s++) {
                out.write(songs[s].getName());
                out.newLine();
            }
            out.flush();
        }
        //Used for debugging, but should not print anything according to instructions
        catch (Exception e){
          //e.printStackTrace();
        }
    }
}
