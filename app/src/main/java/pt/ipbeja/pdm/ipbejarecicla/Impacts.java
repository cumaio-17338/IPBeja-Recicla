package pt.ipbeja.pdm.ipbejarecicla;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import pt.ipbeja.pdm.ipbejarecicla.ui.main.SectionsPagerAdapter;

public class Impacts extends AppCompatActivity {

    //Recycler
    RecyclerView communinityRecyclerView;
    CommunityImpactAdapter communityImpactAdapter;
    ArrayList<String> community_impact_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //



        //items.add("Just a test"); //Fazer get da base de dados
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impacts);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //TODO


        community_impact_items = new ArrayList<>();
        communinityRecyclerView = findViewById(R.id.communityRecView);
        communinityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        communityImpactAdapter = new CommunityImpactAdapter(this, community_impact_items);
        communinityRecyclerView.setAdapter(communityImpactAdapter);


    }
}