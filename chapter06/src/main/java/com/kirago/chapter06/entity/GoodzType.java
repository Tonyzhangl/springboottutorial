package com.kirago.chapter06.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "goodz_type")
public class GoodzType implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "tgt_id")
    private Long id;

    @Column(name = "tgt_name")
    private String name;

    @Column(name = "tgt_is_show")
    private int isShow;

    @Column(name = "tgt_order")
    private int order;
}
