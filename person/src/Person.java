public class Person{

    private int userID;
    private String name; 
    private String contactInfo;

    // defult constuctor 
    public Person(){
        this.userID = 0;
        this.name = NULL;
        this.contactInfo = NULL;
    }

    // Constuctor
    public Person(int userID, String name, String contactInfo){
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Create a new object of person 
    public void newPerson(int perUserID, String perName, String perContactInfo){
        Person newPerson = new Person(perUserID, perName, perContactInfo);
    }

    public void newTeam(){
        //Team newTeam = new Team();
    }

    public void assignToTeam(){
        // need a helper function that will take a person oject then addeds it to the team object.
    }



    // getters to get info about the person 
    public int getUserID(){// get the userID
        return this.userID;
    }

    public String getName(){// get the name of person
        return this.name;
    }

    public String getContactInfo(){// get  the contact info of the person
        return this.contactInfo;
    }

    // Only setter just in case a person changes there contact info
    public void setContactInfo(String newInfo){// to change the contact info to the new contact info 
        this.contactInfo = newInfo;  
    }

}
//test 15253563
