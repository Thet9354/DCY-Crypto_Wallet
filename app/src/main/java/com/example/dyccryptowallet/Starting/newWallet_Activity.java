package com.example.dyccryptowallet.Starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dyccryptowallet.HomePage.HomePage_Activity;
import com.example.dyccryptowallet.R;

import java.util.regex.Pattern;

public class newWallet_Activity extends AppCompatActivity {

    private ImageView btn_back;

    private TextView txtView_createPassword, txtView_warning;

    private EditText editTxt_newPassword, editTxt_confirmNewPassword;

    private androidx.appcompat.widget.SwitchCompat switch_faceID;

    private androidx.appcompat.widget.AppCompatCheckBox cb_TC;

    private androidx.appcompat.widget.AppCompatButton btn_createNewWallet;

    private String mPassword, mConfirmPassword;

    //---Variables to store data
    private boolean TC = true;

    private boolean activateFaceID = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_wallet);

        initWidget();

        initUI();

        pageDirectories();

    }

    private void initUI() {

        if (!editTxt_newPassword.getText().toString().isEmpty() | !editTxt_confirmNewPassword.getText().toString().isEmpty())
        {
            btn_createNewWallet.setBackgroundResource(R.drawable.gradient_btn);
        }

        setTextViewColor(txtView_createPassword,
                getResources().getColor(R.color.dcy1),
                getResources().getColor(R.color.dcy2),
                getResources().getColor(R.color.dcy3),
                getResources().getColor(R.color.dcy4));
    }

    private void setTextViewColor(TextView txtView_createPassword, int...color) {
        TextPaint paint = txtView_createPassword.getPaint();
        float width = paint.measureText(txtView_createPassword.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, txtView_createPassword.getTextSize(), color, null, Shader.TileMode.CLAMP);
        txtView_createPassword.getPaint().setShader(shader);
        txtView_createPassword.setTextColor(color[0]);
    }

    private void pageDirectories() {

        switch_faceID.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked)
                    startActivity(new Intent(getApplicationContext(), HomePage_Activity.class));

            }
        });

        btn_createNewWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validatePassword();
                validateConfirmWallet();
                validateTC();
                validateInput();
            }
        });

        cb_TC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    TC = true;
                }
                else
                {
                    TC = false;
                }
            }
        });
    }

    private boolean validateTC() {

        if (!TC)
        {
            txtView_warning.setVisibility(View.VISIBLE);
            return false;
        }
        else
            return true;
    }

    private void validateInput() {

        if (!validatePassword() | !validateConfirmWallet() | !validateTC())
            return;
        else
        {
            startActivity(new Intent(getApplicationContext(), SecureWallet_Activity.class));
        }
    }

    private boolean validateConfirmWallet() {

        mConfirmPassword = editTxt_confirmNewPassword.getText().toString();

        if (mConfirmPassword.isEmpty())
        {
            editTxt_confirmNewPassword.setError("Field cannot be empty in order to proceed");
            return false;
        }
        else if (!mConfirmPassword.equals(mPassword))
        {
            editTxt_confirmNewPassword.setError("Password is not the same as the new password above");
            return false;
        }
        else
            return true;
    }

    private boolean validatePassword() {

        // defining our own password pattern
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                        "(?=\\S+$)" +            // no white spaces
                        ".{8,}" +                // at least 8 characters
                        "$");

        mPassword = editTxt_newPassword.getText().toString();

        if (mPassword.isEmpty())
        {
            editTxt_newPassword.setError("Field cannot be empty in order to proceed");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(mPassword).matches())
        {
            editTxt_newPassword.setError("New Password is too weak");
            return false;
        }
        else
            return true;

    }

    private void initWidget() {

        //TextView
        txtView_createPassword = findViewById(R.id.txtView_createPassword);
        txtView_warning = findViewById(R.id.txtView_warning);

        //Button
        btn_back = findViewById(R.id.btn_back);

        //EditText
        editTxt_newPassword = findViewById(R.id.editTxt_newPassword);
        editTxt_confirmNewPassword = findViewById(R.id.editTxt_confirmNewPassword);

        //androidx.appcompat.widget.SwitchCompat
        switch_faceID = findViewById(R.id.switch_faceID);

        //CheckBox
        cb_TC = findViewById(R.id.cb_TC);

        //androidx.appcompat.widget.AppCompatButton
        btn_createNewWallet = findViewById(R.id.btn_createNewWallet);

    }
}