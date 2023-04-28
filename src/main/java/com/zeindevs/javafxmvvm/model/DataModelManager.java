package com.zeindevs.javafxmvvm.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataModelManager implements DataModel {

    private double x;
    private double y;
    private double z;
    private String lastUpdate;
    private Random random = new Random();

    @Override
    public void recalculateData() {
        int first = random.nextInt(100) + 1;
        int second = random.nextInt(100) + 1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

        x = bottom;
        y = top - bottom;
        z = 100 - top;

        System.out.println("1: " + x );
        System.out.println("2: " + y );
        System.out.println("3: " + z );
        System.out.println("Sum: " + (x + y + z) );

        calTimeStamp();
    }

    @Override
    public double[] getDataValues() {
        return new double[]{x, y, z};
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void saveData(double[] doubles) {
        x = doubles[0];
        y = doubles[1];
        z = doubles[2];
        calTimeStamp();
    }

    private void calTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String date = dateFormat.format(now);
        System.out.println(date);
        lastUpdate = date;
    }
}
