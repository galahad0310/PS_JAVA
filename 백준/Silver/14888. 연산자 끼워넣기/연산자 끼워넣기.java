import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N, min, max;
    static int[] A, operators;

    public static void main(String[] args) throws IOException{
        input();
        rec_func(1, A[1]);
        System.out.println(max);
        System.out.println(min);
    }

    static void rec_func(int depth, int result){
        if(depth == N){
            min = Math.min(min, result);
            max = Math.max(max, result);
        }else{
            for(int i = 1; i<=4; i++){
                if(operators[i] != 0){
                    operators[i]--;
                    rec_func(depth+1, calculator(result, i, A[depth+1]));
                    operators[i]++;
                }
            }
        }
    }

    static int calculator(int operand1, int operator, int operand2){
        if(operator == 1){
            return operand1 + operand2;
        }else if(operator == 2){
            return operand1 - operand2;
        }else if(operator == 3){
            return operand1 * operand2;
        }else{
            return operand1 / operand2;
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        operators = new int[5];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
    }

}