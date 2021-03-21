package com.studio69.namajsikkha.Resources;

import com.studio69.namajsikkha.Model.Kalima;
import com.studio69.namajsikkha.R;

public class KalimaRes {

    public static Kalima[] getKalimas(){
        return KALIMAS;
    }

    public static final Kalima KALIMA_ONE = new Kalima(R.string.kalimaNameOne,R.string.kalimaArbiOne,R.string.kalimaSpellOne,R.string.kalimaMeanOne,9377376);
    public static final Kalima KALIMA_TWO = new Kalima(R.string.kalimaNameTwo,R.string.kalimaArbiTwo,R.string.kalimaSpellTwo,R.string.kalimaMeanTwo,9377377);
    public static final Kalima KALIMA_THREE = new Kalima(R.string.kalimaNameThree,R.string.kalimaArbiThree,R.string.kalimaSpellThree,R.string.kalimaMeanThree,9377378);
    public static final Kalima KALIMA_FOUR = new Kalima(R.string.kalimaNameFour,R.string.kalimaArbiFour,R.string.kalimaSpellFour,R.string.kalimaMeanFour,9377379);
    public static final Kalima KALIMA_FIVE = new Kalima(R.string.kalimaNameFive,R.string.kalimaArbiFive,R.string.kalimaSpellFive,R.string.kalimaMeanFive,9377380);


    public static final Kalima[] KALIMAS = {KALIMA_ONE, KALIMA_TWO, KALIMA_THREE, KALIMA_FOUR, KALIMA_FIVE};


}
