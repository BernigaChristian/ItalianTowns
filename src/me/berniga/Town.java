package me.berniga;

public class Town {
    private String istat;
    private String name;
    private String province;
    private String region;
    private String prefix;
    private String cap;
    private String fisco;
    private int inhabitants;

    public Town(String istat,String name,String province,String region,String prefix,String cap,String fisco,int inhabitants){
        this.istat=istat;
        this.name=name;
        this.province=province;
        this.region=region;
        this.prefix=prefix;
        this.cap=cap;
        this.fisco=fisco;
        this.inhabitants=inhabitants;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public String getFisco() {
        return fisco;
    }

    public int getInhabitants() {
        return inhabitants;
    }
}
