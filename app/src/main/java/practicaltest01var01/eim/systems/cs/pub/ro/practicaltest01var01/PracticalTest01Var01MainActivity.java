package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private EditText historyEditText;
    private Button genericButton;
    private int counterPoints = 0;
    private int SECONDARY_ACTIVITY_REQUEST_CODE = 10;

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.north_button:
                    if (historyEditText.getText().toString().isEmpty()) {
                        historyEditText.setText("North");
                    }
                    else {
                        historyEditText.setText(historyEditText.getText().toString() + ", North");
                    }
                    counterPoints = counterPoints + 1;
                    break;
                case R.id.south_button:
                    if (historyEditText.getText().toString().isEmpty()) {
                        historyEditText.setText("South");
                    }
                    else {
                        historyEditText.setText(historyEditText.getText().toString() + ", South");
                    }
                    counterPoints = counterPoints + 1;
                    break;

                case R.id.west_button:
                    if (historyEditText.getText().toString().isEmpty()) {
                        historyEditText.setText("West");
                    }
                    else {
                        historyEditText.setText(historyEditText.getText().toString() + ", West");
                    }
                    counterPoints = counterPoints + 1;
                    break;

                case R.id.east_button:
                    if (historyEditText.getText().toString().isEmpty()) {
                        historyEditText.setText("East");
                    }
                    else {
                        historyEditText.setText(historyEditText.getText().toString() + ", East");
                    }
                    counterPoints = counterPoints + 1;
                    break;

                case R.id.navigate_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    intent.putExtra("history", historyEditText.getText().toString());
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        historyEditText = (EditText)findViewById(R.id.history_text);

        genericButton = (Button)findViewById(R.id.north_button);
        genericButton.setOnClickListener(genericButtonClickListener);

        genericButton = (Button)findViewById(R.id.south_button);
        genericButton.setOnClickListener(genericButtonClickListener);

        genericButton = (Button)findViewById(R.id.west_button);
        genericButton.setOnClickListener(genericButtonClickListener);

        genericButton = (Button)findViewById(R.id.east_button);
        genericButton.setOnClickListener(genericButtonClickListener);

        genericButton = (Button)findViewById(R.id.navigate_button);
        genericButton.setOnClickListener(genericButtonClickListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            counterPoints = 0;
            historyEditText.setText("");

            if (resultCode == 0)
                Toast.makeText(this, "Button pressed: cancel", Toast.LENGTH_LONG).show();
            else if (resultCode == 1)
                Toast.makeText(this, "Button pressed: register", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Counter", counterPoints);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("Counter")) {
            counterPoints = savedInstanceState.getInt("Counter");
            Toast.makeText(this, "Previous counter " + counterPoints, Toast.LENGTH_LONG).show();
        }
    }
}
