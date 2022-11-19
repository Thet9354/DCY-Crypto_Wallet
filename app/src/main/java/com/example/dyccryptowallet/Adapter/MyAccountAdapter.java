package com.example.dyccryptowallet.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dyccryptowallet.Model.MyAccounts;
import com.example.dyccryptowallet.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAccountAdapter extends RecyclerView.Adapter<MyAccountAdapter.CardViewHolder>{

    private ArrayList<MyAccounts> mArrayListAccounts;
    private Context mcontext;

    public MyAccountAdapter(Context mcontext, ArrayList<MyAccounts> mArrayListAccounts) {
        this.mArrayListAccounts = mArrayListAccounts;
        this.mcontext = mcontext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private MyAccountAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(MyAccountAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public MyAccountAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_accounts, parent, false);

        return new MyAccountAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAccountAdapter.CardViewHolder holder, int position) {

        holder.imgView_acc.setImageResource(mArrayListAccounts.get(position).getImages());

        holder.txtView_accName.setText(mArrayListAccounts.get(position).getAccountName());
        holder.txtView_walletAddress.setText(mArrayListAccounts.get(position).getWalletAddress());

    }

    @Override
    public int getItemCount() {
        return mArrayListAccounts.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private androidx.cardview.widget.CardView cv_account;
        private ImageView imgView_acc;
        private TextView txtView_accName, txtView_walletAddress;

        public CardViewHolder(@NonNull View v) {
            super(v);

            cv_account = (androidx.cardview.widget.CardView) v.findViewById(R.id.cv_account);
            imgView_acc = (ImageView) v.findViewById(R.id.imgView_acc);

            txtView_accName = (TextView) v.findViewById(R.id.txtView_accName);
            txtView_walletAddress = (TextView) v.findViewById(R.id.txtView_walletAddress);

        }
    }
}
