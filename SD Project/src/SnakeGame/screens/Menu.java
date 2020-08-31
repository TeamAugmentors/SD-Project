/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.screens;

import static JFrame.SnakeGameMainMenu.PLAYER;
import Libs.ColorEx;
import static SnakeGame.screens.Screen.SCORE;
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

    //Static vars-------------------
    static int MENU_WIDTH = 200;
    static int MENU_HEIGHT = 800;
    //------------------------------

    //Images----------------------------------------------
    BufferedImage background = null;
    BufferedImage muteButtonImage = null;
    BufferedImage muteButtonSelectedImage = null;
    BufferedImage muteButtonImageRollover = null;
    BufferedImage muteButtonSelectedImageRollover = null;

    ImageIcon muteIcon;
    ImageIcon muteIconRollover;
    ImageIcon muteIconSelected;
    ImageIcon muteIconSelectedRollover;
    //-----------------------------------------------------

    //UI Components-----
    JLabel score;
    JLabel dummy;
    JButton muteButton;
    //------------------

    public Menu() {
        setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));

        try {
            initComponents();
        } catch (IOException e) {
            System.out.println("couldnt find images");
        }

        initLayout();

        if (!PLAYER.clip.isActive()) {
            setMuteButtonSelected();
        }

        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (muteButton.isSelected()) {
                    setMuteButtonDeselected();
                    PLAYER.clip.start();

                } else {
                    setMuteButtonSelected();
                    PLAYER.clip.stop();
                }

            }
        });

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    score.setText(SCORE + "");
                }
            }
        });
        
        t.start();

    }

    private void initComponents() throws IOException {
        initJLabels();
        initImages();
        initButtons();
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

    private void initImages() throws IOException {
        background = ImageIO.read(new File("resources/Snake.Resources/snake_score_board.png"));

        muteButtonImage = ImageIO.read(new File("resources/Snake.Resources/mute_button.png"));
        muteButtonImageRollover = ImageIO.read(new File("resources/Snake.Resources/mute_button_rollover.png"));

        muteButtonSelectedImage = ImageIO.read(new File("resources/Snake.Resources/mute_button_selected.png"));
        muteButtonSelectedImageRollover = ImageIO.read(new File("resources/Snake.Resources/mute_button_selected_rollover.png"));

        muteIcon = new ImageIcon(muteButtonImage);
        muteIconRollover = new ImageIcon(muteButtonImageRollover);

        muteIconSelected = new ImageIcon(muteButtonSelectedImage);
        muteIconSelectedRollover = new ImageIcon(muteButtonSelectedImageRollover);
    }

    private void initJLabels() {
        score = new JLabel();
        score.setText("16");
        score.setBounds(0, 0, 200, 100);
        score.setForeground(ColorEx.BRIGHT_PURPLE);
        score.setFont(new Font("Aerolite", Font.BOLD, 40));

        score.setHorizontalTextPosition(SwingConstants.CENTER);

        dummy = new JLabel();
        dummy.setText("");
        dummy.setPreferredSize(new Dimension(200, 40));

    }

    private void initButtons() {
        muteButton = new JButton();
        muteButton.setFocusable(false);
        makeCustomButton(muteButton, muteIcon, muteIconRollover);
    }

    private void setMuteButtonSelected() {
        muteButton.setSelected(true);
        muteButton.setIcon(muteIconSelected);
        muteButton.setRolloverIcon(muteIconSelectedRollover);
    }

    private void setMuteButtonDeselected() {
        muteButton.setSelected(false);
        muteButton.setIcon(muteIcon);
        muteButton.setRolloverIcon(muteIconRollover);
    }

    private void initLayout() {
        setLayout(new GridBagLayout());

        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 0;
        gb.weighty = 1;
        add(dummy, gb);

        //Let total weight for components below score be 12
        gb.gridx = 0;
        gb.gridy = 1;
        gb.weightx = 0;
        gb.weighty = 1;
        gb.anchor = GridBagConstraints.NORTH;
        add(score, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        gb.weightx = 0;
        gb.weighty = 11;
        add(muteButton, gb);

    }
}
