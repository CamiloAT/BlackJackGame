package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class MyTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }

   

    private Icon prefixIcon;
    private String hint = "Nombre Jugador";

    public MyTextField() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 65, 10, 10));
        setBackground(new Color(0, 0, 0, 0));
        setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
//        setSelectionColor(new Color(17, 130, 65));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(249,239,230,255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        paintIcon(g);
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(26, 25, 61));
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
//        prefixIcon= new ImageIcon(getClass().getResource("/resources/cartas-de-poquer.png"));
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 15, y, this);
        }
       
    }

    private void initBorder() {
        int left = 0;
        int right = 15;
        //  5 is default
        if (prefixIcon != null) {
            //  prefix is left
            left = prefixIcon.getIconWidth() +30;
        }
               setBorder(javax.swing.BorderFactory.createEmptyBorder(10, left, 10, right));
    }
}