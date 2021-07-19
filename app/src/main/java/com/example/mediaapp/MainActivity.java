package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity { // inheritance
//    access control mechanism is displayed in the manifest file when the permission in granted to give access to use of the internet
private Button play;
private Button pause;
private Button next;
private SeekBar seekBar;
private MediaPlayer mediaPlayer;
private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         By calling super.onCreate(savedInstanceState), you tell the app to run your code in addition to the existing code in the onCreate() of the parent class.
//         If you leave out this line, then only your code is run. The existing code is ignored completely.
        setContentView(R.layout.activity_main);

//        media player using local source
        mediaPlayer=MediaPlayer.create(this,R.raw.music);//this keyword

        seekBar=findViewById(R.id.seekBar);
//        media player using remote source
        textView2=findViewById(R.id.textView2);
        Intent intent=getIntent();




        String s=textView2.getText().toString();
       mediaPlayer=new MediaPlayer();


        try { //exception handling
  //scope of this variable is within the try bock i.e it can only be used within try block
            mediaPlayer.setDataSource("https://paglasongs.com/files/download/id/2094"); //lifetime of this variable defines tha as soon as the try block successfully executes the variable becomes non-existent

        } catch (IOException e) {
            e.printStackTrace();
        }
      String  song= intent.getStringExtra(main2.EXTRA_NAME);
        textView2.setText(song);
mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mp) { //media player object is passed as parameter
        Toast.makeText(MainActivity.this, "Ready to PLay", Toast.LENGTH_SHORT).show(); //this toast is also an instance variable
        mp.start();
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               if (fromUser) {
//                   differnt types of instance variable
//                   if the user touches the seekbar the the frontUser boolean varible is invoked and the seekbar gets the duration at which the user wants to jump an gets it when the int
//                   progress type of instance variable is invoked
                   mediaPlayer.seekTo(progress);
               }
            }

            @Override
            public  void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
});
        mediaPlayer.prepareAsync(); //method calling transfers the object to the preparing state
//        mediaPlayer.start();
        play=findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

            }
        });
    pause=findViewById(R.id.pause);
    pause.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediaPlayer.pause();
        }
    });


    }
    public void open_activity(View v){
        Toast.makeText(this, "opening list", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,main2.class);
        startActivity(intent);

    }

}