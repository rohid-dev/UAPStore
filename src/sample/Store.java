package sample;

import sample.models.ClothingProduct;
import sample.models.ElectronicProduct;
import sample.models.FoodProduct;
import sample.models.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
    ArrayList<Product> products = new ArrayList<Product>();

    public Store(ArrayList<Product> products){
        this.products = products;
    }

    public Store(){}

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void addFoodProduct(String name, Double price, LocalDate expirationDate, FoodProduct.SubCategory subCategory, int quantity, int percentage){
        FoodProduct foodProduct = new FoodProduct(name, price, expirationDate, subCategory, quantity, percentage);
        this.products.add(foodProduct);
    }

    public void addFoodProduct(FoodProduct foodProduct){
        this.products.add(foodProduct);
    }

    public void addElectronicProduct(String name, Double price, ElectronicProduct.SubCategory subCategory, int quantity, int percentage){
        ElectronicProduct electronicProduct = new ElectronicProduct(name, price, subCategory, quantity, percentage);
        this.products.add(electronicProduct);
    }
    public void addElectronicProduct(ElectronicProduct electronicProduct){
        this.products.add(electronicProduct);
    }

    public void addClothingProduct(String name, Double price, ClothingProduct.SubCategory subCategory, int quantity, int percentage){
        ClothingProduct clothingProduct = new ClothingProduct(name, price, subCategory, quantity, percentage);
        this.products.add(clothingProduct);
    }
    public void addClothingProduct(ClothingProduct clothingProduct){
        this.products.add(clothingProduct);
    }

    public void addProducts(ArrayList<Product> products){
        this.products.addAll(products);
    }

    public Product getProduct(String id){
        for(Product product: products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
    public void setProductQuantity(String id, int quantity){
        for(Product product: products){
            if(product.getId().equals(id)){
                product.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(String id){
        this.products.remove(getProduct(id));
        Main.storage.storeData();
    }

    public void removeProducts(ArrayList<Product> products){
        this.products.removeAll(products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void clear(){
        this.products.clear();
    }

    public ArrayList<Product> getAllFoodProducts(){
        ArrayList<Product> foodProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getCategory() == Product.Category.Food){
                foodProducts.add(product);
            }
        }
        return foodProducts;
    }

    public ArrayList<Product> getAllElectronicProducts(){
        ArrayList<Product> eletronicProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getCategory() == Product.Category.Electronic){
                eletronicProducts.add(product);
            }
        }
        return eletronicProducts;
    }

    public ArrayList<Product> getAllClothingProducts(){
        ArrayList<Product> clothingProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getCategory() == Product.Category.Clothing){
                clothingProducts.add(product);
            }
        }
        return clothingProducts;
    }

}
