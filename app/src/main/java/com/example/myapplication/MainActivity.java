package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.util.*;
import android.widget.SearchView.*;
import java.io.*;
import android.util.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    protected ArrayList<String> thru_list_1;
    protected ArrayAdapter<String> adapter_thru_1;
    final String filename = "savebled9.txt";
    protected FileOutputStream outputStream;
    protected String  myText;

    protected Button read, write, addWord, btt;
    protected EditText editText;
    protected TextView textView;
    protected ListView listText;
    protected String takeWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        read = findViewById(R.id.read);
        write = findViewById(R.id.write);
        addWord = findViewById(R.id.addWord);
        btt = findViewById(R.id.btt);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id. textView);
        listText = findViewById(R.id.listText);
        thru_list_1 = new ArrayList<>();


    }
    public void AddWordToList(View v){
        takeWord = editText.getText().toString(); //забираем введеное слово
        thru_list_1.add(takeWord);
        textView.setText(takeWord);
        editText.setText("");
        if (thru_list_1.contains("123")){
            Log.e("wer", "BLEEEED");
        }
    } //чтение слова и добавление в ArrayList
    private String array2str(List<String> strings){
        StringBuilder sb = new StringBuilder();
        for (String s : strings){
            sb.append(s+ "\n");
        }
        return sb.toString();
    } //запись в тхт
    public void WriteToTxt(View v){
        myText = array2str(thru_list_1);
        try {
            outputStream = openFileOutput(filename, MODE_PRIVATE);
            outputStream.write(myText.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //запись в тхт
    public void ReadFromTxt(View v){
        try {
            InputStream inputStream = openFileInput(filename);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    thru_list_1.add(receiveString);
                    Log.e("login", String.valueOf(thru_list_1));
                }
                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("logme", "File is in ass: " + e.toString());
        } catch (IOException e) {
            Log.e("logmetwice", "do not read, bos: " + e.toString());
        }


    } //чтение из тхт

    public void GetItJonny(View v){
        adapter_thru_1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, thru_list_1);
        listText.setAdapter(adapter_thru_1); //вывод в ListView




    }




    }



