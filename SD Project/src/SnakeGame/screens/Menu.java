/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.screens;

import static JFrame.SnakeGameMainMenu.PLAYER;
import Libs.ColorEx;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Lassassin
 */
public class Menu extends JPanel {

    static int MENU_WIDTH = 200;
    static int MENU_HEIGHT = 800;

    BufferedImage background = null;
    BufferedImage muteButtonImage = null;
    BufferedImage muteButtonSelectedImage = null;
    BufferedImage muteButtonImageRollover = null;
    BufferedImage muteButtonSelectedImageRollover = null;

    public Menu() {
        setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));

        try {
            background = ImageIO.read(new File("resources/Snake.Resources/snake_score_board.png"));

            muteButtonImage = ImageIO.read(new File("resources/Snake.Resources/mute_button.png"));
            muteButtonImageRollover = ImageIO.read(new File("resources/Snake.Resources/mute_button_rollover.png"));

            muteButtonSelectedImage = ImageIO.read(new File("resources/Snake.Resources/mute_button_selected.png"));
            muteButtonSelectedImageRollover = ImageIO.read(new File("resources/Snake.Resources/mute_button_selected_rollover.png"));
        } catch (IOException e) {
            System.out.println("couldnt find image");
        }

        setLayout(new GridBagLayout());

        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;

        gb.weightx = 0;
        gb.weighty = 1;

        JLabel dummy = new JLabel();
        dummy.setText("");
        dummy.setPreferredSize(new Dimension(200, 40));

        //Let total weight for components below highscore be 12//
        add(dummy, gb);

        gb.gridx = 0;
        gb.gridy = 1;

        gb.weightx = 0;
        gb.weighty = 1;

        gb.anchor = GridBagConstraints.NORTH;

        JLabel highscore = new JLabel();
        highscore.setText("16");
        highscore.setBounds(0, 0, 200, 100);
        highscore.setForeground(ColorEx.BRIGHT_PURPLE);
        highscore.setFont(new Font("Aerolite", Font.BOLD, 40));

        highscore.setHorizontalTextPosition(SwingConstants.CENTER);

        add(highscore, gb);

        ImageIcon muteIcon = new ImageIcon(muteButtonImage);
        ImageIcon muteIconRollover = new ImageIcon(muteButtonImageRollover);

        ImageIcon muteIconSelected = new ImageIcon(muteButtonSelectedImage);
        ImageIcon muteIconSelectedRollover = new ImageIcon(muteButtonSelectedImageRollover);

        JButton muteButton = new JButton();

        muteButton.setFocusable(false);
        makeCustomButton(muteButton, muteIcon, muteIconRollover);

        if (!PLAYER.clip.isActive()) {
            muteButton.setSelected(true);
            muteButton.setIcon(muteIconSelected);
            muteButton.setRolloverIcon(muteIconSelectedRollover);
        }

        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (muteButton.isSelected()) {
                    muteButton.setSelected(false);
                    muteButton.setIcon(muteIcon);
                    muteButton.setRolloverIcon(muteIconRollover);

                    PLAYER.clip.start();

                } else {
                    muteButton.setSelected(true);
                    muteButton.setIcon(muteIconSelected);
                    muteButton.setRolloverIcon(muteIconSelectedRollover);

                    PLAYER.clip.stop();
                }

            }
        });

        gb.gridx = 0;
        gb.gridy = 2;

        gb.weightx = 0;
        gb.weighty = 11;

        add(muteButton, gb);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        g.drawImage(background, 0, 0, this);
    }

    private void makeCustomButton(JButton Button, ImageIcon Icon, ImageIcon rolloverIcon) {

        Button.setRolloverEnabled(true);
        Button.setRolloverIcon(rolloverIcon);
        Button.setSelected(false);
        Button.setIcon(Icon);
        Button.setBorderPainted(false);
        Button.setBorder(null);
        Button.setOpaque(false);
        Button.setFocusPainted(false);
        Button.setContentAreaFilled(false);
    }

}
