package ca.johnoluwale.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    int scoreA, scoreB, spinnerPoints;
    String spinnerValues, TeamA, TeamB;
    EditText editTextTeamA, editTextTeamB;
    Spinner spinnerObjPoints;
    Button displayResultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /*
        Here, I created the items for the spinner container
        and used the datatype integer instead of the charsequence.
        The reason for this is to validate the score
         */
        spinnerObjPoints = findViewById(R.id.spinnerPoints);
        Integer[] points = new Integer[]{1,2,3};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, points);
        spinnerObjPoints.setAdapter(adapter);


        Button addButtonTeamA = findViewById(R.id.buttonAddScoreTeamA);
        Button subtractButtonTeamA = findViewById(R.id.buttonSubtractScoreTeamA);
        Button addButtonTeamB = findViewById(R.id.buttonAddScoreTeamB);
        Button subtractButtonTeamB = findViewById(R.id.buttonSubtractScoreTeamB);
        displayResultButton = findViewById(R.id.buttonDisplayResult);
        editTextTeamA = findViewById(R.id.editTextTeamA);
        editTextTeamB = findViewById(R.id.editTextTeamB);

        addButtonTeamA.setOnClickListener(this);
        subtractButtonTeamA.setOnClickListener(this);
        addButtonTeamB.setOnClickListener(this);
        subtractButtonTeamB.setOnClickListener(this);

        displayResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamA = editTextTeamA.getText().toString();
                TeamB = editTextTeamB.getText().toString();
                Intent intent = new Intent(MainActivity.this, DisplayResultActivity.class);
                intent.putExtra("Team A", TeamA);
                intent.putExtra("Team B", TeamB);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*
    Here lies the code that handles the
    score handling for both teams.
     */
    @Override
    public void onClick(View v) {
        /*
        Here I passed in the spinner object to a string and
        explicitly casted the string to integer for comparison
        in order to get the appropriate score based on the
        selected item from the spinner
         */
        spinnerValues = spinnerObjPoints.getSelectedItem().toString();
        spinnerPoints = Integer.parseInt(spinnerValues);
        int id = v.getId();
        if (id == R.id.buttonAddScoreTeamA && spinnerPoints == 1) {
            scoreA += 1;
        } else if (id == R.id.buttonAddScoreTeamA && spinnerPoints == 2) {
            scoreA += 2;
        } else if (id == R.id.buttonAddScoreTeamA && spinnerPoints == 3) {
            scoreA += 3;
        }else if(id == R.id.buttonSubtractScoreTeamA){
            scoreA -=1 ;
        }
            editTextTeamA = findViewById(R.id.editTextTeamA);
            editTextTeamA.setText(Integer.toString(scoreA));

            if (id == R.id.buttonAddScoreTeamB && spinnerPoints == 1) {
                scoreB += 1;
            } else if (id == R.id.buttonAddScoreTeamB && spinnerPoints == 2) {
                scoreB += 2;
            }else if (id == R.id.buttonAddScoreTeamB && spinnerPoints == 3) {
                scoreB += 3;
            }else if(id == R.id.buttonSubtractScoreTeamB){
                scoreB -=1 ;
            }
            editTextTeamB = findViewById(R.id.editTextTeamB);
            editTextTeamB.setText(Integer.toString(scoreB));
    }
}