/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Matr;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author andrey
 */
public class TableCellRenderer extends JLabel implements javax.swing.table.TableCellRenderer  {
    private final Fragment frag;
    private final Matrix matr;

    TableCellRenderer(Fragment f,Matrix matr) {
        setHorizontalTextPosition(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
        this.frag = f;
        this.matr = matr;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row>=frag.i && row<=frag.i1 && column>=frag.j && column <=frag.j1)
            setBackground(Color.RED);
        else
            setBackground(Color.WHITE);
        setText(Integer.toString(matr.getValue(row, column)));
        return this;
    }

    
}
