/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcodeday7;

import java.util.ArrayList;

/**
 *
 * @author ShokoBanana
 */
public class Tower {
    
    private String towerName;
    private int id;
    private ArrayList<Tower> towers = new ArrayList<Tower>();;
    
    public Tower(String name, int _id){
        towerName = name;
        id = _id;
    }
    
    public Tower(String name){
        towerName = name;
        id = -1;
    }
    
    public String getTowerName(){
        return towerName;
    }
    
    public int getId(){
        return id;
    }
    
    public void addToTowerList(Tower tower){
        towers.add(tower);
    }
    
    public ArrayList<Tower> getTowerList(){
        return towers;
    }
    
    @Override
    public String toString(){
        String nested = "";
        for(int i = 0; i < towers.size(); i++){
            nested += towers.get(i).toString() + " ";
        }
        String ans = "The tower " + towerName + " with ID " + id;
        ans += nested.length() != 0 ? " has the following nested towers " + nested : "";
        return  ans;
    }
}
