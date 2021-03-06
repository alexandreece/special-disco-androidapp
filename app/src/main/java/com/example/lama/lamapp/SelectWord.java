package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;

public class SelectWord extends AppCompatActivity {

    ListView vue;

    private int pos;
    private int position;
    private ArrayList<String> wordList;
    private Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);
        final Intent intent = getIntent();
        position = (int) intent.getIntExtra("position",0);
        pos = (int) intent.getIntExtra("pos",0);

        wordList = (ArrayList<String>) intent.getSerializableExtra("list");
        game = (Game) intent.getSerializableExtra("game");

        //get word from DB
        DatabaseHandler db = new DatabaseHandler(this);
        final List<Word> words = db.getWordsList();
        db.close();

        vue = (ListView) findViewById(R.id.list);

        List<String> liste = new ArrayList<String>();
        for (Word mot : words) {
            liste.add(mot.getWord());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste);
        vue.setAdapter(adapter);


        //click listener
        vue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int positions, long id) {


                String selected = (String) vue.getItemAtPosition(positions);

                Intent intent_next = new Intent(SelectWord.this, PickupWord.class);


                wordList.set(position, selected);

                //wordList.add(pos,selected);
                intent_next.putExtra("list", wordList);
                intent_next.putExtra("game", game);
                intent_next.putExtra("pos", pos);


                startActivity(intent_next);
            }
        });
    }
}