package com.example.mery.drugbox;

import android.animation.Animator;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splesh_animation);
        imageView.setAnimation(animation);
        textView.setAnimation(animation);

        getData();

    }
private List<DrugList> list;
    private void getData() {

        (Api.getClient().getUsersList()).enqueue(new Callback<List<DrugList>>() {
            @Override
            public void onResponse(Call<List<DrugList>> call, Response<List<DrugList>> response) {

                list = response.body();



                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();

                bundle.putParcelableArrayList("key", (ArrayList<? extends Parcelable>) list);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }

            @Override
            public void onFailure(Call<List<DrugList>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
