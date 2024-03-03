public class DataTypeExample {
    public static void main(String[] args) {
        byte aByte = Byte.MAX_VALUE;
        short aShort = Short.MAX_VALUE;
        int anInt = Integer.MAX_VALUE;
        long aLong = Long.MAX_VALUE;

        float aFloat = Float.MAX_VALUE;
        double aDouble = Double.MAX_VALUE;

        char aChar = 'A';
        boolean aBoolean = true;

        System.out.println("Переполнение byte: " + (byte) (aByte + 1));

        System.out.println("Операция с int и long: " + (anInt + aLong));

        System.out.println("Операция с float и double: " + (aFloat + aDouble));

        System.out.println("Символ после 'A': " + (char) (aChar + 1));

        System.out.println("Логическое И: " + (aBoolean && false));
        System.out.println("Логическое ИЛИ: " + (aBoolean || false));

        System.out.println("Переполнение int: " + (anInt + 1));
        System.out.println("Переполнение long: " + (aLong + 1));

        System.out.println("Преобразование int в byte: " + (byte) anInt);

        System.out.println("Операция сравнения: " + (aShort < anInt));
        System.out.println("Операция неравенства: " + (aFloat != aDouble));
        System.out.println("Операция равенства: " + (aBoolean == true));
    }

}