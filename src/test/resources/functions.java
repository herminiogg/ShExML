public class Helper {

    public String allCapitals(String input) {
        return input.toUpperCase();
    }

    public int addOne(int number) {
        return number + 1;
    }

    public String getName(String str) {
        return str.trim().split(" ", 2)[0];
    }

    public String getSurname(String str) {
        return str.trim().split(" ", 2)[1];
    }

    public String nameAndYear(String name, int year) {
        return name + year;
    }

    public String[] getNameParts(String name) {
        return name.split(" ");
    }

    public boolean isBefore2010(int year) {
        return year < 2010;
    }

    public boolean outsideUSA(String country) {
        return !country.equals("USA");
    }

    public String concatenate(String a, String b) {
        return a + b;
    }

    public int addOneAutoIncrement(String number) {
        return Integer.parseInt(number) + 1;
    }

}
