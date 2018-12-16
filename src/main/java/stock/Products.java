package stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {
    private Item[] products;

    public Map<String,Double> getAllProducts(){
        Map<String,Double> productList = new HashMap<>();

        for(int i = 0; i < products.length; i++){
            productList.put(products[i].getTitle(), products[i].getItemPrice());
        }
        //System.out.println("product list" + productList);
        return productList;
    }



}
