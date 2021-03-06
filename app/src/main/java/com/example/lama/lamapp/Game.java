package com.example.lama.lamapp;

import com.example.lama.lamapp.DAOs.Joueur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Game implements Serializable{

    // ----- INSTANTIATION ----- //
    int Level;

    int NbPlayers;

    String TeamA;
    String TeamB;

    ArrayList<Joueur> TeamA_List_Joueurs = new ArrayList<Joueur>();
    ArrayList<Joueur> TeamB_List_Joueurs = new ArrayList<Joueur>();

    int NbWords;
    int CurrentWord;
    ArrayList<String> Words_List = new ArrayList<String>();
    ArrayList<String> Words_Current_List = new ArrayList<String>();
    String Word;

    int CurrentRound;
    int[] PlayerToPlay = new int[2];
    int NbPointsTurn;
    int NbPointsRoundTeamA;
    int NbPointsRoundTeamB;
    int WinRoundTeamA;
    int WinRoundTeamB;

    int Count;

    int Quit;

    // ----- CONSTRUCTOR ----- //
    public Game() {
        Level = 0;
        NbPlayers = 0;
        TeamA = "";
        TeamB = "";
        NbWords = 0;
        Word = "";
        Count = 0;
        Quit = 0 ;
        CurrentWord = 0;
        CurrentRound = 0;
        PlayerToPlay[0] = 0;
        PlayerToPlay[1] = 0;
        NbPointsTurn = 0;
        WinRoundTeamA = 0;
        WinRoundTeamB = 0;
        NbPointsRoundTeamA = 0;
        NbPointsRoundTeamB = 0;
    }

    // ----- GETTERS ----- //
    public int getLevel() {
        return Level;
    }

    public int getNbPlayers() {
        return NbPlayers;
    }

    public String getNameTeamA() {
        return TeamA;
    }
    public String getNameTeamB() {
        return TeamB;
    }

    public ArrayList<Joueur> getTeamA_List_Joueurs() { return TeamA_List_Joueurs; }
    public ArrayList<Joueur> getTeamB_List_Joueurs() { return TeamB_List_Joueurs; }

    public String getNameJoueurTeamA(int pJoueurID) {
        Joueur Joueur = TeamA_List_Joueurs.get(pJoueurID);
        String JoueurName = Joueur.getNomJoueur();
        return JoueurName;
    }

    public String getNameJoueurTeamB(int pJoueurID) {
        Joueur Joueur = TeamB_List_Joueurs.get(pJoueurID);
        String JoueurName = Joueur.getNomJoueur();
        return JoueurName;
    }

    public int getCurrentWord() {return this.CurrentWord; };
    public int getNbWords() {
        return NbWords;
    }
    public ArrayList<String> getWords_List() {
        return this.Words_List;
    }
    public ArrayList<String> getWords_Current_List() {
        return this.Words_Current_List;
    }
    public String getWord(int pWordID) { return this.Words_List.get(pWordID); }
    public String getWordCurrentList(int pWordID) { return this.Words_Current_List.get(pWordID); }

    public int[] getPlayerToPlay() { return this.PlayerToPlay; }

    public int getCurrentRound(){ return CurrentRound; }
    public int getNbPointsTurn()  { return NbPointsTurn; }
    public int getNbPointsRoundTeamA() {
        return NbPointsRoundTeamA;
    }
    public int getNbPointsRoundTeamB() { return NbPointsRoundTeamB; }
    public int getWinRoundTeamA() {
        return WinRoundTeamA;
    }
    public int getWinRoundTeamB() { return WinRoundTeamB; }

    public int getCount() { return Count; }
    public int getQuit() { return Quit; }

    // ----- SETTERS ----- //
    public void setLevel(int pLevel){
        this.Level = pLevel;
    }

    public void setNbPlayers(int pNbPlayers){ this.NbPlayers = pNbPlayers;}

    public void setNameTeamA(String pNameTeamA){this.TeamA = pNameTeamA ;}
    public void setNameTeamB(String pNameTeamB){this.TeamB = pNameTeamB ;}

    public void addTeamA(ArrayList<Joueur> A){this.TeamA_List_Joueurs = A;}
    public void addTeamB(ArrayList<Joueur> B){this.TeamB_List_Joueurs = B;}

    public void addPlayerTeamA(Joueur pJoueur){ this.TeamA_List_Joueurs.add(pJoueur);}
    public void addPlayerTeamB(Joueur pJoueur){ this.TeamB_List_Joueurs.add(pJoueur);}

    public void setCurrentWord(int pCurrentWord) { this.CurrentWord = pCurrentWord; }
    public void setNbWords(int pNbWords){
        this.NbWords = pNbWords;
    }
    public void setWords_List(ArrayList<String> pWordList){ this.Words_List = pWordList;}
    public void setWords_Current_List() {

        this.Words_Current_List.addAll(this.Words_List);
        Random random = new Random();
        Collections.shuffle(this.Words_Current_List,random);
    }
    public void addWord(String pWord){
        this.Words_List.add(pWord);
    }
    public void deleteWord(String pLastWord){ this.Words_Current_List.remove(pLastWord);}

    public void setCurrentRound(int pCurrentRound){ CurrentRound = pCurrentRound; }
    public void setPlayerToPlay(int[] pPlayerToPlay){ PlayerToPlay = pPlayerToPlay; }
    public void setNbPointsTurn(int pNbPointsTurn){
        NbPointsTurn = pNbPointsTurn;
    }
    public void setNbPointRoundTeamA(int pNbPointsRound){
        NbPointsRoundTeamA = pNbPointsRound;
    }
    public void setNbPointRoundTeamB(int pNbPointsRound){
        NbPointsRoundTeamB = pNbPointsRound;
    }
    public void setWinRoundTeamA(){
        WinRoundTeamA++;
    }
    public void setWinRoundTeamB(){
        WinRoundTeamB++;
    }

    public void setCount(int pCount) { Count = pCount; }
    public void setQuit(int pQuit) { Quit = pQuit; }

    @Override
    public String toString() {
        return "Game{" +
                "Level=" + Level +
                ", NbPlayers=" + NbPlayers +
                ", TeamA='" + TeamA + '\'' +
                ", TeamB='" + TeamB + '\'' +
                ", TeamA_List_Joueurs=" + TeamA_List_Joueurs +
                ", TeamB_List_Joueurs=" + TeamB_List_Joueurs +
                ", NbWords=" + NbWords +
                ", Words_List=" + Words_List +
                ", Word='" + Word + '\'' +
                ", NbPointsRoundTeamA=" + NbPointsRoundTeamA +
                ", NbPointsRoundTeamB=" + NbPointsRoundTeamB +
                '}';
    }
}
