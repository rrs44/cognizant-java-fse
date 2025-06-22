import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

  
}

class SearchProds {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null; 
    }

   
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null; 
    }
}

public class EcommerceSearchDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Keyboard", "Accessories")
        };

        System.out.println("All Products:");
        for (Product p : products) {
            System.out.println(p);
        }

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nSearch Results:- ");

        String searchName1 = "Phone";
        Product result1 = SearchProds.linearSearch(products, searchName1);
        System.out.println("Linear Search for \"" + searchName1 + "\": " + (result1 != null ? result1 : "Not Found"));

        String searchName2 = "Phone";
        Product result2 = SearchProds.binarySearch(sortedProducts, searchName2);
        System.out.println("Binary Search for \"" + searchName2 + "\": " + (result2 != null ? result2 : "Not Found"));

        String searchName3 = "Watch";
        Product result3 = SearchProds.linearSearch(products, searchName3);
        System.out.println("Linear Search for \"" + searchName3 + "\": " + (result3 != null ? result3 : "Not Found"));

        Product result4 = SearchProds.binarySearch(sortedProducts, searchName3);
        System.out.println("Binary Search for \"" + searchName3 + "\": " + (result4 != null ? result4 : "Not Found"));
    }
}
