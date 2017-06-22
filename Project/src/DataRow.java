/**
 * Created by marshall on 10/05/2017.
 */
public class DataRow {
    private int id;
    private String name;
    private int sn;
    private String street;
    private String suburb;
    private int postcode;
    private float ar;
    private String descr;
    private String scene;
    private float ap;
    DataRow(int id, String name, int sn, String street, String suburb, int postcode, float ar, String descr, String scene, float ap){
        this.id = id;
        this.name = name;
        this.sn = sn;
        this.street = street;
        this.suburb = suburb;
        this.postcode = postcode;
        this.ar = ar;
        this.descr = descr;
        this.scene = scene;
        this.ap = ap;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSn(){
        return id;
    }
    public String getStreet() {
        return street;
    }
    public String getSuburb() {
        return suburb;
    }
    public int getPostcode() {
        return postcode;
    }
    public float getAr() {
        return ar;
    }
    public String getDescr() {
        return descr;
    }
    public String getScene() {
        return scene;
    }
    public float getAp() {
        return ap;
    }
}