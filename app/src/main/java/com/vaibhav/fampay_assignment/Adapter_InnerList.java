package com.vaibhav.fampay_assignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Adapter_InnerList extends RecyclerView.Adapter<Adapter_InnerList.MyViewHolder> {

    JSONArray data;
    int type;
    int height;

    public Adapter_InnerList(JSONArray data,int type,int height){
        this.data = data;
        this.type = type;
        this.height = height;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        switch (type){
            case 1: return new MyViewHolder(inflater.inflate(R.layout.hc1,parent,false));
            case 3: return new MyViewHolder(inflater.inflate(R.layout.hc3,parent,false));
            case 5: return new MyViewHolder(inflater.inflate(R.layout.hc5,parent,false));
            case 6: return new MyViewHolder(inflater.inflate(R.layout.hc6,parent,false));
            case 9: return new MyViewHolder(inflater.inflate(R.layout.hc9,parent,false));
            default: v = null;
        }
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if(type==1){
            try {
                JSONObject temp = data.getJSONObject(position);
                holder.title.setText(temp.getString("title"));
                URL url = new URL(temp.getJSONObject("icon").getString("image_url"));
                LoadImage l = new LoadImage();
                holder.shapeableImageView.setImageBitmap(l.execute(url).get());
                if(!temp.getString("bg_color").equals("")) holder.cardView.setBackgroundColor(Color.parseColor(temp.getString("bg_color")));
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getString("url")));
                            v.getContext().startActivity(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (JSONException | MalformedURLException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }else if(type==3){
            try {
                JSONObject temp = data.getJSONObject(position);
                holder.title.setText(temp.getString("title"));
                holder.subtitle.setText(temp.getString("description"));
                URL url = new URL(temp.getJSONObject("bg_image").getString("image_url"));
                LoadImage l = new LoadImage();
                holder.linearLayout.setBackground(new BitmapDrawable(l.execute(url).get()));
                //holder.linearLayout.setBackgroundColor(Color.parseColor(temp.getString("bg_color")));
                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getString("url")));
                            v.getContext().startActivity(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                holder.action.setText(temp.getJSONArray("cta").getJSONObject(0).getString("text"));
                holder.action.setBackgroundColor(Color.parseColor(temp.getJSONArray("cta").getJSONObject(0).getString("bg_color")));
                holder.action.setTextColor(Color.parseColor(temp.getJSONArray("cta").getJSONObject(0).getString("text_color")));
                holder.action.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getJSONArray("cta").getJSONObject(0).getString("url")));
                            v.getContext().startActivity(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (JSONException | MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }else if (type==5){
            try {
                JSONObject temp = data.getJSONObject(position);
                URL url = new URL(temp.getJSONObject("bg_image").getString("image_url"));
                LoadImage l = new LoadImage();
                holder.imageView.setImageBitmap(l.execute(url).get());
                holder.linearLayout.setBackgroundColor(Color.parseColor(temp.getString("bg_color")));
                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getString("url")));
                            v.getContext().startActivity(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (JSONException | MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }else if(type==6){
            try {
                JSONObject temp = data.getJSONObject(position);
                holder.title.setText(temp.getString("title"));
                URL url = new URL(temp.getJSONObject("icon").getString("image_url"));
                LoadImage l = new LoadImage();
                holder.shapeableImageView.setImageBitmap(l.execute(url).get());
                holder.cardView.setBackgroundColor(Color.parseColor(temp.getString("bg_color")));
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getString("url")));
                            v.getContext().startActivity(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (JSONException | MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }else{
            try {
                JSONObject temp = data.getJSONObject(position);
                URL url = new URL(temp.getJSONObject("bg_image").getString("image_url"));
                LoadImage l = new LoadImage();
                ViewGroup.LayoutParams params = holder.linearLayout.getLayoutParams();
                params.height = height;
                holder.linearLayout.setLayoutParams(params);
                holder.linearLayout.setBackground(new BitmapDrawable(l.execute(url).get()));
                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getString("url")));
                            v.getContext().startActivity(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (JSONException | MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int getItemCount() {
        return data.length();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ShapeableImageView shapeableImageView;
        TextView title, subtitle;
        LinearLayout linearLayout;
        Button action;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            if(type==1){
                cardView = itemView.findViewById(R.id.cardView_hc1);
                shapeableImageView = itemView.findViewById(R.id.imageView_hc1);
                title = itemView.findViewById(R.id.title_hc1);
            }else if(type==3){
                linearLayout = itemView.findViewById(R.id.linear_layout_hc3);
                title = itemView.findViewById(R.id.title_hc3);
                subtitle = itemView.findViewById(R.id.subtitle_hc3);
                action = itemView.findViewById(R.id.action_button_hc3);
            }else if(type==5){
                linearLayout = itemView.findViewById(R.id.linear_layout_hc5);
                imageView = itemView.findViewById(R.id.imageView_hc5);
            }else if(type==6){
                cardView = itemView.findViewById(R.id.cardView_hc6);
                shapeableImageView = itemView.findViewById(R.id.imageView_hc6);
                title = itemView.findViewById(R.id.title_hc6);
                imageView = itemView.findViewById(R.id.arrow_button_hc6);
            }else{
                linearLayout = itemView.findViewById(R.id.linear_layout_hc9);
            }
        }
    }

}


class LoadImage extends AsyncTask<URL,Void,Bitmap>{

    @Override
    protected Bitmap doInBackground(URL... urls) {
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }
}