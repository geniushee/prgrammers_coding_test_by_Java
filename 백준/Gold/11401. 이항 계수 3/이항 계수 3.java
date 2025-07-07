import java.io.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int mod = 1000000007;
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        long[] fac = new long[n+1];
        long[] inverse = new long[n+1];

        //  팩토리얼
        fac[0] = 1;
        for(int i = 1;i <= n;i++){
            fac[i] = fac[i-1] * i % mod;
        }

        // 리버스
        inverse[n] = modPow(fac[n], mod - 2, mod);
        for(int i = n;i>0;i--){
            inverse[i-1] = inverse[i] * i % mod;
        }

        System.out.println(fac[n] * inverse[n-k] % mod *inverse[k] % mod);
    }

    public static long modPow(long a, long b, long mod) {
        long result = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1) {  // b가 홀수면 곱하기
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;  // b를 절반으로 나눔
        }

        return result;
    }
}