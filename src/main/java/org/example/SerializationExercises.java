package org.example;

import com.google.gson.Gson;
import org.example.model.Movie;
import org.example.model.Session;
import org.example.model.Theater;

import java.io.*;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */

    public static class Exercise1 {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Movie movie1 = new Movie("Avatar", 150);
            Movie movie2 = new Movie("Cars", 120);
            Theater theater1 = new Theater("Los Alisios", 40);
            Theater theater2 = new Theater("El Muelle", 35);
            Session session1 = new Session(movie1, theater1);
            Session session2 = new Session(movie2, theater2);
            
            Gson gson = new Gson();
            String movie1json = gson.toJson(movie1);
            String movie2json = gson.toJson(movie2);

            try (FileWriter writer = new FileWriter("writer1.json")){
                gson.toJson(movie1, writer);
                System.out.println("The object has been serialized.");
            } catch (IOException e){
                System.out.println("ERROR: " + e );
            }

            try (FileWriter writer2 = new FileWriter("writer2.json")){
                gson.toJson(movie2, writer2);
                System.out.println("The object has been serialized.");
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            }

            System.out.println(movie1json);
            System.out.println(movie2json);

        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {

        public static void main(String[] args) {

            //FileOutputStream fileOutputStream = new FileOutputStream("example1.txt");
            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //objectOutputStream.writeObject(movie1);
            //objectOutputStream.close();
//
            //FileOutputStream fileOutputStream1 = new FileOutputStream("example2.txt");
            //ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
            //objectOutputStream1.writeObject(movie2);
            //objectOutputStream1.close();
//
            //FileInputStream fileInputStream = new FileInputStream("example1.txt");
            //ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //Movie movie1InFile = (Movie) objectInputStream.readObject();
            //objectInputStream.close();
            //System.out.println(movie1InFile);
//
        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {

        public static void main(String[] args) {

        }
    }
}