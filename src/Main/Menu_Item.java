
package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

public class Menu_Item extends javax.swing.JPanel {

    public void setShowing(boolean showing){
        this.showing = showing;
    }
    public ArrayList<Menu_Item> getSubMenu() {
        return subMenu;
    }
    private final ArrayList<Menu_Item> subMenu = new ArrayList<>();
    private ActionListener act;
    private boolean active = false;
    
    public Menu_Item(Icon icon, boolean sbm, Icon iconSub, String menuName, ActionListener act, Menu_Item... subMenu) {
        initComponents();
        
        lb_icon.setIcon(icon);
        lb_menuName.setText(menuName);
        lb_iconSub.setIcon(iconSub);
        lb_iconSub.setVisible(sbm);
        
        if(act != null){
            this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
        for(int i = 0; i<subMenu.length;i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
        
    }
    public void setAction(ActionListener act) {
    this.act = act;
    }
    public void setActive(boolean active) {
    this.active = active;
    if (active) {
        setBackground(new Color(229, 231, 235)); // abu-abu muda
        lb_menuName.setForeground(new Color(17, 24, 39)); // hitam soft
    } else {
        setBackground(Color.WHITE);
        lb_menuName.setForeground(Color.BLACK);
    }
    repaint();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_menuName = new javax.swing.JLabel();
        lb_iconSub = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lb_menuName.setText("Menu Item...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lb_menuName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_menuName, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lb_iconSub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        setBackground(new java.awt.Color(255,255,255));
        if(showing){
            hideMenu();
        }else{
            showMenu();
        }
        if(act != null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_iconSub;
    private javax.swing.JLabel lb_menuName;
    // End of variables declaration//GEN-END:variables

    private void hideMenu() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = subMenu.size()-1; i>=0; i--){
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }
    private void showMenu() {
         new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = subMenu.size()-1; i>=0; i--){
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }
    private void sleep(){
        try{
            Thread.sleep(20);
        }catch(Exception e){   
        }
    }
     @Override
    protected void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    if (active) {
        g.setColor(new Color(107, 114, 128)); // abu-abu gelap
        g.fillRect(0, 0, 4, getHeight());
    }
}
}
