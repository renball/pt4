/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.points;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author q
 */
@Entity
public class MyPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id = -1;
    int x=0, y=0;


    
    public MyPoint() {
    }
    public MyPoint(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public int getId() {
        return id;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move (int x, int y){
        this.x = x;
        this.y = y;
    }

    public MyPoint (int x, int y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
