package fuerNix;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAPI {
    public static void main(String[] args) throws MalformedURLException {
        //https://cat-fact.herokuapp.com/facts
        //https://www.campus02.at/
        URL myUrl = new URL("https://www.campus02.at/");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(myUrl.openStream()))){
            System.out.println("bis.read() = " + br.readLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
