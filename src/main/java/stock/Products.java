package stock;

import java.util.HashMap;
import java.util.Map;

public class Products {
    private Item[] products;

    public Map<String,Double> getItemAndPrice(){
        Map<String,Double> productList = new HashMap<>();

        for(int i = 0; i < products.length; i++){
            productList.put(products[i].getTitle(), products[i].getItemPrice());
        }
        //System.out.println("product list" + productList);
        return productList;
    }



}
