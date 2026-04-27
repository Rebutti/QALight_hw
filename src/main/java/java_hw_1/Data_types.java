package java_hw_1;

public class Data_types {
    public static void main(String args[]){


        byte d = 127;
        short e = 32767;
        final int A = 2147483647;
        long f = 9223372036854775807L;
        final float b = 4.23f, c = 6.45f;
        double g = 15.658;
        boolean h = false;
        char i = 254, j = 'I';
        //A = 5; очікуванна помилка, бо статичні змінні неможна змінювати
        String text = "Data types bellow:", text_end = "The end :)";

        System.out.println("Hello Anton. " + text);
        System.out.println("byte = " + d);
        System.out.println("int = " + A);
        System.out.println("long = " + f);
        System.out.println("float = " + b);
        System.out.println("double = " + g);
        System.out.println("boolean = " + h);
        System.out.println("char like ASCII = " + i);
        System.out.println("char like letter = " + j);
        System.out.println(text_end);

    }
}
