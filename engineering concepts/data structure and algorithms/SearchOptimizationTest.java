import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
    
    @Override
    public String toString() {
        return productId + ": " + productName + " (" + category + ")";
    }
}

public class SearchOptimizationTest {
    public static void main(String[] args) {
        System.out.println("--- Asymptotic Notation & Scenarios ---");
        System.out.println("Big O notation defines the upper bound of an algorithm's time complexity, helping us evaluate performance at scale.");
        System.out.println("Linear Search -> Best: O(1) | Average: O(n) | Worst: O(n)");
        System.out.println("Binary Search -> Best: O(1) | Average: O(log n) | Worst: O(log n)");
        
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Smartphone", "Electronics"),
            new Product(109, "Desk Chair", "Furniture"),
            new Product(102, "Coffee Maker", "Appliances"),
            new Product(107, "Headphones", "Accessories")
        };

        int targetId = 109;

        System.out.println("\n--- Linear Search Execution ---");
        Product foundLinear = linearSearch(products, targetId);
        System.out.println("Result: " + foundLinear);

        System.out.println("\n--- Binary Search Execution ---");
        Arrays.sort(products);
        Product foundBinary = binarySearch(products, targetId);
        System.out.println("Result: " + foundBinary);

        System.out.println("\n--- Complexity Analysis ---");
        System.out.println("Binary search O(log n) is vastly faster than Linear Search O(n) as datasets grow.");
        System.out.println("For a professional e-commerce platform with millions of products, Binary Search is the only suitable choice for performance.");
    }

    public static Product linearSearch(Product[] arr, int targetId) {
        for (Product p : arr) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] arr, int targetId) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].productId == targetId) {
                return arr[mid];
            }
            if (arr[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
