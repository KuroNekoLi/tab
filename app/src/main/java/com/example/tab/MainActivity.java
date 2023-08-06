package com.example.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.tab.LeanbackTabLayout;
import androidx.leanback.tab.LeanbackViewPager;

import android.os.Bundle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private LeanbackTabLayout tabLayout;
    private LeanbackViewPager viewPager;
    private final HashMap<String, List<Student>> schoolStudents = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeSchoolStudents();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setupViewPager();
    }

    public void initializeSchoolStudents() {
        schoolStudents.put("1班", Arrays.asList(new Student("小明", "1"), new Student("小美", "2"), new Student("小華", "3")));
        schoolStudents.put("2班", Arrays.asList(new Student("大明", "1"), new Student("大美", "2"), new Student("小胖", "3"), new Student("小李", "4")));
        schoolStudents.put("3班", Arrays.asList(new Student("小智", "1"), new Student("小祥", "2"), new Student("老胡", "3"), new Student("小芬", "4"), new Student("大胖", "5")));
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for (Map.Entry<String, List<Student>> entry : schoolStudents.entrySet()) {
            adapter.addFragment(StudentFragment.newInstance(entry.getValue()), entry.getKey());
        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}