package com.example.user.nextpreview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import android.view.LayoutInflater;

public class Planet {

    public static final String[] PLANETS = {"1","2","3","4"};
    public static final String[] Answer1 = {"5","6","7","8"};
    public static final String[] Answer2 = {"9","10","11","12"};
    public static final String[] Answer3 = {"13","14","15","16"};
    public static final String[] Answer4 = {"17","18","19","20"};

    public static final Map<String, String> PLANET_DETAIL;
    public static final Map<String, String> ANSWER_DETAIL1;
    public static final Map<String, String> ANSWER_DETAIL2;
    public static final Map<String, String> ANSWER_DETAIL3;
    public static final Map<String, String> ANSWER_DETAIL4;

    static {
        Map<String, String> planets = new HashMap<String, String>();
        planets.put("1","What is Android ?");

        planets.put("2", "Mercury is the smallest and closest to the Sun of the eight planets" +
                " in the Solar System. Mercury's axis has the smallest tilt of any of the planets.");
        planets.put("3", "Venus is the second planet from the Sun. It has no natural satellite. " +
                "After the Moon, it is the brightest natural object in the night sky.");
        planets.put("4", "Earth is the third-closest planet to the Sun, the densest planet in " +
                "the Solar System, the largest of the Solar System's four terrestrial planets.");


        PLANET_DETAIL = Collections.unmodifiableMap(planets);


    }


      static {
          Map<String, String> answer1 = new HashMap<String, String>();
          answer1.put("5","mm");
          answer1.put("6", "ff");
          answer1.put("7", "jj");
          answer1.put("8", "ll" );
          ANSWER_DETAIL1 = Collections.unmodifiableMap(answer1);
      }

    static {
        Map<String, String> answer2 = new HashMap<String, String>();
        answer2.put("9","ww");

        answer2.put("10", "oo");
        answer2.put("11", "pp");
        answer2.put("12", "rr");

        ANSWER_DETAIL2 = Collections.unmodifiableMap(answer2);
    }
    static {
        Map<String, String> answer3 = new HashMap<String, String>();
        answer3.put("13","yy");

        answer3.put("14", "kk");
        answer3.put("15", "ee");
        answer3.put("16", "qq" );
        ANSWER_DETAIL3 = Collections.unmodifiableMap(answer3);
    }
    static {
        Map<String, String> answer4 = new HashMap<String, String>();
        answer4.put("17","gg");

        answer4.put("18", "aa");
        answer4.put("19", "cc");
        answer4.put("20", "vv" );
        ANSWER_DETAIL4 = Collections.unmodifiableMap(answer4);
    }
}
