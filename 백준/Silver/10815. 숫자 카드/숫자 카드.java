import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            arr[Integer.parseInt(st.nextToken())+10000000] = true;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<m; i++){
            if (arr[Integer.parseInt(st.nextToken())+10000000])
                sb.append(1 + " ");
            else
                sb.append(0 + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}