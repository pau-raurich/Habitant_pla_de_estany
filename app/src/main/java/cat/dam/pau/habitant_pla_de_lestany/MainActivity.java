package cat.dam.pau.habitant_pla_de_lestany;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //Array dels municips disponibles
    String[] municipis = new String[]{
            "Banyoles","Cornellà del Terri","Mata","Camós","Palol de Revardit",
            "Sant Miquel de Campmajor","Serinya","Crespìà","Esponella","Fontcoberta",
            "Vilademuls"
    };

    //Array dels habitants per municipis (ordenat)
    int [] habitants = new int[]{
            17451,2106,1903,698,459,218,1084,247,441,1212,769
    };

    //HashMap per relacionar municipis(key) amb habitants(value)
    HashMap<String,Integer> habitantsMunicipi = new HashMap<String, Integer>();


    //Funció que fa la relacio de municipis amb habitants
    public void setHashMap(){
        for(int i=0; i<municipis.length;i++){
            habitantsMunicipi.put(municipis[i],habitants[i]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setHashMap();

        final Button btn_Cerca = findViewById(R.id.boto_buscar);
        final TextView tv_totalHabitants = findViewById(R.id.casella_resultat_habitants);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, municipis);

        AutoCompleteTextView atv_Municipi  = (AutoCompleteTextView) findViewById(R.id.casella_resultat_municipi);

        atv_Municipi.setAdapter(adapter);

        btn_Cerca.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                String municipiSeleccionat = atv_Municipi.getText().toString();

                tv_totalHabitants.setText(String.valueOf(habitantsMunicipi.get(municipiSeleccionat)));
            }
        });

    }
}