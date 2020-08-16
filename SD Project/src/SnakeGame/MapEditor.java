/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame;

import JFrame.SnakeGameMainMenu;
import static JFrame.SnakeGameMainMenu.MAP_BOARD;
import Libs.ColorEx;
import SnakeGame.boards.MapBoard;
import SnakeGame.screens.Screen;
import static SnakeGame.screens.Screen.TILE_SIZE;
import SnakeGame.screens.Wall;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import static JFrame.SmartAssistant.SNAKE_GAME_MAIN_MENU;
import javax.swing.JOptionPane;

/**
 *
 * @author Lassassin
 */
public class MapEditor extends JPanel implements Runnable {

    private Thread thread;
    private boolean isRunning = false;
    private Key key;
    private int WIDTH = 1600, HEIGHT = 800;
    private int xCoordinate, yCoordinate;

    private selectionBlock sBlock;

    private ArrayList<Wall> walls = new ArrayList<Wall>();

    public static ArrayList<Wall> MAP;

    public MapEditor() {
        setPreferredSize(new Dimension(1600, 800));

        key = new MapEditor.Key();

        xCoordinate = 5;
        yCoordinate = 5;

        sBlock = new selectionBlock(xCoordinate, yCoordinate);

        setFocusable(true);
        addKeyListener(key);

        if (MAP != null) {
            walls = MAP;
        }

        start();

    }

    private void start() {
        isRunning = true;
        thread = new Thread(this, "Map Editor Loop");
        thread.start();

    }

    public void tick() {
        sBlock.move(xCoordinate, yCoordinate);
    }

    @Override
    public void paint(Graphics g) {
        drawBack(g);
        drawWalls(g);
        drawGrid(g);

        sBlock.draw(g);
    }

    public void stop() {

        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        while (isRunning) {
            repaint();
            tick();
        }
    }

    private void drawBack(Graphics g) {

        g.setColor(ColorEx.DARK_PURPLE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

    }

    private void drawGrid(Graphics g) {
        g.setColor(ColorEx.GRID_BLUE);

        for (int i = TILE_SIZE; i < HEIGHT; i = i + TILE_SIZE) {
            g.drawLine(0, i, WIDTH, i);
        }

        for (int i = TILE_SIZE; i < WIDTH; i = i + TILE_SIZE) {
            g.drawLine(i, 0, i, HEIGHT);
        }

    }

    private void drawWalls(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
            walls.get(i).draw(g);
        }
    }

    public class Key implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (yCoordinate < 1) {

                } else {
                    yCoordinate--;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (yCoordinate > HEIGHT / 20 - 2) {

                } else {
                    yCoordinate++;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (xCoordinate < 1) {

                } else {
                    xCoordinate--;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (xCoordinate > WIDTH / 20 - 2) {

                } else {
                    xCoordinate++;

                }
            }
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                removeWall((Wall) checkWall("remove"));
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (xCoordinate == WIDTH / 40 && yCoordinate == HEIGHT / 40) {
                    JOptionPane.showMessageDialog(null, "You cannot add a block onto the starting position!");
                } else {

                    if (walls.isEmpty()) {
                        addWall();
                    } else {

                        boolean collide = (boolean) checkWall("add");
                        if (!collide) {
                            addWall();
                        }

                    }

                }

            }

            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                MAP = walls;
                MAP_BOARD.dispose();
                SNAKE_GAME_MAIN_MENU.setVisible(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        void addWall() {
            walls.add(new Wall(xCoordinate, yCoordinate));
        }

        Object checkWall(String label) {
            for (int i = 0; i < walls.size(); i++) {
                if (walls.get(i).getX() == xCoordinate && walls.get(i).getY() == yCoordinate) {
                    //It collided
                    return label.equals("add") ? true : walls.get(i);
                }
            }
            return label.equals("add") ? false : null;
        }

        void removeWall(Wall wall) {
            walls.remove(wall);
        }

    }

}
