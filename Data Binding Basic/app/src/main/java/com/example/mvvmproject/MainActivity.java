package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mvvmproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get text from edit text
                String sText = binding.etInput.getText().toString().trim();

                //Check Condition
                if (!sText.equals("")){
                    //When text is not empty
                    //Set text on text view
                    binding.tvOutput.setText(sText);
                }else{
                    //When Text is empty
                    //Display Toast
                    Toast.makeText(getApplicationContext(), "Lütfen metin giriniz", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Initialize Fragment
        Fragment fragment = new MainFragment();
        //Commit fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }
}