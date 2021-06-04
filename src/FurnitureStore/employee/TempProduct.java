package FurnitureStore.employee;

public class TempProduct {

    private static int productId;
    private static int productCategory;
    private static String productMaterial;
    private static Double productPrice;
    private static String productSize;
    private static String productDescription;
    private static int availableProductAmount;

    public static int getProductId() {
        return productId;
    }

    public static void setProductId(int _productId) {
        productId = _productId;
    }

    public static int getProductCategory() {
        return productCategory;
    }

    public static void setProductCategory(int _productCategory) {
        productCategory = _productCategory;
    }

    public static String getProductMaterial() {
        return productMaterial;
    }

    public static void setProductMaterial(String _productMaterial) {
        productMaterial = _productMaterial;
    }

    public static Double getProductPrice() {
        return productPrice;
    }

    public static void setProductPrice(Double _productPrice) {
        productPrice = _productPrice;
    }

    public static String getProductSize() {
        return productSize;
    }

    public static void setProductSize(String _productSize) {
        productSize = _productSize;
    }

    public static String getProductDescription() {
        return productDescription;
    }

    public static void setProductDescription(String _productDescription) {
        productDescription = _productDescription;
    }

    public static int getAvailableProductAmount() {
        return availableProductAmount;
    }

    public static void setAvailableProductAmount(int _availableProductAmount) {
        availableProductAmount = _availableProductAmount;
    }
}
