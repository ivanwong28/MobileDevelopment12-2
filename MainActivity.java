package e.windows10.mobiledevelopmen12;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer player;
    private Button lagu1,lagu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lagu1 = (Button) this.findViewById(R.id.lagu1);
        lagu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(1);
            }
        });

        lagu2 = (Button) this.findViewById(R.id.lagu2);
        lagu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(2);
            }
        });
    }
    @Override
    public void onPause(){
        try {
            super.onPause();
            player.pause();
        }catch (Exception e){
        }
    }

    private void playSound(int i){
        try {
            if (player.isPlaying()){
                player.stop();
                player.release();
            }
        }catch (Exception e) {
            Toast.makeText(this,"Masuk Exception",Toast.LENGTH_LONG).show();
        }
        if (i == 1){
            Toast.makeText(this,"Sedang Memainkan Lagu 1",Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this,R.raw.lagu);
        }else if (i == 2){
            Toast.makeText(this,"Sedang Memainkan Lagu 2",Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this,R.raw.lagu2);
        }
        player.setLooping(false);
        player.start();
    }
}
