package com.example.mylib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {
    String nik;
    List<Card> currentCardsSet=new ArrayList();
    StatePlayer statePlayer;
    Game game;

    boolean doStep(Card card) {
        boolean result = false;
        if (statePlayer.equals(StatePlayer.ATACK)) {
            game.cardsOnTable.put(card, null);
            result = true;
        } else if (statePlayer.equals(StatePlayer.DEFENSE)) {
            for (Card tempKey : game.cardsOnTable.keySet()) {
                if (game.cardsOnTable.get(tempKey) == null) {
                    result = validationDefense(card);
                    if (result) {
                        game.cardsOnTable.put(tempKey, card);
                        break;
                    }
                }
            }
        } else {
            result = validationAtackToo(card);
            // TODO: 4/23/2020  validation card before this moment
            if (result) {
                game.cardsOnTable.put(card, null);
            }
        }
        if (result) {
            currentCardsSet.remove(card);
        }
return result;
    }

    private boolean validationAtackToo(Card card) {
        // TODO: 4/23/2020
        return true;
    }

    private boolean validationDefense(Card card) {
        // TODO: 4/23/2020
        return true;
    }


    void canNotDefense(){
        for (Map.Entry<Card, Card> temp : game.cardsOnTable.entrySet()) {
            currentCardsSet.add(temp.getKey());
            if (temp.getValue() != null) {
                currentCardsSet.add(temp.getValue());
            }
            game.cardsOnTable.clear();
            this.statePlayer = StatePlayer.ATACK_TOO;

            int number = game.players.indexOf(this);
            if (number == (game.players.size() - 1)) {
                game.players.get(0).statePlayer = StatePlayer.ATACK;
            } else {
                game.players.get(number + 1).statePlayer = StatePlayer.ATACK;
            }
            List<Player> tempList = new ArrayList<>(game.players);
            tempList.remove(this);
            game.addCardsForPlayers(tempList);


        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "nik='" + nik + '\'' +
                ", currentCardsSet=" + currentCardsSet +
                ", statePlayer=" + statePlayer +
                '}';
    }
}
