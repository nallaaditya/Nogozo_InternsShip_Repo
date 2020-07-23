package com.example.nogozo_aditya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    Context context;
    String data1[];
    int images[];



    ArrayList<Brand> items;

    ArrayList<Brand> itemsfiltered;



    public MyAdapter(Context context, String[] data1, int[] images, List<Brand>itemslist) {
        this.context = context;
        this.data1 = data1;
        this.images = images;
        items=new ArrayList<Brand>(itemslist);

        itemsfiltered=new ArrayList<Brand>(itemslist);

    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recycler_item,parent,false);

        return new MyViewHolder(view);

    }

    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position)
    {

        holder.name.setText(itemsfiltered.get(position).name);

        holder.imageview.setImageResource(itemsfiltered.get(position).image);

    }

    public int getItemCount() {
        return itemsfiltered.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageview;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.item_language);
            imageview=itemView.findViewById(R.id.item_imageview);

        }
    }


    public void filter(String query)
    {
        if(query.isEmpty())
        {
            itemsfiltered=items;
        }
        else
        {

            ArrayList<Brand> filteredList = new ArrayList<>();
            for (Brand row :items) {


                if ((search_algo_kmp(query.toString().toLowerCase(),row.name.toString().toLowerCase())==1))
                {
                    filteredList.add(row);
                }
            }

            itemsfiltered = filteredList;
        }

        notifyDataSetChanged();



    }


    int search_algo_kmp(String substring, String mainstring)
    {

        //length of substring
        int x = substring.length();


        //length of main string
        int y = mainstring.length();



        int longest_prefix_suffix_values[] = new int[x];

        // index for substring[]
        int j = 0;


       //inorder to compute the longest prefix suffix values
        computeLPSArray(substring, x, longest_prefix_suffix_values);


        // index for mainstring[]
        int i = 0;


        while (i < y) {
            if (substring.charAt(j) == mainstring.charAt(i)) {
                j++;
                i++;
            }
            if (j == x) {
              return 1;
            }
            //checking if they mismatch
            else if (i < y && substring.charAt(j) != mainstring.charAt(i)) {
                // Do not match longest_prefix_suffix_values[0..longest_prefix_suffix_values[j-1]] characters,
                if (j != 0)
                    j = longest_prefix_suffix_values[j - 1];
                else
                    i = i + 1;
            }
        }
        return 0;
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {

                if (len != 0) {
                    len = lps[len - 1];

                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }



}
