package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {
    private Button RegisterButton;
    private Button CancelButton;
    private EditText historyText;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.register_button:
                    setResult(1, null);
                    break;
                case R.id.cancel_button:
                    setResult(0, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        historyText = (EditText)findViewById(R.id.secondary_text);
        RegisterButton = (Button)findViewById(R.id.register_button);
        RegisterButton.setOnClickListener(buttonClickListener);

        CancelButton = (Button)findViewById(R.id.cancel_button);
        CancelButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("history")) {
            String history = intent.getStringExtra("history");
            historyText.setText(String.valueOf(history));
        }
    }
}
