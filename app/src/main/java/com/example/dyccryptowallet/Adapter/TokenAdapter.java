package com.example.dyccryptowallet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dyccryptowallet.Model.CryptoModel;
import com.example.dyccryptowallet.R;

import java.util.ArrayList;

public class TokenAdapter extends RecyclerView.Adapter<TokenAdapter.CardViewHolder>{

    private ArrayList<CryptoModel> mArrayListToken;
    private Context mcontext;

    public TokenAdapter(Context context, ArrayList<CryptoModel> mArrayListToken) {
        this.mArrayListToken = mArrayListToken;
        this.mcontext = context;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private TokenAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(TokenAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public TokenAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_token, parent, false);

        return new TokenAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TokenAdapter.CardViewHolder holder, int position) {

        holder.imgView_token.setImageResource(mArrayListToken.get(position).getImages());


        holder.txtView_Token.setText(mArrayListToken.get(position).getTokenName());
        holder.txtView_TokenPrice.setText(mArrayListToken.get(position).getTokenPrice());
        holder.txtView_PriceChange.setText(mArrayListToken.get(position).getPriceChange());
        holder.txtView_tokenOwned.setText(mArrayListToken.get(position).getTokenOwned());
        holder.txtView_tokenID.setText(mArrayListToken.get(position).getTokenID());


    }

    @Override
    public int getItemCount() {
        return mArrayListToken.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        androidx.cardview.widget.CardView cv_token;
        ImageView imgView_token;
        TextView txtView_Token, txtView_TokenPrice, txtView_PriceChange, txtView_tokenOwned, txtView_tokenID;

        public CardViewHolder(@NonNull View v) {
            super(v);

            cv_token = (androidx.cardview.widget.CardView) v.findViewById(R.id.cv_token);
            imgView_token = (ImageView) v.findViewById(R.id.imgView_token);

            txtView_Token = (TextView) v.findViewById(R.id.txtView_Token);
            txtView_TokenPrice = (TextView) v.findViewById(R.id.txtView_TokenPrice);
            txtView_PriceChange = (TextView) v.findViewById(R.id.txtView_PriceChange);
            txtView_tokenOwned = (TextView) v.findViewById(R.id.txtView_tokenOwned);
            txtView_tokenID = (TextView) v.findViewById(R.id.txtView_tokenID);
        }
    }
}
