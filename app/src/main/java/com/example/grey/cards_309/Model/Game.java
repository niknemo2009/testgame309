package com.example.grey.cards_309.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
    String name;
    List<Player> players =new ArrayList<>();
    List<Card> deck=new ArrayList<>();
    Map<Card,Card> cardsOnTable=new HashMap<>();
    Suit currentKosir;



    public Game(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        for(Player temp:players){
            temp.game=this;
        }
        generateDeck();
        setCurrentKosir();
        addCardsForPlayers( players );

    }

    public  void addCardsForPlayers(List<Player> players33) {
        int count = 0;
        while (!deck.isEmpty() && count < players33.size()) {
            for (Player temp : players33) {
                if (!deck.isEmpty()) {
                    if (temp.currentCardsSet.size() < 6) {
                        temp.currentCardsSet.add(deck.get(0));
                        deck.remove(0);
                    } else {
                        count++;
                    }
                }else {
                    break;
                }



            }


        }
    }

    private void generateDeck(){
        for(Suit tempMust:Suit.values())
            for (VALUE_CARD temp:VALUE_CARD.values() ) {
                deck.add(new Card(tempMust,temp));
            }
        Collections.shuffle(deck);
    }
    private void setCurrentKosir() {
        Random rand=new Random();
        int index=rand.nextInt(3);
        this.currentKosir = Suit.values()[index];
    }
    void  vidbiy(){

    }

    public static void main(String[] args) {
        Player one=new Player();
        Player two=new Player();
        Player three=new Player();
        Player for33=new Player();
        List<Player>  list=new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(for33);
        Game game=new Game("game1",list);
      //  one.step(one.currentNabirCards.get(0))
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", cardsOnTable=" + cardsOnTable +
                ", currentKosir=" + currentKosir +
                '}';
    }
}
