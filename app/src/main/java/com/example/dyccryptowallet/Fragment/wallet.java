package com.example.dyccryptowallet.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.dyccryptowallet.Adapter.CollectiblesAdapter;
import com.example.dyccryptowallet.Adapter.TokenAdapter;
import com.example.dyccryptowallet.Model.CryptoModel;
import com.example.dyccryptowallet.R;
import com.example.dyccryptowallet.SentPages.TokenSendTo_Activity;

import java.util.ArrayList;

public class wallet extends Fragment {

    private TokenAdapter mTokenAdapter;
    private ArrayList<CryptoModel> mArrayListToken = new ArrayList<>();


    private CollectiblesAdapter mCollectiblesAdapter;
    private ArrayList<CryptoModel> mArrayListCollectibles = new ArrayList<>();

    private TextView txtView_sent, txtView_receive, txtView_buy;


    private TextView txtView_network, txtView_cryptoCurrency, txtView_currency, txtView_accBalance,
            txtView_profitPercentage, txtView_token, txtView_collectibles;

    private androidx.recyclerview.widget.RecyclerView rc_cryptoToken, rc_collectibles;

    private Context mContext;

    int[] tokenPic = {R.drawable.bitcoin, R.drawable.ethereum, R.drawable.tether, R.drawable.usdc, R.drawable.binance,
            R.drawable.xrp, R.drawable.dogecoin, R.drawable.cardano, R.drawable.polygon, R.drawable.polkadot};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_wallet, container, false);

        mContext = getActivity();

        initUI(rootView);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        return rootView;
    }

    private void initUI(View view) {

        //TextView
        txtView_network = view.findViewById(R.id.txtView_network);
        txtView_cryptoCurrency = view.findViewById(R.id.txtView_cryptoCurrency);
        txtView_currency = view.findViewById(R.id.txtView_currency);
        txtView_accBalance = view.findViewById(R.id.txtView_accBalance);
        txtView_profitPercentage = view.findViewById(R.id.txtView_profitPercentage);
        txtView_token = view.findViewById(R.id.txtView_token);
        txtView_collectibles = view.findViewById(R.id.txtView_collectibles);
        txtView_sent = view.findViewById(R.id.txtView_sent);

        //androidx.recyclerview.widget.RecyclerView
        rc_cryptoToken = view.findViewById(R.id.rc_cryptoToken);
        rc_collectibles = view.findViewById(R.id.rc_collectibles);



        initRecView();
    }

    private void initRecView() {


        //------------rc_cryptoToken ----------
        rc_cryptoToken.setHasFixedSize(true);
        mTokenAdapter = new TokenAdapter(getContext(), mArrayListToken);
        rc_cryptoToken.setAdapter(mTokenAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setSmoothScrollbarEnabled(true);

        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rc_cryptoToken.setLayoutManager(llm);

        new LoadAllToken().execute();

        initTokenRecView();

        pageDirectories();
    }

    private void pageDirectories() {

        txtView_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView_token.getPaint().setUnderlineText(true);
                txtView_token.setTextColor(Color.WHITE);

                txtView_collectibles.getPaint().setUnderlineText(false);
                txtView_collectibles.setTextColor(Color.parseColor("#8FA2B7"));

                initTokenRecView();
            }
        });

        txtView_collectibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView_collectibles.getPaint().setUnderlineText(true);
                txtView_collectibles.setTextColor(Color.WHITE);

                txtView_token.getPaint().setUnderlineText(false);
                txtView_token.setTextColor(Color.parseColor("#8FA2B7"));

                initCollectiblesRecView();
            }
        });

        txtView_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TokenSendTo_Activity.class));
            }
        });
    }

    CryptoModel cryptoModel;

    private void initCollectiblesRecView() {

        rc_collectibles.setVisibility(View.VISIBLE);
        rc_cryptoToken.setVisibility(View.GONE);

    }

    private void initTokenRecView() {

        rc_cryptoToken.setVisibility(View.VISIBLE);
        rc_collectibles.setVisibility(View.GONE);


    }

    class LoadAllToken extends AsyncTask<String, String, String> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            rc_cryptoToken.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... args) {
            try {

                String[] tokenName = getResources().getStringArray(R.array.token);
                String[] tokenID = getResources().getStringArray(R.array.tokenID);
                String[] tokenPrice = getResources().getStringArray(R.array.tokenPrice);
                String[] tokenPriceChange = getResources().getStringArray(R.array.tokenPriceChange);
                String[] tokenOwned = getResources().getStringArray(R.array.tokenOwned);


                for (int i = 0 ; i < tokenName.length; i++)
                {
                    cryptoModel = new CryptoModel();
                    cryptoModel.setId(i);
                    cryptoModel.setImages(tokenPic[i]);
                    cryptoModel.setTokenID(tokenID[i]);
                    cryptoModel.setTokenName(tokenName[i]);
                    cryptoModel.setTokenPrice(tokenPrice[i]);
                    cryptoModel.setTokenOwned(tokenOwned[i]);
                    cryptoModel.setPriceChange(tokenPriceChange[i]);
                    mArrayListToken.add(cryptoModel);
                    cryptoModel = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

            rc_cryptoToken.setVisibility(View.GONE);

            if (mArrayListToken != null && mArrayListToken.size() > 0) {
                mTokenAdapter = new TokenAdapter(mContext, mArrayListToken);
                rc_cryptoToken.setAdapter(mTokenAdapter);
                mTokenAdapter.notifyDataSetChanged();
            }
        }
    }
}