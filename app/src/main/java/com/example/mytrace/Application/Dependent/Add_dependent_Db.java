package com.example.mytrace.Application.Dependent;

public class Add_dependent_Db {
    // string variable for
    // storing employee name.
  //  private String citizen;
    private String Relation;
    private String Gender;
//    private String CurrAddress;
 //   private String IC;
  //  private String age;
    private String name;
//    private String PNumber;
//    private String State;



    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public Add_dependent_Db() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String Relation) {
        this.Relation = Relation;
    }

    public String getGenders() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
}

