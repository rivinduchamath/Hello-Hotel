package lk.sliit.employeeManagement.entity.kitchen;

import lk.sliit.employeeManagement.entity.banquet.BanquetOrder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    private String menuId;
    private String name;
    private String type;
    private double unitPrice;
    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<BanquetOrder> banquetOrders = new ArrayList<>();
    @ManyToMany(mappedBy = "menus")
    private List<FoodItem> foodItems = new ArrayList<>();

    public Menu() {
    }

    public Menu(String menuId, String name, String type, double unitPrice) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
        this.unitPrice = unitPrice;
    }
}
