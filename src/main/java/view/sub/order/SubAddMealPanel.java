/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import java.util.List;


/**
 *
 * @author Admin
 */
public class SubAddMealPanel extends javax.swing.JPanel {
    
    public static final int MAX_COMPONENT_AMOUNT = 18;
    private int currentAmount = 0;
    
    private final List<MealPanel> mealPanels ;
    

    /**
     * Creates new form SubAddMealPanel
     */
    public SubAddMealPanel() {
        mealPanels = null;
        initComponents();
    }
    
    public SubAddMealPanel(List<MealPanel> mealPanels){
        this.mealPanels = mealPanels;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
    }// </editor-fold>//GEN-END:initComponents

    
    
    public boolean addComponent(MealPanel mealPanel){
        boolean b = false;
        if(currentAmount< MAX_COMPONENT_AMOUNT){
            this.add(mealPanel);
            currentAmount++;
            b = true;
            this.validate();
            this.repaint();
        }
        return b;
    }
    
    public boolean addComponens(List<MealPanel> mealPanels){
        boolean b = false;
        if((mealPanels.size() + this.getCurrentAmount()) <= 18 ){
            mealPanels.forEach(t -> {
                this.add((MealPanel)t);
                currentAmount++;     
            });
            b = true;
            this.validate();
            this.repaint();
        }
        return b;
    }
    
    public int getCurrentAmount(){
        return this.currentAmount;
    }
    
    //public setListMeal
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
