package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Product")
@Getter
@Setter
public class Product {
    
    @Id
    @Column(name="p_id")
    private int pid;

    @Column(name="p_name")
    private String pname;

    @Column(name="p_price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "c_id")  
    @JsonBackReference
    private Category cat;

    public Product() {
    }

    public Product(int pid, String pname, float price, Category cat) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", cat=" + cat + "]";
    }


    

    
}
