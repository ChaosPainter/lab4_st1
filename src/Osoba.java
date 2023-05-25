import java.time.LocalDateTime;

public class Osoba {
    private String name=null;
    private String surname=null;
    private int year = 0;
    private Gender gender=null;

    public Osoba() {
    }

    public Osoba(String name, String surname, int year, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", gender=" + gender +
                '}';
    }
     public void print()
     {
         System.out.println(this.toString());
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int age()
    {
      return LocalDateTime.now().getYear()-year;
    }
}
