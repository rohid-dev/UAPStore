package sample;

import sample.models.CartItem;
import sample.models.Product;

import java.util.ArrayList;

public class Cart {
    ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
    Double totalPrice;

    public Cart(){
        calculateTotalPrice();
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
        calculateTotalPrice();
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public Integer getCartItemCount(){
        int c = 0;
        for(CartItem cartItem: cartItems){
            c+= cartItem.getQuantity();
        }
        return c;
    }

    public CartItem getCartItem(String id){
        for(CartItem cartItem: cartItems){
            if(cartItem.getProduct().getId().equals(id)){
                return cartItem;
            }
        }
        return null;
    }

    public void addCartItem(Product product, int increaseBy){
        CartItem cartItem = getCartItem(product.getId());
        if(cartItem != null){
            cartItem.increaseQuantity(increaseBy);
            calculateTotalPrice();
            return;
        }
        cartItems.add(new CartItem(product, increaseBy));
        calculateTotalPrice();
    }

    public void removeCartItem(CartItem cartItem){
        this.cartItems.remove(cartItem);
        calculateTotalPrice();
    }

    public void removeCartItem(String id, int decreaseBy){
        CartItem cartItem = getCartItem(id);
        cartItem.decreaseQuantity(decreaseBy);
        calculateTotalPrice();
    }

    public void removeCartItem(String id){
        removeCartItem(getCartItem(id));
        calculateTotalPrice();
    }

    public void removeAll(){
        this.cartItems.clear();
        calculateTotalPrice();
    }

    public void calculateTotalPrice(){
        this.totalPrice = 0.0;
        for(CartItem cartItem: cartItems){
            this.totalPrice += cartItem.getTotalPrice();
        }
    }

    public Double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public void buyAllItems(){
        for(CartItem cartItem: cartItems){
            System.out.println(cartItem.getId());
            Main.store.setProductQuantity(cartItem.getProduct().getId(), cartItem.getProduct().getQuantity() - cartItem.getQuantity());
        }
        this.removeAll();
        Main.storage.storeData();
    }
}
