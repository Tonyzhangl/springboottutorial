package com.kirago.chapter06.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "goodz_info")
public class Goodz implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "tg_id")
    private Long id;

    @Column(name = "tg_title")
    private String title;

    @Column(name = "tg_price")
    private double price;

    @Column(name = "tg_unit")
    private String unit;

    @Column(name = "tg_order")
    private int order;

    @OneToOne
    @JoinColumn(name = "tg_type_id")
    private GoodzType type;
}
