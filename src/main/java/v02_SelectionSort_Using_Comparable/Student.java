package v02_SelectionSort_Using_Comparable;

public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public int compareTo(Student that){
        if(this.score>that.score)
            return 1;
        else if(this.score<that.score)
            return -1;
        else if(this.score==that.score)
            return this.name.compareTo(that.name);
        else
            return 0;
    }

    @Override
    public String toString(){
        return ("Name: "+this.name +" - Score: "+this.score);
    }
}
