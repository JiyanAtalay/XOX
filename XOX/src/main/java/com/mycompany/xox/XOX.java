
package com.mycompany.xox;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class XOX extends JFrame{
public XOX(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        XOX ekran = new XOX("XOX Oyunu");
        
        ekran.setResizable(false);
        ekran.setFocusable(false);
        
        ekran.setSize(600, 600);
        
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Oyun oyun = new Oyun();
        
        oyun.requestFocus();
        
        oyun.addMouseListener(oyun);
        
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        
        ekran.add(oyun);
        
        ekran.setVisible(true);
    }
}
