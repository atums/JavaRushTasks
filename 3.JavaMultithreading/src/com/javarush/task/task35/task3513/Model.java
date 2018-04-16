package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    public int score;
    public int maxTile;
    private Stack previousStates;
    private Stack previousScores;
    private boolean isSaveNeeded = true;
    private Tile[][] gameTiles;

    public Model() {
        score = 0;
        maxTile =  2;
        resetGameTiles();
        previousStates = new Stack();
        previousScores = new Stack();
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(this::right));
        priorityQueue.add(getMoveEfficiency(this::up));
        priorityQueue.add(getMoveEfficiency(this::down));
        Move move = priorityQueue.peek().getMove();
        move.move();
    }

    public boolean hasBoardChanged() {
        int sumReally = 0;
        int sumBefore = 0;

        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        temp = (Tile[][]) previousStates.peek();
        for(int i = 0; i < FIELD_WIDTH; i++) {
            for(int j = 0; j < FIELD_WIDTH; j++) {
                sumReally += gameTiles[i][j].value;
                sumBefore += temp[i][j].value;
            }
        }
        if(sumBefore != sumReally) {
            return true;
        } else {
            return false;
        }
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if(hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch(n) {
            case 0: {
                left();
                break;
            }
            case 1: {
                right();
                break;
            }
            case 2: {
                up();
                break;
            }
            case 3: {
                down();
                break;
            }
        }
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
//        for(int i = 0; i < FIELD_WIDTH; i++) {
//            System.arraycopy(tiles[i], 0, newTiles[i], 0, FIELD_WIDTH);
//        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                newTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(newTiles);
//        previousStates.push(tiles.clone());
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if(!previousScores.empty() && !previousStates.empty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if(!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    private void addTile() {
        ArrayList<Tile> listEmpty = getEmptyTiles();
        if(!listEmpty.isEmpty()) { // Нахуя эта проверка вообще не понятно!!!!
            int randomInt = (int) (Math.random() * listEmpty.size());
            listEmpty.get(randomInt).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private ArrayList<Tile> getEmptyTiles() {
        ArrayList<Tile> result = new ArrayList<>();
        for(int i = 0; i < FIELD_WIDTH; i++) {
            for(int j = 0; j < FIELD_WIDTH; j++) {
                if(gameTiles[i][j].value == 0) {
                    result.add(gameTiles[i][j]);
                }
            }
        }
        return result;
    }
     public void resetGameTiles() {
         this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
         for(int i = 0; i < FIELD_WIDTH; i++) {
             for(int j = 0; j < FIELD_WIDTH; j++) {
                 gameTiles[i][j] = new Tile();
             }
         }
         addTile();
         addTile();
     }

     private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        Tile tempTile;
        for(int i = 0; i < FIELD_WIDTH - 1; i++) { // не понял зачем второй цикл мы же обрабатываем одномерный массив
            for(int j = 0; j < FIELD_WIDTH - 1 ; j++) {
                if(tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    tempTile = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = tempTile;
                    isCompressed = true;
                }
            }
        }
        return isCompressed;
     }

     private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;
        for(int i = 0; i < FIELD_WIDTH - 1 ; i++) {
            if(tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value *= 2;
                tiles[i + 1].value = 0;
                isMerged = true;
                if(tiles[i].value > maxTile) maxTile = tiles[i].value;
                score += tiles[i].value;
            }
        compressTiles(tiles);
        }
        return isMerged;
     }

     public void left() {
        if(isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isNeedAdd = false;
        for(int i = 0; i < FIELD_WIDTH; i++) {
            if(compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) isNeedAdd = true;
        }
        if(isNeedAdd) {
            addTile();
        }
        isSaveNeeded = true;
     }

     public void down() {
        saveState(gameTiles);
        rotateArr();
        rotateArr();
        rotateArr();
        left();
        rotateArr();
     }

     public void up() {
         saveState(gameTiles);
         rotateArr();
         left();
         rotateArr();
         rotateArr();
         rotateArr();
     }

     public void right() {
        saveState(gameTiles);
        rotateArr();
        rotateArr();
        left();
        rotateArr();
        rotateArr();
     }

    private void rotateArr() {
        int valueArr = FIELD_WIDTH;
        for (int i = 0; i < valueArr / 2; i++) {
            for (int j = i; j < (valueArr - 1) - i; j++) {
                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[j][(valueArr - 1) - i];
                gameTiles[j][(valueArr - 1) - i] = gameTiles[(valueArr - 1) - i][(valueArr - 1) - j];
                gameTiles[(valueArr - 1) - i][(valueArr - 1) - j] = gameTiles[(valueArr - 1) - j][i];
                gameTiles[(valueArr - 1) - j][i] = tmp;
            }
        }
    }
}
