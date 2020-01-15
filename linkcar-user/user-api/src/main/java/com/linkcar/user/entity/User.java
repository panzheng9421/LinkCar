package com.linkcar.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3363260953098591076L;

    private Integer id;

    private String name;

}