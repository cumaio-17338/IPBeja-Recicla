package pt.ipbeja.pdm.ipbejarecicla;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


public class Impacts extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impacts);

        Toolbar toolbar = findViewById(R.id.mainToolBar);
        toolbar.setTitle(R.string.estatisticas);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.view_pager_id);
        adapter = new ViewPageAdapter(getSupportFragmentManager());


        //Add fragments
        adapter.AddFragment(new FragMyImpact(), "Meu Impacto");
        adapter.AddFragment(new FragCommunityImpact(), "Comunidade");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }
}