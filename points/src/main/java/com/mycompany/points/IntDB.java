/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.points;

import java.util.ArrayList;

/**
 *
 * @author q
 */
public interface IntDB {
    ArrayList<MyPoint> getAllPoint_h();
    public void addPointToBD_h (MyPoint mp);
    public void movePointToBD_h (MyPoint mp);
}
