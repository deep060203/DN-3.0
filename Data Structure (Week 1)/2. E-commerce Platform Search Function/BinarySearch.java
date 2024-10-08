import java.util.Comparator;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String productName, Comparator<Product> comparator) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = comparator.compare(products[mid], new Product(0, productName, ""));

            if (result == 0) {
                return products[mid];
            }
            if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

