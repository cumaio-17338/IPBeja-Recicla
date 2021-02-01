package pt.ipbeja.pdm.ipbejarecicla;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class SaberMais extends AppCompatActivity {

    private TabLayout tabLayout; //to put the green toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saber_mais_layout);

        //to put the green toolbar
        Toolbar toolbar = findViewById(R.id.mainToolBar);
        toolbar.setTitle(R.string.saber_mais);
        setSupportActionBar(toolbar);


        /*SABER MAIS */
        SectionPagerAdapter sectionsPagerAdapter = new SectionPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
    /*SABER MAIS */

}