package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import snacker.Snackers;
import stock.Products;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Snackers[] snackers = getSnackerList();
        Map<String,String> emailAndFaveSnack = getEmailAndFaveSnk(snackers);
        Products products = getStockList();
        Map<String,Double> itemAndPrice = products.getItemAndPrice();
        findMatchedSnackers(itemAndPrice, emailAndFaveSnack);
    }

    public static Snackers[] getSnackerList(){
        String url = "https://s3.amazonaws.com/misc-file-snack/MOCK_SNACKER_DATA.json";

        try(InputStream inputStream = new URL(url).openStream();
            InputStream reader = new BufferedInputStream(inputStream)){

            int data = reader.read();
            StringBuffer buffer = new StringBuffer();
            while(data != -1){
                buffer.append((char) data);
                data = reader.read();
            }
            String jsonData = buffer.toString();

            Snackers[] snackers = new GsonBuilder().create().fromJson(jsonData, Snackers[].class);
            return snackers;

        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }


    public static Products getStockList(){

        String url = "https://ca.desknibbles.com/products.json?limit=250";

        try(InputStream inputStream = new URL(url).openStream();
            InputStream reader = new BufferedInputStream(inputStream)){

            int data = reader.read();
            StringBuffer buffer = new StringBuffer();
            while(data != -1){
                buffer.append((char) data);
                data = reader.read();
            }
            String jsonData = buffer.toString();

            Products products = new Gson().fromJson(jsonData, Products.class);
            return products;


        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public static Map<String,String> getEmailAndFaveSnk(Snackers[] snackers){
        Map<String,String> snackerEmailAndSnack = new HashMap<>();

        for(int i = 0; i < snackers.length; i++){
            snackerEmailAndSnack.put(snackers[i].getEmail(), snackers[i].getFave_snack());
        }
        //System.out.println(snackerEmailAndSnack);
        return snackerEmailAndSnack;

    }

    public static void findMatchedSnackers(Map<String,Double> stockList, Map<String,String> emailsAndFaveSnackList){

        List<String> faveSnackerEmails = new ArrayList<>();
        Set<String> matchedSnackList = new HashSet<>();
        double totalPrice = 0;

        for(Map.Entry<String,String> entry : emailsAndFaveSnackList.entrySet()){
            if(stockList.containsKey(entry.getValue())){
                totalPrice += stockList.get(entry.getValue());
                //System.out.println(totalPrice);

                String matchedSnack = entry.getValue();
                faveSnackerEmails.add(entry.getKey()); //adds email to the list
                matchedSnackList.add(matchedSnack); //adds matched fave snack without duplicates
            }
        }

        System.out.println("List of stocked snacks that matched with fave snacks" + matchedSnackList);
        System.out.println("Emails of snackers who listed above as fave snack " + faveSnackerEmails);
        System.out.println("Total price " + totalPrice);

    }
}
