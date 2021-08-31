public class Runner {
    public static void main(String[] args) {
        if (validateCardNumber("1299258971548971")) {
            System.out.println("Is valid");
        } else {
            System.out.println("Is not valid");
        }
    }

    private static boolean validateCardNumber(String number) {
        char[] arrayCharNumber = number.toCharArray();
        int[] arrayIntegerNumber = new int[arrayCharNumber.length];
        int[] arrayNumberIn = new int[arrayIntegerNumber.length];
        int sum = 0;
        boolean result;
        for (int i = 0; i < arrayIntegerNumber.length; i++) {
            arrayIntegerNumber[i] = Character.getNumericValue(arrayCharNumber[i]);
        }
        for (int i = arrayIntegerNumber.length - 1; i > 0; i--) {
            arrayNumberIn[i] = arrayIntegerNumber[i];
            i--;
            int mul = arrayIntegerNumber[i] * 2;
            if (mul <= 9) {
                arrayNumberIn[i] = mul;
            } else {
                int x = 0;
                String mulString = String.valueOf(mul);
                char[] mulCharArray = mulString.toCharArray();
                int[] mulIntegerArray = new int[mulCharArray.length];
                int convertedValue = 0;
                for (int y = 0; y < mulIntegerArray.length; y++) {
                    mulIntegerArray[y] = mulCharArray[y] - '0';
                    convertedValue += mulIntegerArray[y];
                }
                arrayNumberIn[i] = convertedValue;
            }
            sum += arrayNumberIn[i];

        }
        if (sum % 10 == 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}

