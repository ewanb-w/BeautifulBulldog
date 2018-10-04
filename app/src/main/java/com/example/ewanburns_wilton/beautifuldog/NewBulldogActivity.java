package com.example.ewanburns_wilton.beautifuldog;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import io.realm.Realm;

public class NewBulldogActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView nameField3;
    private TextView ageField3;
    private ImageView imageView2;
    private Realm realm;
    private Button bulldogImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bulldog);
        nameField3 = (EditText) findViewById(R.id.name_field3);
        ageField3 = (EditText) findViewById(R.id.age_view3);
        imageView2 = (ImageView) findViewById(R.id.image_view2);
        realm = Realm.getDefaultInstance();
        bulldogImageButton = (Button) findViewById(R.id.button);

        String id = (String) getIntent().getStringExtra("bulldog");
        Bulldog bulldog = realm.where(Bulldog.class).equalTo("id", id).findFirst();
        nameField3.setText(bulldog.getName());
        ageField3.setText(bulldog.getAge());
        bulldog.setImage();

        bulldogImageButton.setOnClickListener(new View.OnClickListener) {
            @Override
            public void onClick(final View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 1);
                }
            }
        });
    }
}
