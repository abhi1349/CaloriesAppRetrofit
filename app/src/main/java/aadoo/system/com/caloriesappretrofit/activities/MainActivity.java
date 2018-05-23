package aadoo.system.com.caloriesappretrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import aadoo.system.com.caloriesappretrofit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getFruits(View view) {

        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("type","fruits");
        startActivity(intent);
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
    }

    public void getVegitables(View view) {

        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("type","vegitables");
        startActivity(intent);
    }


}
