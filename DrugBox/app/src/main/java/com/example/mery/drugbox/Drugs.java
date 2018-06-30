package com.example.mery.drugbox;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Drugs extends AppCompatActivity {
private CircleImageView imageView;
private TextView textViewdrug, textviewcategory, textviewproducer, textviewprice, textviewadress,textviewtel;
private ImageButton imageButton;
private Button button;
    DrugList ob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_drugs_page);

        Bundle bundle = getIntent().getExtras();
       ob=bundle.getParcelable("key");

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        button=findViewById(R.id.map);
        imageButton=findViewById(R.id.imagebuton);
        textviewcategory=findViewById(R.id.textviewcategory);
        textViewdrug=findViewById(R.id.textdrug);
        imageView=findViewById(R.id.imagephamacy);
        textviewproducer=findViewById(R.id.textviewproducer);
        textviewprice=findViewById(R.id.textviewprice);
        textviewadress=findViewById(R.id.textviewadress);
        textviewtel=findViewById(R.id.textviewtel);
        textviewcategory.setText(ob.getType());
        textViewdrug.setText(ob.getDrugName());
        textviewproducer.setText(ob.getProducer());
        textviewprice.setText(ob.getPrice());
        textviewadress.setText(ob.getAddress());
        textviewtel.setText(ob.getTelephone());
        String pharmacy_name=ob.getPharmacy();
        switch (pharmacy_name){
            case "Vaga Pharm" : imageView.setImageResource(R.drawable.vaga); break;
            case "Alfa Pharm":imageView.setImageResource(R.drawable.alfa); break;
            case "Natali Pharm":imageView.setImageResource(R.mipmap.nataali);
        }

imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
       // intent.putExtra("pharmname", ob.getPharmacy());
        intent.setData(Uri.parse("https://goo.gl/maps/KjvV2zX8W3N2"));
        startActivity(intent);
    }
});




    }
}
