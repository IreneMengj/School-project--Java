
public class UsernameGenerator {
    //declare variables
    private String fullName;
    private String username;


    //constructor
    public UsernameGenerator() {
    }

    //constructor with parameters
    public UsernameGenerator(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

    //getter and setter
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }


    //generator method
    public void generateUser() {
        //"count" is to count the total number of uppercase vowels contained in the username
        int count = 0;
        //create a StringBuffer to easily deal with string
        StringBuffer sb = new StringBuffer();

        //UR1 a) The username starts with the last letter of the forename followed by the last letter of the surname
        //find the last letter in forename
        for(int i=0;i<fullName.length();i++){
            if(fullName.charAt(i)==' '){
                char c = fullName.charAt(i - 1);
                sb.append(c);
                //if this letter is one of 'A', 'E', 'I', 'O', 'U', "count" should be added one
                if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                    count+=1;
                }
            }
        }
        //find the last letter in surname
        char c1 = fullName.charAt(fullName.length() - 1);
        sb.append(c1);
        //if this letter is one of 'A', 'E', 'I', 'O', 'U', "count" should be added one
        if (c1=='A'||c1=='E'||c1=='I'||c1=='O'||c1=='U') {
            count += 1;
        }

        //UR1 b) d) e) c)
        //append left letters. If it is an uppercase vowel, append twice.
        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == 'A' || fullName.charAt(i) == 'E' || fullName.charAt(i) == 'I' ||
                    fullName.charAt(i) == 'O' || fullName.charAt(i) == 'U') {
                sb.append(fullName.charAt(i)).append(fullName.charAt(i));
                count += 2;
                //remove space
            } else if(fullName.charAt(i)==' ') {
                continue;
            }else{
                sb.append(fullName.charAt(i));
            }
        }
        //append the number at last and return username
        username = sb.append(count).toString();
    }

    //validator method
    public boolean[] validateUser(String[] array) {
        //create a boolean array,the length should be the length of the array
        boolean[] bo = new boolean[array.length];
        //Check the validity of the usernames in the array
        for (int i = 0; i < array.length; i++) {
            String username = array[i];
            //if it is started with ".",add false in boolean array and use "continue" to end current loop
            if (username.startsWith(".")) {
                bo[i] = false;
                continue;
            }
            //if it is larger than 30 or smaller than 6,add false in boolean array and continue
            if (username.length() > 30 || username.length() < 6) {
                bo[i] = false;
                continue;
            }
            //test whether it includes other characters except the character mentioned in the requirement
            for (int j = 0; j < username.length(); j++) {
                if ((username.charAt(j) >= 'A' && username.charAt(j) <= 'Z') || (username.charAt(j) >= 'a' && username.charAt(j) <= 'z')
                        || ((username.charAt(j) >= '0' && username.charAt(j) <= '9') || username.charAt(j) == '.')) {
                    bo[i] = true;
                } else {
                    bo[i] = false;
                    break;
                }
            }
        }
        //return boolean array
        return bo;
    }

}

