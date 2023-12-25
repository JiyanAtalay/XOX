
package com.mycompany.xox;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Oyun extends JPanel implements ActionListener,MouseListener{
    public tahta[][] isaretler = new tahta[3][3];
    int sayac = 0;
    Timer timer = new Timer(0, this);
    
    public void kontrol(){
        if(isaretler != null){


            String message = "";
            boolean flag = false;
            for(int i = 0;i<3;i++){
                if(isaretler[i][0] instanceof x && isaretler[i][1] instanceof x && isaretler[i][2] instanceof x){
                    flag = true;
                    message = "Kazanan taraf X\nTebrikler\n";
                }
                else if(isaretler[i][0] instanceof o && isaretler[i][1] instanceof o && isaretler[i][2] instanceof o){
                    flag = true;
                    message = "Kazanan taraf O\nTebrikler\n";
                }
                else if(isaretler[0][i] instanceof x && isaretler[1][i] instanceof x && isaretler[2][i] instanceof x){
                    flag = true;
                    message = "Kazanan taraf X\nTebrikler\n";
                }
                else if(isaretler[0][i] instanceof o && isaretler[1][i] instanceof o && isaretler[2][i] instanceof o){
                    flag = true;
                    message = "Kazanan taraf 0\nTebrikler\n";
                }
                else if(isaretler[0][0] instanceof x && isaretler[1][1] instanceof x && isaretler[2][2] instanceof x){
                    flag = true;
                    message = "Kazanan taraf X\nTebrikler\n";
                }
                else if(isaretler[0][0] instanceof o && isaretler[1][1] instanceof o && isaretler[2][2] instanceof o){
                    flag = true;
                    message = "Kazanan taraf 0\nTebrikler\n";
                }
                else if(isaretler[2][0] instanceof x && isaretler[1][1] instanceof x && isaretler[0][2] instanceof x){
                    flag = true;
                    message = "Kazanan taraf X\nTebrikler\n";
                }
                else if(isaretler[2][0] instanceof o && isaretler[1][1] instanceof o && isaretler[0][2] instanceof o){
                    flag = true;
                    message = "Kazanan taraf 0\nTebrikler\n";
                }
            }
            if(flag){
                try {
                    Thread.sleep(750);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                }
                timer.stop();
                
                JOptionPane.showMessageDialog(this, message);

                System.exit(0);
            }
        }
    }
    
    private BufferedImage image;
    
    public Oyun() {
        setBackground(Color.WHITE);
        timer.start();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursorImage = toolkit.getImage("x.png");
        cursorImage = cursorImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");

        this.setCursor(customCursor);
        
    }
    
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        g.setColor(Color.BLACK);
        
        g.drawLine(0,200, 600, 200);
        g.drawLine(0, 400, 600, 400);
        
        g.drawLine(200, 0, 200, 600);
        g.drawLine(400, 0, 400, 600);
        
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(isaretler[i][j] instanceof x){
                    try {
                        image = ImageIO.read(new FileImageInputStream(new File("x.png")));
                        
                        g.drawImage(image, (i+1)*200-200, (j+1)*200-200, 190, 190, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(isaretler[i][j] instanceof o){
                    try {
                        image = ImageIO.read(new FileImageInputStream(new File("o.png")));
                        
                        g.drawImage(image, (i+1)*200-200, (j+1)*200-200, 190, 190, this);
                    } catch (IOException ex) {
                        Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        //kontrol();
    }
    
    @Override
    public void repaint() {
        super.repaint(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        kontrol();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        boolean flag = false;
        
        if(sayac%2==0){
            if(e.getButton() == e.BUTTON1){
                if(x<=200){
                    if(y<=200 && isaretler[0][0] == null){
                        isaretler[0][0] = new x();
                        flag = true;
                    }
                    else if(y>200 && y<=400 && isaretler[0][1] == null){
                        isaretler[0][1] = new x();
                        flag = true;
                    }
                    else if(y>400 && y<=600 && isaretler[0][2] == null){
                        isaretler[0][2] = new x();
                        flag = true;
                    }
                }
                else if(x>200 && x<=400){
                    if(y<=200 && isaretler[1][0] == null){
                        isaretler[1][0] = new x();
                        flag = true;
                    }
                    else if(y>200 && y<=400 && isaretler[1][1] == null){
                        isaretler[1][1] = new x();
                        flag = true;
                    }
                    else if(y>400 && y<=600 && isaretler[1][2] == null){
                        isaretler[1][2] = new x();
                        flag = true;
                    }
                }
                else if(x>400 && x<=600){
                    if(y<=200 && isaretler[2][0] == null){
                        isaretler[2][0] = new x();
                        flag = true;
                    }
                    else if(y>200 && y<=400 && isaretler[2][1] == null){
                        isaretler[2][1] = new x();
                        flag = true;
                    }
                    else if(y>400 && y<=600 && isaretler[2][2] == null){
                        isaretler[2][2] = new x();
                        flag = true;
                    }
                }
                if(flag){
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("o.png");
                    cursorImage = cursorImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");

                    this.setCursor(customCursor);
                    sayac++;
                }
            }
        }
        else if(sayac%2==1){
            if(e.getButton() == e.BUTTON1){
                if(x<=200){
                    if(y<=200 && isaretler[0][0] == null){
                        isaretler[0][0] = new o();
                        flag = true;
                    }
                    else if(y>200 && y<=400 && isaretler[0][1] == null){
                        isaretler[0][1] = new o();
                        flag = true;
                    }
                    else if(y>400 && y<=600 && isaretler[0][2] == null){
                        isaretler[0][2] = new o();
                        flag = true;
                    }
                }
                else if(x>200 && x<=400){
                    if(y<=200 && isaretler[1][0] == null){
                        isaretler[1][0] = new o();
                        flag = true;
                    }
                    else if(y>200 && y<=400 && isaretler[1][1] == null){
                        isaretler[1][1] = new o();
                        flag = true;
                    }
                    else if(y>400 && y<=600 && isaretler[1][2] == null){
                        isaretler[1][2] = new o();
                        flag = true;
                    }
                }
                else if(x>400 && x<=600){
                    if(y<=200 && isaretler[2][0] == null){
                        isaretler[2][0] = new o();
                        flag = true;
                    }
                    else if(y>200 && y<=400 && isaretler[2][1] == null){
                        isaretler[2][1] = new o();
                        flag = true;
                    }
                    else if(y>400 && y<=600 && isaretler[2][2] == null){
                        isaretler[2][2] = new o();
                        flag = true;
                    }
                }
                if(flag){
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("x.png");
                    cursorImage = cursorImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");

                    this.setCursor(customCursor);
                    sayac++;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
