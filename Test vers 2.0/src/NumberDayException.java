public class NumberDayException extends NumberFormatException{
    public NumberDayException (int date){
        super(String.format("Введена не правильная дата [%d]", date));
    }

}
