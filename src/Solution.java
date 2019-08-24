import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        //-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
        if(args[0].equals("-c")){
            if (args[2].equals("м")){
                allPeople.add(Person.createMale(args[1],format.parse(args[3])));
                System.out.println(allPeople.size()-1);
            }else if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], format.parse(args[3])));
                System.out.println(allPeople.size() - 1);
            }
        }else if (args[0].equals("-u")){
            //-u - обновляет данные человека с данным id
            int id =Integer.parseInt( args[1]);
            if (args[3].equals("м")){
                allPeople.set(id,Person.createMale(args[2],format.parse(args[4])));
            }else if (args[3].equals("ж")) {
                allPeople.set(id, Person.createFemale(args[2], format.parse(args[4])));
            }

        }else if(args[0].equals("-d")){
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);

        }else if(args[0].equals("-i")){
            int id = Integer.parseInt(args[1]);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = outputDateFormat.format(allPeople.get(id).getBirthDate());
            String Sexs = null;
            //-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
            if (allPeople.get(id).getSex().equals(Sex.MALE)){
                Sexs = "м";
            }else if (allPeople.get(id).getSex().equals(Sex.FEMALE)){
                Sexs = "ж";
            }
            System.out.println(allPeople.get(id).getName() + " " + Sexs + " "+ date);

        }

    }

}

