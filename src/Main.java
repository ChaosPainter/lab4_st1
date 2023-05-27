import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        Example_1();
        System.out.println();
        Example_2();
        System.out.println();
        Example_3();
        System.out.println();
        Example_4();
        Zadanie1();
        Zadanie2();
        Zadanie3();
        Zadanie4();
        Zadanie5();
        Zadanie6();
        Zadanie7();
        Zadanie9();
        
    }

    private static void Zadanie9() {
        var osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Jan","Kowalski", 1950, Gender.Male));
        osoby.add(new Osoba("Janina","Kowalska", 1951, Gender.Female));
        osoby.add(new Osoba("Anna","Mawak", 2000, Gender.Female));
        osoby.add(new Osoba("Zofia","Kowalska", 2004, Gender.Female));

        osoby.sort((o , x)->
                {
                    int res =o.getSurname().compareToIgnoreCase(x.getSurname());
                    if (res!=0)
                    {
                        return res;
                    }
                    return o.getName().compareToIgnoreCase(x.getName());
                }
        );
        osoby.forEach(x->x.print());
    }

    private static void Zadanie7() {
        var osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Jan","Kowalski", 1950, Gender.Male));
        osoby.add(new Osoba("Janina","Kowalska", 1951, Gender.Female));
        osoby.add(new Osoba("Anna","Mawak", 2000, Gender.Female));
        osoby.add(new Osoba("Zofia","Kowalska", 2004, Gender.Female));
        var li = osoby.stream().filter(x->x.getSurname().startsWith("Ko")).count();
        System.out.println(li);
    }

    private static void Zadanie6() {
        var osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Jan","Kowalski", 1950, Gender.Male));
        osoby.add(new Osoba("Janina","Kowalska", 1951, Gender.Female));
        osoby.add(new Osoba("Anna","Mawak", 2000, Gender.Female));
        osoby.add(new Osoba("Zofia","Kowalska", 2004, Gender.Female));
        
        osoby.stream().filter(x->x.getSurname().startsWith("Ko")).forEach(x -> x.print() );
    }

    private static void Zadanie5() {
        var osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Jan","Kowalski", 1950, Gender.Male));
        osoby.add(new Osoba("Janina","Kowalska", 1951, Gender.Female));
        osoby.add(new Osoba("Anna","Nowak", 2000, Gender.Female));
        osoby.add(new Osoba("Zofia","Kowalska", 2004, Gender.Female));
        
        osoby.stream().filter(x->x.getYear()>1999).forEach(x->x.print());
    }

    private static void Zadanie4() {
        var lista = new ArrayList<>(Arrays.asList(1,7,5,2,10,100,150));
        lista.stream().filter(x->x>=8&&x<=110).collect(Collectors.toList()).forEach(x-> System.out.println(x+", "));
    }

    private static void Zadanie3() {
        var lista = new ArrayList<>(Arrays.asList(1,7,5,2,10,100,150));
        var min =lista.stream().filter(x->x%2==0).min(Comparator.comparingInt(x->x)).get();
        System.out.println(min);
    }

    private static void Zadanie2() {
        var lista = new ArrayList<>(Arrays.asList(1,7,5,2,10,100,150));
        lista.stream().filter(x->x%2==0).forEach(System.out::println);
    }

    private static void Zadanie1() {
        var osoba = new Osoba("Wojciech", "Liszka", 1992, Gender.Male);
        Zadanie1process(osoba, x->x.print());
    }

    private static void Zadanie1process(Osoba osoba, SomeInterface i) 
    {   
        i.wykonajOsoba(osoba);
    }

    private static void Example_4() {
        var osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Jan","Kowalski", 1950, Gender.Male));
        osoby.add(new Osoba("Janina","Kowalska", 1951, Gender.Female));
        osoby.add(new Osoba("Anna","Nowak", 2000, Gender.Female));
        osoby.add(new Osoba("Zofia","Kowalska", 2004, Gender.Female));
        osoby.stream().filter(x->x.getSurname().startsWith("K")).map(x->x.toString()).forEach(System.out::println);
    }

    private static void Example_3() {
        var lista = new ArrayList<>(Arrays.asList(1,7,5,2,10,100,150));
        List<Integer> result = lista.stream().filter(x->x>=7).collect(Collectors.toList());

        for (var inte: result)
        {
            System.out.println(inte+", ");
        }

        lista.stream()
                .filter( el -> el >=7)
                .sorted((a,b)-> - a.compareTo(b))
                .forEach(el -> System.out.print(el + ", "));

    }

    public static void Example_2()
    {
        var osoby = new ArrayList<Osoba>();
        osoby.add(new Osoba("Jan","Kowalski", 1950, Gender.Male));
        osoby.add(new Osoba("Janina","Kowalska", 1951, Gender.Female));
        osoby.add(new Osoba("Anna","Nowak", 2000, Gender.Female));
        osoby.add(new Osoba("Zofia","Kowalska", 2004, Gender.Female));

        System.out.println();

        wypiszOsoby(osoby, (Osoba o)->o.getGender()==Gender.Female && o.age()>=18 && o.age()<=25);
        wypiszOsobyPredicate(osoby, (Osoba o)->o.getGender()==Gender.Female && o.age()>=18 && o.age()<=25);

        processOsoby(osoby, (Osoba o) -> o.getGender() == Gender.Female && o.age() >= 18 && o.age() <= 25, o -> o.print());
        processOsobyWithFunction(osoby, (Osoba o) -> o.getGender() == Gender.Female && o.age() >= 18 && o.age() <= 25, o-> o.toString(),o-> System.out.println(o));
        processElements(osoby, (Osoba x) -> x.getGender() == Gender.Female && x.age() >= 18 && x.age() <= 25,
                x-> x.toString(), x -> System.out.println(x));
        osoby.stream().filter(x->x.getGender()==Gender.Female && x.age()>=18 && x.age()<=25).map(x->x.toString()).forEach(x-> System.out.println(x));

    }



    private static <T, TMap> void processElements(List<T> elements, Predicate<T> tester, Function<T, TMap> mapper, Consumer<TMap> action)
    {
        for (T element : elements) {
            if (tester.test(element)) {
                var data = mapper.apply(element);
                action.accept(data);
            }
        }

    }

    private static void processOsoby(List<Osoba> osoby, SprOsoba tester, Consumer<Osoba> action)
    {
        for (Osoba osoba : osoby) {
            if (tester.test(osoba)) {
                action.accept(osoba);
            }
        }
    }
    public static void processOsobyWithFunction(List<Osoba> osoby, SprOsoba tester, Function<Osoba, String> mapper, Consumer<String> action)
    {
        for (Osoba osoba : osoby) {
            if (tester.test(osoba)) {
                String data = mapper.apply(osoba);
                action.accept(data);
            }
        }
    }



    private static void wypiszOsoby(List<Osoba> osoby, SprOsoba tester)
    {
        for (Osoba person : osoby) {
            if (tester.test(person)) {
                person.print();
            }
        }
    }
    private static void wypiszOsobyPredicate(List<Osoba> osoby, Predicate<Osoba> tester)
    {
        for (Osoba osoba : osoby) {
            if (tester.test(osoba)) {
                osoba.print();
            }
        }
    }



    public static void Example_1()
    {
        Operation op=(a, b) -> a+b;
        double result = calc(3,2,op);
        System.out.println("Wynik :" +result);
        double result2 = calc(3, 4, (a,b)->a+b);
        double result3 = calc(3, 4, new Add());
//        var result4 = calc(8, 3, new Operation() {
//            @Override
//            public double operation(double a, double b)
//            {
//                return a + b;
//            }
//        });
//        System.out.println("Następne wyrażenie z użyciem klasy anonimowej: " + result4);

        var result5 = calc2(5, 4, (a,b) -> a + b);
        System.out.println("Wyrażenie z użyciem wbudowanego interfejsu Java: " + result5);


    }
    public static double calc(double a, double b,  Operation op)
    {
        return op.op(a,b);
    }
    private static double calc2(double a, double b, DoubleBinaryOperator op)
    {
        return op.applyAsDouble(a, b);
    }



}