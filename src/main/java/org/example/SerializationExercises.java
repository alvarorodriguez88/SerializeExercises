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

        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {

        public static void main(String[] args) {

            Gson gson = new Gson();
            try (FileReader fileReader1 = new FileReader("writer1.json")){
                Movie movie1 = gson.fromJson(fileReader1, Movie.class);
                System.out.println("MOVIE 1: TITLE -> " + movie1.getTitle() + " DURATION: " + movie1.getDuration());
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            }

            try (FileReader fileReader2 = new FileReader("writer2.json")){
                Movie movie2 = gson.fromJson(fileReader2, Movie.class);
                System.out.println("MOVIE 2: TITLE -> " + movie2.getTitle() + " DURATION: " + movie2.getDuration());
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            }

            Movie movie3 = new Movie("Fast & Furious", 180);
            Movie movie4 = new Movie("Mortadelo y Filemon", 120);

            try (FileOutputStream fileOutputStream = new FileOutputStream("outputStream1.txt")){
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(movie3);
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            }
            try (FileOutputStream fileOutputStream1 = new FileOutputStream("outputStream2.txt")){
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream1);
                objectOutputStream2.writeObject(movie4);
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            }
        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {

        public static void main(String[] args) {
            try (FileInputStream fileInputStream = new FileInputStream("outputStream1.txt")){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Movie movie3 = (Movie) objectInputStream.readObject();
                System.out.println("MOVIE 1: " + movie3);
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try(FileInputStream fileInputStream2 = new FileInputStream("outputStream2.txt")){
                ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
                Movie movie4 = (Movie) objectInputStream2.readObject();
                System.out.println("MOVIE 2: " + movie4);
            } catch (IOException e){
                System.out.println("ERROR: " + e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}