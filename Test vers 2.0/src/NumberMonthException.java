public class NumberMonthException extends NumberFormatException{
    public NumberMonthException (int date){
        super(String.format("Введен не правильный месяц [%d]", date));
    }
}
