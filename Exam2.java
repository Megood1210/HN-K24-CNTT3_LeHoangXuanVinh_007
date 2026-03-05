import java.util.*;

public class Exam2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input == null || input.trim().isEmpty()){
            System.out.println("Lỗi: Chuỗi không hợp lệ");
            return;
        }

        input = input.toLowerCase();
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == ' '){
                continue;
            }

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else {
                map.put(ch,1);
            }
        }
        List<Character> chars = new ArrayList<>(map.keySet());

        for (int i = 0; i < chars.size() - 1; i++) {
            for (int j = 0; j < chars.size() - i - 1; j++) {
                if(chars.get(j) > chars.get(j+1)){
                    char temp = chars.get(j);
                    chars.set(j,chars.get(j+1));
                    chars.set(j+1,temp);
                }
            }
        }
        int max = 0;

        for (char c: chars){
            int count = map.get(c);
            System.out.println(c + "xuất hiện: " + count + " lần");

            if (count > max){
                max = count;
            }
        }

        System.out.println("Ký tự xuất hiện nhiều nhất: ");
        for (char c : chars){
            if (map.get(c) == max){
                System.out.println(c + " ");
            }
        }
        System.out.println("(" + max + " lần)");
    }
}
