package ru.androidacademy.lecture3.germanmikhaylov;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        javaTextView();
    }

    private void javaTextView() {
        TextView disclaimer = new TextView(this);
        disclaimer.setText("© 2018 German Mikhaylov");
        disclaimer.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        disclaimer.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));

        LinearLayout myLayout = findViewById(R.id.layout);
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, // width
                ViewGroup.LayoutParams.WRAP_CONTENT); // height
        linearLayoutParams.setMargins(16,0,16,0);
        linearLayoutParams.gravity = Gravity.BOTTOM;
        disclaimer.setLayoutParams(linearLayoutParams);
        myLayout.addView(disclaimer);
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
