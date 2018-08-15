package amithgc.slidernumpad.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import amithgc.slidernumpad.SliderNumPad;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSingleShowButton();
    }

    private void setSingleShowButton() {
        Button btn_single_show = (Button) findViewById(R.id.btn_single_show);
        btn_single_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SliderNumPad bottomSheetDialogFragment = new SliderNumPad.Builder(MainActivity.this)
                        .setOnTextSelectedListener(new SliderNumPad.OnTextInputFinishListener() {
                            @Override
                            public void onTextSelected(final double value) {
                                Toast.makeText(MainActivity.this, "Selected: " + value, Toast.LENGTH_LONG).show();
                            }
                        })
                        .setButtonBackgroundColor("#efefef")
                        .setButtonEqualsBackgroundColor("#6e84bf")
                        .setButtonSubmitBackgroundColor("#49b756")
                        .setTextColor("#999999")
                        .setTextSubmitColor("#ffffff")
                        .setTextEqualsColor("#ffffff")
                        .setTextSize(20)
                        .setTextStyle(Typeface.BOLD_ITALIC)
                        .create();
                bottomSheetDialogFragment.show(getSupportFragmentManager());
            }
        });
    }
}
