package com.example.ewanburns_wilton.beautifuldog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import io.realm.Realm;
public class BulldogActivity extends AppCompatActivity {


    private TextView nameField2;
    private TextView ageField2;
    private ImageView imageView1;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog);

        nameField2 = (TextView) findViewById(R.id.name_field2);
        ageField2 = (TextView) findViewById(R.id.age_field2);
        imageView1 = (ImageView) findViewById(R.id.image_view1);
        realm = Realm.getDefaultInstance();
        String id = (String) getIntent().getStringExtra("bulldog");
        Bulldog bulldog = realm.where(Bulldog.class).equalTo("id", id).findFirst();
        nameField2.setText(bulldog.getName());
        ageField2.setText(bulldog.getAge());
        bulldog.setImage();
    }
}