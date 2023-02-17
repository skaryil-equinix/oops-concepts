abstract class Athlete{//data abstraction

    private String name;//data encapsulation
    private int age;
    private int matches;

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setMatches(int matches){
        this.matches = matches;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getMatches(){
        return this.matches;
    }

    public boolean hasPlayed(){
        if(getMatches()>0)
            return true;
        else
            return false;
    }

    abstract public void calculateStatistics();//Polymorphism - Overriding

    public static void main(String[] args){
        Footballer foot1 = new Footballer("skk", 23, 12, 13);
        foot1.calculateStatistics();

        Cricketer cric1 = new Cricketer("Ab de Villers", 45, 50, 5906, 12);
        cric1.calculateStatistics();
    }
}


class Footballer extends Athlete{//data inheritance

    private int goals;

    Footballer(String name, int age, int matches, int goals){
        super.setName(name);
        super.setAge(age);
        super.setMatches(matches);
        this.goals = goals;
    }

    public int getGoals(){
        return this.goals;
    }

    public void calculateStatistics(){
        if(!hasPlayed()){
            System.out.println("The player has not played any games");
            return;
        }
        System.out.println("Goals per match: "+((float)getGoals()/(float)getMatches()));
    }
}

class Cricketer extends Athlete{

    private int runsScored;
    private int wicketsTaken;

    Cricketer(String name, int age, int matches, int runsScored, int wicketsTaken){
        super.setName(name);
        super.setAge(age);
        super.setMatches(matches);
        this.runsScored = runsScored;
        this.wicketsTaken = wicketsTaken;
    }
    public void calculateStatistics(){
        if(!hasPlayed()){
            System.out.println("The player has not played any games");
            return;
        }
        System.out.println("Average runs scored per match: "+((float)runsScored/(float)getMatches()));
        System.out.println("Average wickets taken per match: "+((float)wicketsTaken/(float)getMatches()));   
    }
}