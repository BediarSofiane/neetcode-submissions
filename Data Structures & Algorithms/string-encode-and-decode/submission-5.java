class Solution {

public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: strs){
            int len = s.length();
            stringBuilder.append(len);
            stringBuilder.append("#");
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.isEmpty()){
            return new ArrayList<>();
        }
        int index = 0;
        List<String> result = new ArrayList<>();
        while(index < str.length()){
            String len = "";
            char c = str.charAt(index);
            while(c != '#'){
                len += c;
                c = str.charAt(++index);
            }
            //index is pointing to # character
            index++;
            System.out.println(len);
            int lenAsInt = Integer.parseInt(len);
            int nextIndex = index + lenAsInt;
            result.add(str.substring(index, nextIndex));
            index = nextIndex;
        }
        return result;
    }

/*
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            int div = length;
            int digits = 0;
            while (div > 0){
                div = div / 10;
                digits ++;
            }
            for(int i=0; i<3-digits; i++){
                stringBuilder.append(0);
            }
            stringBuilder.append(str.length());
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        int index = 0;
        int length = str.length();
        List<String> result = new ArrayList<>();
        System.out.println(str);
        while(index < length){
            System.out.println(index);
            int currentLength = Integer.parseInt(str.substring(index, index + 3));
            if(currentLength == 0){
                result.add("");
                index = index + 4;
                continue;
            }
            result.add(str.substring(index+3, index+3+currentLength));
            index += currentLength + 3;
            System.out.println(result);
        }
        return result;
    }
*/
}
