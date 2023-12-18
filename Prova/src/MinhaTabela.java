
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Francisco Pomba
 */
public class MinhaTabela extends JTable{
    public MinhaTabela(){
        getTableHeader().setDefaultRenderer(new MinhaTabelaHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, new MinhaTabelaCells());
        
    }
    private class MinhaTabelaHeader extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(30,30,30));
            com.setForeground(new Color(200,200,200));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            return com;
        }
    }
    public void fixarTabela(JScrollPane scroll){
        scroll.setVerticalScrollBar(new VerticalScrollBarCustom());
        JScrollPane pane = new JScrollPane();
        //Pane.setBackground(new Color(30,30,30));
        //pane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pane);
        
    
    
    }
    private class MinhaTabelaCells extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            if(isCellSelected(row, column)){
                if(row % 2==0){
                   com.setBackground(new Color(33,103,153));
                }else{
                    com.setBackground(new Color(29,86,129));
                }
            
            }else{
                if(row % 2==0){
                   com.setBackground(new Color(50,50,50));
                }else{
                    com.setBackground(new Color(30,30,30));
                }
            }
            com.setForeground(new Color(200,200,200));
            setBorder(new EmptyBorder(0,5,0,5));
            
            
            return com;
        }
        
    
    
    
    }
    private class VerticalScrollBarCustom extends JScrollBar{
        public VerticalScrollBarCustom(){
            setUI(new ModernScrollBarUI());
            setPreferredSize(new Dimension(8,8));
            setForeground(new Color(48,144,216));
            setBackground(new Color(30,30,30));
        }
    
    
    }
    private class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 80;

    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected JButton createDecreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int height;
        if (orientation == JScrollBar.VERTICAL) {
            size = rctngl.width / 2;
            x = rctngl.x + ((rctngl.width - size) / 2);
            y = rctngl.y;
            width = size;
            height = rctngl.height;
        } else {
            size = rctngl.height / 2;
            y = rctngl.y + ((rctngl.height - size) / 2);
            x = 0;
            width = rctngl.width;
            height = size;
        }
        g2.setColor(scrollbar.getBackground());
        g2.fillRect(x, y, width, height);
    }

    @Override
    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rctngl.x;
        int y = rctngl.y;
        int width = rctngl.width;
        int height = rctngl.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 10, 10);
    }

    private class ScrollBarButton extends JButton {

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {
        }
    }
}
}
