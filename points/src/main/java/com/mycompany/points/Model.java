/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.points;
import java.util.ArrayList;
/**
 *
 * @author q
 */
public class Model {

    /**
     * @param args the command line arguments
     */
    ArrayList<MyPoint> myPoints = new ArrayList<>();
    ArrayList<IObserver> observers = new ArrayList<>();

    DB_hibernate db_h;
    void refresh(){
        for(IObserver o: observers){
            o.refresh();
        }
    }

    public Model() {
    }
    
    public void init(DB_hibernate db) {
        this.db_h = db;
        
        setAllPoints(db.getAllPoint_h());
    }
    
    
    public void setAllPoints(ArrayList<MyPoint> myPoints){
        this.myPoints = myPoints;
        refresh();
    }

    public void addObserver(IObserver o){
        observers.add(o);
    }
    public void addPoints(MyPoint mp){
        myPoints.add(mp);
        if(this.db_h!=null){
            this.db_h.addPointToBD_h(mp);
        }
        refresh();
    }

    public void move(MyPoint mp){        
        myPoints.get(myPoints.size()-1).move(mp.getX(),mp.getY());
        if(this.db_h!=null){
            this.db_h.movePointToBD_h(myPoints.get(myPoints.size()-1));
        }
        refresh();
    }

    public ArrayList<MyPoint> getMyPoints() {
        return myPoints;
    }

}
