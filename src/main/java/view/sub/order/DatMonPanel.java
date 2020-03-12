/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import entities.Employee;
import entities.Order;
import entities.Table;
import entities.TableStatus;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.ProductOrderTableModel;
import service.table.TableService;
import service.table.TableServiceImpl;

/**
 *
 * @author Admin
 */
public class DatMonPanel extends javax.swing.JPanel {

    TablePanel tablePanel = new TablePanel();
    InformationPanel informationPanel = new InformationPanel();
    ProductOrderTableModel productOrderTableModel;
    private final Table selectedTable; 
    private final TableService tableService;
    JButton[] buttonTables;
    JTable tableOrdered;
    JLabel labelTableName;
    String nameTable;
    private JButton selectedButton;
    /**
     * Creates new form DatMonPanel
     */
    public DatMonPanel() {
        selectedTable = new Table();
        tableService = new TableServiceImpl();
        initComponents();
        setPnLeft();
        setPnRight();
        initEvents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        pnLeft = new javax.swing.JPanel();
        pnRight = new javax.swing.JPanel();

        setLayout(new javax.swing.OverlayLayout(this));

        jSplitPane1.setDividerLocation(700);

        pnLeft.setLayout(new javax.swing.OverlayLayout(pnLeft));
        jSplitPane1.setLeftComponent(pnLeft);

        pnRight.setLayout(new javax.swing.OverlayLayout(pnRight));
        jSplitPane1.setRightComponent(pnRight);

        add(jSplitPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnRight;
    // End of variables declaration//GEN-END:variables

    private void setPnLeft() {
        pnLeft.add(tablePanel);
        //InformationPanel informationPanel = new InformationPanel();
        //pnLeft.add(informationPanel);
    }
    
    private void setPnRight(){      
        pnRight.add(informationPanel);
    }
    
    private void initEvents(){
        initEventTableOfTablePanel();
        btAddEvent();
        
    }
    
    private void initEventTableOfTablePanel(){
        buttonTables = tablePanel.getTables();
        tableOrdered = informationPanel.getTableFromInformationPanel();
        labelTableName = informationPanel.getLabelFromInformationPanel();
        for (JButton btTable : buttonTables) {
            btTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    nameTable = btTable.getText().trim();
                    
                    selectedButton = btTable;
                    selectedTable.copy(tableService.getOne(nameTable));
                    Integer idStatus = selectedTable.getStatus().getId();
                    if(idStatus == TableStatus.EMPTY || idStatus == TableStatus.ORDERED){
                        Order order = new Order();
                        order.setId_Order(0);
                        order.setTable(selectedTable);
                        new AddMealDialog(DatMonPanel.this, true, order).setVisible(true);
                    }if(idStatus == TableStatus.FULL ){
                        informationPanel.getbtAdd().setEnabled(true);
                        Integer idOrder = Integer.parseInt(selectedButton.getActionCommand());
                        productOrderTableModel = new ProductOrderTableModel(tableOrdered, idOrder);
                        productOrderTableModel.loadDataTable();
                        
                    }
                    labelTableName.setText("Bàn "+nameTable);
                }
            });
        }
    }

    private void btAddEvent() {
        final JButton btAdd = informationPanel.getbtAdd();
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(btAdd.isEnabled()){
                    Integer idOrder = Integer.parseInt(selectedButton.getActionCommand()); 
                    Order order = new Order();
                    order.setId_Order(idOrder);
                    order.setTable(selectedTable);
                    new AddMealDialog(DatMonPanel.this, true, order).setVisible(true);
                }
               
            }
            
        });
    }
    
    public JButton getSelectedButton(){
        return selectedButton;
    }
}
