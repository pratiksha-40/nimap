package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Category")
@Getter
@Setter
public class Category {


    @Id
    @Column(name="c_id")
    private int cid;

    @Column(name="c_name")
    private String cname;

    @Column(name="c_desc")
    private String cdesc;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "cat" )
    @JsonManagedReference
    private List<Product> pp = new ArrayList<>();

    public Category() {
    }

    public Category(int cid, String cname, String cdesc, List<Product> pp) {
        this.cid = cid;
        this.cname = cname;
        this.cdesc = cdesc;
        this.pp = pp;
    }

    @Override
    public String toString() {
        return "Category [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc + ", pp=" + pp + "]";
    }

    

}
