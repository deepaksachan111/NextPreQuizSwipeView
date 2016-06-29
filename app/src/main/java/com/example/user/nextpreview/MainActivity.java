package com.example.user.nextpreview;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import android.support.v4.app.Fragment;


import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int NUM_ITEMS = 4;

    int  currentq = 0;
    int FINALMARKS = 0;
    PlanetFragmentPagerAdapter planetFragmentPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        planetFragmentPagerAdapter = new PlanetFragmentPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(planetFragmentPagerAdapter);
        //Button button = (Button)findViewById(R.id.goto_first);
        //button.setOnClickListener(btnListener);
        Button button = (Button)findViewById(R.id.goto_previous);
        button.setOnClickListener(btnListener);
        button = (Button)findViewById(R.id.goto_next);
        button.setOnClickListener(btnListener);
       // button = (Button)findViewById(R.id.goto_next);
        //button.setOnClickListener(btnListener);
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId()) {
                //case R.id.goto_first:
                    //viewPager.setCurrentItem(0);
                    //break;
                case R.id.goto_previous:
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                    break;
                case R.id.goto_next:

                    String s = SwipeFragment.getText;
                    String dd = s;
                    final String[] FinalAnswer = {"mm","oo","ee","vv"};

                    if(currentq <= 3){
                        if (FinalAnswer[currentq].equals(s)){

                            int total =  FINALMARKS++;

                            Log.v("ffffff",String.valueOf(total));
                            //int FM = FINALMARKS;

                        }
                        currentq++;
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }

                else {
                        Toast.makeText(MainActivity.this,"All Question is finished",Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(MainActivity.this,"" +FINALMARKS,Toast.LENGTH_LONG).show();
                   // viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                    break;

                   // Toast.makeText(MainActivity.this,"" +FINALMARKS,Toast.LENGTH_LONG).show();
               // case R.id.goto_last:
                    //viewPager.setCurrentItem(NUM_ITEMS - 1);
                    //break;
            }
        }
    };

    public static class PlanetFragmentPagerAdapter extends FragmentPagerAdapter {
        public PlanetFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
           // SwipeFragment fragment = new SwipeFragment();
            return SwipeFragment.newInstance(position);
        }
    }

    public static class SwipeFragment extends Fragment {

         public static String getText;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View swipeView = inflater.inflate(R.layout.swipe_fragment, container, false);
            TextView tv = (TextView)swipeView.findViewById(R.id.text);


            final RadioGroup radioGroup =(RadioGroup)swipeView.findViewById(R.id.radioGroup1);
         //   RadioButton answer=(RadioButton)swipeView.findViewById(radioGroup.getCheckedRadioButtonId());
            RadioButton b1 = (RadioButton)swipeView.findViewById(R.id.radio0);
            RadioButton b2 = (RadioButton)swipeView.findViewById(R.id.radio1);
            RadioButton b3 = (RadioButton)swipeView.findViewById(R.id.radio2);
            RadioButton b4 = (RadioButton)swipeView.findViewById(R.id.radio3);
            //ImageView img = (ImageView)swipeView.findViewById(R.id.imageView);


            Bundle args = getArguments();
            int position = args.getInt("position");
            String planet = Planet.PLANETS[position];
            String answer1 = Planet.Answer1[position];
            String answer2 = Planet.Answer2[position];
            String answer3 = Planet.Answer3[position];
            String answer4 = Planet.Answer4[position];
            //int imgResId = getResources().getIdentifier(planet, "drawable", "com.javapapers.android.androidswipeableviews.app");
            //img.setImageResource(imgResId);
            tv.setText(Planet.PLANET_DETAIL.get(planet));
           // Log.v("hhhhhhhhhhhh", Planet.PLANET_DETAIL.get(planet));
            b1.setText(Planet.ANSWER_DETAIL1.get(answer1));
           // Log.v("hhhhhhhhhhhh.....", Planet.PLANET_DETAIL.get(answer1));
            b2.setText(Planet.ANSWER_DETAIL2.get(answer2));
          //  Log.v("hhhhhhhhhhhh..", Planet.PLANET_DETAIL.get(answer2).toString());
            b3.setText(Planet.ANSWER_DETAIL3.get(answer3));
          //  Log.v("hhhhhhhhhhhh....", Planet.PLANET_DETAIL.get(answer3).toString());
            b4.setText(Planet.ANSWER_DETAIL4.get(answer4));
           // Log.v("hhhhhhhhhhhh.....", Planet.PLANET_DETAIL.get(answer4));



            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int id=group.getCheckedRadioButtonId();
                    RadioButton rb=(RadioButton)swipeView. findViewById(id);
                    getText =rb.getText().toString();

                }
            });
         /*   radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId){
                        case R.id.radio0:
                            // do operations specific to this selection

                            break;

                        case R.id.radio1:
                            // do operations specific to this selection
                            break;

                        case R.id.radio2:
                            // do operations specific to this selection
                            break;

                        case R.id.radio3:
                            // do operations specific to this selection
                            break;

                    }


                }
            });*/


            return swipeView;
        }

        static SwipeFragment newInstance(int position) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            swipeFragment.setArguments(args);
            return swipeFragment;
        }
    }

}
