package FurnitureStore.customer;

import FurnitureStore.models.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    private static ObservableList<CartItem> cart = FXCollections.observableArrayList();

    public static void add(CartItem i){
        cart.add(i);
    }

    public static void remove(CartItem i){
        cart.remove(i);
    }

    public static ObservableList<CartItem> getCart(){
        return cart;
    }
}
