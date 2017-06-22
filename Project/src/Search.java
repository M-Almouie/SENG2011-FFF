/**
 * SENG2011 Project Fine Food Finder
 * Yida Hao
 * Search function
 * It is not case-sensitive now
 */ 
import java.util.ArrayList;
import java.util.Scanner;
public class Search {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test cases
        OutletProfile outlet1 = new OutletProfile("Mcdonald's","Kingsford","Meeks St",13,(float) 1.2,"blah","blah","blah",11,new ArrayList<Review>());
        OutletProfile outlet2 = new OutletProfile("KFC","Maroubra","Fitzgerald AVE",11,(float) 2.1,"blah","blah","blah",12,new ArrayList<Review>());
        OutletProfile outlet3 = new OutletProfile("CurryKing","Kingsford","Anzac Parade",14,(float) 2.2,"blah","blah","blah",20,new ArrayList<Review>());
        OutletProfile outlet4 = new OutletProfile("Sushi","Kensington","High St",40,(float) 3.2,"blah","blah","blah",8,new ArrayList<Review>());
        
        
        System.out.print("input the keywords here:");
        Scanner sc = new Scanner(System.in);
        String j = null;
        j = sc.nextLine();
        
        
        
        int haveResult = 0; // 1 if there is at least one result
        
        
       
        if (isNumeric(j)){
          
           int i = Integer.parseInt(j); // transform string into a integer
        
           if(i == outlet1.getStreetNum() || i == outlet1.getAvgPrice()){
        	    System.out.println("\n"+"outletname:"+outlet1.getName()+"\n"+"Address:"+outlet1.getSuburb()+"\t"+outlet1.getStreetName()+"\t\t"+outlet1.getStreetNum()+"\n"+"avgRate:"+outlet1.getAvgRating()+"\n"+"description:"+outlet1.getDescription()+"\n"+"Scenery:"+outlet1.getScenry()+"\n"+"foodgenre:"+outlet1.getFoodGenre()+"\t"+"avgprice:"+outlet1.getAvgPrice());
        	    haveResult = 1;
           }
           if(i == outlet2.getStreetNum() || i == outlet2.getAvgPrice()){
        	    System.out.println("\n"+"outletname:"+outlet2.getName()+"\n"+"Address:"+outlet2.getSuburb()+"\t"+outlet2.getStreetName()+"\t\t"+outlet2.getStreetNum()+"\n"+"avgRate:"+outlet2.getAvgRating()+"\n"+"description:"+outlet2.getDescription()+"\n"+"Scenery:"+outlet2.getScenry()+"\n"+"foodgenre:"+outlet2.getFoodGenre()+"\t"+"avgprice:"+outlet2.getAvgPrice());
          	    haveResult = 1;
           }
           if(i == outlet3.getStreetNum() || i == outlet3.getAvgPrice()){
        	    System.out.println("\n"+"outletname:"+outlet3.getName()+"\n"+"Address:"+outlet3.getSuburb()+"\t"+outlet3.getStreetName()+"\t\t"+outlet3.getStreetNum()+"\n"+"avgRate:"+outlet3.getAvgRating()+"\n"+"description:"+outlet3.getDescription()+"\n"+"Scenery:"+outlet3.getScenry()+"\n"+"foodgenre:"+outlet3.getFoodGenre()+"\t"+"avgprice:"+outlet3.getAvgPrice());
        	    haveResult = 1;
           }
           if(i == outlet4.getStreetNum() || i == outlet4.getAvgPrice()){
        	    System.out.println("\n"+"outletname:"+outlet4.getName()+"\n"+"Address:"+outlet4.getSuburb()+"\t"+outlet4.getStreetName()+"\t\t"+outlet4.getStreetNum()+"\n"+"avgRate:"+outlet4.getAvgRating()+"\n"+"description:"+outlet4.getDescription()+"\n"+"Scenery:"+outlet4.getScenry()+"\n"+"foodgenre:"+outlet4.getFoodGenre()+"\t"+"avgprice:"+outlet4.getAvgPrice());
        	    haveResult = 1;
           }
           if(haveResult == 0){
           	System.out.println("Sorry, no result matches the keyword" + i);
           } 
        }  else {
           String k = j.toLowerCase();       
           if(outlet1.getStreetName().toLowerCase().contains(k) ||outlet1.getSuburb().toLowerCase().contains(k)|| outlet1.getName().toLowerCase().contains(k)){
            	System.out.println("\n"+"outletname:"+outlet1.getName()+"\n"+"Address:"+outlet1.getSuburb()+"\t"+outlet1.getStreetName()+"\t\t"+outlet1.getStreetNum()+"\n"+"avgRate:"+outlet1.getAvgRating()+"\n"+"description:"+outlet1.getDescription()+"\n"+"Scenery:"+outlet1.getScenry()+"\n"+"foodgenre:"+outlet1.getFoodGenre()+"\t"+"avgprice:"+outlet1.getAvgPrice());
            	haveResult = 1;
           }
           if(outlet2.getStreetName().toLowerCase().contains(k) ||outlet2.getSuburb().toLowerCase().contains(k)|| outlet2.getName().toLowerCase().contains(k)){
            	System.out.println("\n"+"outletname:"+outlet2.getName()+"\n"+"Address:"+outlet2.getSuburb()+"\t"+outlet2.getStreetName()+"\t\t"+outlet2.getStreetNum()+"\n"+"avgRate:"+outlet2.getAvgRating()+"\n"+"description:"+outlet2.getDescription()+"\n"+"Scenery:"+outlet2.getScenry()+"\n"+"foodgenre:"+outlet2.getFoodGenre()+"\t"+"avgprice:"+outlet2.getAvgPrice());
            	haveResult = 1;
           }
           if(outlet3.getStreetName().toLowerCase().contains(k) ||outlet3.getSuburb().toLowerCase().contains(k)|| outlet3.getName().toLowerCase().contains(k)){
            	System.out.println("\n"+"outletname:"+outlet3.getName()+"\n"+"Address:"+outlet3.getSuburb()+"\t"+outlet3.getStreetName()+"\t\t"+outlet3.getStreetNum()+"\n"+"avgRate:"+outlet3.getAvgRating()+"\n"+"description:"+outlet3.getDescription()+"\n"+"Scenery:"+outlet3.getScenry()+"\n"+"foodgenre:"+outlet3.getFoodGenre()+"\t"+"avgprice:"+outlet3.getAvgPrice());
            	haveResult = 1;
           }
           if(outlet4.getStreetName().toLowerCase().contains(k) ||outlet4.getSuburb().toLowerCase().contains(k)|| outlet4.getName().toLowerCase().contains(k)){
            	System.out.println("\n"+"outletname:"+outlet4.getName()+"\n"+"Address:"+outlet4.getSuburb()+"\t"+outlet4.getStreetName()+"\t\t"+outlet4.getStreetNum()+"\n"+"avgRate:"+outlet4.getAvgRating()+"\n"+"description:"+outlet4.getDescription()+"\n"+"Scenery:"+outlet4.getScenry()+"\n"+"foodgenre:"+outlet4.getFoodGenre()+"\t"+"avgprice:"+outlet4.getAvgPrice());
            	haveResult = 1;
           }
           if(haveResult == 0){
           	System.out.println("Sorry, no result matches the keyword");
           } 
        }
        sc.close();
	}
public static boolean isNumeric(String str){ //check if the input is a number or a string
	for(int i = str.length(); --i >= 0;){
		int chr = str.charAt(i);
		if (chr < 48 || chr > 57)
			return false;
	}
    return true;
}
}