package br.com.softblue.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class PrimeiraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
    }

    public void next(View view){
        Intent it = new Intent(this.getApplicationContext(), SegundaActivity.class);

        /* Enviando uma mensagem para a Segunda activity */
        String msg = "Mensagem vinda da Primeira Activity";
        it.putExtra("msg", msg);
        //startActivity(it);

        this.startActivityForResult(it,100);
    }

    /* Esse método é chamado pelo android, quando uma subActivity é fechada */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK ){
            String status = data.getStringExtra("status");

            Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
            Button button = (Button) this.findViewById(R.id.btn);
            button.setEnabled(false);
        }
    }
}
