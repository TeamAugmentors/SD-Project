/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author Lassassin
 */
public class HintTextField extends JTextField {

    Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
    Font lostFont = new Font("Tahoma", Font.ITALIC, 11);

    public HintTextField(final String hint) {

        setText(hint);
        setFont(lostFont);
        setForeground(ColorEx.GRAY);

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);

                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().length() == 0) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });

    }

    public HintTextField(final String hint, Font gainFont, Font lostFont, ColorEx color) {

        this.gainFont = gainFont;
        this.lostFont = lostFont;

        setText(hint);
        setFont(lostFont);
        setForeground(color);

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                } else {
                    setText(getText());
                    setFont(gainFont);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().length() == 0) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });

    }

    public Font getGainFont() {
        return gainFont;
    }

    public void setGainFont(Font gainFont) {
        this.gainFont = gainFont;
    }

    public Font getLostFont() {
        return lostFont;
    }

    public void setLostFont(Font lostFont) {
        this.lostFont = lostFont;
    }

}
