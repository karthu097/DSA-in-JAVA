/*
Basic ArithamaticException when the user tries to divide by zero

*/

public class Day_4_ex {
    public static void main(String[] args){
        int nums[] = {10,5,0};

        for(int n : nums){
            try{
                int result = 100 / n;
                System.out.println("100 /" + n +" = " + result );
            }catch(ArithmeticException e){
                System.out.println("Error :" +e.getMessage());
                //e.gitMessage() is a methos give you the error description java generates
                //e.printStackTrace() give you the full trace very useful for the debugging

            } finally{
                System.out.println("Attempted with n = " + n);
            }
        }
    }
}
//this program handles the exception so that we won't get any exception