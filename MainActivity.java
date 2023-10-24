package pl.zabrze.zs10.koszykowka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import pl.zabrze.zs10.koszykowka.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private PunktyViewModel punktyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);
        punktyViewModel.getPunkty().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.textView.setText(String.valueOf(integer));
                    }
                });
        binding.textView.setText(String.valueOf(punktyViewModel.getPunkty()));
        binding.button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zmienPunkty(1);
                    }
                }
        );
        binding.button2.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zmienPunkty(2);
            }
        });
        binding.button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zmienPunkty(3);
                    }
                }
        );
    }
    private void zmienPunkty(int i){
        punktyViewModel.dodajPunkty(i);
    }
}