package com.newexample.awtWindow;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mywindow extends Frame {
    public Mywindow(String title) throws HeadlessException {
        super(title);
        setSize(600,700);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g){
        super.paint(g);
        Font sansSerifLarge=new Font("SanSerif",Font.BOLD,18);
        Font sansSerifSmall=new Font("SanSerif",Font.BOLD,12);

        g.setFont(sansSerifLarge);
        g.setColor(Color.red);
        g.drawString("Ankit Raut",80,150);
        g.setFont(sansSerifSmall);
        g.drawString("-Legend",120,160);


    }

}
