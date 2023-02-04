package edu.northeastern.numad23sp_siyueli;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RViewHolder extends RecyclerView.ViewHolder {
    public TextView urlName;
    public TextView url;

    public RViewHolder(View itemView) {
        super(itemView);
        urlName = itemView.findViewById(R.id.item_name);
        url = itemView.findViewById(R.id.item_desc);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlAddress = url.toString();
                if (!urlAddress.startsWith("http://")) {
                    urlAddress = "http://" + urlAddress;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //
                intent.setData(Uri.parse(urlAddress));
                v.getContext().startActivity(intent);
            }
        });

    }
}
