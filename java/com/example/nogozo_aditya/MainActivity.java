package com.example.nogozo_aditya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{


    RecyclerView recyclerView;

    String suntypes[];

    int images[];

    EditText editText;

    MyAdapter myAdapter;

    ArrayList<Brand> items;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        items=new ArrayList<Brand>();

        editText=(EditText)findViewById(R.id.actv);


        images=new int[]{R.drawable.adobe_animate,R.drawable.adobe_audition,R.drawable.adobe_bridge,R.drawable.adobe_dreamweaver,
                R.drawable.adobe_fireworks,R.drawable.adobe_flash,R.drawable.adobe_illustrator,R.drawable.adobe_indesign,
                R.drawable.adobe_lightroom,R.drawable.adobe_photoshop,R.drawable.adobe_premierpro,R.drawable.adobe_xd,
                R.drawable.amazon,R.drawable.amazon_alexa,R.drawable.amazon_music,R.drawable.amazon_webservices,
                R.drawable.android,R.drawable.apple,R.drawable.ardunio,R.drawable.avast,R.drawable.bbc,R.drawable.bbm_messenger,
                R.drawable.bing,R.drawable.bitcoin,R.drawable.blackberry,R.drawable.bmw,R.drawable.breakingbad,
                R.drawable.britishairways,R.drawable.burgerking,R.drawable.chrome,R.drawable.citibank,R.drawable.dashcube,
                R.drawable.dell,R.drawable.discord,R.drawable.disney_movies,R.drawable.drupal,R.drawable.ebay,R.drawable.facebook,
                R.drawable.facebook_messenger,R.drawable.ferrai,R.drawable.firefox,R.drawable.flutter,R.drawable.git,R.drawable.github,
                R.drawable.gmail,R.drawable.google,R.drawable.google_alerts,R.drawable.google_blog_search,R.drawable.google_classroom,
                R.drawable.google_cloudplatform,R.drawable.google_code,R.drawable.google_computeengine,R.drawable.google_docs,
                R.drawable.google_drawing,R.drawable.google_drawive,R.drawable.google_earth,R.drawable.google_form,
                R.drawable.google_groups,R.drawable.google_images,R.drawable.google_keep,R.drawable.google_maps,
                R.drawable.google_maps_old,R.drawable.google_mobile,R.drawable.google_news,R.drawable.google_photos,
                R.drawable.google_playstore,R.drawable.google_scholar,R.drawable.google_sheets,R.drawable.google_sketchup,
                R.drawable.google_slides,R.drawable.google_translate,R.drawable.google_wallet,R.drawable.google_websearch,
                R.drawable.hangouts,R.drawable.haskell,R.drawable.hbogo,R.drawable.honda,R.drawable.hp,R.drawable.hsbc,
                R.drawable.icq,R.drawable.instagram,R.drawable.intellij_idea,R.drawable.james_bond,R.drawable.jarvis,R.drawable.java,
                R.drawable.jeep,R.drawable.kik_messenger,R.drawable.kotlin,R.drawable.linkedin,R.drawable.maclogo,R.drawable.mastercard,
                R.drawable.microsoft,R.drawable.microsoft_access,R.drawable.microsoft_classroom,R.drawable.microsoft_edge,
                R.drawable.microsoft_excel,R.drawable.microsoft_exchange,R.drawable.microsoft_grove,R.drawable.microsoft_mixer,
                R.drawable.microsoft_onenote,R.drawable.microsoft_outlook,R.drawable.microsoft_powerpoint,
                R.drawable.microsoft_project,R.drawable.microsoft_publisher,R.drawable.microsoft_sharepoint,
                R.drawable.microsoft_todo_app,R.drawable.microsoft_visio,R.drawable.microsoft_word,
                R.drawable.mitbushi,R.drawable.moodle,R.drawable.netflix,R.drawable.nike,R.drawable.nikon,R.drawable.onedrive,
                R.drawable.ookla_speedtest,R.drawable.openstack,R.drawable.opera,R.drawable.paypal,R.drawable.pinterest,
                R.drawable.pirates_of_caribeean,R.drawable.playstation,R.drawable.powerpoint,R.drawable.power_bi,
                R.drawable.pubg,R.drawable.qq,R.drawable.react_naive,R.drawable.renault,R.drawable.selenium,R.drawable.signal,
                R.drawable.skype,R.drawable.slack,R.drawable.slack_new,R.drawable.snapchat,R.drawable.spotify,R.drawable.starwars,
                R.drawable.swift,R.drawable.tableau,R.drawable.telegram,R.drawable.threema,R.drawable.thunderbird,R.drawable.twitter,
                R.drawable.united_airlines,R.drawable.verge,R.drawable.vimeo,R.drawable.visa,R.drawable.volvo,R.drawable.wechat,
                R.drawable.whatsapp,R.drawable.wikipedia,R.drawable.windows_10,R.drawable.windows_8,R.drawable.windows_defragmeter,
                R.drawable.windows_xp,R.drawable.wordpress,R.drawable.xamarin,R.drawable.xbox,R.drawable.yahoo,R.drawable.youtube};


        suntypes=getResources().getStringArray(R.array.ItemsList);


        for(int i=0;i<suntypes.length -1;i++)
        {

            items.add(new Brand(suntypes[i],images[i]));

        }






        recyclerView=(RecyclerView)findViewById(R.id.main_recyclerview);

         myAdapter=new MyAdapter(this,suntypes,images,items);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editText.addTextChangedListener(mQueryWatcher);

    }

    private TextWatcher mQueryWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            myAdapter.filter(s.toString());
        }
    };


}