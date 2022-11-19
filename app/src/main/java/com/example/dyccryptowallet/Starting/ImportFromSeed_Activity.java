package com.example.dyccryptowallet.Starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dyccryptowallet.HomePage.HomePage_Activity;
import com.example.dyccryptowallet.R;

import java.util.regex.Pattern;

public class ImportFromSeed_Activity extends AppCompatActivity {

    private EditText editTxt_seedPhrase, editTxt_newPassword, editTxt_confirmPassword;

    private ImageView imgView_scan, btn_back;

    private androidx.appcompat.widget.SwitchCompat switch_faceID;

    private androidx.appcompat.widget.AppCompatButton btn_import;

    private String confirmPassword = " ";
    private String newPassword = " ";
    private String  seedPhrase = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_from_seed);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_import.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateSeedPhase();

                validateNewPassword();

                validateConfirmPassword();

                validateInput();
            }
        });
    }

    private void validateInput() {

        if (!validateSeedPhase() | !validateNewPassword() | !validateConfirmPassword())
            return;
        else
        {
            startActivity(new Intent(getApplicationContext(), HomePage_Activity.class));
        }
    }

    private boolean validateConfirmPassword() {

        confirmPassword = editTxt_confirmPassword.getText().toString();

        if (confirmPassword.isEmpty())
        {
            editTxt_confirmPassword.setError("Field cannot be empty in order to proceed");
            return false;
        }
        else if (!confirmPassword.equals(newPassword))
        {
            editTxt_confirmPassword.setError("Password is not the same as the new password above");
            return false;
        }
        else
            return true;
    }

    private boolean validateNewPassword() {

        newPassword = editTxt_newPassword.getText().toString();

        // defining our own password pattern
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                        "(?=\\S+$)" +            // no white spaces
                        ".{8,}" +                // at least 8 characters
                        "$");

        if (newPassword.isEmpty())
        {
            editTxt_newPassword.setError("Field cannot be empty in order to proceed");
            return false;
        }
        else if (newPassword.length() < 8)
        {
            editTxt_newPassword.setError("New Password must be at least 8 characters");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(newPassword).matches())
        {
            editTxt_newPassword.setError("New Password is too weak");
            return false;
        }
        else
            return true;

    }

    private boolean validateSeedPhase() {
        //Cross check with the database to see if the seed phrase exist

        seedPhrase = editTxt_seedPhrase.getText().toString();

        if (seedPhrase.isEmpty())
        {
            editTxt_seedPhrase.setError("Seed phrase is needed to proceed");
            return false;
        }
        else
        {
            //TODO: Check if the seed phrase really exist
            return true;
        }
    }

    private void initUI() {

        if (!editTxt_seedPhrase.getText().toString().isEmpty() | !editTxt_newPassword.getText().toString().isEmpty() | !editTxt_confirmPassword.getText().toString().isEmpty())
        {
            btn_import.setBackgroundResource(R.drawable.gradient_btn);
            System.out.println("Yessir");
        }

        if (!seedPhrase.isEmpty() | !newPassword.isEmpty() | !confirmPassword.isEmpty())
        {
            int[] colors = {Color.parseColor("#8AD4EC"),Color.parseColor("#EF96FF"), Color.parseColor("#FF56A9"), Color.parseColor("#FFAA6C")};

            //create a new gradient color
            GradientDrawable gd = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, colors);

            gd.setCornerRadius(0f);
            //apply the button background to newly created drawable gradient
            btn_import.setBackground(gd);
        }
    }

    private void initWidget() {

        //EditText
        editTxt_seedPhrase = findViewById(R.id.editTxt_seedPhrase);
        editTxt_newPassword = findViewById(R.id.editTxt_newPassword);
        editTxt_confirmPassword = findViewById(R.id.editTxt_confirmPassword);

        //ImageView
        imgView_scan = findViewById(R.id.imgView_scan);
        btn_back = findViewById(R.id.btn_back);

        //androidx.appcompat.widget.SwitchCompat
        switch_faceID = findViewById(R.id.switch_faceID);

        //Button
        btn_import = findViewById(R.id.btn_import);
    }
}