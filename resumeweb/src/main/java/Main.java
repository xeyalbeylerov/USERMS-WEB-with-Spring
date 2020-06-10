public class Main {
public static int checkDoubleRepeat(String number){
    char[] c = number.toCharArray();
    int count = 0;
    char buffer=0;
    for (int i = 0; i < c.length; i++) {//array size qədər davam edir
        char first = c[i];//index-dəki rəqəm
        if (i < c.length - 1) {//1234 varsa, arr 0-dan başlayır deyə -1 yazdıq
            char last=c[i + 1];//index dən bir sonrakı rəqəm
            if (last==first&&buffer!=last){//əgər iki simvol biri birinə bərabərdirsə və last buffer-ə bərabər deyilsə count+ olur
                count++;
                buffer=last;
            }
        }
    }
//    System.out.println("repeated count " + count);
//
    if(count==2)
    System.out.println("repeated number " + number);
    return count;
}


    public static boolean checkIsIncrement(String number) {
        boolean isIncrement = true;
        char[] c = number.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char firstNumber = c[i];
            if (i < c.length - 1) {
                char secondNumber = c[i + 1];
                if (firstNumber > secondNumber) {
                    isIncrement = false;
                }
            }
        }
        return isIncrement;
    }

    public static void mainLogic(int a,int b) {
        int first = (int)Math.pow(a,2);
        int last = (int)Math.pow(b,2);
        System.out.println(first+" - "+last);
        int codeCount = 0;
        for (;first < last; first++) {
            boolean isIncrement = checkIsIncrement(String.valueOf(first));
            if (isIncrement) {
                int repeatCount = checkDoubleRepeat(String.valueOf(first));
                if (repeatCount == 2) {
                    codeCount++;
                }
            }
        }
        System.out.println("Code " + codeCount);
    }


    public static void main(String[] args) {

      mainLogic(372,809);

    }

}
