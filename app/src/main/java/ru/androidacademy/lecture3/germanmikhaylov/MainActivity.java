package ru.androidacademy.lecture3.germanmikhaylov;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        EditText editText = findViewById(R.id.text_input_send_message);
        String webadress = editText.getText().toString();
        Uri paresedWebpage = Uri.parse(webadress);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (intent.resolveActivity(getPackageManager()) != null) {
            intent.setData(paresedWebpage);
            startActivity(intent);
        }
    }
}
