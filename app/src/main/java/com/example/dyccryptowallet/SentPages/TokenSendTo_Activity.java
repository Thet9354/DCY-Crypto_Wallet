package com.example.dyccryptowallet.SentPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dyccryptowallet.Adapter.MyAccountAdapter;
import com.example.dyccryptowallet.Adapter.TokenAdapter;
import com.example.dyccryptowallet.Fragment.wallet;
import com.example.dyccryptowallet.Model.CryptoModel;
import com.example.dyccryptowallet.Model.MyAccounts;
import com.example.dyccryptowallet.R;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class TokenSendTo_Activity extends AppCompatActivity {

    private MyAccountAdapter myAccountAdapter;
    private ArrayList<MyAccounts> mArrayListAccounts = new ArrayList<MyAccounts>();

    private ImageView btn_cancel, btn_forward;

    private TextView txtView_account, txtView_accBalance, txtView_transferBetweenMyAcc;

    private EditText editTxt_sendTo;

    private androidx.recyclerview.widget.RecyclerView rc_recentSendToAcc;

    private Context mContext;

    MyAccounts myAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_send_to);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

    }

    private void initUI() {

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });

    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout LL_accounts = dialog.findViewById(R.id.LL_accounts);
        androidx.recyclerview.widget.RecyclerView rv_myAccounts = dialog.findViewById(R.id.rv_myAccounts);

        LL_accounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TokenSendTo_Activity.this, "Lmao", Toast.LENGTH_SHORT).show();
            }
        });


        //------------rv_myAccounts ----------
        rv_myAccounts.setHasFixedSize(true);
        myAccountAdapter = new MyAccountAdapter(getApplicationContext(), mArrayListAccounts);
        rv_myAccounts.setAdapter(myAccountAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setSmoothScrollbarEnabled(true);

        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_myAccounts.setLayoutManager(llm);

        new LoadAllAccount().execute();

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        class LoadAllAccount extends AsyncTask<String, String, String> {



            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                rv_myAccounts.setVisibility(View.VISIBLE);
            }

            protected String doInBackground(String... args) {
                try {

                    String[] accountName = getResources().getStringArray(R.array.AccountName);
                    String[] walletAddress = getResources().getStringArray(R.array.WalletAddress);


                    for (int i = 0 ; i < accountName.length; i++)
                    {
                        myAccounts = new MyAccounts();
                        myAccounts.setId(i);
//                        myAccounts.setImages(tokenPic[i]);
                        myAccounts.setAccountName(accountName[i]);
                        myAccounts.setWalletAddress(walletAddress[i]);

                        mArrayListAccounts.add(myAccounts);
                        myAccounts = null;
                    }


                } catch (Exception e) {
                    e.printStackTrace();

                }

                return null;
            }

            protected void onPostExecute(String file_url) {

                rv_myAccounts.setVisibility(View.GONE);

                if (mArrayListAccounts != null && mArrayListAccounts.size() > 0) {
                    myAccountAdapter = new TokenAdapter(mContext, mArrayListAccounts);
                    rv_myAccounts.setAdapter(myAccountAdapter);
                    myAccountAdapter.notifyDataSetChanged();
                }
            }
        }

    }




    private void initWidget() {

        //ImageView
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_forward = findViewById(R.id.btn_forward);

        //TextView
        txtView_account = findViewById(R.id.txtView_account);
        txtView_accBalance = findViewById(R.id.txtView_accBalance);
        txtView_transferBetweenMyAcc = findViewById(R.id.txtView_transferBetweenMyAcc);

        //EditText
        editTxt_sendTo = findViewById(R.id.editTxt_sendTo);

        //RecyclerView
        rc_recentSendToAcc = findViewById(R.id.rc_recentSendToAcc);
    }
}