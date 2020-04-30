import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorImplementation {
	
	static ArrayList<Person> list = new ArrayList<Person>();
     

    public static void main(String[] argv ) {
    	list.add(new Person("mark", 12));
        list.add(new Person("adam", 2));
        list.add(new Person("zsca", 18));
        list.add(new Person("jack", 1));

        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        
        for ( Person perp : list ) {
            System.out.println( ""+perp+"<br />" );
        }
        
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);


        for ( Person perp : list ) {
            System.out.println( ""+perp+"<br />" );
        }
    }
}
class RatingCompare implements Comparator<Person>
{
    public int compare(Person m1, Person m2)
    {
        if (m1.getAge() < m2.getAge()) return -1;
        if (m1.getAge() > m2.getAge()) return 1;
        else return 0;
    }
}
  
// Class to compare Movies by name
class NameCompare implements Comparator<Person>
{
    public int compare(Person m1, Person m2)
    {
        return m1.getName().compareTo(m2.getName());
    }
}
  
/*The Person class has getAge() and getName() methods.
Write code to sort the given array of Person objects by age first, and name second.
*/
class Person {
    private String name;
    private int age;

    Person( String name, int age ) { 
        this.name = name;
        this.age = age;
    }   
    
    public String getName() {
        return this.name;
    }   

    public int getAge() {
        return this.age;
    }   
    public String toString() {
        return this.name+" ("+this.age+")";
    }
}


