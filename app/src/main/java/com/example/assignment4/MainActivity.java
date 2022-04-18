package com.example.assignment4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCAD;
    EditText conversionAmountText;
    Button btnEuro;
    Button btnGBP;
    Button btnCHF;
    double conversionAmount, cad, euro, gbp, chf, cny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversionAmountText = findViewById(R.id.conversionAmount);
        btnCAD = findViewById(R.id.btnCAD);
        btnEuro = findViewById(R.id.btnEuro);
        btnGBP = findViewById(R.id.btnGBP);
        btnCHF = findViewById(R.id.btnCHF);

        btnCAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversionAmount = Double.parseDouble(String.valueOf(conversionAmountText.getText()));
                cad = conversionAmount * 1.25;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("conversionAmount", conversionAmount);
                intent.putExtra("cad", cad);
                startActivity(intent);
            }
        });

        btnEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversionAmount = Double.parseDouble(String.valueOf(conversionAmountText.getText()));
                euro = conversionAmount * 0.91;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("conversionAmount", conversionAmount);
                intent.putExtra("cad", euro);
                startActivity(intent);
            }
        });

        btnGBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversionAmount = Double.parseDouble(String.valueOf(conversionAmountText.getText()));
                gbp = conversionAmount * 0.76;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("conversionAmount", conversionAmount);
                intent.putExtra("cad", gbp);
                startActivity(intent);
            }
        });

        btnCHF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversionAmount = Double.parseDouble(String.valueOf(conversionAmountText.getText()));
                chf = conversionAmount * 0.93;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("conversionAmount", conversionAmount);
                intent.putExtra("cad", chf);
                startActivity(intent);
            }
        });


    }

    public void clickButton(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Convert");
        builder.setMessage("Do you want to convert to Chinese Yuan?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                conversionAmount = Double.parseDouble(String.valueOf(conversionAmountText.getText()));
                cny = conversionAmount * 6.36;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("conversionAmount", conversionAmount);
                intent.putExtra("cad", cny);
                startActivity(intent);
            }

        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You clicked cancel", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void showResults(View view) {

        Uri uri = Uri.parse("content://com.example.assignment4.ExampleProvider/currencies");

        Cursor cr = getContentResolver().query(uri, null, null, null, null);

        TextView output = findViewById(R.id.tv);
        String results = "Database results: \n";
        if (cr.moveToFirst())
            do {
                for (int i = 0; i < cr.getColumnCount(); i++)
                    results += cr.getString(i) + "  ";
                results += "\n";
            } while (cr.moveToNext());

        cr.close();

        output.setText(results);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search:
                Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contact:
                Toast.makeText(this, "You clicked Contact Us", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.otherOptions:
                Toast.makeText(this, "You clicked Other options", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    public void extraInfo(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void extraLocale(View view) {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }


}