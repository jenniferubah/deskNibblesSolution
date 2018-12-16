package stock;

import java.util.Date;

public class Item {
    private double id;
    private String title;
    private String handle;
    private String body_html;
    private Date published_at;
    private Date created_at;
    private Date updated_at;
    private String vendor;
    private String product_type;
    private String[] tags;
    private Variant[] variants;
    private Image[] images;
    private Option[] options;

    public double getItemPrice() {

        double itemPrice = 0;
        for(int i = 0; i < variants.length; i++){
            itemPrice = variants[i].getPrice();
        }
        //System.out.println(itemPrice);
        return itemPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getProduct_type() {
        return product_type;
    }
}
