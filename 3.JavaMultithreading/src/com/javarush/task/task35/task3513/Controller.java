package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import static java.awt.event.KeyEvent.VK_ESCAPE;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public View getView() {
        return view;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    public Tile[][] getGameTiles() {
       return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            model.autoMove();
        }
        if(e.getKeyCode() == KeyEvent.VK_Z) {
            model.rollback();
        }
        if(e.getKeyCode() == KeyEvent.VK_R) {
            model.randomMove();
        }
        if(model.canMove() == false)
            view.isGameLost = true;

        if(!view.isGameLost && !view.isGameWon) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT) model.left();
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) model.right();
            if(e.getKeyCode() == KeyEvent.VK_UP) model.up();
            if(e.getKeyCode() == KeyEvent.VK_DOWN) model.down();
        }

        if(model.maxTile == WINNING_TILE)
            view.isGameWon = true;

        view.repaint();
    }
}
