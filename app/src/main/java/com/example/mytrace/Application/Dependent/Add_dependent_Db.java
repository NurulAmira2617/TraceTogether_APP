package com.example.mytrace.Application.Dependent;

public class Add_dependent_Db {
    // string variable for
    // storing employee name.
    private String citizen;
    private String Relation;
    private String Gender;
   private String CurrAddress;
   private String IC;
    private String age;
    private String name;
    private String PNumber;
   private String State;



    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public Add_dependent_Db() {

    }

    public Add_dependent_Db(String name, String Gender, String Relation, String citizen,String CurrAddress,String IC,String age,String PNumber,String State) {
        this.name = name;
        this.Gender = Gender;
        this.Relation = Relation;
        this.citizen = citizen;
        this.age = age;
        this.CurrAddress = CurrAddress;
        this.PNumber = PNumber;
        this.State = State;
        this.IC = IC;
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
    public String getCurrAddress() {

        return CurrAddress;
    }

    public void setCurrAddress(String CurrAddress) {

        this.CurrAddress = CurrAddress;
    }
    public String getIC() {

        return IC;
    }

    public void setIC(String IC) {

        this.IC = IC;
    }
    public String getage() {

        return age;
    }

    public void setage(String age) {

        this.age = age;
    }
    public String getPNumber() {

        return PNumber;
    }

    public void setPNumber(String PNumber) {

        this.PNumber = PNumber;
    }
    public String getCitizen() {

        return citizen;
    }
    public void setCitizen(String citizen) {

        this.citizen = citizen;
    }
    public void setState(String State) {

        this.State = State;
    }
    public String getState() {

        return State;
    }


}

