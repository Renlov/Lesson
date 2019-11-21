package com.ifmo.lesson17;

public abstract class Factory {
    public static Factory getFactory(String county) {
        if (county == null) return null;
        if (county.equals("Japan")) return new JapanFactory();
        if (county.equals("Germany")) return new GermanyFactory();
        if (county.equals("England"))  return new EnglandFactory();
        if(county.equals("Crysler")) return new CanadaFactory();
        if(county.equals("Russia")) return new RussiaFactory();
        return null;
    }
    public abstract Car createCar();
}
