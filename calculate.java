import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class calculate extends JFrame implements ActionListener {
  static JFrame fr;
  static JTextField tf;

  String s0, s1, s2;

  calculate() {
    s0 = s1 = s2 = "";
  }

  public static void main(String args[]) {

    fr = new JFrame("My Calculator With Thiraphat");

    calculate cl = new calculate();

    tf = new JTextField(100);
  

    tf.setEditable(false);

    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bp, bm, bs, bd, bnull, beq, bdot, bmod ;

    // number of Button
    b0 = new JButton("0");
    b1 = new JButton("1");
    b2 = new JButton("2");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("9");

    bp = new JButton("+");
    bm = new JButton("-");
    bs = new JButton("*");
    bd = new JButton("/");
    bmod = new JButton("%");
    bnull = new JButton("C");

    beq = new JButton("=");

    bdot = new JButton(".");
    //set Cursor to operand
    bp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bmod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    bnull.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    beq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    //Add ActionListener to object calculate
    b0.addActionListener(cl);
    b1.addActionListener(cl);
    b2.addActionListener(cl);
    b3.addActionListener(cl);
    b4.addActionListener(cl);
    b5.addActionListener(cl);
    b6.addActionListener(cl);
    b7.addActionListener(cl);
    b8.addActionListener(cl);
    b9.addActionListener(cl);
    bs.addActionListener(cl);
    bd.addActionListener(cl);
    bp.addActionListener(cl);
    bm.addActionListener(cl);
    beq.addActionListener(cl);
    bdot.addActionListener(cl);
    bnull.addActionListener(cl);
    bmod.addActionListener(cl);
    //set Font of Button
        b0.setFont(new Font("Monospace", Font.BOLD, 20));
        b1.setFont(new Font("Monospace", Font.BOLD, 20));
        b2.setFont(new Font("Monospace", Font.BOLD, 20));
        b3.setFont(new Font("Monospace", Font.BOLD, 20));
        b4.setFont(new Font("Monospace", Font.BOLD, 20));
        b5.setFont(new Font("Monospace", Font.BOLD, 20));
        b6.setFont(new Font("Monospace", Font.BOLD, 20));
        b7.setFont(new Font("Monospace", Font.BOLD, 20));
        b8.setFont(new Font("Monospace", Font.BOLD, 20));
        b9.setFont(new Font("Monospace", Font.BOLD, 20));
        bp.setFont(new Font("Monospace", Font.BOLD, 20));
        bs.setFont(new Font("Monospace", Font.BOLD, 20));
        bmod.setFont(new Font("Monospace", Font.BOLD, 20));
        bnull.setFont(new Font("Monospace", Font.BOLD, 20));
        beq.setFont(new Font("Monospace", Font.BOLD, 20));
        bm.setFont(new Font("Monospace", Font.BOLD, 20));
        bdot.setFont(new Font("Monospace", Font.BOLD, 20));
        bd.setFont(new Font("Monospace", Font.BOLD, 20));
    // Panel
    JPanel panel = new JPanel();
    
    // ADD textFiel to panel
    panel.add(tf);
    //Add number
    panel.add(b0);
    panel.add(b1);
    panel.add(b2);
    panel.add(b3);
    panel.add(b4);
    panel.add(b5);
    panel.add(b6);
    panel.add(b7);
    panel.add(b8);
    panel.add(b9);

    // Add operator to panel
    panel.add(bs);
    panel.add(bm);
    panel.add(bd);
    panel.add(beq);
    panel.add(bmod);
    panel.add(bnull);
    panel.add(bdot);
    panel.add(bp);

    //Add Backgroundcolor to panel
    panel.setBackground(Color.yellow);
    Border bdDefault = new LineBorder(Color.RED, 4, true);
    panel.setBorder(bdDefault);
    fr.setSize(200, 400);
    fr.add(panel);
    fr.setVisible(true);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  //Handle ActionEvent
  public void actionPerformed(ActionEvent ev) {
    String sBtn = ev.getActionCommand();

    if((sBtn.charAt(0) >= '0' && sBtn.charAt(0) <= '9') || sBtn.charAt(0) == '.') {

      if(!s1.equals("")) s2 += sBtn;
      else s0+=sBtn;

      tf.setText(s0 + s1 + s2);
    }
    else if(sBtn.charAt(0) == 'C') {
      s0 = s1 = s2 = "";

      tf.setText(s0 + s1 + s2);
    }
    else if(sBtn.charAt(0) == '=') {

      double total;

      if(s1 == "+") total = (Double.parseDouble(s0) + Double.parseDouble(s2));
      else if(s1 == "-") total = (Double.parseDouble(s0) - Double.parseDouble(s2));
      else if(s1 == "*") total = (Double.parseDouble(s0) * Double.parseDouble(s2));
      else if(s1 == "/") total = (Double.parseDouble(s0) / Double.parseDouble(s2));
      else total = (Double.parseDouble(s0) % Double.parseDouble(s2));

      tf.setText(s0 + s1 + s2 + "=" + total);
      s0 = Double.toString(total);
      s1 = s2 = "";
    }
    else {
      if(s1.equals("") || s2.equals("")) {
        s1 = sBtn;
      }
      else {
        double total;

      if(s1 == "+") total = (Double.parseDouble(s0) + Double.parseDouble(s2));
      else if(s1 == "-") total = (Double.parseDouble(s0) - Double.parseDouble(s2));
      else if(s1 == "*") total = (Double.parseDouble(s0) * Double.parseDouble(s2));
      else if(s1 == "/") total = (Double.parseDouble(s0) / Double.parseDouble(s2));
      else total = (Double.parseDouble(s0) % Double.parseDouble(s2));

        s0 = Double.toString(total);

        s1 = sBtn;

        s2 = "";
      }

      tf.setText(s0 + s1 + s2);
      
    }
  }
}