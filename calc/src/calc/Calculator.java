package calc;

public class Calculator {

    private class Operations{

        static double getOperation(double a, double b, String key) throws Exception {
            switch (key){
                case ("+"):
                    return a + b;
                case ("-"):
                    return a - b;
                case ("*"):
                    return a * b;
                case ("/"):
                    return a / b;
            }
            throw new Exception("Error! You entered an invalid operation symbol");
        }

    }

    public double calculate(String expression) throws Exception{
        String[] arr = expression.split("\s++");
        // |s++
        contains(arr);
        double result;
        if (arr.length == 5){ //
            this.priority(arr);
            result = Operations.getOperation(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), arr[1]);
            result = Operations.getOperation(result, Integer.parseInt(arr[4]), arr[3]);
        }
        else {
            result = Operations.getOperation(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), arr[1]);
        }
        return result;
    }

    private void priority(String[] arr){
        if(arr[1].equals("+") || arr[1].equals("-")){
            if(arr[3].equals("/") || arr[3].equals("*")){
                for (int i = 0; i < 3; i++) {
                    String tmp = arr[i];
                    arr[i] = arr[i+2];
                    arr[i+2] = tmp;
                }
            }
        }
    }

    public void contains(String[] arr) throws Exception{
        if (!((arr.length == 3 && containsChar(arr[1])) || (arr.length == 5 && containsChar(arr[1]) && containsChar(arr[3]))) || !chekNum(arr))
            throw new Exception("Error Incorrect input");
        //
    }

    private boolean chekNum(String[] arr){
        for(int i = 0 ; i<arr.length;i+=2){ //
            if(!isNum(arr[i]) || Integer.parseInt(arr[i]) < 1 || Integer.parseInt(arr[i]) > 10){ //isNum числа
                return false;
            }
        }
        return true;
    }

    private boolean containsChar(String a){
        return a.equals("*") || a.equals("/") || a.equals("+") || a.equals("-");
    }

    private boolean isNum(String a){
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}