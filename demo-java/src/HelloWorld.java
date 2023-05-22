public class HelloWorld {
    public static void main(String[] args){
        double myFirstValue = 80.00;
        double mySecondValue = 20.00;
        double myValuesTotal = (myFirstValue+mySecondValue)*100.00;

        System.out.println("MyValuesTotal " + myValuesTotal);
        double theRemainder = myValuesTotal % 40.00d;

        System.out.println("The Remainder " + theRemainder);

        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        System.out.println("isNoRemainder  " +  isNoRemainder);


    }
}
