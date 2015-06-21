package br.com.softblue.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by RogerWillian on 21/06/2015.
 */
public class SegundaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

         /* Recuperando a mensagem enviada da primeira Activity */
        String msg = this.getIntent().getStringExtra("msg");
        TextView textView = (TextView) this.findViewById(R.id.txtMsg);
        textView.setText(msg);
    }

    public void preview(View view){

        String status = "Activity visualizada !";
        Intent it = new Intent(this.getApplicationContext(), PrimeiraActivity.class);
        it.putExtra("status", status);

        /* Garante que os dos serão voltados */

        this.setResult(RESULT_OK, it);
        this.finish();
    }
}
