package amithgc.slidernumpad.demo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
                            public void onTextSelected(final Uri uri) {
                                Log.d("ted", "uri: " + uri);
                                Log.d("ted", "uri.getPath(): " + uri.getPath());
                            }
                        })
                        .create();
                bottomSheetDialogFragment.show(getSupportFragmentManager());
            }
        });
    }
}
