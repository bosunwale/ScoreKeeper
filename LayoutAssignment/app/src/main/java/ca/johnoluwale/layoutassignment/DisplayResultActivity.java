package ca.johnoluwale.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {
    TextView teamA, teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        teamA = findViewById(R.id.textTeamAScore);
        teamB = findViewById(R.id.textTeamBScore);
        Bundle bundle;
        bundle = getIntent().getExtras();
        teamA.setText(bundle.getString("Team A"));
        teamB.setText(bundle.getString("Team B"));
    }
}