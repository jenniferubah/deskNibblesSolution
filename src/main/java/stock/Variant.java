package stock;

import java.util.Date;

public class Variant {
    private double id;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String sku;
    private boolean requires_shipping;
    private boolean taxable;
    private FeaturedImage[] featured_images; //maybe a list instead of an array?
    private boolean available;
    private double price;
    private int grams;
    private double compare_at_price;
    private int postion;
    private double product_id;
    private Date created_at;
    private Date updated_at;


    public double getPrice() {
        //System.out.println(price);
        return price;
    }

}
