package com.example.lama.lamapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnterWord extends Activity {

    private ListView vue1;
    private ListView vue2;
    private TextView LabelNomEq1, LabelNomEq2;
    private Game game;
    private EditText word;
    private EnterWordAdapter adaptaterA;
    private EnterWordAdapter adaptaterB;

    private ArrayList<String> wordlistA;
    private ArrayList<String> wordlistB;
    private ArrayList<String> wordB = new ArrayList<>();
    private ArrayList<String> wordA = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);
        Intent intent = getIntent();

        game = (Game) intent.getSerializableExtra("game");



       /* if (intent.getStringExtra("motChoisi")!=null){
            motChoisi = intent.getStringExtra("motChoisi");
            Log.i("Mot choisi", motChoisi);
        }*/
        int ab;
        if (intent.getSerializableExtra("wordlistA") != null || intent.getSerializableExtra("wordlistB") != null) {
            ab = (int) intent.getSerializableExtra("ab");
            Log.i("WORDLISTA", "onCreate: "+intent.getSerializableExtra("wordlistA"));
            Log.i("WORDLISTB", "onCreate: "+intent.getSerializableExtra("wordlistB"));
            wordA = (ArrayList<String>) intent.getSerializableExtra("wordlistA");
            wordB = (ArrayList<String>) intent.getSerializableExtra("wordlistB");
        } else {
            Log.i("ELSE", "onCreate: ");
            for (int i = 0; i < game.getNbPlayers(); i++) {
                String wA = "";
                String wB = "";
                Log.i("test ", "onCreate: " + i);
                wordA.add(wA);
                wordB.add(wB);
            }
        }
        LabelNomEq1 = (TextView) findViewById(R.id.NameEq1TextViewEnterWord);
        LabelNomEq2 = (TextView) findViewById(R.id.NameEq2TextViewEnterWord);
        LabelNomEq1.setText(game.getNameTeamA());
        LabelNomEq2.setText(game.getNameTeamB());

       /* if (motChoisi!=null){
            Log.i("Mot choisi","Non null !");

             word = (EditText) findViewById(R.id.word);
            Log.i("Hello EditText",word.toString());
            word.setText(motChoisi, TextView.BufferType.NORMAL);
            Toast.makeText(getApplicationContext(), motChoisi, Toast.LENGTH_SHORT).show();
        }*/


        vue1 = (ListView) findViewById(R.id.enter_word_list1);
        vue2 = (ListView) findViewById(R.id.enter_word_list2);


        adaptaterA = new EnterWordAdapter(this, R.layout.enter_word1, wordA,wordB, game, 1);
        adaptaterB = new EnterWordAdapter(this, R.layout.enter_word1, wordA,wordB, game, 2);
        vue1.setAdapter(adaptaterA);
        vue2.setAdapter(adaptaterB);

    }
/*
    public void aleatoire(View view) {
        EditText word = (EditText) findViewById(R.id.word);
        Random alea = new Random();
        DatabaseHandler db = new DatabaseHandler(this);
        List<Word> words = db.getWordsList();
        db.close();
        String ranMot = words.get(alea.nextInt(words.size())).getWord();
        word.setText(ranMot, TextView.BufferType.NORMAL);
        Toast.makeText(getApplicationContext(), ranMot, Toast.LENGTH_SHORT).show();
    }

    */
}