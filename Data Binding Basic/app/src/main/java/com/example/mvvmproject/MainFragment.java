package com.example.mvvmproject;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvvmproject.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    //Initialize veriable
    private FragmentMainBinding binding;
    private View view;

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Assign variable
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container,false);
        view = binding.getRoot();

        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get text from edit text
                String sText = binding.etInput.getText().toString().trim();
                //Check condition
                if (!sText.equals("")){
                    //When text is not empty
                    binding.tvOutput.setText(sText);
                }else{
                    //When text is empty, Display toast
                    Toast.makeText(view.getContext(), "Lütfen metin giriniz", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Return view
        return view;
    }
}