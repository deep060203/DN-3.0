public class LinearSearch {
    public static Product linearSearch(Product[] products, Integer productId, String productName, String category) {
        for (Product product : products) {
            boolean matches = true;
            if (productId != null && product.getProductId() != productId) {
                matches = false;
            }
            if (productName != null && !product.getProductName().equalsIgnoreCase(productName)) {
                matches = false;
            }
            if (category != null && !product.getCategory().equalsIgnoreCase(category)) {
                matches = false;
            }
            if (matches) {
                return product;
            }
        }
        return null;
    }
}

